package com.example.firebaserecyclerviewexample.realtime;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.firebaserecyclerviewexample.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class firebase_realtime_database extends AppCompatActivity {


    Button add;
    EditText value;
    RecyclerView recycler;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<module> list;
    adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_realtime_database);

        FirebaseApp.initializeApp(this);
        add=findViewById(R.id.add_bt);
        value=findViewById(R.id.value);
        recycler=findViewById(R.id.recycler);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("hello");
        list=new ArrayList<>();


        add.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 databaseReference.push().setValue(value.getText().toString());
             }
      });




      ValueEventListener eventListener=new ValueEventListener() {
          @Override
          public void onDataChange(DataSnapshot snapshot) {

              for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                  String data=dataSnapshot.getValue(String.class);

                  list.add(new module(data));


              }

          }

          @Override
          public void onCancelled(DatabaseError error) {

          }
      };


        databaseReference.addValueEventListener(eventListener);

        adapter= new adapter(this, list) {
            @Override
            public void registerDataSetObserver(DataSetObserver dataSetObserver) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

            }

            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                return null;
            }

            @Override
            public int getViewTypeCount() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }
        };




        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));










    }
}
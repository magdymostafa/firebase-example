package com.example.firebaserecyclerviewexample.firestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.firebaserecyclerviewexample.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class firebase_firestore extends AppCompatActivity {


    Button add;
    EditText value;
    RecyclerView recycler;
    FirebaseFirestore firestore;
    adapter adapter;
    ArrayList<module> user_array;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_firestore);
        add = findViewById(R.id.add_bt2);
        value = findViewById(R.id.value2);
        recycler = findViewById(R.id.recycler2);
        firestore = FirebaseFirestore.getInstance();
        user_array=new ArrayList<module>();


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Map<String, Object> user = new HashMap<>();
                user.put("name", value.getText().toString());


                firestore.collection("users").document("hi")
                        .set(user)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {

                            }
                        });
                adapter.notifyDataSetChanged();


            }
        });


        adapter=new adapter(this,user_array);



        firestore.collection("users").orderBy("name",Query.Direction.DESCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(QuerySnapshot value,FirebaseFirestoreException error) {

                        for (DocumentChange documentChange:value.getDocumentChanges()){

                            if (documentChange.getType()== DocumentChange.Type.ADDED){


                                user_array.add(documentChange.getDocument().toObject(module.class));
                            }

                            adapter.notifyDataSetChanged();
                        }

                    }
                });





        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);
    }

}
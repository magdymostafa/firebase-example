package com.example.firebaserecyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.firebaserecyclerviewexample.firestore.firebase_firestore;
import com.example.firebaserecyclerviewexample.realtime.firebase_realtime_database;

public class MainActivity extends AppCompatActivity {


    Button authentication_btn,realtime_btn,firestore_btn;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        authentication_btn=findViewById(R.id.firebase_authentication);
        realtime_btn=findViewById(R.id.realtime_database);
        firestore_btn=findViewById(R.id.firestore);


        authentication_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent=new Intent(MainActivity.this,firebase_Authentication.class);

                startActivity(intent);
            }
        });

        realtime_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(MainActivity.this, firebase_realtime_database.class);

                startActivity(intent);
            }
        });

        firestore_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent=new Intent(MainActivity.this, firebase_firestore.class);

                startActivity(intent);
            }
        });



    }
}
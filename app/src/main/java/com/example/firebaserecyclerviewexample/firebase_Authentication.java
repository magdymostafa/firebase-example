package com.example.firebaserecyclerviewexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class firebase_Authentication extends AppCompatActivity {


    EditText edit_create,edit_creae_pass,edit_signin,edit_signin_pass;
    Button create_btn,signin_bt,signout_bt;


    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_authentication);


        firebaseAuth=FirebaseAuth.getInstance();
        edit_create=findViewById(R.id.edit_create);
        edit_creae_pass=findViewById(R.id.edit_create_pass);
        edit_signin=findViewById(R.id.edit_signin);
        edit_signin_pass=findViewById(R.id.edit_signin_pass);

        create_btn=findViewById(R.id.create_bt);
        signin_bt=findViewById(R.id.signin_bt);
        signout_bt=findViewById(R.id.signout_bt);



        create_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firebaseAuth.createUserWithEmailAndPassword(edit_create.getText().toString(),edit_creae_pass.getText().toString())
                        .addOnCompleteListener(firebase_Authentication.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(Task<AuthResult> task) {

                                if (task.isSuccessful()){

                                    Toast.makeText(firebase_Authentication.this, edit_create.getText().toString(), Toast.LENGTH_SHORT).show();


                                }else{

                                    Toast.makeText(firebase_Authentication.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }
        });


        signin_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firebaseAuth.signInWithEmailAndPassword(edit_signin.getText().toString(),edit_signin_pass.getText().toString())
                        .addOnCompleteListener(firebase_Authentication.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(Task<AuthResult> task) {

                                if (task.isSuccessful()){

                                    Toast.makeText(firebase_Authentication.this, edit_signin.getText().toString(), Toast.LENGTH_SHORT).show();
                                }else {

                                    Toast.makeText(firebase_Authentication.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }

                            }
                        });


            }
        });


        signout_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();

            }
        });


    }
}
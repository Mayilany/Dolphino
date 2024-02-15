package com.example.dolphino;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LogInActivity extends AppCompatActivity {


    EditText edUsername,edPassword;
    Button btn;
    TextView tv;

    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://dolphino-95fc9-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        edUsername = findViewById(R.id.editTextLoginUserName);
        edPassword = findViewById(R.id.editTextLogInPassword);
        btn = findViewById(R.id.button);
        tv = findViewById(R.id.textViewNewUser);
        tv.setPaintFlags(tv.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateUsername() | !validatePassword() ){

                }
                else{
                    checkUser();
                }
            }
        });


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LogInActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });


    }
    public boolean validateUsername(){
        String val= edUsername.getText().toString();
        if(val.isEmpty()){
            edUsername.setError("Username cannot be empty");
            return false;
        }
        else{
            edUsername.setError(null);
            return true;
        }
    }
    public boolean validatePassword(){
        String val= edPassword.getText().toString();
        if(val.isEmpty()){
            edPassword.setError("Password cannot be empty");
            return false;
        }
        else{
            edPassword.setError(null);
            return true;
        }
    }

    public void checkUser(){
        String userUserName= edUsername.getText().toString().trim();
        String userUserPassword;
        userUserPassword = edPassword.getText().toString().trim();

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("users");
        Query checkDatabase= reference.orderByChild("name").equalTo(userUserName);

        checkDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    edUsername.setError(null);
                    String passwordFromDB = snapshot.child(userUserName).child("password").getValue(String.class);
                    if (passwordFromDB.equals(userUserPassword)) {
                        edUsername.setError(null);
                        String nameFromDB = snapshot.child(userUserName).child("name").getValue(String.class);
                        String emailFromDB = snapshot.child(userUserName).child("email").getValue(String.class);
                        String usernameFromDB = snapshot.child(userUserName).child("username").getValue(String.class);
                        Intent intent = new Intent(LogInActivity.this, HomeActivity.class);
                        intent.putExtra("name", nameFromDB);
                        intent.putExtra("email", emailFromDB);
                        intent.putExtra("username", usernameFromDB);
                        intent.putExtra("password", passwordFromDB);
                        startActivity(intent);
                    } else {
                        edPassword.setError("Invalid Credentials");
                        edPassword.requestFocus();
                    }
                } else {
                    edUsername.setError("User does not exist");
                    edUsername.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

}}
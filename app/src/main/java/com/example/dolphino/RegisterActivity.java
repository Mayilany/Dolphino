package com.example.dolphino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {


    EditText edUsername,edEmail,edPhone,edPassword,edCPassword;
    Button btn;
    TextView tv;

    FirebaseDatabase database;
    DatabaseReference reference;

    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://dolphino-95fc9-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername= findViewById(R.id.editTextSignUpUserName);
        edEmail= findViewById(R.id.editTextSignUpEmail);
        edPhone= findViewById(R.id.editTextSignUpPhone);
        edPassword= findViewById(R.id.editTextSignUpPassword);
        edCPassword=findViewById(R.id.editTextSignUpCPassword);
        btn= findViewById(R.id.button);
        tv=findViewById(R.id.textView2);
        tv.setPaintFlags(tv.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LogInActivity.class));



            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");

                String name = edUsername.getText().toString();
                String Email = edEmail.getText().toString();
                String phone = edPhone.getText().toString();
                String password = edPassword.getText().toString();
                String CPassword = edCPassword.getText().toString();


                if (name.length() == 0 || Email.length() == 0 || phone.length() == 0 || password.length() == 0 || CPassword.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                } else {


                    HelperClass helperClass = new HelperClass(name, Email, phone, password, CPassword);
                    reference.child(name).setValue(helperClass);
                    Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(RegisterActivity.this, LogInActivity.class);
                    startActivity(intent);

                }



            }



        });
    }
}
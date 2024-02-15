package com.example.dolphino;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
/*import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.concurrent.TimeUnit;

public class OTPVerifyActivity extends AppCompatActivity {


    private boolean otpSent = false;
    private String countryCode = "+91";
    private String id = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverify);


        final EditText mobileET = findViewById(R.id.OTPPhone);
        final EditText otpET = findViewById(R.id.EnterOTP);
        final Button actionBtn = findViewById(R.id.button);

        FirebaseApp.initializeApp(this);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        actionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(otpSent){
                    final String getOTP = otpET.getText().toString();

                    if(id.isEmpty()){
                        Toast.makeText(OTPVerifyActivity.this, "Unable to verify OTP", Toast.LENGTH_SHORT).show();
                    }
                    else{

                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(id, getOTP);

                        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(task.isSuccessful()){

                                    FirebaseUser userDetails = task.getResult().getUser();

                                    Toast.makeText(MainActivity.this, "Verified", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(MainActivity.this, "Something went wrong!!!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
                else{
                    final String getMobile = mobileET.getText().toString();

                    PhoneAuthOptions options = PhoneAuthOptions.newBuilder(firebaseAuth)
                            .setPhoneNumber(countryCode+""+getMobile)
                            .setTimeout(60L, TimeUnit.SECONDS)
                            .setActivity(MainActivity.this)
                            .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                @Override
                                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                    Toast.makeText(MainActivity.this, "OTP sent successfully", Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onVerificationFailed(@NonNull FirebaseException e) {

                                    Toast.makeText(MainActivity.this, "Something went wrong "+e.getMessage(), Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                    super.onCodeSent(s, forceResendingToken);
                                    otpET.setVisibility(View.VISIBLE);
                                    actionBtn.setText("Verify OTP");
                                    id = s;
                                    otpSent = true;
                                }
                            }).build();

                    PhoneAuthProvider.verifyPhoneNumber(options);
                }

            }
        });
    }
}*/
package com.example.myapplication02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.winkelen.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginpageActivity extends AppCompatActivity {
    Button buttonView;
    TextInputEditText emailLog;
    TextInputEditText passLog;
    TextView signup;
    FirebaseAuth mAuth;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        buttonView = findViewById(R.id.buttonnext);
        emailLog=findViewById(R.id.emailLog);
        passLog=findViewById(R.id.passLog);
        signup=findViewById(R.id.signup);
        mAuth=FirebaseAuth.getInstance();

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginpageActivity.this, HomeActivity.class));
            }
        });
        passLog.setOnClickListener(view -> {
            loginUser();
        });
        signup.setOnClickListener(view -> {
            startActivity(new Intent(LoginpageActivity.this,RegisterPageActivity.class));
        });

    }

    private void loginUser() {
        String email=emailLog.getText().toString();
        String password=passLog.getText().toString();
        if(TextUtils.isEmpty(email)){
            emailLog.setError("Email cannot be empty");
            emailLog.requestFocus();
        }
        else if(TextUtils.isEmpty(password)){
            passLog.setError("Password cannot be empty");
            passLog.requestFocus();
        }
        else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(LoginpageActivity.this, "Logging Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginpageActivity.this,LoginpageActivity.class));
                    }
                    else{
                        Toast.makeText(LoginpageActivity.this, "Login Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
package com.example.myapplication02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.winkelen.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterPageActivity extends AppCompatActivity {
    TextInputEditText emailreg;
    TextInputEditText passreg;
    Button regbutton;
    TextView allogin;
    FirebaseAuth mAuth;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        emailreg=findViewById(R.id.emailReg);
        passreg=findViewById(R.id.passReg);
        regbutton=findViewById(R.id.buttonReg);
        allogin=findViewById(R.id.loginReg);
        mAuth=FirebaseAuth.getInstance();
        regbutton.setOnClickListener(view ->{
            createUser();
        });
        allogin.setOnClickListener(view -> {
            startActivity(new Intent(RegisterPageActivity.this,LoginpageActivity.class));
        });

    }

    private void createUser() {
        String email=emailreg.getText().toString();
        String password=passreg.getText().toString();
        if(TextUtils.isEmpty(email)){
            emailreg.setError("Email cannot be empty");
            emailreg.requestFocus();
        }
        else if(TextUtils.isEmpty(password)){
            passreg.setError("Password cannot be empty");
            passreg.requestFocus();
        }
        else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(RegisterPageActivity.this, "Registered Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterPageActivity.this,LoginpageActivity.class));
                    }
                    else{
                        Toast.makeText(RegisterPageActivity.this, "Registered Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
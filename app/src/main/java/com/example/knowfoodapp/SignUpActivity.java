package com.example.knowfoodapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class SignUpActivity extends AppCompatActivity {
    private Button signUpButton;
    private Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUpButton = findViewById(R.id.btnSignUp);
        signUpButton.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                Intent goToSignUpActivityIntent = new Intent(SignUpActivity.this,UserSignUpActivity.class);
                startActivity(goToSignUpActivityIntent);
            }
        });

        loginButton = findViewById(R.id.btnSignIn);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToLoginActivity = new Intent(SignUpActivity.this,UserSignUpActivity.class);
                startActivity(goToLoginActivity);
            }
        });
    }
}

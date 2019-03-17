package com.example.knowfoodapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.knowfoodapp.helpers.SignUpDBHelper;
import com.example.knowfoodapp.model.SignUp;
import com.example.knowfoodapp.DBOperations.tblUsersDBOperations;

public class UserSignUpActivity extends AppCompatActivity {
    private Button btnSignUp;
    private EditText txtEmail;
    private EditText txtPassword;
    private EditText txtConfirmPassword;
    private tblUsersDBOperations tblUsersDBOperations;
    private SignUpDBHelper signUpDBHelper;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_up);
        getSupportActionBar().setTitle("Sign Up");

        btnSignUp = (Button) findViewById(R.id.btnRegister);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtConfirmPassword = (EditText) findViewById(R.id.txtConfirmPassword);
        tblUsersDBOperations = new tblUsersDBOperations(this);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterUser();
            }
        });
    }

    public void RegisterUser(){
        SignUp userDetails = new SignUp();
        userDetails.setEmailId(txtEmail.getText().toString());
        userDetails.setPassword(txtPassword.getText().toString());
        userDetails.DateCreated = dateFormat.format(date);
        userDetails.setActive(true);
        userDetails.setSynced(false);
        boolean check = tblUsersDBOperations.addUser(userDetails);
        if (check)
            toastMessage("Congratulations! Your registration is successful. Welcome to KnowFood! ");
        else
            toastMessage("Oops! Something went wrong. Please try again.");

    }

    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}

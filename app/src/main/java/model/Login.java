package model;

import com.example.knowfoodapp.UserSignUpActivity;

public class Login {
    public String Username;
    public String Password;

    public Login(){

    }

    public String getUsername(){
        return Username;
    }

    public String getPassword(){
        return Password;
    }

    public void setUsername(String username){
        this.Username = username;
    }

    public void setPassword(String password){
        this.Password = password;
    }

}

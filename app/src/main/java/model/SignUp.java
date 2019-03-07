package model;

import java.sql.Timestamp;
import java.util.Date;

public class SignUp {
    public long Id;
    public String EmailId;
    public String Password;
    public boolean isActive;
    public boolean isSynced;
    public String DateCreated;

    public SignUp(long id,String emailid,String password, String date, boolean isActive, boolean isSynced){
        this.Id = id;
        this.EmailId = emailid;
        this.Password = password;
        this.DateCreated = date;
        this.isActive = isActive;
        this.isSynced = isSynced;
    }

    public SignUp(){

    }

    public long getId()
    {
        return Id;
    }

    public void setId(long Id){
        this.Id = Id;
    }

    public String getEmailId(){
        return EmailId;
    }

    public void setEmailId(String emailId){
        this.EmailId = emailId;
    }

    public String getPassword(){
        return Password;
    }

    public void setPassword(String password){
        this.Password = password;
    }

    public boolean getActive() {
        return isActive;
    }

    public void setActive(boolean active){
        this.isActive = active;
    }

    public boolean getSynced(){
        return isSynced;
    }

    public void setSynced(boolean synced){
        this.isSynced = synced;
    }
}

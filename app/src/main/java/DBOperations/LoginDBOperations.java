package DBOperations;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import helpers.LoginDBHelper;
import model.Login;
import model.SignUp;

public class LoginDBOperations {
    SQLiteOpenHelper dbHandler;
    SQLiteDatabase database;

    public LoginDBOperations(Context context){
        dbHandler = new LoginDBHelper(context);
    }

    public void openConnection(){
        database = dbHandler.getReadableDatabase();
    }

    public void closeConnection(){
        dbHandler.close();
    }

    public SignUp queryUser(String username, String password){
        openConnection();
        SignUp user = null;

        Cursor cursor = database.query(LoginDBHelper.TABLE_NAME, new String[]{LoginDBHelper.COLUMN_ID,
                LoginDBHelper.COLUMN_EMAIL,LoginDBHelper.COLUMN_PASSWORD}, LoginDBHelper.COLUMN_EMAIL + "=? and "
                + LoginDBHelper.COLUMN_PASSWORD + "=?",new String[]{username,password},null,null,null,"1");

        if(cursor != null){
            cursor.moveToFirst();
        }
        if(cursor!=null && cursor.getCount() > 0){
            user = new SignUp();
            user.setId(cursor.getLong(0));
            user.setEmailId(cursor.getString(1));
            user.setPassword(cursor.getString(2));
        }
        return user;
    }
}

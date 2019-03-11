package DBOperations;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import helpers.SignUpDBHelper;
import model.Login;
import model.SignUp;

public class tblUsersDBOperations {
    SQLiteOpenHelper dbHandler;
    SQLiteDatabase database;

    public tblUsersDBOperations(Context context){
        dbHandler = new SignUpDBHelper(context);
    }

    public void openDBConnection() {
        database = dbHandler.getWritableDatabase();
    }

    public void closeDBConnection(){
        dbHandler.close();
    }

    public boolean addUser(SignUp user){
        ContentValues values = new ContentValues();
        values.put(SignUpDBHelper.COLUMN_EMAIL, user.EmailId);
        values.put(SignUpDBHelper.COLUMN_PASSWORD, user.Password);
        values.put(SignUpDBHelper.COLUMN_DATECREATED, user.DateCreated);
        values.put(SignUpDBHelper.COLUMN_ISACTIVE, user.isActive? 1: 0);
        values.put(SignUpDBHelper.COLUMN_ISSYNCED, user.isSynced? 1: 0);

        openDBConnection();
        long result = database.insert(SignUpDBHelper.TABLE_NAME,null,values);
        closeDBConnection();
        if (result == -1)
            return false;
        else
            return true;
    }
}

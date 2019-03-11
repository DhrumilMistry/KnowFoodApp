package helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LoginDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "knowfood.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "users";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_EMAIL = "EmailId";
    public static final String COLUMN_PASSWORD = "Password";
    public static final String COLUMN_ISACTIVE = "IsActive";
    public static final String COLUMN_ISSYNCED = "IsSynced";
    public static final String COLUMN_DATECREATED = "DateCreated";

    public LoginDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

package com.example.knowfoodapp.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SignUpDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "knowfood.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "users";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_EMAIL = "EmailId";
    public static final String COLUMN_PASSWORD = "Password";
    public static final String COLUMN_ISACTIVE = "IsActive";
    public static final String COLUMN_ISSYNCED = "IsSynced";
    public static final String COLUMN_DATECREATED = "DateCreated";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_EMAIL + " TEXT, " +
                    COLUMN_PASSWORD + " TEXT, " +
                    COLUMN_ISACTIVE + " NUMERIC, " +
                    COLUMN_ISSYNCED + " NUMERIC, " +
                    COLUMN_DATECREATED + " TEXT " +
                    ")";

    public SignUpDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL(TABLE_CREATE);
    }
}

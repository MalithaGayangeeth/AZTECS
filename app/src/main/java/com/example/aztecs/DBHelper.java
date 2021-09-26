package com.example.aztecs;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "Shopping";
    private static final String USER_TABLE_NAME = "users";

    // User table column names
    private static final String COLUMN_USER_ID = "id";
    private static final String COLUMN_NAME_FIRST_NAME = "firstname";
    private static final String COLUMN_NAME_LAST_NAME = "lastname";
    private static final String COLUMN_NAME_USER_EMAIL = "email";
    private static final String COLUMN_NAME_USER_PASSWORD = "password";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_USER_CREATE_ENTRIES = "CREATE TABLE " + USER_TABLE_NAME + " (" +
                COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NAME_FIRST_NAME + " TEXT," +
                COLUMN_NAME_LAST_NAME + " TEXT," +
                COLUMN_NAME_USER_EMAIL + " TEXT," +
                COLUMN_NAME_USER_PASSWORD + " TEXT);";

        db.execSQL(SQL_USER_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE_NAME);
        onCreate(db);
    }

    public boolean userRegister(UserModel user) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_FIRST_NAME, user.getFirstname());
        values.put(COLUMN_NAME_LAST_NAME, user.getLastname());
        values.put(COLUMN_NAME_USER_EMAIL, user.getEmail());
        values.put(COLUMN_NAME_USER_PASSWORD, user.getPassword());
        long result = db.insert(USER_TABLE_NAME, null, values);
        if (result == -1) {
            db.close();
            return false;
        } else {
            db.close();
            return true;
        }
    }


}

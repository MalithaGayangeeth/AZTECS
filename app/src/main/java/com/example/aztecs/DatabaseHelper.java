package com.example.aztecs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Dumindu.db";

    public static final String TABLE_NAME = "feedback_table";
    public static final String COL_2 ="NAME";
    public static final String COL_3="FEEDBACK";

    public static final String TABLE_NAME1 = "order_table";
    public static final String COL_4 ="USERID";
    public static final String COL_5="ITEMNAME";
    public static final String COL_6="QUENTITY";

   //public static final String COL_1 = "ID";
    //public static final String COL_2 ="NAME";
    //public static final String COL_3="FEEDBACK";
    //public static final String COL_4 ="USERID";
    //public static final String COL_5="ITEMNAME";
   // public static final String COL_6="QUENTITY";


    private String TABLE_CREATE_NAME = "create table " + TABLE_NAME + " (" +
            //COL_1 + " TEXT ," +
            COL_2 + " TEXT," +
            COL_3 + " TEXT)";


    private String TABLE_CREATE_NAME1 = "create table " + TABLE_NAME1 + " (" +
            COL_4 + " TEXT PRIMARY KEY," +
            COL_5 + " TEXT," +
            COL_6 + " TEXT)";




    public DatabaseHelper(@Nullable Context context) {

        super(context, DATABASE_NAME, null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       // db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,FEEDBACK TEXT)");
        db.execSQL(TABLE_CREATE_NAME);
        db.execSQL(TABLE_CREATE_NAME1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       //db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        onCreate(db);
    }

    public boolean insertData( String name, String feedback){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2,name);
        contentValues.put(COL_3,feedback);

        long result =  db.insert(TABLE_NAME, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

//order
    public boolean InsertData(String userid, String itemname , String quentity){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_4,userid);
        contentValues.put(COL_5,itemname);
        contentValues.put(COL_6,quentity);

        long result =  db.insert(TABLE_NAME1, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }


    public Cursor getdata() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+"  ",  null);
        return res;
    }
//order
    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME1+"  ",  null);
        return res;
    }


    public boolean UpdateData( String name, String feedback) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2,name);
        contentValues.put(COL_3,feedback);

        db.update(TABLE_NAME, contentValues, "NAME = ?",new String[] { name});
        return true;
    }

    //order
    public boolean Updatedata( String userid, String itemname , String quentity) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_4,userid);
        contentValues.put(COL_5,itemname);
        contentValues.put(COL_6,quentity);

        db.update(TABLE_NAME1, contentValues, "USERID= ?",new String[] { userid});
        return true;
    }

    public Integer deleteData (String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "NAME = ?",new String[] {name});
    }

//order
public Integer DeleteData (String userid) {

    SQLiteDatabase db = this.getWritableDatabase();
    return db.delete(TABLE_NAME1, "USERID = ?",new String[] {userid});
}


}

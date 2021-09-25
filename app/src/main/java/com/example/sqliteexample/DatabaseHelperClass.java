package com.example.sqliteexample;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelperClass extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "employee_database";
    //Database Table name
    private static final String TABLE_NAME = "EMPLOYEE";
    //Table columns
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String TELE = "tele";
    public static final String EMAIL = "email";
    public static final String ADDRESS1 = "address1";
    public static final String ADDRESS2 = "address2";
    public static final String CITY = "city";
    public static final String DATE = "date";
    private SQLiteDatabase sqLiteDatabase;


    //creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"("+ID+
        " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT NOT NULL,"+TELE+" TEXT NOT NULL,"+EMAIL+" TEXT NOT NULL,"+ADDRESS1+" TEXT NOT NULL,"+ADDRESS2+" TEXT NOT NULL,"+CITY+" TEXT NOT NULL,"+DATE+" TEXT NOT NULL);";
    //Constructor
    public DatabaseHelperClass (Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //Add Employee Data
    public void addEmployee(DeliveryModelClass deliveryModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.NAME, deliveryModelClass.getName());
        contentValues.put(DatabaseHelperClass.TELE, deliveryModelClass.getTele());
        contentValues.put(DatabaseHelperClass.EMAIL, deliveryModelClass.getEmail());
        contentValues.put(DatabaseHelperClass.ADDRESS1, deliveryModelClass.getAddress1());
        contentValues.put(DatabaseHelperClass.ADDRESS2, deliveryModelClass.getAddress2());
        contentValues.put(DatabaseHelperClass.CITY, deliveryModelClass.getCity());
        contentValues.put(DatabaseHelperClass.DATE, deliveryModelClass.getDate());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelperClass.TABLE_NAME, null,contentValues);
    }
    //get Delivery
    public List<DeliveryModelClass> getEmployeeList(){
        String sql = "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<DeliveryModelClass> storeEmployee = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String tele = cursor.getString(2);
                String email = cursor.getString(3);
                String address1 = cursor.getString(4);
                String address2 = cursor.getString(5);
                String city = cursor.getString(6);
                String date = cursor.getString(7);
                storeEmployee.add(new DeliveryModelClass(id,name,tele,email,address1,address2,city,date));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeEmployee;
    }
    //UpdateDelivery
    public void updateEmployee(DeliveryModelClass deliveryModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelperClass.NAME, deliveryModelClass.getName());
        contentValues.put(DatabaseHelperClass.TELE, deliveryModelClass.getTele());
        contentValues.put(DatabaseHelperClass.EMAIL, deliveryModelClass.getEmail());
        contentValues.put(DatabaseHelperClass.ADDRESS1, deliveryModelClass.getAddress1());
        contentValues.put(DatabaseHelperClass.ADDRESS2, deliveryModelClass.getAddress2());
        contentValues.put(DatabaseHelperClass.CITY, deliveryModelClass.getCity());
        contentValues.put(DatabaseHelperClass.DATE, deliveryModelClass.getDate());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME,contentValues,ID + " = ?" , new String[]
                {String.valueOf(deliveryModelClass.getId())});
    }

    //Delete Delivery
    public void deleteEmployee(int id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, ID + " = ? ", new String[]
                {String.valueOf(id)});
    }

}

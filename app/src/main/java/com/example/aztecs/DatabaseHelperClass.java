package com.example.aztecs;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelperClass extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "shop_database";
    //Database Table name
    private static final String TABLE_NAME = "PLANT";

    //**
    private static final String TABLE_NAME2 = "FERTILIZER";
    //**
    
    //Table columns
    public static final String ID = "id";
    public  static final String IMAGE = "image";
    public static final String NAME = "name";
    public static final String QUANTITY = "quantity";
    public static final String PRICE = "price";

    //**
    //Table columns
    public static final String ID2 = "id2";
    public  static final String IMAGE2 = "image2";
    public static final String NAME2 = "name2";
    public static final String QUANTITY2 = "quantity2";
    public static final String PRICE2 = "price2";
    //**


    private SQLiteDatabase sqLiteDatabase;
    private ByteArrayOutputStream byteArrayOutputStream;
    private byte[] imagebyte;
    //**
    private ByteArrayOutputStream byteArrayOutputStream2;
    private byte[] imagebyte2;
    //**

    //creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"("+ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + IMAGE + " BOLB," + NAME + " TEXT NOT NULL,"+QUANTITY+" TEXT NOT NULL,"+PRICE+" TEXT NOT NULL);";

    //*
    //creating table query
    private static final String CREATE_TABLE2 = "create table " + TABLE_NAME2 +"("+ID2+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + IMAGE2 + " BOLB," + NAME2 + " TEXT NOT NULL,"+QUANTITY2+" TEXT NOT NULL,"+PRICE2+" TEXT NOT NULL);";
    //*


    //Constructor
    public DatabaseHelperClass (Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE2);

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME2);

        onCreate(db);
    }


    //Add Plant Data to the database
    public void addPlant(PlantModelClass plantModelClass){
        ContentValues contentValues = new ContentValues();

        Bitmap imagetostore = plantModelClass.getImage();
        byteArrayOutputStream= new ByteArrayOutputStream();
        imagetostore.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        imagebyte = byteArrayOutputStream.toByteArray();
        contentValues.put(DatabaseHelperClass.IMAGE, imagebyte);
        contentValues.put(DatabaseHelperClass.NAME, plantModelClass.getName());
        contentValues.put(DatabaseHelperClass.QUANTITY, plantModelClass.getQuantity());
        contentValues.put(DatabaseHelperClass.PRICE, plantModelClass.getPrice());

        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelperClass.TABLE_NAME, null,contentValues);
        sqLiteDatabase.close();
    }

    //*
    //Add Fertilizer Data to the database
    public void addFertilizer(FertilizerModelClass fertilizerModelClass){
        ContentValues contentValues = new ContentValues();

        Bitmap imagetostore = fertilizerModelClass.getImage();
        byteArrayOutputStream2= new ByteArrayOutputStream();
        imagetostore.compress(Bitmap.CompressFormat.JPEG,100, byteArrayOutputStream2);
        imagebyte2 = byteArrayOutputStream2.toByteArray();
        contentValues.put(DatabaseHelperClass.IMAGE2, imagebyte2);
        contentValues.put(DatabaseHelperClass.NAME2, fertilizerModelClass.getName());
        contentValues.put(DatabaseHelperClass.QUANTITY2, fertilizerModelClass.getQuantity());
        contentValues.put(DatabaseHelperClass.PRICE2, fertilizerModelClass.getPrice());

        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelperClass.TABLE_NAME2, null,contentValues);
        sqLiteDatabase.close();
    }
    //*

    //get data
    public List<PlantModelClass> getPlantList(){
        String sql = "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<PlantModelClass> storePlant = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);


        if (cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                byte[] imagebytes= cursor.getBlob(1);
                Bitmap objectbitmap = BitmapFactory.decodeByteArray(imagebytes,0,imagebytes.length);

                String name = cursor.getString(2);
                String quantity = cursor.getString(3);
                String price = cursor.getString(4);

                storePlant.add(new PlantModelClass(id,objectbitmap,name,quantity,price));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storePlant;
    }

    //*****


    //get data
    public List<FertilizerModelClass> getFertilizerList(){
        String sql = "select * from " + TABLE_NAME2;
        sqLiteDatabase = this.getReadableDatabase();
        List<FertilizerModelClass> storeFertilizer = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);


        if (cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                byte[] imagebytes2= cursor.getBlob(1);
                Bitmap objectbitmap2 = BitmapFactory.decodeByteArray(imagebytes2,0,imagebytes2.length);

                String name = cursor.getString(2);
                String quantity = cursor.getString(3);
                String price = cursor.getString(4);

                storeFertilizer.add(new FertilizerModelClass(id,objectbitmap2,name,quantity,price));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeFertilizer;
    }
    //*****

    //Update data
    public int updatePlant(PlantModelClass plantModelClass){
        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseHelperClass.NAME, plantModelClass.getName());
        contentValues.put(DatabaseHelperClass.QUANTITY, plantModelClass.getQuantity());
        sqLiteDatabase = this.getWritableDatabase();
        int x=sqLiteDatabase.update(TABLE_NAME,contentValues,ID + " = ?" , new String[]
                {String.valueOf(plantModelClass.getId())});
        return x;
    }

    //**********

    //Update data
    public int updateFertilizer(FertilizerModelClass fertilizerModelClass){
        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseHelperClass.NAME2, fertilizerModelClass.getName());
        contentValues.put(DatabaseHelperClass.QUANTITY2, fertilizerModelClass.getQuantity());
        sqLiteDatabase = this.getWritableDatabase();
        int x1=sqLiteDatabase.update(TABLE_NAME2,contentValues,ID2 + " = ?" , new String[]
                {String.valueOf(fertilizerModelClass.getId())});
        return x1;
    }
    //**********


    //Delete data
    public int deletePlant(int id){
        sqLiteDatabase = this.getWritableDatabase();
        int i;
        i=sqLiteDatabase.delete(TABLE_NAME, ID + " = ? ", new String[]
                {String.valueOf(id)});
        return i;
    }



    //*******************
    //Delete data
    public int deleteFertilizer(int id){
        sqLiteDatabase = this.getWritableDatabase();
        int i1;
        i1=sqLiteDatabase.delete(TABLE_NAME2, ID2 + " = ? ", new String[]
                {String.valueOf(id)});
        return i1;
    }
    //*******************




}


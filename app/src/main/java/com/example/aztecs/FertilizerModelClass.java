package com.example.aztecs;

import android.graphics.Bitmap;

public class FertilizerModelClass {

    Integer id;
    Bitmap image;
    String name;
    String quantity;
    String price;

    public FertilizerModelClass(Bitmap image,String name, String quantity, String price) {
        this.image = image;
        this.name = name;
        this.quantity = quantity;
        this.price = price;

    }

    public FertilizerModelClass(Integer id, Bitmap image, String name, String quantity, String price) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public FertilizerModelClass(Integer id, String name, String quantity, String price) {
        this.id = id;

        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bitmap getImage() {
        return image;
    }


    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

package com.example.sqliteexample;

public class DeliveryModelClass {

    Integer id;
    String name;
    String tele;
    String email;
    String address1;
    String address2;
    String city;
    String date;

    public DeliveryModelClass(String name, String tele, String email, String address1, String address2, String city, String date) {
        this.name = name;
        this.tele = tele;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.date = date;
    }

    public DeliveryModelClass(Integer id, String name, String tele, String email, String address1, String address2, String city, String date) {
        this.id = id;
        this.name = name;
        this.tele = tele;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

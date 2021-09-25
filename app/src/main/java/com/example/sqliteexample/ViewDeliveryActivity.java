package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ViewDeliveryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_delivery);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<DeliveryModelClass> deliveryModelClasses = databaseHelperClass.getEmployeeList();

        if (deliveryModelClasses.size() > 0){
            DeliveryAdapterClass employeeadapterclass = new DeliveryAdapterClass(deliveryModelClasses, ViewDeliveryActivity.this);
            recyclerView.setAdapter(employeeadapterclass);
        }else {
            Toast.makeText(this, "There is no delivery in the database", Toast.LENGTH_SHORT).show();
        }
    }}


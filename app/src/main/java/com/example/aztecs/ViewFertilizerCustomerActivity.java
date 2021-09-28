package com.example.aztecs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ViewFertilizerCustomerActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fertilizer_customer);


        //Added back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<FertilizerModelClass> fertilizerModelClasses = databaseHelperClass.getFertilizerList();

        if (fertilizerModelClasses.size() > 0) {
            FertilizerViewAdapterClass fertilizeradapterclass = new FertilizerViewAdapterClass(fertilizerModelClasses, ViewFertilizerCustomerActivity.this);
            recyclerView.setAdapter(fertilizeradapterclass);
        } else {
            Toast.makeText(this, "There is no fertilizer in the database", Toast.LENGTH_SHORT).show();
        }


    }



}
package com.example.aztecs;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ViewPlantActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_plant);

        //Added back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<PlantModelClass> plantModelClasses = databaseHelperClass.getPlantList();

        if (plantModelClasses.size() > 0){
            PlantAdapterClass plantadapterclass = new PlantAdapterClass(plantModelClasses, ViewPlantActivity.this);
            recyclerView.setAdapter(plantadapterclass);
        }else {
            Toast.makeText(this, "There is no plant in the database", Toast.LENGTH_SHORT).show();
        }




    }
}
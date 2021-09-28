package com.example.aztecs;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ViewFertilizerActivity extends AppCompatActivity {

    RecyclerView recyclerView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fertilizer);

        //Added back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView2 = findViewById(R.id.recyclerView2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<FertilizerModelClass> fertilizerModelClasses = databaseHelperClass.getFertilizerList();

        if (fertilizerModelClasses.size() > 0){
            FertilizerAdapterClass fertilizeradapterclass = new FertilizerAdapterClass(fertilizerModelClasses, ViewFertilizerActivity.this);
            recyclerView2.setAdapter(fertilizeradapterclass);
        }else {
            Toast.makeText(this, "There is no fertilizers in the database", Toast.LENGTH_SHORT).show();
        }




    }
}

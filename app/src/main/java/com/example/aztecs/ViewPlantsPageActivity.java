package com.example.aztecs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ViewPlantsPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_plants_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    //When click back button in twice then exit app
    int counter = 0;

    public void onClickPress() {
        counter++;
        if (counter == 2)
            super.onBackPressed();
    }

    public void openViewFertilizersPageActivity() {
        Intent intent = new Intent(this, ViewPlantsPageActivity.class);
        startActivity(intent);
    }

}
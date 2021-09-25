package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class MainActivityLocation extends AppCompatActivity  {
    //Initialize variable
    EditText etSource,etDestination;
    Button btTrack;
    private Button button_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_location);


        button_next = (Button) findViewById(R.id.button_next);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPayment();
            }
        });

        //Assign variable
        etSource=findViewById(R.id.et_source);
        etDestination=findViewById(R.id.et_destination);
        btTrack=findViewById(R.id.bt_track);


        btTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get value from edit text
                String sSource = etSource.getText().toString().trim();
                String sDestination=etDestination.getText().toString().trim();



//Check condition
                if(sSource.equals("") && sDestination.equals("")){
                    //When bothe value blank
                    Toast.makeText(getApplicationContext()
                            ,"Enter Both location",Toast.LENGTH_LONG).show();
                }else{
                    //When both value fill
                    //Display track
                    DisplayTrack(sSource,sDestination);
                }


            }
        });
    }

    private void DisplayTrack(String sSource, String sDestination) {
        //If the  device does not have a map installed,then redirect it to play store
        try{
            //When google map is installed
            //Initialize uri
            Uri uri= Uri.parse("https://www.google.co.in/maps/dir/"+ sSource + "/"
               +sDestination);
            //Initialize intent with action view
            Intent intent =new Intent(Intent.ACTION_VIEW,uri);
            //set package
            intent.setPackage("com.google.android.apps.maps");
            //set flag
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //Start activity
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            //When google map is not installed
            //Initialize uri
            Uri uri =Uri.parse("https://play.google.com/stoe/apps/details?id=com.google.apps.maps");
            //Initialize inent with action view
            Intent intent=new Intent(Intent.ACTION_VIEW,uri);
            //set flag
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //Start Activity
            startActivity(intent);

        }
    }
    public void openPayment() {
        Intent intent = new Intent(this, Payment.class);
        startActivity(intent);

    }

}

package com.example.aztecs;



import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    ImageView imageView, imageView1;
    EditText editText_name,editText_quantity,editText_price;
    Button button_add,button_view;

    private Bitmap selectimage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Added back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        imageView = (ImageView) findViewById(R.id.imageView1);
        editText_name = findViewById(R.id.edittext_name);
        editText_quantity = findViewById(R.id.edittext_quantity);
        editText_price = findViewById(R.id.edittext_price);
        button_add = findViewById(R.id.button_add);
        button_view = findViewById(R.id.button_view);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                gallery.launch(intent);
            }

        });

        //add item when clicking add item button
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String stringName = editText_name.getText().toString();
                String stringQuantity = editText_quantity.getText().toString();
                String stringPrice = editText_price.getText().toString();



                if (stringName.length() <=0 || stringQuantity.length() <=0 || stringPrice.length() <=0 ){
                    Toast.makeText(MainActivity.this, "Please Enter All Data!!!", Toast.LENGTH_SHORT).show();
                }else {
                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(MainActivity.this);
                    PlantModelClass plantModelClass = new PlantModelClass(selectimage,stringName,stringQuantity,stringPrice);
                    databaseHelperClass.addPlant(plantModelClass);
                    Toast.makeText(MainActivity.this, "Plants Successfully Added!!!", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });

        //view all
        button_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewPlantActivity.class);
                startActivity(intent);



            }

        });


    }

    private ActivityResultLauncher<Intent> gallery = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()== Activity.RESULT_OK){
                        Intent data = result.getData();
                        Uri imageuri= data.getData();
                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageuri);
                            imageView.setImageBitmap(bitmap);
                            selectimage=bitmap;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                }
            }
    );




}

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

public class FertilizerActivity extends AppCompatActivity {
    ImageView imageView, imageViewNew;
    EditText editText_name2,editText_quantity2,editText_price2;
    Button button_add2,button_view2;

    private Bitmap selectimage2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fertilizer);

        //Added back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        imageView = (ImageView) findViewById(R.id.imageViewNew);
        editText_name2 = findViewById(R.id.edittext_name2);
        editText_quantity2 = findViewById(R.id.edittext_quantity2);
        editText_price2 = findViewById(R.id.edittext_price2);
        button_add2 = findViewById(R.id.button_add2);
        button_view2 = findViewById(R.id.button_view2);


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
        button_add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String stringName = editText_name2.getText().toString();
                String stringQuantity = editText_quantity2.getText().toString();
                String stringPrice = editText_price2.getText().toString();



                if (stringName.length() <=0 || stringQuantity.length() <=0 || stringPrice.length() <=0 ){
                    Toast.makeText(FertilizerActivity.this, "Please Enter All Data!!!", Toast.LENGTH_SHORT).show();
                }else {
                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(FertilizerActivity.this);
                    FertilizerModelClass fertilizerModelClass = new FertilizerModelClass(selectimage2,stringName,stringQuantity,stringPrice);
                    databaseHelperClass.addFertilizer(fertilizerModelClass);
                    Toast.makeText(FertilizerActivity.this, "Fertilizers Successfully Added!!!", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });

        //view all
        button_view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FertilizerActivity.this, ViewFertilizerActivity.class);
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
                            selectimage2=bitmap;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                }
            }
    );




}

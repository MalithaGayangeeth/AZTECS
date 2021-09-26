package com.example.aztecs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton imageButton13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton13 = (ImageButton) findViewById(R.id.imageButton13);

        imageButton13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openMainActivity7();
            }

            public void openMainActivity7() {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, MainActivity7.class);
                startActivity(intentLoadNewActivity);
            }
        });

    }
}

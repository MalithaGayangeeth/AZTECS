package com.example.aztecs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity04 extends AppCompatActivity {
private Button button4;
private Button button10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main04);

        button4 = (Button) findViewById(R.id.button4);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openMainActivity05();
            }

            public void openMainActivity05() {
                Intent intentLoadNewActivity = new Intent(MainActivity04.this, MainActivity05.class);
                startActivity(intentLoadNewActivity);
            }
        });
        button10 = (Button) findViewById(R.id.button10);

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openMainActivity06();
            }

            public void openMainActivity06() {
                Intent intentLoadNewActivity = new Intent(MainActivity04.this, MainActivity06.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }
}
package com.example.aztecs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlantsPageActivity extends AppCompatActivity {
    private Button button05;
    //x

    TextView textView;
    EditText txt04,txt05,txt06,txt07;
    Button button04,button06,button07;
    ImageView imageView;

    //x



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plants_page);
        //Added back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //***

        textView = findViewById(R.id.lbl02);
        textView.setText(R.string.lbl02);

        textView = findViewById(R.id.lbl03);
        textView.setText(R.string.lbl03);

        textView = findViewById(R.id.lbl04);
        textView.setText(R.string.lbl04);

        textView = findViewById(R.id.lbl05);
        textView.setText(R.string.lbl05);

        textView = findViewById(R.id.lbl06);
        textView.setText(R.string.lbl06);

        txt04 = (EditText)findViewById(R.id.txt04);
        txt05 = (EditText)findViewById(R.id.txt05);
        txt06= (EditText)findViewById(R.id.txt06);
        txt07 = (EditText)findViewById(R.id.txt07);
        button04 = (Button)findViewById(R.id.button04);
        button05 = (Button)findViewById(R.id.button05);
        button06 = (Button)findViewById(R.id.button06);
        button07 = (Button)findViewById(R.id.button07);
        imageView = (ImageView)findViewById(R.id.imageView2);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlantsPageActivity.this,"Insert Image!!",Toast.LENGTH_SHORT).show();
            }
        });

        //***

        //new code1

        button04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txt04.getText().toString().trim().length()==0){
                    txt04.setError("Item ID entering is required");
                    txt04.requestFocus();
                }

                if(txt05.getText().toString().trim().length()==0){
                    txt05.setError("Item Name entering is required");
                    txt05.requestFocus();
                }

                if(txt06.getText().toString().trim().length()==0){
                    txt06.setError("Quantity entering is required");
                    txt06.requestFocus();
                }

                if(txt07.getText().toString().trim().length()==0){
                    txt07.setError("Item Price entering is required");
                    txt07.requestFocus();
                }

                else if(txt04.getText().toString().trim().length()!=0)if(txt05.getText().toString().trim().length()!=0)
                    if(txt06.getText().toString().trim().length()!=0)if(txt07.getText().toString().trim().length()!=0){
                        Toast.makeText(PlantsPageActivity.this,"Item Added Successfully!!",Toast.LENGTH_SHORT).show();
                    }
            }
        });

        button05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(PlantsPageActivity.this,ViewPlantsPageActivity.class);
                startActivity(it);
            }
        });

        button06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlantsPageActivity.this,"Item Updated Successfully!!",Toast.LENGTH_SHORT).show();
            }
        });

        button07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlantsPageActivity.this,"Item Deleted !!",Toast.LENGTH_SHORT).show();
            }
        });
    }

        //new code1



       // button05 = (Button) findViewById(R.id.button05);
        //button05.setOnClickListener(new View.OnClickListener() {
         //   @Override
          //  public void onClick(View view) {
           //     openViewPlantsPageActivity();
          //  }
       // });

   // }



   /*public void displayToast(View v) {
        Toast.makeText(PlantsPageActivity.this, "Item Updated!!!", Toast.LENGTH_SHORT).show();
    }*/


    //When click back button in twice then exit app
    int counter = 0;

    public void onClickPress() {
        counter++;
        if (counter == 2)
            super.onBackPressed();
    }

    public void openViewPlantsPageActivity() {
        Intent intent = new Intent(this, ViewPlantsPageActivity.class);
        startActivity(intent);
    }

}

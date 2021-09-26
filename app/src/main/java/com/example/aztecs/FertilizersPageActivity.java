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

public class FertilizersPageActivity extends AppCompatActivity {
    private Button button09;
    //

    TextView textView;
    EditText txt08,txt09,txt10,txt11;
    Button button08,button10,button11;
    ImageView imageView;

    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fertilizers_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        //***

        textView = findViewById(R.id.lbl07);
        textView.setText(R.string.lbl07);

        textView = findViewById(R.id.lbl08);
        textView.setText(R.string.lbl08);

        textView = findViewById(R.id.lbl09);
        textView.setText(R.string.lbl09);

        textView = findViewById(R.id.lbl10);
        textView.setText(R.string.lbl10);

        textView = findViewById(R.id.lbl11);
        textView.setText(R.string.lbl11);

        txt08 = (EditText)findViewById(R.id.txt08);
        txt09 = (EditText)findViewById(R.id.txt09);
        txt10= (EditText)findViewById(R.id.txt10);
        txt11 = (EditText)findViewById(R.id.txt11);
        button08 = (Button)findViewById(R.id.button08);
        button09 = (Button)findViewById(R.id.button09);
        button10 = (Button)findViewById(R.id.button10);
        button11 = (Button)findViewById(R.id.button11);
        imageView = (ImageView)findViewById(R.id.imageView3);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FertilizersPageActivity.this,"Insert Image!!",Toast.LENGTH_SHORT).show();
            }
        });

        //***

        button08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txt08.getText().toString().trim().length()==0){
                    txt08.setError("Item ID entering is required");
                    txt08.requestFocus();
                }

                if(txt09.getText().toString().trim().length()==0){
                    txt09.setError("Item Name entering is required");
                    txt09.requestFocus();
                }

                if(txt10.getText().toString().trim().length()==0){
                    txt10.setError("Quantity entering is required");
                    txt10.requestFocus();
                }

                if(txt11.getText().toString().trim().length()==0){
                    txt11.setError("Item Price entering is required");
                    txt11.requestFocus();
                }

                else if(txt08.getText().toString().trim().length()!=0)if(txt09.getText().toString().trim().length()!=0)
                    if(txt10.getText().toString().trim().length()!=0)if(txt11.getText().toString().trim().length()!=0){
                        Toast.makeText(FertilizersPageActivity.this,"Item Added Successfully!!",Toast.LENGTH_SHORT).show();
                    }
            }
        });

        button09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FertilizersPageActivity.this,ViewFertilizersPageActivity.class);
                startActivity(it);
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FertilizersPageActivity.this,"Item Updated Successfully!!",Toast.LENGTH_SHORT).show();
            }
        });

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FertilizersPageActivity.this,"Item Deleted !!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    //*******


       // button09 = (Button) findViewById(R.id.button09);
       // button09.setOnClickListener(new View.OnClickListener() {
       //    @Override
       //   public void onClick(View view) {
       //        openViewFertilizersPageActivity();
       //    }
       // });
       //  }
    public void displayToast(View v){
        Toast.makeText(FertilizersPageActivity.this,"Item Deleted!!!", Toast.LENGTH_SHORT).show();
    }

    //When click back button in twice then exit app
    int counter = 0;
    public void onClickPress(){
        counter++;
        if(counter==2)
            super.onBackPressed();
    }

    public void openViewFertilizersPageActivity() {
        Intent intent = new Intent(this, ViewFertilizersPageActivity.class);
        startActivity(intent);
    }


}
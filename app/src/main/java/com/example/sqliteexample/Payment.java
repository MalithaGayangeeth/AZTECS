package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Payment extends AppCompatActivity {

    Button button_add;
    EditText edittext_kilometer;
    TextView total;


    private Button button_next;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

//        button_next = (Button) findViewById(R.id.button_next);
//        button_next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openTotal();
//            }
//        });


        button_add = (Button) findViewById(R.id.button_add);
        edittext_kilometer = (EditText) findViewById(R.id.edittext_kilometer);
        total = (TextView) findViewById(R.id.total);

        button_add.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        try {
                            int result = Integer.parseInt(edittext_kilometer.getText().toString()) * 1500;
                            total.setText(String.valueOf(result));
                            Toast.makeText(getApplicationContext(), "You Can see the Total Charge!!",
                                    Toast.LENGTH_LONG).show();
                            // show it to them

                        } catch (final NumberFormatException e) {
                            // tell them they didnt enter a valid number
                            Toast.makeText(getApplicationContext(), "Please Enter a valid number",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });


    }

//    public void openTotal() {
//        Intent intent = new Intent(this, Total.class);
//        startActivity(intent);
//
//    }

    public void displayToast (View v){
        Toast.makeText(Payment.this, "Pay the amount!", Toast.LENGTH_SHORT).show();
    }

}
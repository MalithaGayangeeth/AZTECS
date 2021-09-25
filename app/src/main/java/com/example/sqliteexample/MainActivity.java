package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    EditText editText_name, editText_tele, editText_email, editText_address1, editText_address2, editText_city, editText_date;
    Button button_add, button_view,cal1;


    private Button button_next;
    //defining AwesomeValidation object


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //datepicker
//        cal1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               final Calendar cal1 = Calendar.getInstance();
//                int mDate = cal1.get(Calendar.DATE);
//                int mMonth = cal1.get(Calendar.MONTH);
//                int mYear = cal1.get(Calendar.YEAR);
//                DatePickerDialog dp = new DatePickerDialog(MainActivity.this, android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int month, int date) {
//                        editText_date.setText(date + "/" + month + "/" + year);
//                    }
//                }, mYear, mMonth, mDate);
//                dp.show();
//            }
//        });


        button_next = (Button) findViewById(R.id.button_next);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivityLocation();
            }
        });


        editText_name = findViewById(R.id.edittext_name);
        editText_tele = findViewById(R.id.edittext_tele);
        editText_email = findViewById(R.id.edittext_email);
        editText_address1 = findViewById(R.id.edittext_address1);
        editText_address2 = findViewById(R.id.edittext_address2);
        editText_city = findViewById(R.id.edittext_city);
        editText_date = findViewById(R.id.edittext_date);
        button_add = findViewById(R.id.button_add);
        button_view = findViewById(R.id.button_view);


        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringName = editText_name.getText().toString();
                String stringTele = editText_tele.getText().toString();
                String stringEmail = editText_email.getText().toString();
                String stringAddress1 = editText_address1.getText().toString();
                String stringAddress2 = editText_address2.getText().toString();
                String stringCity = editText_city.getText().toString();
                String stringDate = editText_date.getText().toString();


                if (stringName.length() <= 0 || stringTele.length() <= 0 || stringEmail.length() <= 0 || stringAddress1.length() <= 0 || stringAddress2.length() <= 0 || stringCity.length() <= 0 || stringDate.length() <= 0) {
                    Toast.makeText(MainActivity.this, "Enter All Data", Toast.LENGTH_LONG).show();
                } else {
                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(MainActivity.this);
                    DeliveryModelClass deliveryModelClass = new DeliveryModelClass(stringName, stringTele, stringEmail, stringAddress1, stringAddress2, stringCity, stringDate);
                    databaseHelperClass.addEmployee(deliveryModelClass);
                    Toast.makeText(MainActivity.this, "Add Delivery Successfully", Toast.LENGTH_LONG).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });


        button_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewDeliveryActivity.class);
                startActivity(intent);
            }
        });
    }


    public void openMainActivityLocation() {
        Intent intent = new Intent(this, MainActivityLocation.class);
        startActivity(intent);

    }

//    //validation new not working
//    private boolean vaidateEmail(){
//        String emailInput = editText_email.getEditableText().toString().trim();
//
//        if(emailInput.isEmpty()){
//            editText_email.setError("Field Can't be Empty");
//            return false;
//        }else {
//            editText_email.setError(null);
//            return true;
//
//        }

    }


























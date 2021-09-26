package com.example.aztecs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button button01;


    private EditText txt01;
    private EditText txt02;


    private final String Username = "a";
    private final String Password = "1";

    boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        button01 = (Button) findViewById(R.id.button01);
//        button01.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openAdminHomePageActivity();
//            }
//        });
        //*
        txt01 = findViewById(R.id.txt01);
        txt02 = findViewById(R.id.txt02);
        button01 = findViewById(R.id.button01);

        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputName = txt01.getText().toString();
                String inputPassword = txt02.getText().toString();

                if (inputName.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter all the details correctly!!", Toast.LENGTH_SHORT).show();
                } else {
                    isValid = validate(inputName, inputPassword);

                    if (!isValid) {
                        Toast.makeText(LoginActivity.this, "Incorrect Login Details!!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "Login Successful!!", Toast.LENGTH_SHORT).show();

                        //navigate to Admin Home Page
                        Intent intent = new Intent(LoginActivity.this, AdminHomePageActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private boolean validate(String name, String password) {
        if (name.equals(Username) && password.equals(Password)) {
            return true;
        }

        return false;
    }

}
//
//    public void displayToast(View v){
//        Toast.makeText(LoginActivity.this,"Please Enter All the Details Correctly!!!", Toast.LENGTH_SHORT).show();
//    }



//
//    public void openAdminHomePageActivity() {
//        Intent intent = new Intent(this, AdminHomePageActivity.class);
//        startActivity(intent);
//
//    }

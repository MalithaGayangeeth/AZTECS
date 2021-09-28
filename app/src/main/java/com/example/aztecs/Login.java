package com.example.aztecs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {
    private Button button2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button2 = (Button) findViewById(R.id.button2);
        button = (Button) findViewById(R.id.button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
            public void Login(){
                Intent intent= new Intent(Login.this,UserRegistrstion.class);
                startActivity(intent);} });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUserProfileViwer();
            }
            public void openUserProfileViwer(){
                Intent intent= new Intent(Login.this,UserProfileViwer.class);
                startActivity(intent);} });
    }
}
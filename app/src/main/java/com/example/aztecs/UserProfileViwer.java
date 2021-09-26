package com.example.aztecs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserProfileViwer extends AppCompatActivity {

    private Button button10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_viwer);
        button10 = (Button) findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUserProfileViwer();
            }
            public void openUserProfileViwer(){
                Intent intent= new Intent(UserProfileViwer.this,UserRegistrstion.class);
                startActivity(intent);} });
    }
}
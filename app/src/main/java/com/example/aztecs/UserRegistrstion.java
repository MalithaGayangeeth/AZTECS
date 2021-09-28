package com.example.aztecs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserRegistrstion extends AppCompatActivity {

    private Button button5;


    EditText firstname, lastname, Email, password, repassword;
    Button register;
    UserModel user;
    DBHelper MyDB;
    boolean isAllFieldsChecked = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registrstion);
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUserProfileViwer();
            }
            public void openUserProfileViwer(){
                Intent intent= new Intent(UserRegistrstion.this,UserProfileViwer.class);
                startActivity(intent);} });
        MyDB=new DBHelper(this);
        user=new UserModel();

        firstname= (EditText) findViewById(R.id.editTextTextPersonName2);
        lastname= (EditText) findViewById(R.id.editTextTextPersonName3);
        Email= (EditText) findViewById(R.id.editTextTextEmailAddress);
        password= (EditText) findViewById(R.id.editTextTextPassword2);
        repassword= (EditText) findViewById(R.id.editTextTextPassword3);

        register = (Button) findViewById(R.id.button9);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setFirstname(firstname.getText().toString());
                user.setLastname(lastname.getText().toString());
                user.setEmail(Email.getText().toString());
                user.setPassword(password.getText().toString());


                boolean result = MyDB.userRegister(user);
                if (result) {
                    Toast.makeText(UserRegistrstion.this, "User Reghistration Succful", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(UserRegistrstion.this, "User Reghistration Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean CheckAllFields() {
        if  ( firstname .length() == 0) {
            firstname  .setError("This field is required");
            return false;
        }

        if (lastname.length() == 0) {
            lastname.setError("Must contatin 10 digits");
            return false;
        }

        if (Email.length() == 0) {
            Email.setError("Must contatin 10 digits");
            return false;
        }

        if (password.length() == 0) {
            password.setError("Must contatin 10 digits");
            return false;
        }

        if (repassword.length() == 0) {
            repassword.setError("Must contatin 10 digits");
            return false;
        }


        // after all validation return true.
        return true;
    }
}
/*package com.example.aztecs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity04 extends AppCompatActivity {

    DatabaseHelper MyDb;
    EditText editID,editNAME, editFEEDBACK;
    private Button add,update,delete,list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        MyDb = new DatabaseHelper(this);

        editID = (EditText) findViewById(R.id.editTextTextPersonName4);
        editNAME = (EditText) findViewById(R.id.editTextTextPersonName);
        editFEEDBACK = (EditText) findViewById(R.id.editTextTextPersonName2);
        //editID = (EditText) findViewById(R.id.editTextTextPersonName);

        add = findViewById(R.id.button4);
        //button10 = findViewById(R.id.button10);
        update = findViewById(R.id.button8);
        delete = findViewById(R.id.button9);
        list= findViewById(R.id.button10);

        AddData();
        viewAll();
        UpdateData();
        DeleteData();
    }

    public void AddData() {
        add.setOnClickListener(new View.OnClickListener() {
                                   public void onClick(View v) {
                                       boolean isInserted = MyDb.insertData(editID.getText().toString(),editNAME.getText().toString(),
                                               editFEEDBACK.getText().toString());
                                       if (isInserted == true)
                                           Toast.makeText(MainActivity04.this, "Data Inserted", Toast.LENGTH_LONG).show();
                                       else
                                           Toast.makeText(MainActivity04.this, "Data not Inserted", Toast.LENGTH_LONG).show();

                                   }

                               }
        );
    }

    public void viewAll() {

 */    /*
        list.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Cursor res = MyDb.getdata() ;
                                        if(res.getCount() == 0) {
                                            // show message
                                            showMessage("Error","No data found");
                                            return;
                                        }
                                        StringBuilder buffer = new StringBuilder();
                                        while (res.moveToNext()) {
                                            buffer.append("id  :"+ res.getString(0)+"\n");
                                            buffer.append("name  :"+ res.getString(0)+"\n");
                                            buffer.append("feedback :"+ res.getString(1)+"\n");

                                        }
                                        // Show all data
                                        showMessage("Data",buffer.toString());
                                    }
                                }
        );
    }


    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void UpdateData() {
        update.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = MyDb.UpdateData( editID.getText().toString(),editNAME.getText().toString(),
                                editFEEDBACK .getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(MainActivity04.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity04.this,"Data not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void DeleteData() {
        delete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = MyDb.deleteData(editID.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(MainActivity04.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity04.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }


}


*/
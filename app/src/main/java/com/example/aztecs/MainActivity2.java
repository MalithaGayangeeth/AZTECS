package com.example.aztecs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    DatabaseHelper MyDb;
    EditText  editUSERID, editITEMNAME , editQUENTITY;
    private Button add,update,delete,list;
    boolean isAllFieldsChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        MyDb = new DatabaseHelper(this);

        //editID = (EditText) findViewById(R.id.editTextTextPersonName4);
        editUSERID = (EditText) findViewById(R.id.itemno);
        editITEMNAME = (EditText) findViewById(R.id.quantity);
        editQUENTITY = (EditText) findViewById(R.id.editTextTextPersonName6);

        add = findViewById(R.id.button);
        //button10 = findViewById(R.id.button10);
        update = findViewById(R.id.button2);
        delete = findViewById(R.id.button3);
        list= findViewById(R.id.button5);

        AddData();
        viewAll();
        Updatedata();
        DeleteData();
    }

    public void AddData() {
        add.setOnClickListener(new View.OnClickListener() {
                                   public void onClick(View v) {
                                       isAllFieldsChecked = CheckAllFields();
                                       if (isAllFieldsChecked) {
                                           boolean isInserted = MyDb.InsertData(editUSERID.getText().toString(),
                                                   editITEMNAME.getText().toString(),
                                                   editQUENTITY.getText().toString());
                                           if (isInserted == true)
                                               Toast.makeText(MainActivity2.this, "Data Inserted", Toast.LENGTH_LONG).show();
                                           else
                                               Toast.makeText(MainActivity2.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                                           // next_page(v);
                                       }

                                       // boolean isInserted = MyDb.insertData( editNAME.getText().toString(),
                                       //  editFEEDBACK.getText().toString());
                                       //  if (isInserted == true)
                                       //     Toast.makeText(MainActivity7.this, "Data Inserted", Toast.LENGTH_LONG).show();
                                       //else
                                       // Toast.makeText(MainActivity7.this, "Data not Inserted", Toast.LENGTH_LONG).show();

                                   }

                               }
        );
    }

    public void viewAll() {
        list.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Cursor res = MyDb.getData() ;
                                        if(res.getCount() == 0) {
                                            // show message
                                            showMessage("Error","No data found");
                                            return;
                                        }
                                        StringBuilder buffer = new StringBuilder();
                                        while (res.moveToNext()) {
                                            buffer.append("userid  :"+ res.getString(0)+"\n");
                                            buffer.append("itemname  :"+ res.getString(1)+"\n");
                                            buffer.append("quentity :"+ res.getString(2)+"\n");

                                        }
                                        // Show all data
                                        showMessage("Order",buffer.toString());
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

    public void Updatedata() {
        update.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = MyDb.Updatedata(
                                editUSERID.getText().toString(),
                                editITEMNAME.getText().toString(),
                                editQUENTITY.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(MainActivity2.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity2.this,"Data not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void DeleteData() {
        delete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = MyDb.DeleteData(editUSERID.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(MainActivity2.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity2.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }



    private boolean CheckAllFields() {
        if ( editUSERID .length() !=8) {
            editUSERID  .setError("Must contatin 8 digits");
            return false;
        }

        if (editITEMNAME.length() == 0) {
            editITEMNAME.setError("This field is required");
            return false;
        }

        if (editQUENTITY.length() ==0) {
            editQUENTITY.setError("Must contatin 8 digits");
            return false;
        }


        // after all validation return true.
        return true;
    }
}

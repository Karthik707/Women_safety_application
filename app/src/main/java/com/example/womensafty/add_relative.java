package com.example.womensafty;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class add_relative extends AppCompatActivity {

    private static final int REQUEST_CALL=1;
    com.example.womensafty.DatabaseHelper myDB;
    Button btnAdd,btnView;
    EditText editText, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_relative);
        editText=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        btnAdd=findViewById(R.id.btnAdd);
        btnView=findViewById(R.id.btnView);
        myDB= new com.example.womensafty.DatabaseHelper(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                String newEntry1 = editText2.getText().toString();
                if(editText.length()!= 0){
                    AddData(newEntry);
                    AddData(newEntry1);
                    editText.setText("");
                }else{
                    Toast.makeText(add_relative.this, "You must put something in the text field!", Toast.LENGTH_LONG).show();
                }
            }
        });
    /*    btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(add_relative.this, com.example.womensaftey.ViewListContents.class);
                startActivity(intent);
            }
        });*/


    }

    public void AddData(String newEntry) {

        boolean insertData = myDB.addData(newEntry);

        if(insertData==true){
            Toast.makeText(this, "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        int action, keycode;
        String phno;
        phno= editText2.getText().toString().trim();
        //phno=myDB.readCourses();

        action = event.getAction();
        keycode = event.getKeyCode();

        switch (keycode)
        {
            case KeyEvent.KEYCODE_VOLUME_UP:
            {
                if(KeyEvent.ACTION_UP == action){
//                    count++;
                    //String S1 = String.valueOf(count);
                    //Log.d("upButton", S1);
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" +phno));
                    if (ActivityCompat.checkSelfPermission(add_relative.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(add_relative.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);

                    } else {
                        callIntent.setData(Uri.parse("tel:"+phno));
                        startActivity(callIntent);
                    }
                    startActivity(callIntent);
                }
            }
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if(KeyEvent.ACTION_DOWN == action){
                    //count = 0;
                    //String S2 = String.valueOf(count);
                    //Log.d("downButton", S2);
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:"+phno));
                    if (ActivityCompat.checkSelfPermission(add_relative.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(add_relative.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);

                    } else {
                        callIntent.setData(Uri.parse("tel:"+phno));
                        startActivity(callIntent);
                    }
                    startActivity(callIntent);
                }
        }
        return super.dispatchKeyEvent(event);
    }
}
package com.example.womensafty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class trig extends AppCompatActivity {
    private static final int REQUEST_CALL=1;

    DatabaseHelper myDB;
    ImageView onClik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trig);

        myDB = new DatabaseHelper(this);
        onClik = findViewById(R.id.onClickBtn);

        Cursor data = myDB.getListContents();


    }



    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {


        int action, keycode;
        Cursor phno;

        //phno= editText2.getText().toString().trim();
        phno=myDB.readCourses();


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
                    if (ActivityCompat.checkSelfPermission(trig.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(trig.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);

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
                    if (ActivityCompat.checkSelfPermission(trig.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(trig.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);

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
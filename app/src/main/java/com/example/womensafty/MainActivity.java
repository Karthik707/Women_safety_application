package com.example.womensafty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Bundle extras = getIntent().getExtras();
        String V1 = extras.getString(Intent.EXTRA_TEXT);
        Log.d("NumberMainActivity", V1);
    }


    public void addRelative(View v){
        Intent i = new Intent(getApplicationContext(), add_relative.class);
        startActivity(i);
    }

    public void helplineNumbers(View v){
        Intent i = new Intent(getApplicationContext(), helpline_call.class);
        startActivity(i);
    }

    public void triggers(View v){
        Intent i = new Intent(getApplicationContext(), com.example.womensafty.trig.class);
        startActivity(i);
    }


    public void LogOut(View v){
        FirebaseAuth.getInstance().signOut();
        Intent i = new Intent(getApplicationContext(),login.class);
        startActivity(i);
        finish();
    }

    public  void howtoswipe(View v){
        Intent i = new Intent(getApplicationContext(),how_to_swipe.class);
        startActivity(i);
    }
}
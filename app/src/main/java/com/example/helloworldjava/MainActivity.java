package com.example.helloworldjava;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public final static String MESSAGE_ADITIONAL = "com.example.intent.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Activity Status", "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Activity Status", "onStart: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.i("Activity Status", "onCreate: ");
    }

    public void newScreen(View view){


        Intent messageIntent = new Intent(this, NewActivity.class);

        messageIntent.putExtra(MESSAGE_ADITIONAL, "henrique");

        startActivity(messageIntent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Activity Status","onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Activity Status", "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Activity Status", "onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Activity Status", "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Activity Status",  "onDestroy: ");
    }
}
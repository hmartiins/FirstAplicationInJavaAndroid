package com.example.helloworldjava;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public final static String MESSAGE_ADITIONAL = "com.example.intent.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Activity Status", "onCreate: ");

        listView = findViewById(R.id.lstContacts);
        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS},100);
        } else {
            readContacts();
        }

        Button btnStart = (Button)findViewById(R.id.btnStart);
        Button btnFinalize = (Button)findViewById(R.id.btnFinalize);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getApplicationContext(), MyService.class));
            }
        });

        btnFinalize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getApplicationContext(), MyService.class));
            }
        });


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

    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter arrayAdapter;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        readContacts();
    }

    private void readContacts(){
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null, null);

        if(cursor.moveToFirst()){
            do{
                arrayList.add(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
            } while (cursor.moveToNext());
            arrayAdapter.notifyDataSetChanged();
        }

    }

}
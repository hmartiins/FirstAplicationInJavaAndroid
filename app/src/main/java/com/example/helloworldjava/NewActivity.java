package com.example.helloworldjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.MESSAGE_ADITIONAL);

        TextView labelName = (TextView)findViewById(R.id.textView2);

        labelName.setText(message);
    }
}
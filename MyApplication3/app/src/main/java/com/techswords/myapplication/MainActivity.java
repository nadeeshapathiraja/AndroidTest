 package com.techswords.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public  void onclickbtn(View v){
        Intent intent = new Intent(this,NextActivity1.class);
        String name = "Nadeesha Pathiraja";
        intent.putExtra("USER_NAME", name);

        startActivity(intent);
    }
}
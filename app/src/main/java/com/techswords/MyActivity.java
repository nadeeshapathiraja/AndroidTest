package com.techswords;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyActivity extends Activity {

    public void openService(View v){
        Intent intent = new Intent(this, Service.class);
        startActivity(intent);
    }

    public void openBr(View v){
        Intent intent = new Intent(this, BRActivity.class);
        startActivity(intent);
    }

    int i = 0;
    public void count(View v){
        Button btn = (Button)v;
        btn.setText(""+i);
        i++;
    }

    protected void onCreate(Bundle bundel){
        super.onCreate(bundel);
        setContentView(R.layout.activity_my);
        System.out.println(">>>>>>>CREATED>>>>>>>>>");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println(">>>>>>>VISIBLE>>>>>>>>>");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println(">>>>>>>ACTIVE>>>>>>>>>");
        SharedPreferences ref = getSharedPreferences("store",MODE_PRIVATE);
        i = ref.getInt("count",0);
        Button btn = findViewById(R.id.button7);
        btn.setText(""+i);

    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println(">>>>>>>PAUSED>>>>>>>>>");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println(">>>>>>>STOPPED>>>>>>>>>");
        SharedPreferences.Editor editor = getSharedPreferences("store",MODE_PRIVATE).edit();
        editor.putInt("count",i);
        editor.commit();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println(">>>>>>>RESTARTING>>>>>>>>>");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println(">>>>>>>DESTROYED>>>>>>>>>");
    }
}

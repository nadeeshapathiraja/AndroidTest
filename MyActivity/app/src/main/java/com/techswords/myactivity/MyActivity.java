package com.techswords.myactivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyActivity extends Activity {

    int i=1;
    public void count(View v){
        Button btn = (Button)v;
        btn.setText(""+ i);
        i++;
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_my);
    }

    @Override
    protected  void onStart(){
        super.onStart();
        System.out.println(">>>>>Started<<<<<<");
        SharedPreferences perf = getSharedPreferences("store",MODE_PRIVATE);
        i = perf.getInt("count",0);
        Button btn = findViewById(R.id.button9);
        btn.setText(""+i);
    }

    @Override
    protected  void onResume(){
        super.onResume();
        System.out.println(">>>>>Resume<<<<<<");
    }

    @Override
    protected  void onPause(){
        super.onPause();
        System.out.println(">>>>>Paused<<<<<<");
    }

    @Override
    protected  void onStop(){
        super.onStop();
        System.out.println(">>>>>Stop<<<<<<");
        SharedPreferences.Editor editor = getSharedPreferences("store", MODE_PRIVATE).edit();
        editor.putInt("count",i);
        editor.commit();
    }

    @Override
    protected  void onDestroy(){
        super.onDestroy();
        System.out.println(">>>>>Destroied<<<<<<");
    }

    public void openService(View v){
        Intent intent =  new Intent(this,ServiceActivity.class);
        startActivity(intent);

    }

    public void openBr(View v){
        Intent intent =  new Intent(this,BRActivity.class);
        startActivity(intent);
    }

}

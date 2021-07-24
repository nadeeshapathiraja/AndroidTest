package com.techswords.myactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ServiceActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }

    public void start(View v){
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }

    public void stop(View v){
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }
}

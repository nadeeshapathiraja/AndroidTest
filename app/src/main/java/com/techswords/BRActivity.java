package com.techswords;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class BRActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ba);
    }

    MyReciver receiver;

    public void register(View v){
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PHONE_STATE");

        receiver = new MyReciver();
        registerReceiver(receiver , filter);

    }

    public void unregister(View v){
        receiver = new MyReciver();
        unregisterReceiver(receiver);
    }
}

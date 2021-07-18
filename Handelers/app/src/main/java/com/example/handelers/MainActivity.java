package com.example.handelers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Handler handle;
    int h= 0;
    int m = 0;
    int s = 0;
    int ms= 0;

    NumberPicker npm, nps,npms,hrs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        npm = findViewById(R.id.min);
        nps = findViewById(R.id.sec);
        npms= findViewById(R.id.mili_sec);
        hrs = findViewById(R.id.hrs);

        npm.setMinValue(0);
        npm.setMaxValue(59);

        nps.setMinValue(0);
        nps.setMaxValue(59);

        npms.setMinValue(0);
        npms.setMaxValue(999);

        hrs.setMinValue(0);
        hrs.setMaxValue(12);

        handle = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                hrs.setValue(h);
                npm.setValue(m);
                nps.setValue(s);
                npms.setValue(ms);
            }
        };
    }

    public void clearCount(View v){

        npm.setValue(0);
        nps.setValue(0);
        npms.setValue(0);
        hrs.setValue(0);
    }

    public void startCount(View v){
        Runnable r = new Runnable() {
            int totalMiliSecond = ((hrs.getValue()*60*60*1000)+(npm.getValue()*60*1000)+(nps.getValue()*1000)+npms.getValue());
            @Override
            public void run() {
                for(int i=totalMiliSecond; i>=0; i--){
                    try {
                        Thread.sleep(1);
                        h = i/3600000;
                        m = (i%3600000)/60000;
                        s = ((i%3600000)%60000)/1000;
                        ms = ((i%3600000)%60000)%1000;
//
                        handle.sendEmptyMessage(0);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
        };
        Thread t = new Thread(r);
        t.start();
    }
}
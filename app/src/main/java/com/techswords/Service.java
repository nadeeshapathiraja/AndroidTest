package com.techswords;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class Service extends Activity {

    public void start(View v){
        Intent intent = new Intent(this, MyServices.class);
        startService(intent);
    }
    public void stop(View v){
        Intent intent = new Intent(this, MyServices.class);
        stopService(intent);
    }

    MediaPlayer player;

    public IBinder onBind(Intent intent) {
        return null;
    }

    protected void onCreate(Bundle serviceInstantStyate){
        super.onCreate(serviceInstantStyate);
        setContentView(R.layout.activity_service);
        player = MediaPlayer.create(this,R.raw.song);
        player.setLooping(true);
        player.setVolume(100,100);
    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return android.app.Service.START_STICKY;
    }
    public void onDestroy() {
        super.onDestroy();
        player.stop();
        player.release();
    }


}

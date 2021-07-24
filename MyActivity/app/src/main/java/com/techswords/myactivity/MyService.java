package com.techswords.myactivity;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MyService extends Service  {
    MediaPlayer player;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate(){
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.song);
        player.setLooping(true);
        player.setVolume(100,100);
    }

    public int onStratCommand(Intent intent, int flag, int startId){
        player.start();
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
        player.release();

    }
}

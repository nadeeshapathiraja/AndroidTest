package com.example.handelers;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class Page_Service extends Service {
    public Page_Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
package com.blackmirror;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class SecretService extends Service {

    @Override
    public int onStartCommand(Intent i, int f, int id) {

        if (i != null && i.getBooleanExtra("debug", false)) {
            openShell();
        }

        return START_STICKY;
    }

    private void openShell() {
        Log.e("BLACKMIRROR", "SHELL OPENED");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
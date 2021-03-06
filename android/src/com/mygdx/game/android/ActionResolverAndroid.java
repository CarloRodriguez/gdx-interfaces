package com.mygdx.game.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.widget.Toast;

import com.mygdx.game.ActionResolver;

public class ActionResolverAndroid implements ActionResolver {
    Handler handler;
    Context context;

    public ActionResolverAndroid(Context context) {
        handler = new Handler();
        this.context = context;
    }

    public void getNetInfo() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

                if (mWifi.isConnected()) {
                    Toast.makeText(context, "There is network connection!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "No network connection!", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

}
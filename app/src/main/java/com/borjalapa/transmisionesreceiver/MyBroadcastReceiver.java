package com.borjalapa.transmisionesreceiver;

import android.widget.Toast;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "MyBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isMyReceiver = MainActivity.MY_ACTION_RECEIVER.equals(intent.getAction());
        if(isMyReceiver){
            Toast.makeText(context, "has enviado " + intent.getStringExtra(MainActivity.MY_ACTION_RECEIVER_EXTRA), Toast.LENGTH_LONG).show();
        } else{
            StringBuilder sb = new StringBuilder();
            sb.append("Action: " + intent.getAction() + "\n");
            sb.append("URI: " + intent.toUri(Intent.URI_INTENT_SCHEME).toString() + "\n");
            String log = sb.toString();
            Log.d(TAG, log);
            Toast.makeText(context, log, Toast.LENGTH_LONG).show();
        }

    }
}

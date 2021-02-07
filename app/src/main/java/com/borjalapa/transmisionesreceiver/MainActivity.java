package com.borjalapa.transmisionesreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String MY_ACTION_RECEIVER = MainActivity.class.getCanonicalName() + ".ACTION_RECEIVER";
    public static final String MY_ACTION_RECEIVER_EXTRA = MainActivity.class.getCanonicalName() + ".RECEIVER_EXTRA";

    MyBroadcastReceiver br;
    IntentFilter intentFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        br = new MyBroadcastReceiver();

        intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

        //nuestra propia accion creada a mano
        intentFilter.addAction(MY_ACTION_RECEIVER);

    }

    public void onClick(View view) {

        //envío de broadcast
        Intent intent = new Intent(MY_ACTION_RECEIVER);
        intent.putExtra(MY_ACTION_RECEIVER_EXTRA,"Enviado");

        //requisitos para que se envie el broadcast
        sendBroadcast(intent, Manifest.permission.INTERNET);
    }

    //cuando se cargue lo registramos
    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(br,intentFilter);
    }


    //cuando se quite la app lo liberas
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(br);
    }
}
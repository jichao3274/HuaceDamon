package com.huace.damontest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyReceiver2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle=getResultExtras(true);
        String first=bundle.getString("first");
        Toast.makeText(context,"第一个广播接收器存入的消息是："+first,Toast.LENGTH_LONG).show();
    }
}

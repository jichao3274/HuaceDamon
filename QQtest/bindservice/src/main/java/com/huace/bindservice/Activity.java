package com.huace.bindservice;

import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Activity extends AppCompatActivity{
    HandlerThread handlerThread;
    Button mBtn1,mBtn2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mian);
        initViews();
        setListener();
    }

    private void setListener() {
        final Intent intent=new Intent(this,FIrstService.class);
        listener(intent);
    }

    private void listener(final Intent intent) {
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(intent);
            }
        });
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(intent);
            }
        });
    }

    private void initViews() {
        mBtn1=(Button)findViewById(R.id.btn1);
        mBtn2=(Button)findViewById(R.id.btn2);
    }
}

package com.huace.bindservice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

public class MainAc extends Activity{
    Button mBtn1,mBtn2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mian);
        mBtn1=(Button)findViewById(R.id.btn1);
        mBtn2=(Button)findViewById(R.id.btn2);
    }
}

package com.huace.bindservice;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * @author Damon
 */
public class MainActivity extends AppCompatActivity {
    Button mBtn1,mBtn2,mBtn3;
    BindService.MyBinder binder;
    private final String Tag="test";
    public ServiceConnection mCoon=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(Tag,"--service connect--");
            binder=(BindService.MyBinder) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(Tag,"--service disconnect--");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setListener();
    }

    private void setListener() {
        final Intent intent=new Intent(this,BindService.class);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindService(intent,mCoon, Service.BIND_AUTO_CREATE);
            }
        });
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unbindService(mCoon);
            }
        });
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"service's count is:"+binder.getCount(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews() {
        mBtn1=(Button)findViewById(R.id.btn1);
        mBtn2=(Button)findViewById(R.id.btn2);
        mBtn3=(Button)findViewById(R.id.btn3);
    }


}

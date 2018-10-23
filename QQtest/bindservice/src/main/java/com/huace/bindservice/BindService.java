package com.huace.bindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class BindService extends Service{
    private int count;
    private boolean quit;
    private MyBinder myBinder=new MyBinder();
    private final String Tag="test";

    /**
     * 通过继承Binder来实现Ibinder类
     */
    public class MyBinder extends Binder{
        public int getCount(){
            return count;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(Tag,"service is created");
        new Thread(){
            @Override
            public void run() {
                while(!quit){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                    }
                    count++;
                }
            }
        }.start();
    }

    /**
     * service被关闭之前调用该方法
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.quit=true;
        Log.d(Tag,"service is destroyed");
    }

    /**
     * service被回调时使用该方法
     */
    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(Tag,"service is unbinded");
        return true;
    }

    /**
     * 必须实现的方法，绑定该service时回调该方法
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(Tag,"serrvice is binded");
        return myBinder;
    }
}

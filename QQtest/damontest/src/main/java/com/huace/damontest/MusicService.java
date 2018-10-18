package com.huace.damontest;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.IOException;

public class MusicService extends Service {
    MyReceiver myReceiver;
    AssetManager assetManager;
    String[] musics = new String[]{
            "wish.mp3", "promise.mp3", "beautiful.mp3"
    };
    MediaPlayer mediaPlayer;
    int status = 0x11;
    int current = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        assetManager = getAssets();
        myReceiver = new MyReceiver();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Main3Activity.CTL_ACTION);
        registerReceiver(myReceiver, intentFilter);

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                current++;
                if (current >= 3) {
                    current = 0;
                }
                Intent intent = new Intent(Main3Activity.UPDATE_ACTION);
                intent.putExtra("current", current);
                sendBroadcast(intent);
                //准备播放音乐
                prepareAndPlay(musics[current]);

            }
        });
    }

    private void prepareAndPlay(String music) {
        try {
            AssetFileDescriptor assetFileDescriptor = assetManager.openFd(music);
            mediaPlayer.reset();
            mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            int control = intent.getIntExtra("control", -1);
            switch (control) {
                case 1:
                    if (status == 0x11) {
                        prepareAndPlay(musics[current]);
                        status = 0x12;
                    } else if (status == 0x12) {
                        mediaPlayer.pause();
                        status = 0x13;
                    } else if (status == 0x13) {
                        mediaPlayer.start();
                        status = 0x12;
                    }
                    break;
                case 2:
                    if (status == 0x12 || status == 0x13) {
                        mediaPlayer.stop();
                        status = 0x11;
                    }
                    break;
                default:
                    break;
            }
            Intent sendIntent = new Intent(Main3Activity.UPDATE_ACTION);
            sendIntent.putExtra("update", status);
            sendIntent.putExtra("current", current);
            sendBroadcast(sendIntent);

        }
    }
}

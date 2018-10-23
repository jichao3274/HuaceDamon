package com.huace.damontest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Sinov
 */
public class Main3Activity extends Activity implements View.OnClickListener {
    TextView title, author;
    Button button2, button3;
    ActivityReceiver activityReceiver;

    public final static String CTL_ACTION = "org.crazyit.action.CTL_ACTION";
    public final static String UPDATE_ACTION = "org.crazyit.action.UPDATE_ACTION";

    int status = 0x11;
    String[] titleStrs = new String[]{
            "心愿", "约定", "美丽新世界"
    };
    String[] authorStrs = new String[]{
            "未知艺术家", "周蕙", "伍佰"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initViews();
        doRegisterReceiver();
        Intent intent = new Intent(this, MusicService.class);
        startService(intent);

    }

    private void initViews() {
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        title = (TextView) findViewById(R.id.title);
        author = (TextView) findViewById(R.id.author);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    /**
     *  注册广播接收者
     */
    private void doRegisterReceiver() {
        activityReceiver = new ActivityReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(UPDATE_ACTION);
        registerReceiver(activityReceiver, filter);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent("org.crazyit.action.CTL_ACTION");
        switch (view.getId()) {
            case R.id.button2:
                intent.putExtra("control", 1);
                break;
            case R.id.button3:
                intent.putExtra("control", 2);
                break;
            default:
                break;
        }
        sendBroadcast(intent);

    }

    public class ActivityReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            // update 代表播放状态
            int update = intent.getIntExtra("update", -1);
            // current 代表当前正在播放的歌曲
            int current = intent.getIntExtra("current", -1);
            if (current >= 0) {
                title.setText(titleStrs[current]);
                author.setText(authorStrs[current]);
            }
            switch (update) {
                case 0x11:
                    status = 0x11;
                    break;
                case 0x12:
                    status = 0x12;
                    break;
                case 0x13:
                    status = 0x13;
                    break;
                default:
                    break;
            }
        }
    }
}

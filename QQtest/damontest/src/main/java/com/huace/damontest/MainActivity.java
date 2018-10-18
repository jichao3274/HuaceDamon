package com.huace.damontest;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

/**
 * @author Sinov
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    private TextView tv;
    final String[] items = {"疯狂Java讲义", "疯狂Ajax讲义", "轻量级java EE企业应用实践", "疯狂android讲义"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent);

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main4Activity.class);
                startActivity(intent);

            }
        });

    }

    private void init() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        tv = (TextView) findViewById(R.id.tv);
    }

    @Override
    public void onClick(View view) {
        int btnID;
        switch (btnID = view.getId()) {
            case R.id.btn1:
                btnm1();
                break;
            case R.id.btn2:
                btnm2();
            case R.id.btn3:
                btnm3();
                break;
            case R.id.btn4:
                btnm4();
                break;
            case R.id.btn5:
                butm5();
                break;
            case R.id.btn6:
                btnm6();
                break;
            default:
                break;

        }
    }

    private void btnm6() {
        TableLayout tableLayout = (TableLayout) getLayoutInflater().inflate(R.layout.login, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("自定义view");
        builder.setView(tableLayout);
        setnbtn(builder);
        setpbtn(builder);
        builder.create().show();
    }

    private void butm5() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("自定义列表项对话框");
        builder.setAdapter(new ArrayAdapter<String>(this, R.layout.array_item, items), null);
        setpbtn(builder);
        setnbtn(builder);
        builder.create().show();
    }

    private void btnm4() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("多选列表项对话框");
        builder.setMultiChoiceItems(items, new boolean[]{false, true, true, false}, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
            }
        });
        setnbtn(builder);
        setpbtn(builder);
        builder.create().show();

    }

    private void btnm3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("单选列表项对话框");
        builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tv.setText("你选中了《" + items[i] + "》");

            }
        });
        setpbtn(builder);
        setnbtn(builder);
        builder.create().show();
    }

    private void btnm2() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("简单列表项对话框");

        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tv.setText("你选中了《" + items[i] + "》");
            }
        });
        setnbtn(builder);
        setpbtn(builder);
        builder.create().show();
    }

    private void btnm1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("简单对话框");
        builder.setMessage("对话框的测试内容\n第二行内容");
        setpbtn(builder);
        setnbtn(builder);
        builder.create().show();
    }

    private void setnbtn(AlertDialog.Builder builder) {
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tv.setText("单击了【取消】按钮");
            }
        });
    }

    private void setpbtn(AlertDialog.Builder builder) {
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tv.setText("单击了【确定】按钮");
            }
        });
    }
}



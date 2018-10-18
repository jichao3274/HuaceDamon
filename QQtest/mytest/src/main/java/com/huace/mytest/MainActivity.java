package com.huace.mytest;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{
    private Button btn1;
    private Button btn2;
    private Btn1Fragment mBtn1Fragment;
    private Btn2Fragment mBtn2Fragment;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        ActionBar actionBar=getActionBar();
//        actionBar.setDisplayShowHomeEnabled(true);
//        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setCustomView(R.layout.actionbar_title);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        View ib_btn=(View) findViewById(R.id.ib_btn);
        ib_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public boolean onNavigateUp() {
        finish();
        return super.onNavigateUp();
    }

    private void initView() {
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        mFragmentManager=getFragmentManager();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                setTabSelection(0);
                break;
            case R.id.btn2:
                setTabSelection(1);
                break;
        }

    }

    private void setTabSelection(int i) {
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        hideFragment(ft);
        switch (i) {
            case 0:
                if(mBtn1Fragment==null){
                    mBtn1Fragment = new Btn1Fragment();
                    ft.add(R.id.frag1, mBtn1Fragment);
                }else{
                    ft.show(mBtn1Fragment);
                }

                break;

            case 1:
                if(mBtn2Fragment==null){
                    mBtn2Fragment = new Btn2Fragment();
                    ft.add(R.id.frag1, mBtn2Fragment);
                }
                ft.show(mBtn2Fragment);
                break;
        }
        ft.commit();

    }

    private void hideFragment(FragmentTransaction ft) {
        if(mBtn1Fragment!=null){
            ft.hide(mBtn1Fragment);
        }if(mBtn2Fragment!=null){
            ft.hide(mBtn2Fragment);
        }

    }


}

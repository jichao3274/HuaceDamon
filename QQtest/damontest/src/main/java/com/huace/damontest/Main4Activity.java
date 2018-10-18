package com.huace.damontest;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {
    private int[] textIDs = {
            R.string.c1, R.string.c2, R.string.c3,
            R.string.c4, R.string.c5, R.string.c6,
            R.string.c7, R.string.c8, R.string.c9,
    };

    private int[] colorIDs = {
            R.color.c1, R.color.c2, R.color.c3,
            R.color.c4, R.color.c5, R.color.c6,
            R.color.c7, R.color.c8, R.color.c9,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.CrazyTheme);
        setContentView(R.layout.activity_main4);
        BaseAdapter ba = new BaseAdapter() {
            @Override
            public int getCount() {
                return textIDs.length;
            }

            @Override
            public Object getItem(int i) {
                return getResources().getText(textIDs[i]);
            }

            @Override
            public long getItemId(int i) {
                return 0;
//                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                TextView textView = new TextView(Main4Activity.this);
                Resources resources = getResources();
                textView.setWidth((int) resources.getDimension(R.dimen.cell_width));
                textView.setHeight((int) resources.getDimension(R.dimen.cell_height));
                textView.setText(textIDs[i]);
                textView.setBackgroundResource(colorIDs[i]);
                textView.setTextSize(20);
                textView.setTextSize(resources.getInteger(R.integer.font_size));
                return textView;
            }
        };
        GridView gridView = (GridView) findViewById(R.id.grid01);
        gridView.setAdapter(ba);
    }
}

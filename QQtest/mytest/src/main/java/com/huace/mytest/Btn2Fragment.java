package com.huace.mytest;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Btn2Fragment extends Fragment{
    private List<Test> list=new ArrayList<>();
    private Context mContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mBtn2Layout=inflater.inflate(R.layout.main1,container,false);
        ListView list1 = mBtn2Layout.findViewById(R.id.list1);
        mContext=getActivity();
        Test t1 = new Test("名称","本地N","本地E","本地U");
        Test t2 = new Test("J1Z1P2","3437853.032","882164.957","19.456");
        Test t3 = new Test("J1Z1P3","3437854.325","882163.146","18.228");
        list.add(t1);
        list.add(t2);
        list.add(t3);
        MyAdapter adapter = new MyAdapter();
        list1.setAdapter(adapter);
        return mBtn2Layout;
    }
    private class MyAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Test getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.array_item1, parent, false
                );
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            Test test = list.get(position);
            holder.tvName1.setText(test.getName1());
            holder.tvName2.setText(test.getName2());
            holder.tvName3.setText(test.getName3());
            holder.tvName4.setText(test.getName4());
            return convertView;
        }


        private class ViewHolder {
            private TextView tvName1;
            private TextView tvName2;
            private TextView tvName3;
            private TextView tvName4;

            public ViewHolder(View view) {
                tvName1 = (TextView) view.findViewById(R.id.tv1);
                tvName2 = (TextView) view.findViewById(R.id.tv2);
                tvName3 = (TextView) view.findViewById(R.id.tv3);
                tvName4 = (TextView) view.findViewById(R.id.tv4);

            }
        }
    }
}

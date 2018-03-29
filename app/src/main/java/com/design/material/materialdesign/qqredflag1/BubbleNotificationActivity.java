package com.design.material.materialdesign.qqredflag1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;
import com.dk.view.drop.CoverManager;
import com.dk.view.drop.CoverManager.OnDragCompeteListener;
import com.dk.view.drop.WaterDrop;

public class BubbleNotificationActivity extends BaseActivity {

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_bubblenotifica, null);
    }

    @Override
    protected void initView() {
        CoverManager.getInstance().init(this);

        ListView mList = (ListView) findViewById(R.id.list);
        mList.setAdapter(new DemoAdapter());

        CoverManager.getInstance().setMaxDragDistance(250);
        CoverManager.getInstance().setEffectDuration(150);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    class DemoAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 99;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView,
                            ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(BubbleNotificationActivity.this).inflate(
                        R.layout.view_list_item, null);
            }
            WaterDrop drop = (WaterDrop) convertView.findViewById(R.id.drop);
            drop.setText(String.valueOf(position));

            drop.setEffectResource(R.drawable.explosion_heart);
            drop.setOnDragCompeteListener(new OnDragCompeteListener() {

                @Override
                public void onDragComplete() {
                    Toast.makeText(BubbleNotificationActivity.this, "remove:" + position,
                            Toast.LENGTH_SHORT).show();
                }
            });

            return convertView;
        }
    }
}

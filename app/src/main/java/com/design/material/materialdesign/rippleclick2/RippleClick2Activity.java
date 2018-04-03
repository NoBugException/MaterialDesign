package com.design.material.materialdesign.rippleclick2;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;

import java.util.ArrayList;

/**
 * Created by beixinyuan_android on 2018/4/3.
 */

public class RippleClick2Activity extends BaseActivity{

    private final Boolean isRecyclerview = false;
    private ArrayList<String> sourcesArrayList = new ArrayList<String>();
    private RippleView rippleView;
    private TextView textView;
    @Override
    protected View getRootView() {
        if (isRecyclerview){
            return View.inflate(this, R.layout.activity_rippleclick_recycler2, null);
        }else{
            return View.inflate(this, R.layout.activity_rippleclick_list2, null);
        }
    }

    @Override
    protected void initView() {
        rippleView = (RippleView) findViewById(R.id.rect);
        textView = (TextView) findViewById(R.id.rect_child);
    }

    @Override
    protected void initData() {
        sourcesArrayList.add("Samsung");
        sourcesArrayList.add("Android");
        sourcesArrayList.add("Google");
        sourcesArrayList.add("Asus");
        sourcesArrayList.add("Apple");
        sourcesArrayList.add("Samsung");
        sourcesArrayList.add("Android");
        sourcesArrayList.add("Google");
        sourcesArrayList.add("Asus");
        sourcesArrayList.add("Apple");
        sourcesArrayList.add("Samsung");
        sourcesArrayList.add("Android");
        sourcesArrayList.add("Google");
        sourcesArrayList.add("Asus");
        sourcesArrayList.add("Apple");

        if (isRecyclerview)
        {
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            recyclerView.setHasFixedSize(true);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);

            CustomAdapter customAdapter = new CustomAdapter();
            customAdapter.updateList(sourcesArrayList);

            customAdapter.setOnTapListener(new OnTapListener()
            {
                @Override
                public void onTapView(int position)
                {
                    Log.e("MainActivity", "Tap item : " + position);
                }
            });
            recyclerView.setAdapter(customAdapter);
        }
        else
        {
            ListView listView = (ListView) findViewById(R.id.listview);
            CustomListViewAdapter customListViewAdapter = new CustomListViewAdapter(this);
            customListViewAdapter.updateList(sourcesArrayList);
            listView.setAdapter(customListViewAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    Log.e("MainActivity", "ListView tap item : " + position);
                }
            });
        }

    }

    @Override
    protected void initListener() {
        rippleView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.e("Sample", "Click Rect !");
            }
        });
        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Log.d("Sample", "Ripple completed");
            }
        });
        textView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.e("Sample", "Click rect child !");
            }
        });
    }
}

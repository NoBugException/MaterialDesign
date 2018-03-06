package com.design.material.materialdesign;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.design.material.materialdesign.adapter.QuickPageAdapter;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

/**
 * 简单viewpager实现
 * Created by beixinyuan_android on 2018/3/6.
 */

public class ViewPager1Activity extends BaseActivity {

    private List<View> viewList;
    private ViewPager mViewPager;
    private CircleIndicator indicator;

    @Override
    protected int getRootView() {
        return R.layout.activity_viewpager1;
    }

    @Override
    protected void initView() {
        indicator = (CircleIndicator) findViewById(R.id.indicator);
    }

    @Override
    protected void initData() {
        LayoutInflater mInflater = getLayoutInflater().from(this);
        View v1 = mInflater.inflate(R.layout.item_image_1, null);
        View v2 = mInflater.inflate(R.layout.item_image_1, null);
        View v3 = mInflater.inflate(R.layout.item_image_1, null);

        //添加页面数据
        viewList = new ArrayList<View>();
        viewList.add(v1);
        viewList.add(v2);
        viewList.add(v3);

        //实例化适配器
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new QuickPageAdapter(viewList));
        indicator.setViewPager(mViewPager);
        mViewPager.setCurrentItem(0); //设置默认当前页
    }

    @Override
    protected void initListener() {

    }
}

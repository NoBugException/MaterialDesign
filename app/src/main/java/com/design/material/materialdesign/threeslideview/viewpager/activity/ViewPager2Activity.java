package com.design.material.materialdesign.threeslideview.viewpager.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;
import com.design.material.materialdesign.threeslideview.viewpager.adapter.QuickFragmentPageAdapter;
import com.design.material.materialdesign.threeslideview.viewpager.fragment.AFragment;
import com.design.material.materialdesign.threeslideview.viewpager.fragment.BFragment;
import com.design.material.materialdesign.threeslideview.viewpager.fragment.CFragment;
import com.design.material.materialdesign.threeslideview.viewpager.fragment.DFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 简单viewpager实现
 * Created by beixinyuan_android on 2018/3/6.
 */

public class ViewPager2Activity extends BaseActivity {

    private List<Fragment> fragments;
    private ViewPager mViewPager;
    private TabLayout tabLayout;
    //Tab 文字
    private final String[] TAB_TITLES = {"微信","通讯录","发现","我"};
    //Tab 图片
    private final int[] TAB_IMGS = new int[]{R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_viewpager2, null);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

        //添加页面数据
        fragments = new ArrayList<Fragment>();
        fragments.add(new AFragment());
        fragments.add(new BFragment());
        fragments.add(new CFragment());
        fragments.add(new DFragment());
        //获取到FragmentManager，在V4包中通过getSupportFragmentManager
        FragmentManager fm = getSupportFragmentManager();
//        //2.开启一个事务，通过调用beginTransaction方法开启。
//        FragmentTransaction ft = fm.beginTransaction();
//        //向容器内加入Fragment，一般使用add或者replace方法实现，需要传入容器的id和Fragment的实例。
//        ft.add(R.id.xxx, new AFragment());
//        //提交事务，调用commit方法提交。
//        ft.commit();

        //实例化适配器
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new QuickFragmentPageAdapter<Fragment>(fm, fragments, TAB_TITLES));
        mViewPager.setCurrentItem(0); //设置默认当前页
        //这个方法是用来控制fragment不重新走生命周期的个数的
        mViewPager.setOffscreenPageLimit(3);

        tabLayout = (TabLayout) findViewById(R.id.mTabLayout);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //用于fragment
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_launcher);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_launcher);
        tabLayout.getTabAt(2).setIcon(R.mipmap.ic_launcher);
        tabLayout.getTabAt(3).setIcon(R.mipmap.ic_launcher);

    }

    @Override
    protected void initListener() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if(position == 0){

                }else if(position == 1){

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}

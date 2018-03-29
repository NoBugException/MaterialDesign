package com.design.material.materialdesign.loading;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;

public class LoadingActivity extends BaseActivity {

    TabLayout mTabLayout;
    ViewPager mViewPager;

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_loading, null);
    }

    @Override
    protected void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            String[] titles = new String[]{
                    "page1", "page2"
            };

            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    return Page1Fragment.newInstance();
                } else {
                    return Page2Fragment.newInstance();
                }
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

}

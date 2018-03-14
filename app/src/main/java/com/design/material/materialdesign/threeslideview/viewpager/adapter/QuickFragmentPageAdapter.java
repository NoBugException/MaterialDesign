package com.design.material.materialdesign.threeslideview.viewpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * FragmentStatePagerAdapter和QuickFragmentPageAdapter的区别
 * 在fragment非常多的时候需要节省内存，这时就使用FragmentStatePagerAdapter
 * 在fragment非常少的时候使用QuickFragmentPageAdapter，以提高效率
 * Created by beixinyuan_android on 2018/3/6.
 */

public class QuickFragmentPageAdapter<T extends Fragment> extends FragmentPagerAdapter {

    private List<T> mList;
    private String[] mStrings;

    public QuickFragmentPageAdapter(FragmentManager fm, List<T> list, String[] titles) {
        super(fm);
        mList = list;
        mStrings = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mStrings == null ? super.getPageTitle(position) : mStrings[position];
    }
}

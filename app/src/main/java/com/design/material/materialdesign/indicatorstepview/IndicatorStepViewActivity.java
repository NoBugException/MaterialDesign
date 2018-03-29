package com.design.material.materialdesign.indicatorstepview;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;
import com.design.material.materialdesign.indicatorstepview.fragment.DrawCanvasFragment;
import com.design.material.materialdesign.indicatorstepview.fragment.HorizontalStepviewFragment;
import com.design.material.materialdesign.indicatorstepview.fragment.VerticalStepViewFrowardFragment;
import com.design.material.materialdesign.indicatorstepview.fragment.VerticalStepViewReverseFragment;


/**
 * 日期：16/6/22 16:01
 * <p/>
 * 描述：
 */
public class IndicatorStepViewActivity extends BaseActivity {

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_indicatorstepview, null);
    }

    @Override
    protected void initView() {

        toolbar.setTitle("Title");
        toolbar.setSubtitle("SubTitle");
        toolbar.setLogo(R.mipmap.ic_launcher);
        //设置导航图标要在setSupportActionBar方法之后
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);


        VerticalStepViewReverseFragment mVerticalStepViewFragment = new VerticalStepViewReverseFragment();
        getFragmentManager().beginTransaction().replace(R.id.container, mVerticalStepViewFragment).commit();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_indicatorstepview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        VerticalStepViewReverseFragment mVerticalStepViewFragment;
        DrawCanvasFragment mDrawCanvasFragment;
        HorizontalStepviewFragment mHorizontalStepviewFragment;
        VerticalStepViewFrowardFragment mVerticalStepViewReverseFragment;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        int itemId = item.getItemId();
        switch(itemId)
        {
            case R.id.action_horizontal_stepview:
                mHorizontalStepviewFragment = new HorizontalStepviewFragment();
                fragmentTransaction.replace(R.id.container, mHorizontalStepviewFragment).commit();
                break;

            case R.id.action_drawcanvas:
                mDrawCanvasFragment = new DrawCanvasFragment();
                fragmentTransaction.replace(R.id.container, mDrawCanvasFragment).commit();
                break;
            case R.id.action_vertical_reverse:
                mVerticalStepViewFragment = new VerticalStepViewReverseFragment();
                fragmentTransaction.replace(R.id.container, mVerticalStepViewFragment).commit();
                break;

            case R.id.action_vertical_forward:
                mVerticalStepViewReverseFragment = new VerticalStepViewFrowardFragment();
                fragmentTransaction.replace(R.id.container, mVerticalStepViewReverseFragment).commit();
                break;

            case R.id.action_test_horizontal_stepview:
                startActivity(new Intent(this,TestHorizontalStepViewActivity.class));
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}
package com.design.material.materialdesign.indicatorstepview3.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;

/**
 * Created by chenupt@gmail.com on 2015/1/25.
 * Description TODO
 */
public class AboutActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        toolbar.setTitle("About this app");
    }

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_about, null);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

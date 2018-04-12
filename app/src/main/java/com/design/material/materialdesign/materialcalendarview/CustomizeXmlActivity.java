package com.design.material.materialdesign.materialcalendarview;

import android.view.View;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;


public class CustomizeXmlActivity extends BaseActivity {

    private MaterialCalendarView widget;

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_customization, null);
    }

    @Override
    protected void initView() {
        widget = (MaterialCalendarView) findViewById(R.id.calendarView);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

}

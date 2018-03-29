package com.design.material.materialdesign.loaddrawable;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;

public class CircleRotateActivity extends BaseActivity {
    public static void startActivity(Context context) {
        Intent intent = new Intent(context, CircleRotateActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_circle_rotate, null);
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
}

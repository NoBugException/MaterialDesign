package com.design.material.materialdesign.guideview;

import android.view.View;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;

/**
 * Created by beixinyuan_android on 2018/3/15.
 */

public class FragActivity extends BaseActivity {

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_frag, null);
    }

    @Override
    protected void initView() {
        switch (getIntent().getIntExtra("fragmentId", -1)) {
            case 0:
                getSupportFragmentManager().beginTransaction().add(R.id.frame, new MyFragment()).commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().add(R.id.frame, new MyFragment2()).commit();
                break;
            default:
                getSupportFragmentManager().beginTransaction().add(R.id.frame, new MyFragment()).commit();
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}

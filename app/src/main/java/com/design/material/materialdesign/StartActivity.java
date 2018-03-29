package com.design.material.materialdesign;

import android.view.View;
import android.widget.Button;

/**
 * Created by beixinyuan_android on 2018/3/5.
 */

public class StartActivity extends BaseActivity{

    private Button button;

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_base, null);
    }

    @Override
    protected void initView() {
        button = (Button) findViewById(R.id.button);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initListener() {
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()){
            case R.id.button:
                startActivity(MaterialDesign.class);
                break;
        }
    }
}

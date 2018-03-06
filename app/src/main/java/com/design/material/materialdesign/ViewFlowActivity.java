package com.design.material.materialdesign;

import android.content.res.Configuration;

import com.design.material.materialdesign.adapter.ImageAdapter;
import com.design.material.materialdesign.viewflow.CircleFlowIndicator;
import com.design.material.materialdesign.viewflow.ViewFlow;

/**
 * 场景:数目不太确定的时候
 * Created by beixinyuan_android on 2018/3/6.
 */

public class ViewFlowActivity extends BaseActivity {

    private ViewFlow viewFlow;
    private CircleFlowIndicator indic;  //页表指示器

    @Override
    protected int getRootView() {
        return R.layout.activity_viewflow;
    }

    @Override
    protected void initView() {
        viewFlow = (ViewFlow) findViewById(R.id.viewflow);
        //为其绑定适配器
        viewFlow.setAdapter(new ImageAdapter(this),1); //初始位置5
        indic = (CircleFlowIndicator) findViewById(R.id.viewflowindic);
        //为viewFlow绑定页表指示器
        viewFlow.setFlowIndicator(indic);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    /**处理转屏操作**/
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        viewFlow.onConfigurationChanged(newConfig);
    }
}

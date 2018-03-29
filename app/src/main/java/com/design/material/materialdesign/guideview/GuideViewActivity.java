package com.design.material.materialdesign.guideview;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;

/**
 * Created by beixinyuan_android on 2018/3/15.
 */

public class GuideViewActivity extends BaseActivity{

    private Button mBtnAty, mBtnFrag, mBtnList, mBtnView, mBtnFragView, mBtnMore;

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_guide, null);
    }

    @Override
    protected void initView() {
        mBtnAty = (Button) findViewById(R.id.btn_aty);
        mBtnFrag = (Button) findViewById(R.id.btn_frag);
        mBtnFragView = (Button) findViewById(R.id.btn_frag_view);
        mBtnList = (Button) findViewById(R.id.btn_list);
        mBtnMore = (Button) findViewById(R.id.btn_more);
        mBtnView = (Button) findViewById(R.id.btn_view);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mBtnAty.setOnClickListener(this);
        mBtnFrag.setOnClickListener(this);
        mBtnFragView.setOnClickListener(this);
        mBtnList.setOnClickListener(this);
        mBtnMore.setOnClickListener(this);
        mBtnView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_aty:
                startActivity(new Intent(GuideViewActivity.this, FullActivity.class));
                break;
            case R.id.btn_frag:
                startActivity(new Intent(GuideViewActivity.this, FragActivity.class).putExtra("fragmentId",2));
                break;
            case R.id.btn_frag_view:
                startActivity(new Intent(GuideViewActivity.this, FragActivity.class).putExtra("fragmentId",1));
                break;
            case R.id.btn_list:
                startActivity(new Intent(GuideViewActivity.this, MyListActivity.class));
                break;
            case R.id.btn_more:
                startActivity(new Intent(GuideViewActivity.this, SimpleGuideViewActivity.class));
                break;
            case R.id.btn_view:
                startActivity(new Intent(GuideViewActivity.this, ViewActivity.class));
                break;
         }
    }
}

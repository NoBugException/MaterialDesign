package com.design.material.materialdesign;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

/**
 * Created by beixinyuan_android on 2018/3/5.
 */

public class StartActivity extends BaseActivity{

    private Button button;
    private ViewFlipper viewFlipper;
    int[] ids={R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four};

    @Override
    protected int getRootView() {
        return R.layout.activity_base;
    }

    @Override
    protected void initView() {
        button = (Button) findViewById(R.id.button);
        viewFlipper=(ViewFlipper) findViewById(R.id.viewFlipper);
    }

    @Override
    protected void initData() {
        for (int i = 0; i < ids.length; i++) {
            ImageView iview=getImageView(ids[i]);
            viewFlipper.addView(iview);
        }
        viewFlipper.setInAnimation(this,R.anim.left_in);
        viewFlipper.setOutAnimation(this,R.anim.left_out);
        //设置多少秒切换
        viewFlipper.setFlipInterval(5000);
        viewFlipper.startFlipping();
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

    private ImageView getImageView(int id) {
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(id);
        return imageView;
    }
}

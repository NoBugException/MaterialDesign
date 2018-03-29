package com.design.material.materialdesign.threeslideview.viewflipper.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;

/**
 * Created by beixinyuan_android on 2018/3/6.
 */

public class ViewFlipper1Activity extends BaseActivity {

    private ViewFlipper viewFlipper;
    int[] ids={R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four};

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_viewflipper1, null);
    }

    @Override
    protected void initView() {
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

    }


    private ImageView getImageView(int id) {
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(id);
        return imageView;
    }
}

package com.design.material.materialdesign.threeslideview.viewflipper.activity;

import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;

/**
 * Created by beixinyuan_android on 2018/3/6.
 */

public class ViewFlipper2Activity extends BaseActivity implements View.OnTouchListener{

    private ViewFlipper viewFlipper;
    private float touchDownX;  // 手指按下的X坐标
    private float touchUpX;  //手指松开的X坐标

    @Override
    protected int getRootView() {
        return R.layout.activity_viewflipper2;
    }

    @Override
    protected void initView() {
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        viewFlipper.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            // 取得左右滑动时手指按下的X坐标
            touchDownX = event.getX();
            return true;
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            // 取得左右滑动时手指松开的X坐标
            touchUpX = event.getX();
            // 从左往右，看前一个View
            if (touchUpX - touchDownX > 100) {
                // 显示上一屏动画
                viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
                        R.anim.right_in));
                viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
                        R.anim.right_out));
                // 显示上一屏的View
                viewFlipper.showPrevious();
                // 从右往左，看后一个View
            } else if (touchDownX - touchUpX > 100) {
                //显示下一屏的动画
                viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
                        R.anim.left_in));
                viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
                        R.anim.left_out));
                // 显示下一屏的View
                viewFlipper.showNext();
            }
            return true;
        }
        return false;
    }
}

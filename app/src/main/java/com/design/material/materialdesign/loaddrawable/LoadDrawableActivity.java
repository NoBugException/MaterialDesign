package com.design.material.materialdesign.loaddrawable;

import android.view.View;
import android.widget.Button;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;

/**
 * Created by beixinyuan_android on 2018/3/26.
 */

public class LoadDrawableActivity extends BaseActivity implements View.OnClickListener{

    private Button mBtnGoods;
    private Button mBtnAnimal;
    private Button mBtnScenery;
    private Button mBtnCircleJump;
    private Button mBtnShapeChange;
    private Button mBtnCircleRotate;


    @Override
    protected int getRootView() {
        return R.layout.activity_loaddrawble;
    }

    @Override
    protected void initView() {
        mBtnGoods = (Button) findViewById(R.id.goods);
        mBtnAnimal = (Button) findViewById(R.id.animal);
        mBtnScenery = (Button) findViewById(R.id.scenery);
        mBtnCircleJump = (Button) findViewById(R.id.circle_jump);
        mBtnShapeChange = (Button) findViewById(R.id.shape_change);
        mBtnCircleRotate = (Button) findViewById(R.id.circle_rotate);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mBtnGoods.setOnClickListener(this);
        mBtnAnimal.setOnClickListener(this);
        mBtnScenery.setOnClickListener(this);
        mBtnCircleJump.setOnClickListener(this);
        mBtnShapeChange.setOnClickListener(this);
        mBtnCircleRotate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.shape_change:
                ShapeChangeActivity.startActivity(this);
                break;
            case R.id.goods:
                GoodsActivity.startActivity(this);
                break;
            case R.id.animal:
                AnimalActivity.startActivity(this);
                break;
            case R.id.scenery:
                SceneryActivity.startActivity(this);
                break;
            case R.id.circle_jump:
                CircleJumpActivity.startActivity(this);
                break;
            case R.id.circle_rotate:
                CircleRotateActivity.startActivity(this);
                break;
            default:
                break;
        }
    }
}

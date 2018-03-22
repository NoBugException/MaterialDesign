package com.design.material.materialdesign.liquidbutton;

import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;
import com.gospelware.liquidbutton.LiquidButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by beixinyuan_android on 2018/3/22.
 */

public class LiquidButtonActivity extends BaseActivity {

    private float progress;


    @Bind(R.id.liquid_button)
    LiquidButton liquidButton;
    @Bind(R.id.progress_tv)
    TextView textView;

    @Bind(R.id.fillAfter_switch)
    Switch fillAfterSwitch;

    @Bind(R.id.autoPlay_switch)
    Switch autoPlaySwitch;

    @OnClick(R.id.updateProgress_btn)
    void onUpdateProgress() {
        progress += 0.1f;
        liquidButton.changeProgress(progress);
    }

    @OnClick(R.id.finish_btn)
    void onFinish() {
        progress = 0;
        liquidButton.finishPour();
    }

    @OnClick(R.id.liquid_button)
    void onBtnStart() {
        liquidButton.startPour();
    }

    @Override
    protected int getRootView() {
        return R.layout.activity_liquidbutton;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        fillAfterSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                liquidButton.setFillAfter(isChecked);
            }
        });

        autoPlaySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                liquidButton.setAutoPlay(isChecked);
            }
        });

        liquidButton.setPourFinishListener(new LiquidButton.PourFinishListener() {
            @Override
            public void onPourFinish() {
                Toast.makeText(LiquidButtonActivity.this, "Finish", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onProgressUpdate(float progress) {
                textView.setText(String.format("%.2f", progress * 100) + "%");
            }
        });
    }
}

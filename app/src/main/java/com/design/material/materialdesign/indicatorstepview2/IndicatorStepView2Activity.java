package com.design.material.materialdesign.indicatorstepview2;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.design.material.materialdesign.R;


public class IndicatorStepView2Activity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stepper);

        final ViewPager pager = (ViewPager) findViewById(R.id.pager);
        assert pager != null;
        pager.setAdapter(new PagerAdapter(getSupportFragmentManager()));

        final StepperIndicator indicator = (StepperIndicator) findViewById(R.id.stepper_indicator);
        // We keep last page for a "finishing" page
        indicator.setViewPager(pager, true);

        indicator.addOnStepClickListener(new StepperIndicator.OnStepClickListener() {
            @Override
            public void onStepClicked(int step) {
                pager.setCurrentItem(step, true);
            }
        });
    }

}

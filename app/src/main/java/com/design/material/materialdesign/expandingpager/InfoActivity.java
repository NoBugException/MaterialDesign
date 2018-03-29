package com.design.material.materialdesign.expandingpager;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;
import com.design.material.materialdesign.expandingpager.model.Travel;

import butterknife.Bind;
import butterknife.ButterKnife;

public class InfoActivity extends BaseActivity {

    private static final String EXTRA_TRAVEL = "EXTRA_TRAVEL";
    @Bind(R.id.image) ImageView image;
    @Bind(R.id.title) TextView title;

    public static Intent newInstance(Context context, Travel travel) {
        Intent intent = new Intent(context, InfoActivity.class);
        intent.putExtra(EXTRA_TRAVEL, travel);
        return intent;
    }

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_expandinginfo, null);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);

        Travel travel = getIntent().getParcelableExtra(EXTRA_TRAVEL);
        if (travel != null) {
            image.setImageResource(travel.getImage());
            title.setText(travel.getName());
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}

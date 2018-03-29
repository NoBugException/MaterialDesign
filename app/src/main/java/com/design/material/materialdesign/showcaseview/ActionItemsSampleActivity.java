package com.design.material.materialdesign.showcaseview;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

public class ActionItemsSampleActivity extends BaseActivity {

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_action_items, null);
    }

    @Override
    protected void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        try {
            ViewTarget navigationButtonViewTarget = ViewTargets.navigationButtonViewTarget(toolbar);
            new ShowcaseView.Builder(this)
                    .withMaterialShowcase()
                    .setTarget(navigationButtonViewTarget)
                    .setStyle(R.style.CustomShowcaseTheme2)
                    .setContentText("Here's how to highlight items on a toolbar")
                    .build()
                    .show();
        } catch (ViewTargets.MissingViewException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}

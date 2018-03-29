package com.design.material.materialdesign.showcaseview;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.TextPaint;
import android.view.View;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

public class CustomTextActivity extends BaseActivity {

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_custom_text, null);
    }

    @Override
    protected void initView() {

        TextPaint paint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(getResources().getDimension(R.dimen.abc_text_size_body_1_material));
        paint.setStrikeThruText(true);
        paint.setColor(Color.RED);
        paint.setTypeface(Typeface.createFromAsset(getAssets(), "RobotoSlab-Regular.ttf"));

        TextPaint title = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        title.setTextSize(getResources().getDimension(R.dimen.abc_text_size_headline_material));
        title.setUnderlineText(true);
        title.setColor(Color.YELLOW);
        title.setTypeface(Typeface.createFromAsset(getAssets(), "RobotoSlab-Regular.ttf"));

        ShowcaseView showcaseView = new ShowcaseView.Builder(this)
                .withNewStyleShowcase()
                .setTarget(new ViewTarget(R.id.imageView, this))
                .setContentTextPaint(paint)
                .setContentTitle(R.string.custom_text_painting_title)
                .setContentText(R.string.custom_text_painting_text)
                .setContentTitlePaint(title)
                .build();

        showcaseView.setDetailTextAlignment(Layout.Alignment.ALIGN_CENTER);
        showcaseView.setTitleTextAlignment(Layout.Alignment.ALIGN_CENTER);
        showcaseView.forceTextPosition(ShowcaseView.BELOW_SHOWCASE);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}

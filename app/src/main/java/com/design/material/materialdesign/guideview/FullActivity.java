package com.design.material.materialdesign.guideview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.blog.www.guideview.Guide;
import com.blog.www.guideview.GuideBuilder;
import com.design.material.materialdesign.R;

public class FullActivity extends Activity {

    private Button header_imgbtn;
    Guide guide;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_guide_view);
        header_imgbtn = (Button) findViewById(R.id.header_imgbtn);
        header_imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Toast.makeText(FullActivity.this, "show", Toast.LENGTH_SHORT).show();
            }
        });
        header_imgbtn.post(new Runnable() {
            @Override public void run() {
                showGuideView();
            }
        });
    }

    public void showGuideView() {
        GuideBuilder builder = new GuideBuilder();
        builder.setTargetView(header_imgbtn)
                .setAlpha(100)
                .setHighTargetCorner(30)
                .setHighTargetPadding(10)
                .setOverlayTarget(false)
                .setOutsideTouchable(false);
        builder.setOnVisibilityChangedListener(new GuideBuilder.OnVisibilityChangedListener() {
            @Override public void onShown() {
                Toast.makeText(FullActivity.this, "onShown", Toast.LENGTH_SHORT).show();
            }

            @Override public void onDismiss() {
                Toast.makeText(FullActivity.this, "onDismiss", Toast.LENGTH_SHORT).show();
            }
        });

        builder.addComponent(new SimpleComponent());
        guide = builder.createGuide();
        guide.setShouldCheckLocInWindow(true);
        guide.show(this);
    }
}
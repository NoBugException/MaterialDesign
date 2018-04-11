package com.design.material.materialdesign.circualreveal.codetail.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.design.material.materialdesign.circualreveal.codetail.animation.RevealViewGroup;
import com.design.material.materialdesign.circualreveal.codetail.animation.ViewRevealManager;

public class RevealFrameLayout extends FrameLayout implements RevealViewGroup {
  private ViewRevealManager manager;

  public RevealFrameLayout(Context context) {
    this(context, null);
    manager = new ViewRevealManager();
  }

  public RevealFrameLayout(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
    manager = new ViewRevealManager();
  }

  public RevealFrameLayout(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);

    manager = new ViewRevealManager();
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public RevealFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    manager = new ViewRevealManager();
  }

  @Override protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
    try {
      canvas.save();
      return manager.transform(canvas, child)
              & super.drawChild(canvas, child, drawingTime);
    } finally {
      canvas.restore();
    }
  }

  public void setViewRevealManager(ViewRevealManager manager) {
    if (manager == null) {
      throw new NullPointerException("ViewRevealManager is null");
    }

    this.manager = manager;
  }

  @Override public ViewRevealManager getViewRevealManager() {
    return manager;
  }
}

package com.design.material.materialdesign.materialcalendarview;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

/**
 * Created by maragues on 17/06/16.
 */
public class CustomTileDimensions extends BaseActivity {

  private MaterialCalendarView widget;

  private int currentTileWidth;
  private int currentTileHeight;

  @Override
  protected View getRootView() {
    return View.inflate(this, R.layout.activity_custom_tile, null);
  }

  @Override
  protected void initView() {
    widget = (MaterialCalendarView) findViewById(R.id.calendarView);

    currentTileWidth = MaterialCalendarView.DEFAULT_TILE_SIZE_DP;
    currentTileHeight = MaterialCalendarView.DEFAULT_TILE_SIZE_DP;

    widget.addDecorator(new TodayDecorator());
  }

  @Override
  protected void initData() {

  }

  @Override
  protected void initListener() {
    findViewById(R.id.custom_tile_match_parent).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        widget.setTileSize(LinearLayout.LayoutParams.MATCH_PARENT);
      }
    });

    findViewById(R.id.custom_tile_width_match_parent).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        widget.setTileWidth(LinearLayout.LayoutParams.MATCH_PARENT);
      }
    });

    findViewById(R.id.custom_tile_height_match_parent).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        widget.setTileHeight(LinearLayout.LayoutParams.MATCH_PARENT);
      }
    });

    findViewById(R.id.custom_tile_width_size).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        final NumberPicker view = new NumberPicker(CustomTileDimensions.this);
        view.setMinValue(24);
        view.setMaxValue(64);
        view.setWrapSelectorWheel(false);
        view.setValue(currentTileWidth);
        new AlertDialog.Builder(CustomTileDimensions.this)
                .setView(view)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(@NonNull DialogInterface dialog, int which) {
                    currentTileWidth = view.getValue();
                    widget.setTileWidthDp(currentTileWidth);
                  }
                })
                .show();
      }
    });


    findViewById(R.id.custom_tile_height_size).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        final NumberPicker view = new NumberPicker(CustomTileDimensions.this);
        view.setMinValue(24);
        view.setMaxValue(64);
        view.setWrapSelectorWheel(false);
        view.setValue(currentTileHeight);
        new AlertDialog.Builder(CustomTileDimensions.this)
                .setView(view)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(@NonNull DialogInterface dialog, int which) {
                    currentTileHeight = view.getValue();
                    widget.setTileHeightDp(currentTileHeight);
                  }
                })
                .show();
      }
    });
  }

  private class TodayDecorator implements DayViewDecorator {

    private final CalendarDay today;
    private final Drawable backgroundDrawable;

    public TodayDecorator() {
      today = CalendarDay.today();
      backgroundDrawable = getResources().getDrawable(R.drawable.today_circle_background);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
      return today.equals(day);
    }

    @Override
    public void decorate(DayViewFacade view) {
      view.setBackgroundDrawable(backgroundDrawable);
    }
  }
}

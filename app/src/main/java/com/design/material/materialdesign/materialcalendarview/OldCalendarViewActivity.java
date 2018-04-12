package com.design.material.materialdesign.materialcalendarview;

import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 * Shows off the most basic usage
 */
public class OldCalendarViewActivity extends BaseActivity
        implements CalendarView.OnDateChangeListener {

    private static final DateFormat FORMATTER = SimpleDateFormat.getDateInstance();

    private CalendarView widget;

    private TextView textView;

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_old_calendarview, null);
    }

    @Override
    protected void initView() {
        widget.setOnDateChangeListener(this);

        widget = (CalendarView) findViewById(R.id.calendarView);
        textView = (TextView) findViewById(R.id.textView);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onSelectedDayChange(CalendarView view, int year, int month,
                                    int dayOfMonth) {
        textView.setText(FORMATTER.format(view.getDate()));
    }
}

package com.design.material.materialdesign.materialcalendarview;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Shows off the most basic usage
 */
public class BasicActivity extends BaseActivity implements OnDateSelectedListener, OnMonthChangedListener {

    private static final DateFormat FORMATTER = SimpleDateFormat.getDateInstance();

    private MaterialCalendarView widget;

    private TextView textView;

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_calendarview, null);
    }

    @Override
    protected void initView() {
        widget = (MaterialCalendarView) findViewById(R.id.calendarView);
        textView = (TextView) findViewById(R.id.textView);
    }

    @Override
    protected void initData() {
        //Setup initial text
        textView.setText(getSelectedDatesString());
    }

    @Override
    protected void initListener() {
        widget.setOnDateChangedListener(this);
        widget.setOnMonthChangedListener(this);
    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @Nullable CalendarDay date, boolean selected) {
        textView.setText(getSelectedDatesString());
    }

    @Override
    public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {
        //noinspection ConstantConditions
        getSupportActionBar().setTitle(FORMATTER.format(date.getDate()));
    }

    private String getSelectedDatesString() {
        CalendarDay date = widget.getSelectedDate();
        if (date == null) {
            return "No Selection";
        }
        return FORMATTER.format(date.getDate());
    }
}

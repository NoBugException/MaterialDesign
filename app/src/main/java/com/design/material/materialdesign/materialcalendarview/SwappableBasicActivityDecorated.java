package com.design.material.materialdesign.materialcalendarview;

import android.support.annotation.NonNull;
import android.view.View;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;
import com.design.material.materialdesign.materialcalendarview.decorators.HighlightWeekendsDecorator;
import com.design.material.materialdesign.materialcalendarview.decorators.MySelectorDecorator;
import com.design.material.materialdesign.materialcalendarview.decorators.OneDayDecorator;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.Calendar;

/**
 * Shows off the most basic usage
 */
public class SwappableBasicActivityDecorated extends BaseActivity implements OnDateSelectedListener {

    private final OneDayDecorator oneDayDecorator = new OneDayDecorator();

    private MaterialCalendarView widget;

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_basic_modes, null);
    }

    @Override
    protected void initView() {
        widget = (MaterialCalendarView) findViewById(R.id.calendarView);

        widget.setOnDateChangedListener(this);
        widget.setShowOtherDates(MaterialCalendarView.SHOW_ALL);


        Calendar instance = Calendar.getInstance();
        widget.setSelectedDate(instance.getTime());

        Calendar instance1 = Calendar.getInstance();
        instance1.set(instance1.get(Calendar.YEAR), Calendar.JANUARY, 1);

        Calendar instance2 = Calendar.getInstance();
        instance2.set(instance2.get(Calendar.YEAR), Calendar.DECEMBER, 31);

        widget.state().edit()
                .setMinimumDate(instance1.getTime())
                .setMaximumDate(instance2.getTime())
                .commit();

        widget.addDecorators(
                new MySelectorDecorator(this),
                new HighlightWeekendsDecorator(),
                oneDayDecorator
        );
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        findViewById(R.id.button_weeks).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                widget.state().edit()
                        .setCalendarDisplayMode(CalendarMode.WEEKS)
                        .commit();
            }
        });

        findViewById(R.id.button_months).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                widget.state().edit()
                        .setCalendarDisplayMode(CalendarMode.MONTHS)
                        .commit();
            }
        });
    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
        //If you change a decorate, you need to invalidate decorators
        oneDayDecorator.setDate(date.getDate());
        widget.invalidateDecorators();
    }
}

package com.design.material.materialdesign.materialcalendarview;

import android.util.TypedValue;
import android.view.View;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.format.ArrayWeekDayFormatter;
import com.prolificinteractive.materialcalendarview.format.MonthArrayTitleFormatter;

import java.util.Calendar;

public class CustomizeCodeActivity extends BaseActivity {

    private MaterialCalendarView widget;

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_calendarview, null);
    }

    @Override
    protected void initView() {
        widget = (MaterialCalendarView) findViewById(R.id.calendarView);
        widget.setShowOtherDates(MaterialCalendarView.SHOW_ALL);
        widget.setArrowColor(getResources().getColor(R.color.sample_primary));
        widget.setLeftArrowMask(getResources().getDrawable(R.drawable.ic_navigation_arrow_back));
        widget.setRightArrowMask(getResources().getDrawable(R.drawable.ic_navigation_arrow_forward));
        widget.setSelectionColor(getResources().getColor(R.color.sample_primary));
        widget.setHeaderTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        widget.setWeekDayTextAppearance(R.style.TextAppearance_AppCompat_Medium);
        widget.setDateTextAppearance(R.style.CustomDayTextAppearance);
        widget.setTitleFormatter(new MonthArrayTitleFormatter(getResources().getTextArray(R.array.custom_months)));
        widget.setWeekDayFormatter(new ArrayWeekDayFormatter(getResources().getTextArray(R.array.custom_weekdays)));
        widget.setTileSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 36, getResources().getDisplayMetrics()));
        widget.setTitleAnimationOrientation(MaterialCalendarView.VERTICAL);

        CalendarDay today = CalendarDay.from(2016, 5, 2);
        widget.setCurrentDate(today);
        widget.setSelectedDate(today);

        widget.state().edit()
                .setFirstDayOfWeek(Calendar.WEDNESDAY)
                .setMinimumDate(CalendarDay.from(2016, 4, 3))
                .setMaximumDate(CalendarDay.from(2016, 5, 12))
                .setCalendarDisplayMode(CalendarMode.WEEKS)
                .commit();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

}

package com.design.material.materialdesign.materialcalendarview;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.Calendar;
import java.util.Random;


public class DynamicSettersActivity extends BaseActivity {

    private MaterialCalendarView widget;

    private int currentTileSize;
    private int currentTileWidth;
    private int currentTileHeight;

    private CheckBox check_text_appearance, check_page_enabled, enable_save_current_position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_setters);


    }

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_dynamic_setters, null);
    }

    @Override
    protected void initView() {
        widget = (MaterialCalendarView) findViewById(R.id.calendarView);

        currentTileSize = MaterialCalendarView.DEFAULT_TILE_SIZE_DP;
        currentTileWidth = MaterialCalendarView.DEFAULT_TILE_SIZE_DP;
        currentTileHeight = MaterialCalendarView.DEFAULT_TILE_SIZE_DP;

        widget.setOnTitleClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Toast.makeText(DynamicSettersActivity.this, R.string.today, Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    @Override
    protected void initData() {

    }

    private static final int[] DAYS_OF_WEEK = {
            Calendar.SUNDAY,
            Calendar.MONDAY,
            Calendar.TUESDAY,
            Calendar.WEDNESDAY,
            Calendar.THURSDAY,
            Calendar.FRIDAY,
            Calendar.SATURDAY,
    };

    @Override
    protected void initListener() {
        findViewById(R.id.button_other_dates).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence[] items = {
                        "Other Months",
                        "Out Of Range",
                        "Decorated Disabled",
                        "Select days outside month"
                };
                final int[] itemValues = {
                        MaterialCalendarView.SHOW_OTHER_MONTHS,
                        MaterialCalendarView.SHOW_OUT_OF_RANGE,
                        MaterialCalendarView.SHOW_DECORATED_DISABLED,
                };
                int showOtherDates = widget.getShowOtherDates();

                boolean[] initSelections = {
                        MaterialCalendarView.showOtherMonths(showOtherDates),
                        MaterialCalendarView.showOutOfRange(showOtherDates),
                        MaterialCalendarView.showDecoratedDisabled(showOtherDates),
                        widget.allowClickDaysOutsideCurrentMonth()
                };
                new AlertDialog.Builder(DynamicSettersActivity.this)
                        .setTitle("Show Other Dates")
                        .setMultiChoiceItems(items, initSelections, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if (which < 3) {
                                    int showOtherDates = widget.getShowOtherDates();
                                    if (isChecked) {
                                        //Set flag
                                        showOtherDates |= itemValues[which];
                                    } else {
                                        //Unset flag
                                        showOtherDates &= ~itemValues[which];
                                    }
                                    widget.setShowOtherDates(showOtherDates);
                                } else if (which == 3) {
                                    widget.setAllowClickDaysOutsideCurrentMonth(isChecked);
                                }
                            }
                        })
                        .setPositiveButton(android.R.string.ok, null)
                        .show();
            }
        });

        enable_save_current_position = (CheckBox) findViewById(R.id.enable_save_current_position);
        enable_save_current_position.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean checked) {
                widget.state().edit()
                        .isCacheCalendarPositionEnabled(checked)
                        .commit();
            }
        });

        check_text_appearance = (CheckBox) findViewById(R.id.check_text_appearance);
        check_text_appearance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean checked) {
                if (checked) {
                    widget.setHeaderTextAppearance(R.style.TextAppearance_AppCompat_Large);
                    widget.setDateTextAppearance(R.style.TextAppearance_AppCompat_Medium);
                    widget.setWeekDayTextAppearance(R.style.TextAppearance_AppCompat_Medium);
                } else {
                    widget.setHeaderTextAppearance(R.style.TextAppearance_MaterialCalendarWidget_Header);
                    widget.setDateTextAppearance(R.style.TextAppearance_MaterialCalendarWidget_Date);
                    widget.setWeekDayTextAppearance(R.style.TextAppearance_MaterialCalendarWidget_WeekDay);
                }
                widget.setShowOtherDates(checked ? MaterialCalendarView.SHOW_ALL : MaterialCalendarView.SHOW_NONE);
            }
        });

        check_page_enabled = (CheckBox) findViewById(R.id.check_page_enabled);
        check_page_enabled.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean checked) {
                widget.setPagingEnabled(checked);
            }
        });

        findViewById(R.id.button_previous).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                widget.goToPrevious();
            }
        });

        findViewById(R.id.button_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                widget.goToNext();
            }
        });

        findViewById(R.id.button_min_date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(DynamicSettersActivity.this, widget.getMinimumDate(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        widget.state().edit()
                                .setMinimumDate(CalendarDay.from(year, monthOfYear, dayOfMonth))
                                .commit();
                    }
                });
            }
        });

        findViewById(R.id.button_max_date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(DynamicSettersActivity.this, widget.getMaximumDate(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        widget.state().edit()
                                .setMaximumDate(CalendarDay.from(year, monthOfYear, dayOfMonth))
                                .commit();
                    }
                });
            }
        });

        findViewById(R.id.button_selected_date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(DynamicSettersActivity.this, widget.getSelectedDate(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        widget.setSelectedDate(CalendarDay.from(year, monthOfYear, dayOfMonth));
                    }
                });
            }
        });

        findViewById(R.id.button_toggle_topbar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                widget.setTopbarVisible(!widget.getTopbarVisible());
            }
        });

        final Random random = new Random();

        findViewById(R.id.button_set_colors).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = Color.HSVToColor(new float[]{
                        random.nextFloat() * 360,
                        1f,
                        0.75f
                });
                widget.setArrowColor(color);
                widget.setSelectionColor(color);
            }
        });

        findViewById(R.id.button_set_tile_size).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final NumberPicker view = new NumberPicker(DynamicSettersActivity.this);
                view.setMinValue(24);
                view.setMaxValue(64);
                view.setWrapSelectorWheel(false);
                view.setValue(currentTileSize);
                new AlertDialog.Builder(DynamicSettersActivity.this)
                        .setView(view)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(@NonNull DialogInterface dialog, int which) {
                                currentTileSize = view.getValue();
                                widget.setTileSizeDp(currentTileSize);
                            }
                        })
                        .show();
            }
        });

        findViewById(R.id.button_set_width_height).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LinearLayout layout = new LinearLayout(DynamicSettersActivity.this);
                layout.setOrientation(LinearLayout.HORIZONTAL);
                final NumberPicker pickerWidth = new NumberPicker(DynamicSettersActivity.this);
                pickerWidth.setMinValue(24);
                pickerWidth.setMaxValue(64);
                pickerWidth.setWrapSelectorWheel(false);
                pickerWidth.setValue(currentTileWidth);
                final NumberPicker pickerHeight = new NumberPicker(DynamicSettersActivity.this);
                pickerHeight.setMinValue(24);
                pickerHeight.setMaxValue(64);
                pickerHeight.setWrapSelectorWheel(false);
                pickerHeight.setValue(currentTileHeight);
                layout.addView(pickerWidth);
                layout.addView(pickerHeight);
                new AlertDialog.Builder(DynamicSettersActivity.this)
                        .setView(layout)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(@NonNull DialogInterface dialog, int which) {
                                currentTileWidth = pickerWidth.getValue();
                                currentTileHeight = pickerHeight.getValue();
                                widget.setTileSize(-1);
                                widget.setTileWidthDp(currentTileWidth);
                                widget.setTileHeightDp(currentTileHeight);
                            }
                        })
                        .show();
            }
        });

        findViewById(R.id.button_clear_selection).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                widget.clearSelection();
            }
        });

        findViewById(R.id.button_selection_mode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence[] items = {
                        "No Selection",
                        "Single Date",
                        "Multiple Dates",
                        "Range of Dates"
                };
                new AlertDialog.Builder(DynamicSettersActivity.this)
                        .setTitle("Selection Mode")
                        .setSingleChoiceItems(items, widget.getSelectionMode(), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                widget.setSelectionMode(which);
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });

        findViewById(R.id.button_change_orientation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                widget.setTitleAnimationOrientation(
                        widget.getTitleAnimationOrientation() == MaterialCalendarView.VERTICAL
                                ? MaterialCalendarView.HORIZONTAL
                                : MaterialCalendarView.VERTICAL);

                Toast.makeText(DynamicSettersActivity.this,
                        widget.getTitleAnimationOrientation() == MaterialCalendarView.VERTICAL
                                ? "Vertical"
                                : "Horizontal",
                        Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.button_set_first_day).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = random.nextInt(DAYS_OF_WEEK.length);
                widget.state().edit()
                        .setFirstDayOfWeek(DAYS_OF_WEEK[index])
                        .commit();
            }
        });

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


    public static void showDatePickerDialog(Context context, CalendarDay day,
                                            DatePickerDialog.OnDateSetListener callback) {
        if (day == null) {
            day = CalendarDay.today();
        }
        DatePickerDialog dialog = new DatePickerDialog(
                context, 0, callback, day.getYear(), day.getMonth(), day.getDay()
        );
        dialog.show();
    }
}

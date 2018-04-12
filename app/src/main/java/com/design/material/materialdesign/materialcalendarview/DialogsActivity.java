package com.design.material.materialdesign.materialcalendarview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Shows off the most basic usage
 */
public class DialogsActivity extends BaseActivity {

    private static final DateFormat FORMATTER = SimpleDateFormat.getDateInstance();

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_dialogs, null);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        findViewById(R.id.button_normal_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SimpleDialogFragment().show(getSupportFragmentManager(), "test-normal");
            }
        });

        findViewById(R.id.button_simple_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SimpleCalendarDialogFragment().show(getSupportFragmentManager(), "test-simple-calendar");
            }
        });
    }


    public static class SimpleDialogFragment extends AppCompatDialogFragment {

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return new AlertDialog.Builder(getActivity())
                    .setTitle(R.string.title_activity_dialogs)
                    .setMessage("Test Dialog")
                    .setPositiveButton(android.R.string.ok, null)
                    .create();
        }
    }

    public static class SimpleCalendarDialogFragment extends AppCompatDialogFragment implements OnDateSelectedListener {

        private TextView textView;

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            LayoutInflater inflater = getActivity().getLayoutInflater();

            //inflate custom layout and get views
            //pass null as parent view because will be in dialog layout
            View view = inflater.inflate(R.layout.dialog_basic, null);

            textView = (TextView) view.findViewById(R.id.textView);

            MaterialCalendarView widget = (MaterialCalendarView) view.findViewById(R.id.calendarView);

            widget.setOnDateChangedListener(this);

            return new AlertDialog.Builder(getActivity())
                    .setTitle(R.string.title_activity_dialogs)
                    .setView(view)
                    .setPositiveButton(android.R.string.ok, null)
                    .create();
        }

        @Override
        public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
            textView.setText(FORMATTER.format(date.getDate()));
        }
    }
}

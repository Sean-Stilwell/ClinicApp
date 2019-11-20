package com.example.clinicprojectv2;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.fragment.app.DialogFragment;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    EditText editText;

    public TimePickerFragment(EditText editText) {
        this.editText = editText;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();

        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // If a time is already specified, use that instead of the default
        if (editText.getText().toString().trim().length() > 0) {
            try {
                LocalTime time = LocalTime.parse(editText.getText().toString());
                hour = time.getHour();
                minute = time.getMinute();
            } catch (Exception e) {
                throw new IllegalArgumentException("Could not parse time");
            }
        }

        return new TimePickerDialog(getActivity(), this, hour, minute,
                false);
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        editText.setText(hourOfDay + ":" + String.format("%02d", minute));
    }
}
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

        if (editText.getText().toString() != "") {
            try {
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                Date time = timeFormat.parse(editText.getText().toString());
                hour = time.getHours();
                minute = time.getMinutes();
            } catch (Exception e) {
                System.out.println("Error - defaulting to current time");
            }
        }

        return new TimePickerDialog(getActivity(), this, hour, minute,
                false);
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        editText.setText(hourOfDay + ":" + minute);
    }
}
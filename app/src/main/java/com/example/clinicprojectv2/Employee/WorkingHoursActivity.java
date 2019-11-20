package com.example.clinicprojectv2.Employee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.clinicprojectv2.R;
import com.example.clinicprojectv2.Service.Service;
import com.example.clinicprojectv2.TimePickerFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkingHoursActivity extends AppCompatActivity {

    private int clinicId;
    private List<Workday> workdays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working_hours);

        setUpListenersForWorkdays();
    }

    public void setUpListenersForWorkdays() {

        workdays = new ArrayList<>();

        DatabaseReference databaseWorkdays = FirebaseDatabase.getInstance().getReference("services");
        Query query = databaseWorkdays.child("clinicId").equalTo(clinicId);
        query.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                workdays.clear();

                for(DataSnapshot item : dataSnapshot.getChildren()){
                    Workday workday = item.getValue(Workday.class);
                    workdays.add(workday);
                }

                updateWorkdaysUI();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void updateWorkdaysUI() {

        for (Workday w : workdays) {

            int weekday = w.getWeekday();

            int startTimeFieldId = -1;
            int endTimeFieldId = -1;

            switch(weekday) {
                case Workday.MONDAY:
                    startTimeFieldId = R.id.mondayFrom;
                    endTimeFieldId = R.id.mondayTo;
                    break;
                case Workday.TUESDAY:
                    startTimeFieldId = R.id.tuesdayFrom;
                    endTimeFieldId = R.id.tuesdayTo;
                    break;
                case Workday.WEDNESDAY:
                    startTimeFieldId = R.id.wednesdayFrom;
                    endTimeFieldId = R.id.wednesdayTo;
                    break;
                case Workday.THURSDAY:
                    startTimeFieldId = R.id.thursdayFrom;
                    endTimeFieldId = R.id.thursdayTo;
                    break;
                case Workday.FRIDAY:
                    startTimeFieldId = R.id.fridayFrom;
                    endTimeFieldId = R.id.fridayTo;
                    break;
                case Workday.SATURDAY:
                    startTimeFieldId = R.id.saturdayFrom;
                    endTimeFieldId = R.id.saturdayTo;
                    break;
                case Workday.SUNDAY:
                    startTimeFieldId = R.id.sundayFrom;
                    endTimeFieldId = R.id.sundayTo;
                    break;
            }

            ((EditText)findViewById(startTimeFieldId)).setText(w.getStartTime().toString());
            ((EditText)findViewById(endTimeFieldId)).setText(w.getEndTime().toString());
        }
    }


    public void toggleHoursFields(View view) {

        int visibility = View.VISIBLE;
        if (((CheckBox)view).isChecked()) visibility = View.GONE;

        View target;

        switch (view.getId()) {
            case R.id.isMondayClosed:
                target = findViewById(R.id.fieldContainerMonday);
                break;
            case R.id.isTuesdayClosed:
                target = findViewById(R.id.fieldContainerTuesday);
                break;
            case R.id.isWednesdayClosed:
                target = findViewById(R.id.fieldContainerWednesday);
                break;
            case R.id.isThursdayClosed:
                target = findViewById(R.id.fieldContainerThursday);
                break;
            case R.id.isFridayClosed:
                target = findViewById(R.id.fieldContainerFriday);
                break;
            case R.id.isSaturdayClosed:
                target = findViewById(R.id.fieldContainerSaturday);
                break;
            case R.id.isSundayClosed:
                target = findViewById(R.id.fieldContainerSunday);
                break;
            default:
                throw new IllegalArgumentException();
        }

        target.setVisibility(visibility);
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment((EditText)v);
        newFragment.show(getSupportFragmentManager(), "Time Picker");
    }
}

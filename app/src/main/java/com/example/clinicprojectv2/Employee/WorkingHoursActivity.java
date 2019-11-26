package com.example.clinicprojectv2.Employee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.opengl.Visibility;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.clinicprojectv2.R;
import com.example.clinicprojectv2.Service.Service;
import com.example.clinicprojectv2.TimePickerFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class WorkingHoursActivity extends AppCompatActivity {

    private String clinicId;
    private List<Workday> workdays;
    private String[] workdayIds;
    private int[] workdayFromFields;
    private int[] workdayToFields;
    private int[] workdayClosedCheckboxes;

    private boolean dbReadDone;

    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working_hours);

        dbReadDone = false;

        workdayIds = new String[7];
        workdayFromFields = new int[] {R.id.mondayFrom, R.id.tuesdayFrom, R.id.wednesdayFrom, R.id.thursdayFrom, R.id.fridayFrom, R.id.saturdayFrom, R.id.sundayFrom};
        workdayToFields = new int[] {R.id.mondayTo, R.id.tuesdayTo, R.id.wednesdayTo, R.id.thursdayTo, R.id.fridayTo, R.id.saturdayTo, R.id.sundayTo};
        workdayClosedCheckboxes = new int[] { R.id.isMondayClosed, R.id.isTuesdayClosed, R.id.isWednesdayClosed, R.id.isThursdayClosed, R.id.isFridayClosed, R.id.isSaturdayClosed, R.id.isSundayClosed};

        db = FirebaseDatabase.getInstance().getReference();
        clinicId = "012xabc"; // TEST ONLY
        //clinicId = getIntent().getStringExtra("CLINIC_ID");

        setUpListenersForWorkdays();
    }

    public void setUpListenersForWorkdays() {

        workdays = new ArrayList<>();

        DatabaseReference databaseWorkdays = FirebaseDatabase.getInstance().getReference("workdays");
        Query query = databaseWorkdays.orderByChild("clinicId").equalTo(clinicId);
        query.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                workdays.clear();

                for (DataSnapshot item : dataSnapshot.getChildren()){
                    Workday workday = new Workday();
                    workday.setWorkdayId(item.child("workdayId").getValue().toString());
                    workday.setWeekday(((Long)item.child("weekday").getValue()).intValue());
                    workday.setStartTime(LocalTime.parse(String.format("%02d", item.child("startTime").child("hour").getValue())+":"+String.format("%02d", item.child("startTime").child("minute").getValue())));
                    workday.setEndTime(LocalTime.parse(String.format("%02d", item.child("endTime").child("hour").getValue())+":"+String.format("%02d",item.child("endTime").child("minute").getValue())));
                    workday.setClosed((boolean)item.child("closed").getValue());
                    workday.setClinicId(clinicId);
                    workdays.add(workday);
                }

                for (Workday w : workdays) {
                    workdayIds[w.getWeekday()] = w.getWorkdayId();
                }

                updateWorkdaysUI();
                dbReadDone = true;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void updateWorkdays(View view) {

        if (!dbReadDone)
            displayToast("Please wait...");

        workdays.clear();

        try {
            for (int i = 0; i < 7; i++) {
                String workdayId = ((workdayIds[i] != null) ? workdayIds[i] : UUID.randomUUID().toString());
                String startTime = ((EditText)findViewById(workdayFromFields[i])).getText().toString().trim();
                String endTime = ((EditText)findViewById(workdayToFields[i])).getText().toString().trim();
                boolean isClosed = ((CheckBox)findViewById(workdayClosedCheckboxes[i])).isChecked();


                if (!isClosed && (startTime.length() == 0 || endTime.length() == 0)) {
                    displayToast("Opening hours must be specified for all open days.");
                    return;
                } else if (isClosed && (startTime.length() == 0 || endTime.length() == 0)) {
                    startTime = "06:00";
                    endTime = "21:00";
                }


                workdays.add(new Workday(
                        workdayId,
                        clinicId,
                        i,
                        LocalTime.parse(startTime),
                        LocalTime.parse(endTime),
                        isClosed
                ));
            }

            for (Workday w : workdays) {
                db.child("workdays").child(w.getWorkdayId()).setValue(w);
            }

            displayToast("Changes saved.");

        } catch (IllegalArgumentException e) {
            displayToast(e.getMessage());
        } catch (Exception e) {
            displayToast(e.getMessage());
            Log.d("Test", e.getStackTrace().toString());
        }
    }

    public void updateWorkdaysUI() {

        for (Workday w : workdays) {

            int weekday = w.getWeekday();

            int startTimeFieldId = -1;
            int endTimeFieldId = -1;
            int isClosedFieldId = -1;
            int fieldContainer = -1;

            switch(weekday) {
                case Workday.MONDAY:
                    startTimeFieldId = R.id.mondayFrom;
                    endTimeFieldId = R.id.mondayTo;
                    isClosedFieldId = R.id.isMondayClosed;
                    fieldContainer = R.id.fieldContainerMonday;
                    break;
                case Workday.TUESDAY:
                    startTimeFieldId = R.id.tuesdayFrom;
                    endTimeFieldId = R.id.tuesdayTo;
                    isClosedFieldId = R.id.isTuesdayClosed;
                    fieldContainer = R.id.fieldContainerTuesday;
                    break;
                case Workday.WEDNESDAY:
                    startTimeFieldId = R.id.wednesdayFrom;
                    endTimeFieldId = R.id.wednesdayTo;
                    isClosedFieldId = R.id.isWednesdayClosed;
                    fieldContainer = R.id.fieldContainerWednesday;
                    break;
                case Workday.THURSDAY:
                    startTimeFieldId = R.id.thursdayFrom;
                    endTimeFieldId = R.id.thursdayTo;
                    isClosedFieldId = R.id.isThursdayClosed;
                    fieldContainer = R.id.fieldContainerThursday;
                    break;
                case Workday.FRIDAY:
                    startTimeFieldId = R.id.fridayFrom;
                    endTimeFieldId = R.id.fridayTo;
                    isClosedFieldId = R.id.isFridayClosed;
                    fieldContainer = R.id.fieldContainerFriday;
                    break;
                case Workday.SATURDAY:
                    startTimeFieldId = R.id.saturdayFrom;
                    endTimeFieldId = R.id.saturdayTo;
                    isClosedFieldId = R.id.isSaturdayClosed;
                    fieldContainer = R.id.fieldContainerSaturday;
                    break;
                case Workday.SUNDAY:
                    startTimeFieldId = R.id.sundayFrom;
                    endTimeFieldId = R.id.sundayTo;
                    isClosedFieldId = R.id.isSundayClosed;
                    fieldContainer = R.id.fieldContainerSunday;
                    break;
            }

            ((EditText)findViewById(startTimeFieldId)).setText(w.getStartTime().toString());
            ((EditText)findViewById(endTimeFieldId)).setText(w.getEndTime().toString());
            if (w.isClosed()) {
                ((CheckBox)findViewById(isClosedFieldId)).setChecked(true);
                findViewById(fieldContainer).setVisibility(View.GONE);
            }
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

    private void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}

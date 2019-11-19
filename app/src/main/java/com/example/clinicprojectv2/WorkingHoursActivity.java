package com.example.clinicprojectv2;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class WorkingHoursActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working_hours);
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
}

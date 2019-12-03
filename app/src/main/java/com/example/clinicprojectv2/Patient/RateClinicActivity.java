package com.example.clinicprojectv2.Patient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.clinicprojectv2.Clinic.Clinic;
import com.example.clinicprojectv2.R;

public class RateClinicActivity extends AppCompatActivity {

    Clinic clinic;
    ClinicRating rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_clinic);

        // TODO Initialize rating activity using clinic

        clinic = new Clinic();
        TextView clinicNameLabel = (TextView)findViewById(R.id.clinicName);
        clinicNameLabel.setText(clinic.getName());
    }

    public void createRating(View view) {
        // TODO create rating
    }

    public void cancelRating(View view) {
        this.finish();
    }
}

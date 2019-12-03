package com.example.clinicprojectv2.Patient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clinicprojectv2.Clinic.Clinic;
import com.example.clinicprojectv2.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RateClinicActivity extends AppCompatActivity {

    Clinic clinic;
    String clinicId;
    ClinicRating rating;
    String ratingId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_clinic);

        clinicId = getIntent().getStringExtra("CLINIC_ID");
        ratingId = getIntent().getStringExtra("RATING_ID");

        // TODO Remove this for prod
        clinicId = "x6N8FLlIDEg50o1oguMAOQCXK0H3";
        ratingId = "123";

        setUpListenerForClinic();
        setUpListenerForRating();
    }

    public void createRating(View view) {
        // TODO create rating
    }

    public void cancelRating(View view) {
        this.finish();
    }

    public void setUpListenerForClinic() {
        DatabaseReference databaseUsers = FirebaseDatabase.getInstance().getReference("clinics").child(clinicId);
        databaseUsers.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){
                    clinic = dataSnapshot.getValue(Clinic.class);
                    onClinicFetchSuccess();
                } else {
                    displayToast("Failed to get Clinic object.");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void setUpListenerForRating() {
        DatabaseReference databaseUsers = FirebaseDatabase.getInstance().getReference("ratings").child(ratingId);
        databaseUsers.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){
                    rating = dataSnapshot.getValue(ClinicRating.class);
                    onRatingFetchSuccess();
                } else {
                    displayToast("Failed to get ClinicRating object.");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void onClinicFetchSuccess() {
        TextView clinicNameLabel = (TextView)findViewById(R.id.clinicName);
        clinicNameLabel.setText(clinic.getName());
    }

    public void onRatingFetchSuccess() {
        RatingBar ratingBar = (RatingBar)findViewById(R.id.rating);
        ratingBar.setRating(rating.getRating());
    }

    private void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    public ClinicRating getRating() {
        return rating;
    }

    public void setRating(ClinicRating rating) {
        this.rating = rating;
    }

    public String getRatingId() {
        return ratingId;
    }

    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }
}

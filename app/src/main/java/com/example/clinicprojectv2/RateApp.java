package com.example.clinicprojectv2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RateApp extends AppCompatActivity {

    private static TextView text;
    private static RatingBar ratingBar;
    private static

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rateapp);

        listenerForRatingBar();
    }

    public void soumettreClick(View view){

        startActivity(new Intent(RateApp.this, MainActivity.class));
    }

    public void listenerForRatingBar(){
        ratingBar = (RatingBar) findViewById(R.id.evaluation);
        text = (TextView) findViewById(R.id.rateResult);

        ratingBar.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean result){
                        String newText = "Votre évaluation est " + String.valueOf(rating);
                        text.setText(newText);
                    }
                }
        );
    }
}

package com.example.clinicprojectv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.clinicprojectv2.Booking.Booking;

public class BookingsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings_screen);
        TextView upcoming = (TextView) findViewById(R.id.textView19);
//        if (!Global.getPatient().getBookings().isEmpty()){
//            upcoming.setText(Global.getPatient().getBookings().getList());
//        }
//        else{
//            upcoming.setText("No bookings made!");
//        }
    }
}

package com.example.clinicprojectv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.clinicprojectv2.Patient.RateClinicActivity;

import java.util.List;

public class BookingsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings_screen);

        List<String> bookings = Global.getPatient().getBookings().getBookingsAsStrings();
        ListView bookingList = (ListView)findViewById(R.id.bookingList);
        bookingList.setEmptyView(findViewById(R.id.emptyBooking));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                R.layout.booking_item,
                bookings
        );

        bookingList.setAdapter(arrayAdapter);

        bookingList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView bookingItem = (TextView) parent.getAdapter().getItem(position);
                Intent intent = new Intent(BookingsScreen.this, RateClinicActivity.class);
                BookingsScreen.this.startActivity(intent);
            }
        });
    }
}

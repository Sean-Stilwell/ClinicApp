package com.example.clinicprojectv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.clinicprojectv2.Booking.Booking;
import com.example.clinicprojectv2.Clinic.Clinic;
import com.example.clinicprojectv2.Clinic.Time;
import com.example.clinicprojectv2.Service.Service;

public class CreateBooking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_booking);
    }

    public void createBooking(View view){
        Clinic clinic = findClinic();
        // clinic = new Clinic(); // for testing
        Service service = findService(clinic);
        // service = new Service(); // for testing
        int year = findYear();
        int month = findMonth();
        int day = findDay();
        int hour = findHour();
        int minute = findMinute();
        if (clinic != null && service != null && year != 0 && month != 0 && day != 0 && hour != -1 && minute != -1){
            Time time = new Time(hour,minute);
            Booking newBooking = new Booking(clinic,service,Global.getPatient(),time,year,month,day);
            clinic.addBooking(newBooking);
            Global.getPatient().addBooking(newBooking);
        }
        else{
            TextView error = findViewById(R.id.textViewError);
            error.setText("ERROR: Check information, an error occurred..");
        }
    }

    public Clinic findClinic(){
        EditText clinicName = findViewById(R.id.editText);
        String clinic = clinicName.getText().toString();
        // This function should search for the clinic in firebase.
        return null;
    }

    public Service findService(Clinic clinic){
        EditText serviceName = findViewById(R.id.editText6);
        String service = serviceName.getText().toString();
        // This function should return the service.
        return null;
    }

    public int findYear(){
        EditText yearText = findViewById((R.id.editTextYear));
        int returnVal;
        try{
            returnVal = Integer.parseInt(yearText.getText().toString());
        }
        catch (NumberFormatException exc){
            returnVal = 0;
            TextView error = findViewById(R.id.textViewError);
            error.setText("ERROR: Invalid date used.");
        }
        return returnVal;
    }
    public int findMonth(){
        EditText monthText = findViewById((R.id.editTextMonth));
        int returnVal;
        try{
            returnVal = Integer.parseInt(monthText.getText().toString());
        }
        catch (NumberFormatException exc){
            returnVal = 0;
            TextView error = findViewById(R.id.textViewError);
            error.setText("ERROR: Invalid date used.");
        }
        return returnVal;
    }
    public int findDay(){
        EditText dayText = findViewById((R.id.editTextDay));
        int returnVal;
        try{
            returnVal = Integer.parseInt(dayText.getText().toString());
        }
        catch (NumberFormatException exc){
            returnVal = 0;
            TextView error = findViewById(R.id.textViewError);
            error.setText("ERROR: Invalid date used.");
        }
        return returnVal;
    }
    public int findHour(){
        EditText hourText = findViewById((R.id.editTextHour));
        int returnVal;
        try{
            returnVal = Integer.parseInt(hourText.getText().toString());
        }
        catch (NumberFormatException exc){
            returnVal = 0;
            TextView error = findViewById(R.id.textViewError);
            error.setText("ERROR: Invalid time used.");
        }
        if (returnVal < 0 || returnVal >= 24){
            TextView error = findViewById(R.id.textViewError);
            error.setText("ERROR: Invalid time used.");
            returnVal = -1;
        }
        return returnVal;
    }
    public int findMinute(){
        EditText minuteText = findViewById((R.id.editTextMinute));
        int returnVal;
        try{
            returnVal = Integer.parseInt(minuteText.getText().toString());
        }
        catch (NumberFormatException exc){
            returnVal = 0;
            TextView error = findViewById(R.id.textViewError);
            error.setText("ERROR: Invalid time used.");
        }
        if (returnVal < 0 || returnVal >= 60){
            TextView error = findViewById(R.id.textViewError);
            error.setText("ERROR: Invalid time used.");
            returnVal = -1;
        }
        return returnVal;
    }
}

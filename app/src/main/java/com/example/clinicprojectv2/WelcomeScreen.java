package com.example.clinicprojectv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        // Set the text for the user.
        TextView text = (TextView) findViewById(R.id.textWelcome);
        text.setText("Bonjour, " + Global.getSavedAccount().getFirstName() + ". Vous êtes connectés en tant que " + Global.getUserRole() +".");

        // Change button visibility if the user is not an admin.
        if (Global.getUserRole() != "Administrator"){
            Button adminButton = (Button) findViewById(R.id.button5);
            adminButton.setVisibility(View.GONE);
        }
        // Change button visibility if the user is not an employee.
        if (Global.getUserRole() != "Employee"){
            Button employeeButton = (Button) findViewById(R.id.button11);
            employeeButton.setVisibility(View.GONE);
        }
        // Change button visibility if the user is not a patient.
        if (Global.getUserRole() != "Patient"){
            Button patientButton1 = (Button) findViewById(R.id.button12);
            patientButton1.setVisibility(View.GONE);
            Button patientButton2 = (Button) findViewById(R.id.button13);
            patientButton2.setVisibility(View.GONE);
        }
    }

    public void startAdmin(View view){

    }
    public void startEmployee(View view){

    }
    public void openSearch(View view){
        /*Clicking this button would open the search screen, from which the user can create bookings at the clinics they search*/
        startActivity(new Intent(WelcomeScreen.this, SearchClinics.class));
    }
    public void viewBookings(View view){
        startActivity(new Intent(WelcomeScreen.this, BookingsScreen.class));
    }
}

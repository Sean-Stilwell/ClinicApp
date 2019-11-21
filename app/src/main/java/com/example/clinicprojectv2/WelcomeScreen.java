package com.example.clinicprojectv2;

import androidx.appcompat.app.AppCompatActivity;

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
        text.setText("Bonjour, " + Global.getUserFirstName() + ". Vous êtes connectés en tant que " + Global.getUserRole() +".");

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
            Button patientButton = (Button) findViewById(R.id.button12);
            patientButton.setVisibility(View.GONE);
        }
    }
}

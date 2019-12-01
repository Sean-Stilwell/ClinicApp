package com.example.clinicprojectv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.clinicprojectv2.Administrator.AdminMainActivities.AdminActivity;
import com.example.clinicprojectv2.Administrator.Administrator;
import com.example.clinicprojectv2.Employee.Employee;
import com.example.clinicprojectv2.Employee.EmployeeActivity;

public class WelcomeScreen extends AppCompatActivity {

    private String clinicID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);


        // Set the text for the user.
        TextView text = (TextView) findViewById(R.id.textWelcome);
        text.setText("Welcome, " + Global.getSavedAccount().getFirstName() + ". You are connected as a " + Global.getUserRole() +".");

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
        Intent intent = new Intent(this, AdminActivity.class);
        intent.putExtra("AdminObject", (Administrator)Global.getSavedAccount());
        this.startActivity(intent);
    }
    public void startEmployee(View view){
        clinicID = getIntent().getStringExtra("CLINICID");
        Intent intent ;
        intent = new Intent(this, EmployeeActivity.class);
        //intent.putExtra("EmployeeObject", (Employee)Global.getSavedAccount());
        intent.putExtra("CLINICID", clinicID);
        //intent.putExtra("ClinicObject", Global.getSavedClinic());
        this.startActivity(intent);
    }
    public void createBooking(View view){
        /*Clicking this button would open the search screen, from which the user can create bookings at the clinics they search*/
        startActivity(new Intent(WelcomeScreen.this, CreateBooking.class));
    }
    public void viewBookings(View view){
        startActivity(new Intent(WelcomeScreen.this, BookingsScreen.class));
    }
}

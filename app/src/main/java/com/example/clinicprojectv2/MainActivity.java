package com.example.clinicprojectv2;

import com.example.clinicprojectv2.Employee.WorkingHoursActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.clinicprojectv2.Administrator.AdminMainActivities.AdminActivity;
import androidx.appcompat.app.AppCompatActivity;
import com.example.clinicprojectv2.Account.Account;
import com.example.clinicprojectv2.Account.AccountType;
import com.example.clinicprojectv2.Clinic.Clinic;
import com.example.clinicprojectv2.Employee.Employee;
import com.example.clinicprojectv2.Administrator.Administrator;
import com.example.clinicprojectv2.Employee.EmployeeActivity;
import com.example.clinicprojectv2.Patient.Patient;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.view.View;
import androidx.annotation.NonNull;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DatabaseError;
import android.content.Intent;
import com.google.firebase.auth.FirebaseAuth;
import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user clicks the S'Inscrire button */
    public void openCreationPage(View view) {
        startActivity(new Intent(MainActivity.this, CreateAccount.class));
    }

    /** Called when the user clicks the Se Connecter button */
    public void openLoginPage(View view) {

        startActivity(new Intent(MainActivity.this, LoginScreen.class));
    }

    public void openRatePage(View view) {
        startActivity(new Intent(MainActivity.this, RateApp.class));
    }
}

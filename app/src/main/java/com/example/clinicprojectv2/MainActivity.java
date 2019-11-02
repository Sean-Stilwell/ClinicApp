package com.example.clinicprojectv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
}

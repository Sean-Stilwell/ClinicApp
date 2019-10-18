package com.example.projetfinaleseg2505;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.view.View;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user clicks the Send button */
    public void openCreationPage(View view) {
        startActivity(new Intent(MainActivity.this, CreateAccount.class));
    }

    /** Called when the user clicks the Send button */
    public void openLoginPage(View view) {
        startActivity(new Intent(MainActivity.this, LogInScreen.class));
    }
}

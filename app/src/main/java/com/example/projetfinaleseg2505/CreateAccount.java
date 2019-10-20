package com.example.projetfinaleseg2505;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CreateAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }

    /** Called when the user clicks the Send button */
    public void inscrireClick(View view) {
        // boolean variable for validating the input
        //if variable is true {
            // add data to the database
            startActivity(new Intent(CreateAccount.this, LogInScreen.class));
        //}
        //else {
            // display an error where validation fails
        //}
    }
}

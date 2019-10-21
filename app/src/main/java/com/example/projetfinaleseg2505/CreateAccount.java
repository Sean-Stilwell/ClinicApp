package com.example.projetfinaleseg2505;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.*;
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
        // Getting the user data
        EditText prenomText = (EditText)findViewById(R.id.textUserInput);
        String prenom = prenomText.getText().toString();

        EditText surnameText = (EditText)findViewById(R.id.textUserInput2);
        String surname = surnameText.getText().toString();

        EditText emailText = (EditText)findViewById(R.id.textUserInput3);
        String email = emailText.getText().toString();

        EditText passwordText = (EditText)findViewById(R.id.textUserInput5);
        String password = passwordText.getText().toString();

        EditText usernameText = (EditText)findViewById(R.id.textUserInput5);
        String username = usernameText.getText().toString();

        // Validating the user data
        boolean validEmail = Utility.isValidEmail(email);
        boolean validSurname = Utility.isValidName(surname);
        boolean validPrenom = Utility.isValidName(prenom);

        // Proceeding with the user data in consideration.
        if (validEmail && validSurname && validPrenom) {
            RadioButton button1 = (RadioButton)findViewById(R.id.radioButton2); // Patient
            RadioButton button2 = (RadioButton)findViewById(R.id.radioButton3); // Employee
            if (button1.isChecked()){
                PatientAccount newCompte = new PatientAccount(username, surname, prenom, password, email);
                newCompte.addAccountToDatabase();
            }
            else if (button2.isChecked()){
                EmployeeAccount newCompte = new EmployeeAccount(username, surname, prenom, password, email);
                newCompte.addAccountToDatabase();
            }
            startActivity(new Intent(CreateAccount.this, LogInScreen.class));
        }
        else {
            TextView text = (TextView)findViewById(R.id.textError);
            text.setVisibility(View.VISIBLE);
        }
    }
}

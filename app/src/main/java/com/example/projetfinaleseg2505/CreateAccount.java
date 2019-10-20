package com.example.projetfinaleseg2505;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
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

        // Validating the user data
        boolean validEmail = Utility.isValidEmail(email);
        boolean validSurname = Utility.isValidName(surname);
        boolean validPrenom = Utility.isValidName(prenom);

        // Proceeding with the user data in consideration.
        if (validEmail && validSurname && validPrenom) {
            // add data to the database
            startActivity(new Intent(CreateAccount.this, LogInScreen.class));
        }
        else {
            EditText text = (EditText)findViewById(R.id.textError);
            text.setVisibility(View.VISIBLE);
        }
    }
}

package com.example.projetfinaleseg2505;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LogInScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_screen);
    }

    /** Called when the user clicks the Send button */
    public void connecterClick(View view) {
        // boolean variable for validating the username / password
        //if variable is true {
            startActivity(new Intent(LogInScreen.this, WelcomeScreen.class));
        //}
        //else {
            //EditText text = (EditText)findViewById(R.id.textLogin3);
            //text.setVisibility(View.VISIBLE);
        //}
    }
}

package com.example.projetfinaleseg2505;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LogInScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_screen);
    }

    /** Called when the user clicks the Send button */
    public void connecterClick(View view) {
        // boolean variable for validating the username / password
        if (true) { // add the variable here.
            startActivity(new Intent(LogInScreen.this, WelcomeScreen.class));
        }
        else {
            TextView text = (TextView)findViewById(R.id.textLogin3);
            text.setVisibility(View.VISIBLE);
        }
    }
}

package com.example.clinicprojectv2;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import com.example.clinicprojectv2.Account.AccountType;
import com.example.clinicprojectv2.Clinic.Clinic;
import com.example.clinicprojectv2.Employee.Employee;
import com.example.clinicprojectv2.Patient.Patient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import androidx.annotation.NonNull;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.content.Intent;
import java.util.Objects;

public class CreateAccount extends AppCompatActivity {

    public static final String CLINICS = "clinics";
    public static final String USERS = "users";
    private FirebaseDatabase database;
    private FirebaseAuth mAuth;
    private String firstName ;
    private String lastName ;
    private String email ;
    private String password ;
    private AccountType type ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     * Called when the user clicks the Send button
     */
    public void signUpClick(View view) {

        firstName = this.retrieveFirstName();
        lastName = this.retrieveLastName();
        email = this.retrieveUserEmail();
        password = this.retrieveUserPass();
        type = this.retrieveType();

        if(this.validUserInput(firstName,lastName,email,password)){

            if(type.equals(AccountType.EMPLOYEE)){
                this.signUpEmployee(email,password);
            } else {
                this.signUpPatient(email,password);
            }
        } else {
            this.displayErrorMessage();
        }
    }

    public void displayErrorMessage(){

        TextView text = findViewById(R.id.textError);
        text.setVisibility(View.VISIBLE);
    }

    public String retrieveUserEmail () {

        EditText emailText = findViewById(R.id.emailInput);
        return emailText.getText().toString();
    }

    public String retrieveUserPass(){

        EditText passwordText = findViewById(R.id.passwordInput);
        return passwordText.getText().toString();
    }

    public AccountType retrieveType(){

        RadioButton buttonPatient = findViewById(R.id.radioButton2); // Patient

        if(buttonPatient.isChecked()){
            return AccountType.PATIENT;

        } else {
            return AccountType.EMPLOYEE;
        }
    }

    public String  retrieveFirstName(){

        EditText firstName = findViewById(R.id.firstNameInput);
        return firstName.getText().toString();

    }

    public String  retrieveLastName(){

        EditText lastName = findViewById(R.id.lastNameInput);
        return lastName.getText().toString();

    }

    public boolean validUserInput(String firstName, String lastName, String email, String pass){

        if(Utility.isValidName(firstName)&&
           Utility.isValidName(lastName)&&
           Utility.isValidEmail(email)&&
           Utility.isValidPassword(pass)){
            return true;
        } else {
            return false;
        }
    }

    private void signUpPatient (String email, String pass){

        mAuth.createUserWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {

                                FirebaseUser user = Objects.requireNonNull(task.getResult()).getUser();
                                createAssociatedPatientAccount(user.getUid());

                            } else {
                                displayToast("Email already used.");
                            }
                        }
                    });
        }

    private void signUpEmployee (String email, String pass){

        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            FirebaseUser user = Objects.requireNonNull(task.getResult()).getUser();
                            createAssociatedEmployeeAccount(user.getUid());

                        } else {
                            displayToast("Email already used.");
                        }
                    }
                });
        }


    private void createAssociatedPatientAccount (String userUID){

        Patient patient = new Patient(firstName,lastName,email,userUID);
        DatabaseReference dbRef = database.getReference();
        dbRef.child(USERS).child(userUID).setValue(patient);

        startActivity(new Intent(CreateAccount.this, LoginScreen.class));
    }


    private void createAssociatedEmployeeAccount (String userUID){

        Employee employee = new Employee(firstName,lastName,email,userUID);
        DatabaseReference dbRef = database.getReference();
        dbRef.child(USERS).child(userUID).setValue(employee);

        this.createAssociatedClinic(userUID);

    }

    private void createAssociatedClinic(String userUID){

        Clinic newClinic = new Clinic(userUID);

        DatabaseReference dbRef = database.getReference();
        dbRef.child(CLINICS).child(userUID).setValue(newClinic);

        startActivity(new Intent(CreateAccount.this, LoginScreen.class));
    }



    public void displayToast(String message){

        Toast.makeText(CreateAccount.this, message, Toast.LENGTH_SHORT).show();
    }
}

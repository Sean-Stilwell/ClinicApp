package com.example.clinicprojectv2;
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
import com.example.clinicprojectv2.Administrator.AdminMainActivities.AdminActivity;

public class LoginScreen extends AppCompatActivity {

    public static final String TYPE = "type";
    public static final String USERS = "users";

    private FirebaseDatabase database;
    private FirebaseAuth mAuth;
    private FirebaseUser userGlobal;
    private AccountType accountType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_screen);

        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
    }



    /** Called when the user clicks the Connect button */
    public void loginClick(View view) {

        String email = this.retrieveUserEmail().trim();
        String password = this.retrieveUserPass().trim();


        if(!(this.validUserInput(email,password))){

            this.displayToast("Invalid input.");

        } else {

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                // Successful authentication
                                userGlobal= Objects.requireNonNull(task.getResult()).getUser();
                                onAuthSuccess();

                            } else {
                                displayToast("Sign in failed.");
                            }
                        }
                    });
        }
    }


    // Called if and only if successful authentication.
    public void onAuthSuccess(){
        this.getUserType();
    }

    public void getUserType(){

        DatabaseReference dbReference = database.getReference().child(USERS).child(userGlobal.getUid()).child(TYPE);
        dbReference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){
                    accountType = dataSnapshot.getValue(AccountType.class);
                    onGetUserTypeSuccess();
                } else {
                    // Related object was deleted by the admin. We must also remove the authentication account.
                    deleteUser();
                    displayToast("Account deleted.");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                displayToast("Operation failed.");
            }
        });
    }

    // Called if and only if successful retrieval of account type.
    private void onGetUserTypeSuccess(){

        if(this.accountType.equals(AccountType.ADMINISTRATOR)){

            this.getAdminInfo();

        } else if (accountType.equals(AccountType.PATIENT)){

            this.getPatientInfo();

        } else if (accountType.equals(AccountType.EMPLOYEE)){

            this.getEmployeeInfo();

        } else {
            // ???
        }

    }

    private void getPatientInfo(){

        DatabaseReference dbReference = database.getReference().child(USERS).child(userGlobal.getUid());
        dbReference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Patient patient = dataSnapshot.getValue(Patient.class);
                startNewActivityAdminOrPatient(patient);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                displayToast("Operation failed.");
            }
        });

    }

    private void getEmployeeInfo(){

        DatabaseReference dbReference = database.getReference().child(USERS).child(userGlobal.getUid());
        dbReference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Employee employee = dataSnapshot.getValue(Employee.class);
                getClinicInfo(Objects.requireNonNull(employee));
                getClinicInfo(employee);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                displayToast("Operation failed.");
            }
        });
    }


    private void getAdminInfo(){

        DatabaseReference dbReference = database.getReference().child(USERS).child(userGlobal.getUid());
        dbReference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Administrator admin = dataSnapshot.getValue(Administrator.class);
                startNewActivityAdminOrPatient(admin);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                displayToast("Operation failed.");
            }
        });
    }

    private void getClinicInfo(final Employee employee){

        DatabaseReference dbReference = database.getReference().child(CreateAccount.CLINICS).child(employee.getId());
        dbReference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Clinic clinic = dataSnapshot.getValue(Clinic.class);
                startNewActivityEmployee(employee, clinic);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                displayToast("Operation failed.");
            }
        });
    }

    private void startNewActivityEmployee(Employee employee, Clinic clinic){
        Global.setUserType(1);
        Global.setAccount(employee);
        Intent intent ;
        intent = new Intent(this, WelcomeScreen.class);
        intent.putExtra("EmployeeObject", employee);
        intent.putExtra("ClinicObject", clinic);
        intent.putExtra("CLINICID", clinic.getId());
        this.startActivity(intent);
    }


    // Called if and only if successful retrieval of all information related to user.
    public void startNewActivityAdminOrPatient(Account user){

        Intent intent ;

        if(user instanceof Patient) {
            Global.setUserType(2);
            Patient patient = (Patient) user;
            Global.setAccount(patient);

            intent = new Intent(this, WelcomeScreen.class);
            intent.putExtra("PatientObject", patient);
            this.startActivity(intent);


        } else if (user instanceof Administrator) {
            Global.setUserType(0);
            Administrator admin = (Administrator) user;
            Global.setAccount(admin);

            intent = new Intent(this, WelcomeScreen.class);
            intent.putExtra("AdminObject", admin);
            this.startActivity(intent);
        }
    }


    public void displayToast(String message){

        Toast.makeText(LoginScreen.this, message, Toast.LENGTH_SHORT).show();
    }

    public String retrieveUserEmail(){

        EditText emailText = findViewById(R.id.emailTextEdit);
        return emailText.getText().toString();
    }

    public String retrieveUserPass(){

        EditText passwordText = findViewById(R.id.passTextEdit);
        return passwordText.getText().toString();
    }

    public boolean validUserInput(String email, String pass){
        return (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass));
    }


    public void deleteUser(){
        userGlobal.delete();
    }
}

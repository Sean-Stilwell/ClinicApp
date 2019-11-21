package com.example.clinicprojectv2.Employee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.os.Bundle;

import com.example.clinicprojectv2.Clinic.Clinic;
import com.example.clinicprojectv2.R;
import com.example.clinicprojectv2.Service.Service;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.example.clinicprojectv2.Service.Service;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.clinicprojectv2.Account.Account;
import com.example.clinicprojectv2.Account.AccountType;
import com.example.clinicprojectv2.R;
import com.example.clinicprojectv2.Service.Service;
import com.example.clinicprojectv2.Service.ServicePerformer;
import com.example.clinicprojectv2.Utility;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.app.AlertDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class EmployeeActivity extends AppCompatActivity {

    public static final String SERVICES = "services";

    private List<String> allPossibleServices;

    private List<String> servicesHaveNot;

    private List<String> servicesHaves;

    private Employee employee;

    private Clinic clinic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clinic_modify);


        allPossibleServices = new ArrayList<>();
        servicesHaveNot = new ArrayList<>();
        servicesHaves = new ArrayList<>();
    }

    @Override
    public void onStart() {
        super.onStart();

//        this.getServicesHaves();
//        getAllServices();
    }


    private void getServicesHaves(){

        servicesHaves.clear();

        List<Service> services = clinic.getLinksToServices();
        for(Service e : services){
            this.servicesHaves.add(e.getName());
        }
    }




    private void getAllServices() {



        DatabaseReference databaseUsers = FirebaseDatabase.getInstance().getReference("services");
        databaseUsers.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                allPossibleServices.clear();
                for(DataSnapshot item : dataSnapshot.getChildren()){
                    Service service = item.getValue(Service.class);
                    allPossibleServices.add(Objects.requireNonNull(service).getName());
                }

                onGetAllServices();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }



    private void onGetAllServices(){


    }


    private void clickAddService(){

    }

    private void clickRemoveService(){

        String service ;

    }


    private void displayAllInfo(){

    }



}



package com.example.clinicprojectv2.Employee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.os.Bundle;

import com.example.clinicprojectv2.Clinic.CanadianProvince;
import com.example.clinicprojectv2.Clinic.Clinic;

import com.example.clinicprojectv2.Clinic.Clinic;
import com.example.clinicprojectv2.Clinic.PaymentMethod;
import com.example.clinicprojectv2.R;
import com.example.clinicprojectv2.Service.Service;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
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
import android.widget.ListAdapter;
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

    public static final String CLINICS = "clinics";
    public static final String SERVICES = "services";


    private Clinic clinic;
    private String clinicID;


    private List<String> allPaymentMethods;
    private List<String> havesPaymentMethods;
    private List<String> haveNotPaymentMethods;
    private List<Service> allServices;
    private List<String> havesServices;
    private List<String> haveNotServices;
    private List<String> insurances;



    private Spinner provinceSpinner;
    private Spinner paymentMethodsAddSpinner;
    private Spinner servicesAddSpinner;
    private Spinner paymentMethodsRemoveSpinner;
    private Spinner removeInsurranceSpinner;
    private Spinner servicesSpinnerRemove;



    private EditText clinicNameEditText;
    private EditText streetNumberEdit;
    private EditText streetNameEdit;
    private EditText cityNameEdit;
    private EditText phoneNumberEdit;
    private EditText insurranceEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clinic_modify);

        clinicID = getIntent().getStringExtra("CLINICID");

        allPaymentMethods = new ArrayList<>();
        allPaymentMethods.add(Clinic.PAYMENTMETHODS[0]);
        allPaymentMethods.add(Clinic.PAYMENTMETHODS[1]);
        allPaymentMethods.add(Clinic.PAYMENTMETHODS[2]);

        haveNotPaymentMethods = new ArrayList<>();
        havesPaymentMethods = new ArrayList<>();
        havesServices = new ArrayList<>();
        haveNotServices = new ArrayList<>();
        allServices = new ArrayList<>();
        insurances = new ArrayList<>();

        linkSpinners();
        linkUiFields();

        setUpProvinceSpinner();
    }

    private void setUpProvinceSpinner(){

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, Clinic.PROVINCES);
        provinceSpinner.setAdapter(arrayAdapter);
    }


    private void linkSpinners(){
        paymentMethodsAddSpinner = findViewById(R.id.paymentMethodsAddSpinner);

        provinceSpinner = findViewById(R.id.provinceSpinner);

        servicesAddSpinner = findViewById(R.id.servicesAddSpinner);

        paymentMethodsRemoveSpinner = findViewById(R.id.paymentMethodsRemoveSpinner);

        removeInsurranceSpinner = findViewById(R.id.removeInsurranceSpinner);

        servicesSpinnerRemove = findViewById(R.id.servicesSpinnerRemove);
    }


    private void linkUiFields(){
        clinicNameEditText = findViewById(R.id.clinicNameEditText);
        streetNumberEdit = findViewById(R.id.streetNumberEdit);
        streetNameEdit = findViewById(R.id.streetNameEdit);
        cityNameEdit = findViewById(R.id.cityNameEdit);
        phoneNumberEdit = findViewById(R.id.phoneNumberEdit);
        insurranceEditText = findViewById(R.id.insurranceEditText);
    }





    @Override
    public void onStart() {
        super.onStart();

        setUpListenerForClinicModel();
    }

    private void setUpListenerForClinicModel(){

        DatabaseReference databaseUsers = FirebaseDatabase.getInstance().getReference(CLINICS).child(clinicID);
        databaseUsers.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){
                    clinic = dataSnapshot.getValue(Clinic.class);
                    onGetClinicModelSuccess();

                } else {
                    // SHOULD do something.
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void onGetClinicModelSuccess(){

        setUpListenerForAllServices();

    }

    private void setUpListenerForAllServices(){

        DatabaseReference databaseUsers = FirebaseDatabase.getInstance().getReference(SERVICES);
        databaseUsers.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                allServices.clear();
                for(DataSnapshot item : dataSnapshot.getChildren()){
                    Service service = item.getValue(Service.class);
                    allServices.add(service);
                }

                onGetAllServicesSuccess();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void onGetAllServicesSuccess(){
        initializeHavesPaymentMethod();
        initializeHaveNotPaymentMethods();
        initializeHavesInsurances();
        initializeHavesServices();
        initializeHaveNotServices();
        updateUI();
    }


    private void initializeHavesPaymentMethod(){
        for(String e : clinic.getPaymentMethodsAsString()){
            havesPaymentMethods.add(e);
        }
    }


    private void initializeHaveNotPaymentMethods(){
        for(String e : allPaymentMethods){
            if(!havesPaymentMethods.contains(e)){
                haveNotPaymentMethods.add(e);
            }
        }
    }

    private void initializeHavesInsurances(){
        for(String e : clinic.getInsurances()){
            insurances.add(e);
        }
    }

    private void initializeHavesServices(){
        for(Service e : clinic.getLinksToServices()){
            this.havesServices.add(e.getName());
        }
    }

    private void initializeHaveNotServices(){
        for(Service e : allServices){
            String name = e.getName();
            if(!havesServices.contains(name)){
                haveNotServices.add(name);
            }
        }
    }



    private void updateUI(){

        updateAllSpinners();

        updateInfo();
    }


    private void updateInfo(){

        String clinicName = clinic.getName();
        int addressNumber = clinic.getAddressNumber();
        String streetName = clinic.getAddressStreet();
        String cityName = clinic.getAddressCity();
        String phoneNumber = clinic.getPhoneNumber();
        String province = clinic.getProvinceAsString();
        int provincePosition = Clinic.positionFromProvince(province);


        provinceSpinner.setSelection(provincePosition);
        clinicNameEditText.setText(clinicName);
        streetNumberEdit.setText(Integer.toString(addressNumber));
        streetNameEdit.setText(streetName);
        cityNameEdit.setText(cityName);
        phoneNumberEdit.setText(phoneNumber);
    }


    private void updateAllSpinners(){
        updateSpinnerAddServices();
        updateSpinnerRemoveServices();
        updateSpinnerAddPaymentMethods();
        updateSpinnerRemovePaymentMethods();
        updateSpinnerRemoveInsurrance();
    }


    private void updateSpinnerAddServices(){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, haveNotServices);
        servicesAddSpinner.setAdapter(arrayAdapter);
    }

    private void updateSpinnerRemoveServices(){

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, havesServices);
        servicesSpinnerRemove.setAdapter(arrayAdapter);
    }

    private void updateSpinnerAddPaymentMethods(){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, haveNotPaymentMethods);
        paymentMethodsAddSpinner.setAdapter(arrayAdapter);
    }

    private void updateSpinnerRemovePaymentMethods(){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, havesPaymentMethods);
        paymentMethodsRemoveSpinner.setAdapter(arrayAdapter);
    }

    private void updateSpinnerRemoveInsurrance(){

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, insurances);
        removeInsurranceSpinner.setAdapter(arrayAdapter);
    }

    public void displayToast(String message){

        Toast.makeText(EmployeeActivity.this, message, Toast.LENGTH_SHORT).show();
    }


    public void clickAddService(View view){
        if(servicesAddSpinner.getSelectedItem()!=null) {
            String serviceName = servicesAddSpinner.getSelectedItem().toString();
            haveNotServices.remove(serviceName);
            havesServices.add(serviceName);
            updateSpinnerAddServices();
            updateSpinnerRemoveServices();
            displayToast("Added.");
        } else {
            displayToast("No Service Selected!");
        }
    }

    public void clickRemoveService(View view){
        if(servicesSpinnerRemove.getSelectedItem()!=null) {
            String serviceName = servicesSpinnerRemove.getSelectedItem().toString();
            havesServices.remove(serviceName);
            haveNotServices.add(serviceName);
            updateSpinnerAddServices();
            updateSpinnerRemoveServices();
            displayToast("Removed.");
        } else {
            displayToast("No Service Selected!");
        }
    }


    public void clickAddPayment(View view){

        if(paymentMethodsAddSpinner.getSelectedItem()!=null) {
            String serviceName = paymentMethodsAddSpinner.getSelectedItem().toString();
            haveNotPaymentMethods.remove(serviceName);
            havesPaymentMethods.add(serviceName);
            updateSpinnerAddPaymentMethods();
            updateSpinnerRemovePaymentMethods();
            displayToast("Added.");
        } else {
            displayToast("No Payment Selected!");
        }

    }

    public void clickAddInsurance(View view){
        String name = insurranceEditText.getText().toString();
        if(Utility.isValidServiceName(name)){
            if(insurances.contains(name)){
                displayToast("Exists Already.");
            } else {
                insurances.add(name);
                updateSpinnerRemoveInsurrance();
                insurranceEditText.setText("");
                displayToast("Insurance added.");
            }
        } else {
            displayToast("Not a valid name.");
        }
    }


    public void clickRemoveInsurance(View view){

        if(removeInsurranceSpinner.getSelectedItem()!=null) {
            String serviceName = removeInsurranceSpinner.getSelectedItem().toString();
            insurances.remove(serviceName);
            updateSpinnerRemoveInsurrance();
            displayToast("Removed.");
        } else {
            displayToast("No Insurrance Selected!");
        }

    }

    public void clickRemovePayment(View view){

        if(paymentMethodsRemoveSpinner.getSelectedItem()!=null) {
            String serviceName = paymentMethodsRemoveSpinner.getSelectedItem().toString();
            havesPaymentMethods.remove(serviceName);
            haveNotPaymentMethods.add(serviceName);
            updateSpinnerRemovePaymentMethods();
            updateSpinnerAddPaymentMethods();
            displayToast("Removed.");
        } else {
            displayToast("No Payment Selected!");
        }

    }


    public void clickSave(View view){


        if(TextUtils.isEmpty(clinicNameEditText.getText().toString())||
                TextUtils.isEmpty(streetNumberEdit.getText().toString())
                ||TextUtils.isEmpty(streetNameEdit.getText().toString())
                ||TextUtils.isEmpty(cityNameEdit.getText().toString())
                ||TextUtils.isEmpty(phoneNumberEdit.getText().toString())) {


            displayToast("Some fields are empty");

        } else {

            try {

                String newClinicName = clinicNameEditText.getText().toString();
                String numberAsString = streetNumberEdit.getText().toString();
                int number = Integer.parseInt(numberAsString);
                String streetName = streetNameEdit.getText().toString();
                String cityName = cityNameEdit.getText().toString();
                String phone = phoneNumberEdit.getText().toString();

                List<PaymentMethod> finalPaymentMethods =  Clinic.paymentMethsAsEnumFromStringList(havesPaymentMethods);

                List<Service> finalServices  = getFullServicesFromNames(havesServices);

                List<String> finalInsurances = this.insurances;

                int spinnerProvinceSelected = provinceSpinner.getSelectedItemPosition();

                CanadianProvince province = Clinic.provinceFromPosition(spinnerProvinceSelected);

                clinic.setName(newClinicName);

                clinic.setNumber(number);

                clinic.setStreetName(streetName);

                clinic.setCity(cityName);

                clinic.setPhoneNumber(phone);

                clinic.setProvince(province);

                clinic.removeInsurancesAndSetTo(finalInsurances);

                clinic.removeAllPaymentMetAndSetTo(finalPaymentMethods);

                clinic.removeAllServicesAndSetTo(finalServices);

                DatabaseReference db = FirebaseDatabase.getInstance().getReference();

                db.child(CLINICS).child(clinicID).setValue(clinic).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        displayToast("Success");
                        finish();
                    }


                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        displayToast("Unsecful");
                    }
                });

            } catch (Exception e) {

                displayToast("Some inputs are Invalid.");

            }
        }
        //this.finish();
    }

    private  List<Service> getFullServicesFromNames(List<String> serviceNames){

        List<Service> tmp = new ArrayList<>();

        for(String e : serviceNames){
            for (Service f : allServices){
                if(e.equals(f.getName())){
                    tmp.add(f);
                }
            }
        }
        return tmp;
    }

    public void clickCancel(View view){
        this.finish();
    }

}



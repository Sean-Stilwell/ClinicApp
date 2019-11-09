package com.example.clinicprojectv2.Administrator.AdminMainActivities.ui.ServicesManagement;
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

public class ServicesManagementFragment extends Fragment {

    //private Model model;

    private EditText serviceName;
    private ListView listViewServices;
    private List<Service> services;
    private Spinner addSpinner;
    private String[] roles = {Service.DOCTOR, Service.NURSE, Service.STAFF};


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // model = ViewModelProviders.of(this).get(Model.class);

        View root = inflater.inflate(R.layout.fragment_services, container, false);

        services = new ArrayList<>();
        listViewServices = root.findViewById(R.id.listViewServices);
        this.setUpSpinner(root);
        serviceName = root.findViewById(R.id.serviceNameTextField);
        Button buttonAdd = root.findViewById(R.id.buttonAddService);
        setUpListenerForServices();

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProduct();
            }
        });

        return root;
    }
    private void setUpListenerForServices() {

        DatabaseReference databaseUsers = FirebaseDatabase.getInstance().getReference("services");
        databaseUsers.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                services.clear();
                for(DataSnapshot item : dataSnapshot.getChildren()){
                    Service service = item.getValue(Service.class);
                    services.add(service);
                }
                if(getActivity()!=null){
                    updateUI();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();

        this.setLongClickListenerForListView();
        updateUI();
    }

    private void setLongClickListenerForListView(){

        listViewServices.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Service service = services.get(i);
                showUpdateDeleteDialog(service.getId(), service.getName());
                return true;
            }
        });
    }

    private void setUpSpinner(View root){
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,roles);
        addSpinner = root.findViewById(R.id.performerServiceChoices);
        addSpinner.setAdapter(myAdapter);
    }

    private void updateUI(){
        ServiceList serviceAdapter = new ServiceList(getActivity(),services);
        listViewServices.setAdapter(serviceAdapter);
    }

    private void showUpdateDeleteDialog(final String serviceID, String serviceName) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_services_management, null);
        dialogBuilder.setView(dialogView);


        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,roles);
        final Spinner mySpinner = dialogView.findViewById(R.id.roleChoice);
        mySpinner.setAdapter(myAdapter);


        final EditText serviceNameText = dialogView.findViewById(R.id.editServiceName);
        final Button buttonUpdate = dialogView.findViewById(R.id.buttonUpdateService);
        final Button buttonDelete = dialogView.findViewById(R.id.buttonDeleteService);

        dialogBuilder.setTitle(serviceName);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();


        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String serviceName = serviceNameText.getText().toString().trim();
                ServicePerformer role = getRoleChoice(mySpinner);

                if(validUserInput(serviceName)){

                    updateProduct(serviceID, serviceName, role);
                    alertDialog.dismiss();
                } else {
                    displayToast("Invalid name.");
                }
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteProduct(serviceID);
                alertDialog.dismiss();
            }
        });
    }




    private void updateProduct(String id, String serviceName, ServicePerformer role) {
        Service service = new Service(serviceName,role, id);
        DatabaseReference databaseService = FirebaseDatabase.getInstance().getReference();
        databaseService.child("services").child(id).setValue(service);
        displayToast("Updated");

    }


    private void deleteProduct(String id) {
        DatabaseReference databaseService = FirebaseDatabase.getInstance().getReference();
        databaseService.child("services").child(id).removeValue();
        displayToast("Service Deleted");
    }


    private void addProduct() {

        String serviceName = this.serviceName.getText().toString().trim();
        ServicePerformer role = this.getRoleChoice(addSpinner);

        if(validUserInput(serviceName)){
            DatabaseReference databaseService = FirebaseDatabase.getInstance().getReference().child("services");
            String id = databaseService.push().getKey();
            Service service = new Service(serviceName, role, id);
            databaseService.child(Objects.requireNonNull(id)).setValue(service);
            this.serviceName.setText("");
            displayToast("Service Added");

        } else {
            displayToast("Please enter correct name");
        }

    }

    private ServicePerformer getRoleChoice(Spinner spinner){

        String selection = spinner.getSelectedItem().toString();
        switch (selection){
            case Service.NURSE:
                return ServicePerformer.NURSE;
            case Service.DOCTOR:
                return ServicePerformer.DOCTOR;
            case Service.STAFF:
                return ServicePerformer.STAFF;
            default:
                throw new IllegalArgumentException();
        }
    }

    private boolean validUserInput(String name){
        return Utility.isValidServiceName(name);
    }

    private void displayToast(String message){

        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }




}
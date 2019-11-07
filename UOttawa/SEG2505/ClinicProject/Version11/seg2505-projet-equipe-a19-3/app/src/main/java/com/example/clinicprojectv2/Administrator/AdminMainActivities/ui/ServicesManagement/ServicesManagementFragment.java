package com.example.clinicprojectv2.Administrator.AdminMainActivities.ui.ServicesManagement;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.clinicprojectv2.R;
import com.example.clinicprojectv2.Account.Account;
import com.example.clinicprojectv2.Service.Service;

public class ServicesManagementFragment extends Fragment {

    //private Model model;

    private String[] performers = {Service.DOCTOR, Service.NURSE, Service.STAFF};


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // model = ViewModelProviders.of(this).get(Model.class);

        View root = inflater.inflate(R.layout.fragment_services, container, false);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,performers );
        Spinner mySpinner = root.findViewById(R.id.performerServiceChoices);
        mySpinner.setAdapter(myAdapter);

        return root;
    }
}
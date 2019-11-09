package com.example.clinicprojectv2.Administrator.AdminMainActivities.ui.ServicesManagement;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.example.clinicprojectv2.Account.Account;
import com.example.clinicprojectv2.R;
import com.example.clinicprojectv2.Service.Service;

import java.util.List;

public class ServiceList extends ArrayAdapter<Service> {

    private List<Service> services;
    private Activity context;


    public ServiceList(Activity context, List<Service> services) {
        super(context, R.layout.user_item, services);
        this.context = context;
        this.services = services;
    }

    @Override
    @NonNull

    public View getView(int position, View convertView,ViewGroup parent){

        LayoutInflater inflater = context.getLayoutInflater();
        @SuppressLint("ViewHolder") View listViewItem = inflater.inflate(R.layout.service_item, null,true);

        TextView serviceNameText = listViewItem.findViewById(R.id.serviceNameText);
        TextView serviceRole = listViewItem.findViewById(R.id.servicePerformerText);

        Service service = services.get(position);

        String name = service.getName();
        String role = service.getServicePerformerAsString();

        serviceNameText.setText(name);
        serviceRole.setText(role);

        return listViewItem;
    }
}

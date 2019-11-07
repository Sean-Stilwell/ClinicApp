package com.example.clinicprojectv2.Administrator.AdminMainActivities.ui.AccountManagement;

import com.example.clinicprojectv2.Account.Account;
import com.example.clinicprojectv2.Service.Service;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.clinicprojectv2.R;
import java.util.List;
import androidx.annotation.NonNull;

public class UserList extends ArrayAdapter<Account> {

    private List<Account> users;
    private Activity context;


    public UserList(Activity context, List<Account> users) {
        super(context, R.layout.user_item, users);
        this.context = context;
        this.users = users;
    }

    @Override
    @NonNull

    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.user_item, null,true);

        TextView nameTextView = listViewItem.findViewById(R.id.firstLastNameText);
        TextView emailTextView = listViewItem.findViewById(R.id.emailText);
        TextView typeTextView = listViewItem.findViewById(R.id.typeUserText);

        Account account = users.get(position);

        String name = account.getFullName();
        String email = account.getEmail();
        String type = account.getTypeAsString();

        nameTextView.setText(name);
        emailTextView.setText(email);
        typeTextView.setText(type);

        return listViewItem;
    }




}

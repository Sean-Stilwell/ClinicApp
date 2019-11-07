package com.example.clinicprojectv2.Administrator.AdminMainActivities.ui.AccountManagement;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.example.clinicprojectv2.Account.Account;
import com.example.clinicprojectv2.Account.AccountType;
import com.example.clinicprojectv2.Patient.Patient;
import com.example.clinicprojectv2.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;
import android.app.AlertDialog;

public class AccountManagementFragment extends Fragment {

    //private Model model;
    private List<Account> users;
    private ListView listViewUsers;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //model = ViewModelProviders.of(this).get(Model.class);
        View root = inflater.inflate(R.layout.fragment_accounts, container, false);
        listViewUsers = root.findViewById(R.id.listViewUsers);
        users = new ArrayList<>();
        return root;
    }



    @Override
    public void onStart() {
        super.onStart();
        this.setUpListenerForUsers();
        this.setLongClickListenerForListView();
        updateUI();
    }

    private void setLongClickListenerForListView(){

        listViewUsers.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Account account = users.get(i);
                showUpdateDeleteDialog(account.getId());
                return true;
            }
        });
    }

    private void setUpListenerForUsers() {

        DatabaseReference databaseUsers = FirebaseDatabase.getInstance().getReference("users");
        databaseUsers.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                users.clear();
                for(DataSnapshot item : dataSnapshot.getChildren()){
                    Account currAccount = item.getValue(Account.class);
                    if(Objects.requireNonNull(currAccount).getType()!=AccountType.ADMINISTRATOR){
                        users.add(currAccount);
                    }
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

    private void updateUI(){
        UserList usersAdapter = new UserList(getActivity(),users);
        listViewUsers.setAdapter(usersAdapter);
    }

    private void showUpdateDeleteDialog(final String userID) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_account_management_fragment_admin, null);
        dialogBuilder.setView(dialogView);


        final Button buttonDelete = dialogView.findViewById(R.id.deleteButton);
        final Button buttonCancel =  dialogView.findViewById(R.id.cancelButton);

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        buttonDelete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                deleteUser(userID);
                alertDialog.dismiss();
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                alertDialog.dismiss();
            }
        });
    }

    private void deleteUser(String id) {

        DatabaseReference databaseUsers = FirebaseDatabase.getInstance().getReference("users");
        databaseUsers.child(id).removeValue();
        Toast.makeText(getActivity(), "User Deleted", Toast.LENGTH_LONG).show();
    }



}
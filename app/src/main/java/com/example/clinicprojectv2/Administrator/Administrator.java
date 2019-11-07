package com.example.clinicprojectv2.Administrator;
import com.example.clinicprojectv2.Account.Account;
import com.example.clinicprojectv2.Account.AccountType;
import com.example.clinicprojectv2.Administrator.AdminMainActivities.AdminActivity;

public class Administrator extends Account {

    private static final AccountType type = AccountType.ADMINISTRATOR;
    private static final String name = "Admin";
    private static final String email = "admin@admin.com";
    // Pass : admin123


    /**
     * This method initializes the admin account with default values.
     * This way, only one admin account will exist, and no other ones can be created.
     */
    public Administrator(String id){
        super(name, name, email, type, id);
    }

    public Administrator(){

    }

}
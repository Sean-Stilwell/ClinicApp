package com.example.clinicprojectv2.Administrator;
import com.example.clinicprojectv2.Account.Account;
import com.example.clinicprojectv2.Account.AccountType;

public class Administrator extends Account {

    private static final AccountType type = AccountType.ADMINISTRATOR;
    private static final String name = "Admin";
    private static final String email = "admin@admin.com";

    /**
     * This method initializes the admin account with default values.
     * This way, only one admin account will exist, and no other ones can be created.
     */
    private Administrator(){
        super(name, name, email, type);
    }

}
package com.example.clinicprojectv2.Patient;
import com.example.clinicprojectv2.Account.Account;
import com.example.clinicprojectv2.Account.AccountType;

public class Patient extends Account {

    private static final AccountType type = AccountType.PATIENT;

    /**
     * This method constructs an instance of an employee account.
     *
     * @param firstName the first name of the employee
     * @param lastName  the last name of the employee
     * @param email     the email of the employee
     */
    public Patient(String firstName, String lastName, String email) {
        super(firstName,lastName,email,type);
    }

    public Patient(){
        super();
    }

}
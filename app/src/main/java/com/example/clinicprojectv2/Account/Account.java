package com.example.clinicprojectv2.Account;

import com.example.clinicprojectv2.Employee.Employee;
import com.example.clinicprojectv2.Patient.Patient;
import com.example.clinicprojectv2.Utility;

import java.io.Serializable;

public class Account implements Serializable {

    public static final String PATIENT = "Patient";
    public static final String EMPLOYEE = "Employee";
    public static final String ADMINISTRATOR = "Administrator";

    private String firstName;
    private String lastName;
    private String email;
    private String id;
    private AccountType type;


    /**
     * Constructor for an account.
     */
    public Account(String firstName, String lastName, String email, AccountType type, String id){

        if(!this.accountInfoIsValid(firstName, lastName, email, type, id)){
            throw new IllegalArgumentException("Illegal arguments for account creation.");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.type = type;
        this.id = id;
    }

    public Account(){

    }

    public void setId(String id){
        this.id = id;
    }

    /**
     * This method returns the type of account.
     * @return The type of the account.
     */
    public AccountType getType(){
        return this.type;
    }


    /**
     * This method returns the first name of the person linked to that account.
     * @return The first name of the account
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * This method returns the last name of the person linked to that account.
     * @return The last name of the account
     */
    public String getLastName(){
        return this.lastName;
    }


    /**
     * This method returns the email of that account.
     * @return The email of the account
     */
    public String getEmail(){
        return this.email;
    }

    public String getFullName(){
        return (this.getFirstName()+ " " +this.getLastName());
    }

    public String getId(){
        return this.id;
    }

    public String getTypeAsString(){

        switch (this.getType()) {
            case ADMINISTRATOR:
                return ADMINISTRATOR;
            case EMPLOYEE:
                return EMPLOYEE;
            case PATIENT:
                return PATIENT;
            default:
                throw new IllegalArgumentException();
        }

    }


    /**
     * This method will check if one of the paramaters in the account creation
     * constructors is null.
     * @return True if the information is valid, else otherwise.
     */
    protected boolean accountInfoIsValid(String firstName, String lastName, String email, AccountType type, String id){
        if (firstName == null || lastName == null || email == null || type == null || id == null){
            return false;
        } else if (!(Utility.isValidName(firstName))||
                   !(Utility.isValidName(lastName)) ||
                   !(Utility.isValidEmail(email))){
            return false;
        } else {
            return true;
        }
    }
}
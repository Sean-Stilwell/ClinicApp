package com.example.clinicprojectv2.Account;

import com.example.clinicprojectv2.Utility;

import java.io.Serializable;

public abstract class Account implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private AccountType type;


    /**
     * Constructor for an account.
     */
    public Account(String firstName, String lastName, String email, AccountType type){

        if(!this.accountInfoIsValid(firstName, lastName, email, type)){
            throw new IllegalArgumentException("Illegal arguments for account creation.");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.type = type;
    }

    public Account(){

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



    public void setEmail(String email){
         this.email = email;
    }

    /**
     * This method will check if one of the paramaters in the account creation
     * constructors is null.
     * @return True if the information is valid, else otherwise.
     */
    protected boolean accountInfoIsValid(String firstName, String lastName, String email, AccountType type){
        if (firstName == null || lastName == null || email == null || type == null){
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
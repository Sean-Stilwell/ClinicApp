package com.example.clinicprojectv2;

import com.example.clinicprojectv2.Account.Account;

public class Global {
    private static int userType;
    private static String userFirstName = "name";
    private static Account savedAccount;

    public static void setAccount(Account account){
        if (account == null){
            throw new NullPointerException();
        }
        else{
            savedAccount = account;
        }
    }

    public static Account getSavedAccount(){
        return savedAccount;
    }

    public static void setUserType(int input){
        // Check for valid input
        if (input > 2 || input < 0){
            throw new IllegalArgumentException();
        }
        // Set the user type. 0 = admin, 1 = employee, 2 = patient
        else{
            userType = input;
        }
    }

    public static String getUserRole(){
        // Returns a string representing the user role.
        if (userType == 0){
            return "Administrator";
        }
        else if (userType == 1){
            return "Employee";
        }
        else if (userType == 2){
            return "Patient";
        }
        return null;
    }
}

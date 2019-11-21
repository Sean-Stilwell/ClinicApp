package com.example.clinicprojectv2;

public class Global {
    private static int userType;
    private static String userFirstName = "name";

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

    public static void setUserFirstName(String name){
        // Check for valid input
        if (name == null){
            throw new NullPointerException();
        }
        // Set the user's name
        else{
            userFirstName = name;
        }
    }

    public static String getUserFirstName(){
        return userFirstName;
    }
}

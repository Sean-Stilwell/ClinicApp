package com.example.clinicprojectv2;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Utility {

    /**
    * This method validates if the String given as argument is a valid email.
    * This method throws an exception if the argument is null.
    *
    * @param email String to be validated.
    * @return True if email is valid and false if not.
    */

	public static boolean isValidEmail(String email){

		if(email==null){
			throw new NullPointerException(); // Argument is null
		}
		String regex = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"; // Specific pattern
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches(); // Tries to match email to pattern
	}


    /**
    * This method validates if the name (either first or last name) is valid.
    * This method throws an exception if the argument is null.
    * In this case, we only consider valid names that contain
    * letters only. The first letter must be uppercase.
    *
    * @param name String to be validated.
    * @return True if the name is valid, false if not.
    */

	public static boolean isValidName(String name){

		if(name==null){
			throw new NullPointerException(); // Argument is null
		}
		return name.matches("[A-Z][a-z]*"); // Tries to match name to the specific pattern.
	}


	public static boolean isValidPassword(String pass){
		if(pass==null){
			throw new NullPointerException();
		}

		return (pass.length()>=6);
	}
}


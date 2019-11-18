package com.example.clinicprojectv2;

import android.text.TextUtils;

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

	public static boolean isValidServiceName(String service){
		if(service == null){
			throw new NullPointerException();
		}
		return (!TextUtils.isEmpty(service))&&(service.matches("^[a-zA-Z]*$"))  ;
	}

	/**
	 * This method validates if a given phone number is valid or not.
	 * It throws an exception if the parameter is null.
	 * We consider several types of input as valid.
	 *
	 * @param phoneNumber phone number to be validates
	 * @return true if phone number is valid, false otherwise.
	 * */
	public static boolean isValidPhoneNumber(String phoneNumber){
		// If the phone number is null, we throw an exception
		if(phoneNumber == null){
			throw new NullPointerException();
		}
		// If it is written in the format "1111111111", we accept it.
		if (phoneNumber.matches("\\d{10}")){
			return true;
		}
		// If it uses a - or spaces we also accept it.
		else if (phoneNumber.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")){
			return true;
		}
		// If it uses brackets for the area code we also accept it
		else if (phoneNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")){
			return true;
		}
		// otherwise, there is something wrong with their formatting and we return false.
		else{
			return false;
		}
	}

	/**
	 * This method validates if a given address is valid or not.
	 * It throws an exception if the parameter is null.
	 * We consider several types of input as valid.
	 *
	 * @param address address to be validates
	 * @return true if address is valid, false otherwise.
	 * */
	public static boolean isValidAddress(String address){
		if (address == null){
			throw new NullPointerException();
		}
		// Validating the address value
		if (address.matches("\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)")){
			return true;
		}
		else {
			return false;
		}
	}
}


package com.example.projetfinaleseg2505;

import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Utility {

	private static final String SHA256 = "SHA-256";

    /**
    * This method applies the SHA256 cryptographic on the String argument.
    * The resulted hash is then converted into Hexadcimal String format.
    * The original String is not modified.
    * This method throws an exception if the argument is null.
    *
    * @param argument the String to be hashed
    * @return Hexadciamal String representation of the resulted Hash.
    */

	public static String SHA256(String argument){

		if(argument==null){

			throw new NullPointerException("No argument given.");
		}

		String toReturn = null;

		try {

		    byte[] data = argument.getBytes(StandardCharsets.UTF_8);
		    MessageDigest messageDigest = MessageDigest.getInstance(SHA256);
		    byte[] hash = messageDigest.digest(data);
		    String hexRepresentation = DatatypeConverter.printHexBinary(hash);
		    toReturn = hexRepresentation;

		} catch (NoSuchAlgorithmException e){

			// WILL NEVER HAPPEN IN PRACTICE, BUT STILL HAVE TO CATCH
			// THE ALGORITHM WILL RETURN NULL IF THIS EXCEPTION IS THROWN			
		}
		return toReturn;
	}

    /**
    * This method validates if the String given as argument is a valid email.
    * This method throws an exception if the argument is null.
    *
    * @param email String to be validated.
    * @return True if email is valid and false if not.
    */

	public static boolean isValidEmail(String email){

		if(email==null){
			throw new NullPointerException();
		}
		String regex = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"; // Specific pattern
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches(); // Tries to match email to pattern
	}

	public static boolean isValidName(String name){

		if(name==null){
			throw new NullPointerException();
		}
		String regex = "[A-Z][a-z]*"; // Specific pattern
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);
		return matcher.matches(); // Tries to match name to pattern
	}

}










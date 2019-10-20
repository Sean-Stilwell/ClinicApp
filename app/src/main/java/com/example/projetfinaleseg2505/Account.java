package com.example.projetfinaleseg2505;

import java.lang.NullPointerException;

public class Account {

  protected String username, lastName, firstName, password, email, type;

  /**
  * This method returns the username of that account.
  * @return The username of the account
  */
  protected String getUsername(){
    return this.username;
  }

  /**
  * This method returns the last name of the person linked to that account.
  * @return The last name of the account
  */
  protected String getLastName(){
    return this.lastName;
  }

  /**
  * This method returns the first name of the person linked to that account.
  * @return The first name of the account
  */
  protected String getFirstName(){
    return this.firstName;
  }

  /**
  * This method returns the password of that account.
  * @return The password of the account
  */
  protected String getPassword(){
    return this.password;
  }

  /**
  * This method returns the email of that account.
  * @return The email of the account
  */
  protected String getEmail(){
    return this.email;
  }

  /*protected String encryptPassword(){
    return SHA256(this.password);
  }*/

  /**
  * This method will check if one of the paramaters in the account creation
  * constructors is null.
  * @return True if the information is valid, else otherwise.
  */
  protected boolean accountInfoIsValid(String username, String lastName, String firstName, String password, String email){
    if (username == null || lastName == null || firstName == null || password == null || email == null){
      return false;
    } else {
      return true;
    }
  }

  /**
  * This method uses the current account's information and inserts it into the database.
  * The method is called at the creation of a new account.
  */
  protected void addAccountToDatabase(){
    String fullName = this.firstName + this.lastName;
    DatabaseHelper.insertData(this.username, this.password, this.type, fullName);
  }
}

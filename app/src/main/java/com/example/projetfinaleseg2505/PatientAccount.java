package com.example.projetfinaleseg2505;
public class PatientAccount extends Account{

  private final String TYPE_OF_ACCOUNT = "patient";
  /**
  * This method constructs an instance of a patient's account.
  * @param username the username for login of the patient
  * @param lastName the last name of the patient
  * @param firstName the first name of the patient
  * @param password the password of the patient in alphadecimals, to be converted to hash
  * @param email the email of the patient
  */
  public PatientAccount(String username, String lastName, String firstName, String password, String email){

    if (accountInfoIsValid(username, lastName, firstName, password, email)){
      this.type = TYPE_OF_ACCOUNT;
      this.username = username;
      this.lastName = lastName;
      this.firstName = firstName;
      this.password = password; // TODO : store the password using hashed value given by the encryptPassword method in Account
      this.email = email;
  } else {
    throw new NullPointerException("At least one argument is null.");
   }

   addAccountToDatabase();

  }

  // TODO : For future assignments, add specific access/methods for a patient account.
}

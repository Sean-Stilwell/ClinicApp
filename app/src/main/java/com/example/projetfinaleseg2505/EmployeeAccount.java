package com.example.projetfinaleseg2505;
public class EmployeeAccount extends Account{

  private final String TYPE_OF_ACCOUNT = "employee";
  /**
  * This method constructs an instance of an employee account.
  * @param username the username for login of the employee
  * @param lastName the last name of the employee
  * @param firstName the first name of the employee
  * @param password the password of the employee in alphadecimals, to be converted to hash
  * @param email the email of the employee
  */
  public EmployeeAccount(String username, String lastName, String firstName, String password, String email){

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

  // TODO : For future assignments, add specific access/methods for an employee account.
}

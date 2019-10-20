

public class AdminAccount extends Account {

  private final String TYPE_OF_ACCOUNT = "admin";
  /**
  * This method initializes the admin account with default values.
  * This way, only one admin account will exist, and no other ones can be created.
  */
  private AdminAccount(){
    this.type = TYPE_OF_ACCOUNT;
    this.username = "admin";
    this.lastName = "admin";
    this.firstName = "admin";
    this.password = "password";
    this.email = "email";
  }

  /*
  * This method is called to initialize the admin account through the protected method.
  * The admin account is then saved to the database.
  */
  protected void initializeAdminAccount(){
    new AdminAccount();
    addAccountToDatabase();
  }
}

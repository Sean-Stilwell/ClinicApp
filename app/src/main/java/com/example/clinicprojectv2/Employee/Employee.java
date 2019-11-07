package com.example.clinicprojectv2.Employee;
import com.example.clinicprojectv2.Account.Account;
import com.example.clinicprojectv2.Account.AccountType;

public class Employee extends Account {

    private static final AccountType type = AccountType.EMPLOYEE;

    /**
     * This method constructs an instance of an employee account.
     *
     * @param firstName the first name of the employee
     * @param lastName  the last name of the employee
     * @param email     the email of the employee
     */
    public Employee(String firstName, String lastName, String email,String id) {
        super(firstName,lastName,email,type,id);
    }

    public Employee(){
        super();
    }

}
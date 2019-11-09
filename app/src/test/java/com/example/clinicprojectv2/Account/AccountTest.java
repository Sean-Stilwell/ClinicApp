package com.example.clinicprojectv2.Account;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void setId() {
        // A simple test case that sets then gets the ID to ensure it is set correctly.
        Account testAccount = new Account("Test", "Account", "test@test.com", AccountType.PATIENT, "12345");
        testAccount.setId("14576");
        assertEquals("User ID was not properly set.", "14576", testAccount.getId());
    }

    @Test
    public void getType() {
        // Two tests to determine if the primary account types are assigned properly.
        Account testAccount = new Account("Test", "Account", "test@test.com", AccountType.PATIENT, "12345");
        assertEquals("Account type PATIENT was not properly set", AccountType.PATIENT, testAccount.getType());

        Account testAccount2 = new Account("Test", "Account", "test@test.com", AccountType.EMPLOYEE, "12346");
        assertEquals("Account type EMPLOYEE was not properly set", AccountType.EMPLOYEE, testAccount2.getType());
    }

    @Test
    public void getFirstName() {
        // Test to determine if a name can be properly received
        Account testAccount = new Account("Test", "Account", "test@test.com", AccountType.PATIENT, "12345");
        assertEquals("First Name getter was invalid. Check constructor or setter.", "Test", testAccount.getFirstName());
    }

    @Test
    public void getLastName() {
        // Test to determine if a last name can be properly received
        Account testAccount = new Account("Test", "Account", "test@test.com", AccountType.PATIENT, "12345");
        assertEquals("Last Name getter was invalid. Check constructor or setter.", "Account", testAccount.getLastName());
    }

    @Test
    public void getEmail() {
        // Test to determine if a email can be properly received
        Account testAccount = new Account("Test", "Account", "test@test.com", AccountType.PATIENT, "12345");
        assertEquals("Email getter was invalid. Check constructor or setter.", "test@test.com", testAccount.getEmail());
    }

    @Test
    public void getFullName() {
        // Test to determine if a full name can be properly received
        Account testAccount = new Account("Test", "Account", "test@test.com", AccountType.PATIENT, "12345");
        assertEquals("Full name was not correct.", "Test Account", testAccount.getFullName());
    }

    @Test
    public void getId() {
        // A simple test case that sets then gets the ID to ensure it is set correctly.
        Account testAccount = new Account("Test", "Account", "test@test.com", AccountType.PATIENT, "12345");
        testAccount.setId("14576");
        assertEquals("User ID was not properly set.", "14576", testAccount.getId());
    }

    @Test
    public void getTypeAsString() {
        // Two tests to determine if the primary account types are assigned properly.
        Account testAccount = new Account("Test", "Account", "test@test.com", AccountType.PATIENT, "12345");
        assertEquals("Account type PATIENT was not properly set", "Patient", testAccount.getTypeAsString());

        Account testAccount2 = new Account("Test", "Account", "test@test.com", AccountType.EMPLOYEE, "12346");
        assertEquals("Account type EMPLOYEE was not properly set", "Employee", testAccount2.getTypeAsString());
    }

    @Test
    public void accountInfoIsValid() {
        // Checks that true is returned for valid info.
        Account testAccount = new Account("Test", "Account", "test@test.com", AccountType.PATIENT, "12345");
        boolean checker1 = testAccount.accountInfoIsValid("Test", "Account", "test@test.com", AccountType.PATIENT, "12345");
        assertTrue("Valid info verification rejected in Account class.", checker1);

        // Checks that false is returned for invalid name.
        Account testAccount2 = new Account("Test", "Account", "test@test.com", AccountType.PATIENT, "12345");
        boolean checker2 = testAccount2.accountInfoIsValid("24601", "Account", "test@test.com", AccountType.PATIENT, "12345");
        assertFalse("Invalid info verification accepted in Account class.", checker2);

        // Checks that false is returned for invalid surname
        Account testAccount3 = new Account("Test", "Account", "test@test.com", AccountType.PATIENT, "12345");
        boolean checker3 = testAccount3.accountInfoIsValid("Test", "24601", "test@test.com", AccountType.PATIENT, "12345");
        assertFalse("Invalid info verification accepted in Account class.", checker3);

        // Checks that false is returned for invalid email.
        Account testAccount4 = new Account("Test", "Account", "test@test.com", AccountType.PATIENT, "12345");
        boolean checker4 = testAccount4.accountInfoIsValid("Test", "Account", "wrong", AccountType.PATIENT, "12345");
        assertFalse("Invalid info verification accepted in Account class.", checker4);
    }
}
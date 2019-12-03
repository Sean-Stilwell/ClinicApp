package com.example.clinicprojectv2;

import org.junit.Test;
import static org.junit.Assert.*;

public class UtilityTest {

    @Test
    public void isValidEmail() {
        // It should only accept valid emails
        assertTrue("A valid email was rejected.", Utility.isValidEmail("test@test.com"));
        assertFalse("An invalid email was accepted.", Utility.isValidEmail("bonjour"));
    }

    @Test
    public void isValidName() {
        // It should only accept alphabet letters in the form A-Z + a-z
        assertTrue("A valid name was rejected.", Utility.isValidName("Sean"));
        assertTrue("A valid name was rejected.", Utility.isValidName("Name"));
        assertFalse("An invalid name was accepted.", Utility.isValidName("@@!$Bob%"));
        assertFalse("An invalid name was accepted.", Utility.isValidName("b0b"));
    }

    @Test
    public void isValidPassword() {
        // Length is a concern for this only (unless there are more)
        assertTrue("A valid password was rejected.", Utility.isValidPassword("P4ssw0rd"));
        assertFalse("An invalid password was rejected.", Utility.isValidPassword("short"));
    }

    @Test
    public void isValidPhoneNumber() {
        // Numerous formats are specifically accepted.
        assertTrue("A valid phone number was rejected.", Utility.isValidPhoneNumber("613-725-8360"));
        assertTrue("A valid phone number was rejected.", Utility.isValidPhoneNumber("9056507536"));
        assertTrue("A valid phone number was rejected.", Utility.isValidPhoneNumber("(519)-755-2051"));
        // Anything not matching the format should be rejected.
        assertFalse("An invalid phone number was accepted.", Utility.isValidPhoneNumber("bonjour"));
        assertFalse("An invalid phone number was accepted.", Utility.isValidPhoneNumber("416-7504-2049"));
        assertFalse("An invalid phone number was accepted.", Utility.isValidPhoneNumber("416-hola-2049"));
    }

    @Test
    public void isValidAddress() {
        // Only a few formats are accepted
        assertTrue("A valid address street name was rejected", Utility.isValidAddress("Laurier"));
        assertTrue("A valid address street name was rejected", Utility.isValidAddress("Avenue"));
        assertTrue("A valid address street name was rejected", Utility.isValidAddress("Street"));

        // Other formats are rejected
        assertFalse("An invalid address was accepted.", Utility.isValidAddress("500 Laurier Street 75"));
        assertFalse("An invalid address was accepted.", Utility.isValidAddress("500 865 75"));
        assertFalse("An invalid address was accepted.", Utility.isValidAddress("Test Address Here"));
    }
}
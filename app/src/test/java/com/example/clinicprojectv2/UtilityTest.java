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
}
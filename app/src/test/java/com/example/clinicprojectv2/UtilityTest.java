package com.example.clinicprojectv2;

import org.junit.Test;
import static org.junit.Assert.*;

public class UtilityTest {

    @Test
    public void isValidEmail() {
        // It should only accept valid emails
        assertTrue(Utility.isValidEmail("test@test.com"));
        assertFalse(Utility.isValidEmail("bonjour"));
    }

    @Test
    public void isValidName() {
        // It should only accept alphabet letters in the form A-Z + a-z
        assertTrue(Utility.isValidName("Sean"));
        assertTrue(Utility.isValidName("Name"));
        assertFalse(Utility.isValidName("@@!$Bob%"));
        assertFalse(Utility.isValidName("b0b"));
    }

    @Test
    public void isValidPassword() {
        // Length is a concern for this only (unless there are more)
        assertTrue(Utility.isValidPassword("P4ssw0rd"));
        assertFalse(Utility.isValidPassword("short"));
    }
}
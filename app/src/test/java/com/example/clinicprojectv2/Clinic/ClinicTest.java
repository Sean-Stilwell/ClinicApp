package com.example.clinicprojectv2.Clinic;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClinicTest {

    // This class tests some of the main methods found in Clinic.java

    @Test
    public void setIdTest(){
        // This method ensures that a clinic id can be set properly

        // By passing the id in the constructor
        Clinic clinicTest1 = new Clinic("Clinique");
        assertEquals("The clinic id could not be set properly using the constructor", "Clinique", clinicTest1.getId());

        // By changing the id; from default to Clinique
        Clinic clinicTest2 = new Clinic();
        clinicTest2.setId("Clinique");
        assertEquals("The clinic id could not be set properly using the setId() method", "Clinique", clinicTest2.getId());
    }

    @Test
    public void setNameTest(){
        // This method ensures that a clinic name can be set properly

        // From default to Clinique
        Clinic clinicTest1 = new Clinic();
        clinicTest1.setName("Clinique");
        assertEquals("Clinic name could not be set properly", "Clinique", clinicTest1.getName());

        /* Functionality of setName has changed, therefore commenting this test for now */
        /*
        // Trying an invalid name
        Clinic clinicTest2 = new Clinic();
        clinicTest2.setName(null);
        assertEquals("Clinic name could not be set properly", "Unamed", clinicTest2.getName()); */

    }
}

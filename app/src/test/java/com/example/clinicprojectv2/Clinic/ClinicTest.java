package com.example.clinicprojectv2.Clinic;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClinicTest {

    // This class tests some of the main methods found in Clinic.java

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
}

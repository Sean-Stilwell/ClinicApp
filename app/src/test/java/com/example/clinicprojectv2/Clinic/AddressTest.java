package com.example.clinicprojectv2.Clinic;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {

    // This class tests some of the main methods used in Address.java

    @Test
    public void getAddressProvince(){
        // This method ensures that provinces are set properly in an address.

        // Testing an address in Ontario
        Address testAddress = new Address(CanadianProvince.ON, 7, "Street", "Ottawa");
        assertEquals("Province name not set properly", CanadianProvince.ON, testAddress.getProvince());

        // Testing an address in Québec
        Address testAddress2 = new Address(CanadianProvince.QC, 7, "Street", "Ottawa");
        assertEquals("Province name not set properly", CanadianProvince.QC, testAddress2.getProvince());

        // Testing a default address; should be Ontario
        Address testDefaultAddress = new Address();
        assertEquals("Default province name not set properly", CanadianProvince.ON, testDefaultAddress.getProvince());
    }

    @Test
    public void validAddressTest(){
        // This method ensures that the valid address test in the Address.java works properly

        // Testing a valid address
        Address testAddress1 = new Address(CanadianProvince.ON, 7, "Street", "Ottawa");
        boolean testAddress1Success = testAddress1.isValidAddress(testAddress1.getProvince(), testAddress1.getNumber(), testAddress1.getStreetName(), testAddress1.getCity());
        assertTrue("isValidAddress did not recognize a valid address", testAddress1Success);

        // Testing a non-valid address
        try {
            Address testAddress2 = new Address(CanadianProvince.ON, 7, "Street", "Ottawa");
            testAddress2.setStreetName(null);
            boolean testAddress2Success = testAddress2.isValidAddress(testAddress2.getProvince(), testAddress2.getNumber(), testAddress2.getStreetName(), testAddress2.getCity());
            assertFalse("isValidAddress did not recognize a non-valid address", testAddress2Success);
        } catch (Exception e) {
            System.out.println("Non valid address exception caught");
        }

    }

    @Test
    public void getStreetNameTest(){
        // This method ensures that address street names are set properly.

        // Testing first address
        Address testAddress1 = new Address(CanadianProvince.ON, 7, "Street", "Ottawa");
        assertEquals("Street address not set properly", "Street", testAddress1.getStreetName());

        // Testing a default address
        Address testAddress2 = new Address();
        assertEquals("Street address not set properly", "Unamed", testAddress2.getStreetName());

        // Testing a second name address
        Address testAddress3 = new Address(CanadianProvince.ON, 7, "Trial", "Ottawa");
        assertEquals("Street address not set properly", "Trial", testAddress3.getStreetName());
    }

    @Test
    public void setProvinceTest(){
        // This method ensures that an address' province can be manually set properly

        // Testing change from Québec to Ontario
        Address testAddress1 = new Address(CanadianProvince.QC, 7, "Street", "Ottawa");
        testAddress1.setProvince((CanadianProvince.ON));
        assertEquals("Address' Province could not be set properly", CanadianProvince.ON, testAddress1.getProvince());

        // Testing a change from Ontario to Ontario
        Address testAddress2 = new Address();
        testAddress2.setProvince(CanadianProvince.ON);
        assertEquals("Address' province could not manually be set properly", CanadianProvince.ON, testAddress2.getProvince());
    }

    @Test
    public void setNumberTest(){
        // This method ensures that an address' number can be manually set properly

        // Testing change from default to 7
        Address testAddress1 = new Address();
        testAddress1.setNumber(7);
        assertEquals("Address' number could not be set manually successfully", 7, testAddress1.getNumber());

        // Testing change from 17 to 843
        Address testAddress2 = new Address(CanadianProvince.ON, 17, "Street", "Ottawa");
        testAddress2.setNumber(843);
        assertEquals("Address' number could not be set manually successfully", 843, testAddress2.getNumber());
    }
}

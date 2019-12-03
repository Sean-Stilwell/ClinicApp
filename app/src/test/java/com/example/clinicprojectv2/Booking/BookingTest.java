package com.example.clinicprojectv2.Booking;

import org.junit.Test;
import static org.junit.Assert.*;
import com.example.clinicprojectv2.Clinic.Clinic;
import com.example.clinicprojectv2.Clinic.Time;
import com.example.clinicprojectv2.Employee.Employee;
import com.example.clinicprojectv2.Patient.Patient;
import com.example.clinicprojectv2.Service.Service;
import com.example.clinicprojectv2.Service.ServicePerformer;

public class BookingTest {

    /*
     * For the purpose of passing CircleCI tests, this block of variables has to be commented since android textUtils APIs
     * cannot be mocked by CircleCI.
     */
    /* For testing purposes and to avoid code repetition, variables and objects will be instantiated here
        to be used in the following tests*/
    /*
    Clinic testClinic = new Clinic();
    Service testService = new Service("testService", ServicePerformer.STAFF, "testClinicID");
    Patient testPatient = new Patient("Test", "Patient", "testPatient@patient.com", "testpatientID");
    Time testTime = new Time(3, 7);

    // The test booking that will be used to test different aspects of a Booking object
    Booking testBooking = new Booking(testClinic, testService, testPatient, testTime, 2019, 12, 1); */

    /*
     * For the purpose of passing CircleCI tests, this block of tests has to be commented since android textUtils APIs
     * cannot be mocked by CircleCI.
     */
    /*
    @Test
    public void createBookingTest(){ //
        // This method ensures that object types are attributed properly to a booking when it is instantiated
        assertEquals("Wrong clinic attributed to booking.", testBooking.getBookedClinic(), testClinic);
        assertEquals("Wrong service attributed to booking", testBooking.getBookedService(), testService);
        assertEquals("Wrong start time attributed to booking.", testBooking.getStartTime(), testTime);
    }*/

    /*
     * For the purpose of passing CircleCI tests, this block of tests has to be commented since android textUtils APIs
     * cannot be mocked by CircleCI.
     */
    /*
    @Test
    public void setBookingClinicTest(){//
        // This method ensures that the clinic of a booking can be set properly
        Clinic testClinic2 = new Clinic("differentIDTest");
        testBooking.setBookedClinic(testClinic2);
        assertEquals("The clinic of the booking could not be set properly", testBooking.getBookedClinic(), testClinic2);

    }*/

    /*
     * For the purpose of passing CircleCI tests, this block of tests has to be commented since android textUtils APIs
     * cannot be mocked by CircleCI.
     */
    /*
    @Test
    public void setEmployeeTest(){//
        // This method ensures that employees for a booking are set properly
        Employee testEmployee =  new Employee("test", "employee", "testemployee@employee.com", "testEmployeeID");
        testBooking.setBookedEmployee(testEmployee);
        assertEquals("Employee for the booking was not set properly.",testBooking.getBookedEmployee(), testEmployee);

        Employee testEmployee2 = new Employee("test2", "employee", "testemployee2@employee.com", "testEmployeeID");
        testBooking.setBookedEmployee(testEmployee2);
        assertEquals("Employee for the booking was not set properly", testBooking.getBookedEmployee(), testEmployee2);
    }*/

    /*
     * For the purpose of passing CircleCI tests, this block of tests has to be commented since android textUtils APIs
     * cannot be mocked by CircleCI.
     */
    /*
    @Test
    public void setBookedServiceTest(){//
        // This method ensures that services are set properly for a booking
        Service testService2 = new Service("TestService", ServicePerformer.NURSE, "testServiceID");
        testBooking.setBookedService(testService2);
        assertEquals("The service for the booking was not set properly", testBooking.getBookedService(), testService2);

        Service testService3 = new Service("TestService3", ServicePerformer.DOCTOR, "testService3ID");
        testBooking.setBookedService(testService3);
        assertEquals("The service for the booking was not set properly", testBooking.getBookedService(), testService3);
    }*/

    /*
     * For the purpose of passing CircleCI tests, this block of tests has to be commented since android textUtils APIs
     * cannot be mocked by CircleCI.
     */
    /*
    @Test
    public void setStartTimeTest(){//
        // This method ensures that start times for a booking are set properly

        // First test with an object of type Time
        Time testTime2 = new Time(3, 21);
        testBooking.setStartTime(testTime2);
        assertEquals("Start time for the booking was not set properly", testBooking.getStartTime(), testTime2);

        // Second test using hour and minute as parameters
        Time testTime3 = new Time(4, 52);
        testBooking.setStartTime(4, 52);
        assertEquals("Start time for the booking was not set properly", testBooking.getStartTime(), testTime3);
    }*/
}

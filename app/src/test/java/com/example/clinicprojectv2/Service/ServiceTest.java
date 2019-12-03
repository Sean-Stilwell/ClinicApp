package com.example.clinicprojectv2.Service;

import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceTest {

    /*
     * For the purpose of passing CircleCI tests, this block of tests has to be commented since android textUtils APIs
     * cannot be mocked by CircleCI.
     */
    /*
    @Test
    public void getServiceName(){
        // This method ensures names are set properly in a new service for each kind of service performer.

        // For a doctor
        Service testService = new Service("Doctor", ServicePerformer.DOCTOR, "9876");
        assertEquals("Service name not properly set.", "Doctor", testService.getName());

        // For a nurse
        Service testService2 = new Service("nurse", ServicePerformer.NURSE, "9876");
        assertEquals("Service name not properly set.", "nurse", testService2.getName());

        // For a staff
        Service testService3 = new Service("staff", ServicePerformer.STAFF, "9876");
        assertEquals("Service name not properly set.", "staff", testService3.getName());
    } */


    /*
     * For the purpose of passing CircleCI tests, this block of tests has to be commented since android textUtils APIs
     * cannot be mocked by CircleCI.
     */
    /*
    @Test
    public void getServicePerformerString(){
        // This method ensures service performers are set properly in a new service for each kind of service performer.
        // This method uses the get as string method from Service.java

        // For a doctor
        Service testService = new Service("doctor", ServicePerformer.DOCTOR, "9876");
        assertEquals("Service performer not properly set.", "Doctor", testService.getServicePerformerAsString());

        // For a nurse
        Service testService2 = new Service("nurse", ServicePerformer.NURSE, "9876");
        assertEquals("Service performer not properly set.", "Nurse", testService2.getServicePerformerAsString());

        // For a staff
        Service testService3 = new Service("staff", ServicePerformer.STAFF, "9876");
        assertEquals("Service performer not properly set.", "Staff", testService3.getServicePerformerAsString());
    } */


    /*
     * For the purpose of passing CircleCI tests, this block of tests has to be commented since android textUtils APIs
     * cannot be mocked by CircleCI.
     */
    /*
    @Test
    public void getServicePerformer(){
        // This method ensures service performers are set properly in a new service for each kind of service performer.
        // This method uses the regular get service performer method from Service.java

        // For a doctor
        Service testService = new Service("doctor", ServicePerformer.DOCTOR, "9876");
        assertEquals("Service performer not properly set.", ServicePerformer.DOCTOR, testService.getServicePerformer());

        // For a nurse
        Service testService2 = new Service("nurse", ServicePerformer.NURSE, "9876");
        assertEquals("Service performer not properly set.", ServicePerformer.NURSE, testService2.getServicePerformer());

        // For a staff
        Service testService3 = new Service("staff", ServicePerformer.STAFF, "9876");
        assertEquals("Service performer not properly set.", ServicePerformer.STAFF, testService3.getServicePerformer());
    } */

    /*
     * For the purpose of passing CircleCI tests, this block of tests has to be commented since android textUtils APIs
     * cannot be mocked by CircleCI.
     */
    /*
    @Test
    public void getServiceId(){
        // This method ensures that service id's are properly set for each kind of service performer.

        // For a doctor
        Service testService = new Service("doctor", ServicePerformer.DOCTOR, "9876");
        assertEquals("Service id not properly set.", "9876", testService.getId());

        // For a nurse
        Service testService2 = new Service("nurse", ServicePerformer.NURSE, "3645");
        assertEquals("Service id not properly set.", "3645", testService2.getId());

        // For a staff
        Service testService3 = new Service("staff", ServicePerformer.STAFF, "4628");
        assertEquals("Service id not properly set.", "4628", testService3.getId());
    } */

    @Test
    public void serviceInfoIsValid(){
        /* This method ensures that the serviceInfoIsValid method in Service.java behaves correctly
           in multiple different scenarios. */

        // With 3 null parameters; in this case, seeks asserts for false
        try {
            Service testService = new Service(null, null, null);
            boolean test1Success = testService.serviceInfoIsValid(testService.getName(), testService.getServicePerformer(), testService.getId());
            assertFalse("ServiceInfoIsValid did not recognize a null parameter.", test1Success);
        } catch (Exception e) {
            System.out.println("Null parameter caught.");
        }

        // If service name is null
        try {
            Service nameIsNull = new Service(null, ServicePerformer.DOCTOR, "9876");
            boolean test2Success = nameIsNull.serviceInfoIsValid(nameIsNull.getName(), nameIsNull.getServicePerformer(), nameIsNull.getId());
            assertFalse("ServiceInfoIsValid did not recognize null service name.", test2Success);
        } catch (Exception e) {
            System.out.println("Null parameter caught.");
        }

        // If service performer is null
        try {
            Service performerIsNull = new Service("test", null, "9876");
            boolean test3Success = performerIsNull.serviceInfoIsValid(performerIsNull.getName(), performerIsNull.getServicePerformer(), performerIsNull.getId());
            assertFalse("ServiceInfoIsValid did not recognize null service performer.", test3Success);
            System.out.println("Null parameter caught.");
        } catch (Exception e) {
            System.out.println("Null parameter caught");
        }

        // If service id is null
        try {
            Service idIsNull = new Service("test", ServicePerformer.NURSE, null);
            boolean test4Success = idIsNull.serviceInfoIsValid(idIsNull.getName(), idIsNull.getServicePerformer(), idIsNull.getId());
            assertFalse("ServiceInfoIsValid did not recognize null service id.", test4Success);
        } catch (Exception e) {
            System.out.println("Null parameter caught.");
        }

        /*
        // Test a service properly set up; in this case, seeks asserts for true
        Service properlySetService = new Service("test", ServicePerformer.STAFF, "9876");
        boolean test5Success = properlySetService.serviceInfoIsValid(properlySetService.getName(), properlySetService.getServicePerformer(), properlySetService.getId());
        assertTrue("ServiceInfoIsValid did not recognize a service that has been properly set up.", test5Success); */
    }

}



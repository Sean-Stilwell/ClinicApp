package com.example.clinicprojectv2.Booking;

import com.example.clinicprojectv2.Clinic.Clinic;
import com.example.clinicprojectv2.Clinic.Time;
import com.example.clinicprojectv2.Employee.Employee;
import com.example.clinicprojectv2.Patient.Patient;
import com.example.clinicprojectv2.Service.Service;

import java.io.Serializable;

public class Booking implements Serializable {
    private Clinic bookedClinic;
    private Service bookedService;
    private Employee bookedEmployee;
    private Time startTime;
    private Time endTime;
    private String identifierString;
    private int identifier;
    private String date;

    public Booking(Clinic clinic, Service service, Patient patient, Time time, int year, int month, int day){
        // Verifying that no null parameters were given.
        if (clinic == null || service == null || time == null){
            throw new NullPointerException();
        }

        // Setting the instance variables accordingly.
        bookedClinic = clinic;
        bookedService = service;
        startTime = time;
        setEndTime();
        identifierString = Integer.toString(month) + Integer.toString(day) + Integer.toString(time.getHour()) + Integer.toString(time.getMinute());
        date = Integer.toString(day) + "/" + Integer.toString(month) + "/" + Integer.toString(year);
        identifier = Integer.parseInt(identifierString);

         //Adding the booking to the clinic / patient lists.

        patient.addBooking(this);
        clinic.addBooking(this);
    }

    // getters for instance variables
    public Clinic getBookedClinic(){
        return this.bookedClinic;
    }
    public Service getBookedService(){
        return this.bookedService;
    }
    public Employee getBookedEmployee(){
        return this.bookedEmployee;
    }
    public Time getStartTime(){
        return this.startTime;
    }
    public Time getEndTime(){
        return this.endTime;
    }
    public int getIdentifier(){return this.identifier;}
    public String getDate(){return this.date;}

    //To string method for displaying a booking
    public String toString(){
        String returnString = bookedService.getName() + " - " + bookedService.getId() +
                "\n scheduled for " + getDate() + " at " + Integer.toString(getStartTime().getHour())
                +"h"+Integer.toString(getStartTime().getMinute()) + "\n \n";
        return returnString;
    }

    //setters for instance variables - allows a booking to be modified
    public void setBookedClinic(Clinic clinic){
        if (clinic == null){
            throw new NullPointerException();
        }
        else{
            this.bookedClinic = clinic;
        }
    }
    public void setBookedEmployee(Employee emp){
        if (emp == null){
            throw new NullPointerException();
        }
        else{
            this.bookedEmployee = emp;
        }
    }
    public void setBookedService(Service service){
        if (service == null){
            throw new NullPointerException();
        }
        else{
            this.bookedService = service;
        }
    }
    public void setStartTime(Time time){
        if (time == null){
            throw new NullPointerException();
        }
        else {
            startTime = time;
            setEndTime();
        }
    }
    public void setStartTime(int hour, int minute){
        startTime = new Time(hour,minute);
        setEndTime();
    }
    public void setEndTime(){
        // Ensuring a valid endtime is given, 15 minutes after start time.
        if (startTime.getMinute() >= 45) {
            endTime = new Time(startTime.getHour() + 1, startTime.getMinute() + 15 - 60);
        } else {
            endTime = new Time(startTime.getHour(), startTime.getMinute() + 15);
        }
    }
}

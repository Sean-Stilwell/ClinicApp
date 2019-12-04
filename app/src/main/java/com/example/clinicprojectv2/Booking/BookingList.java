package com.example.clinicprojectv2.Booking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BookingList implements Serializable {
    private Booking[] bookings;

    /**
     * Constructor, creates a list of bookings
     * @param size - the maximum size of a booking (varies based on clinic/employee)
     */
    public BookingList(int size){ bookings = new Booking[size]; }

    /**
     * Method to add a booking to a clinic/patient's list.
     * @param booking - the booking to be added
     */
    public void addBooking(Booking booking){
        int i = 0;
        while (bookings[i] != null){
            i++;
        }
        bookings[i] = booking;
    }

    /**
     * Method to remove a booking from the list.
     * @param booking - the booking to be removed
     */
    public void removeBooking(Booking booking){
        int i = 0;
        while (bookings[i] != booking){
            i++;
        }
        while (i < bookings.length && bookings[i] != null){
            bookings[i] = bookings[i+1];
            i++;
        }
    }

    /**
     * Method to find whether a time is booked for a clinic or patient.
     * Note: the identifier is month + date + time, so it should be unique for each booking.
     * If the identifier is found, then that means the time slot is taken.
     * @param identifier - a representation of the exact date and time of the booking
     * @return
     */
    public boolean findBooking(int identifier){
        for (Booking b : bookings){
            if (b.getIdentifier() == identifier){
                return true;
            }
        }
        return false;
    }

    /**
     * Method to get a string representation of the bookings, for use on the view bookings page
     * @return a representation of all the bookings in a list.
     */
    public String getList(){
        String returnString = "";
        for (Booking b : bookings){
            if (b != null) {
                returnString = returnString + b.toString();
            }
        }
        return returnString;
    }

    public List<String> getBookingsAsStrings() {

        List<String> list = new ArrayList<>();

        for (Booking b : bookings) {
            if (b != null) {
                list.add(b.toString());
            }
        }
        return list;
    }


    /**
     * Method to determine the size of a bookings list.
     * @return the size of the list
     */
    public int getSize(){
        int i = 1;
        while (bookings[i] != null){
            i++;
        }
        return i;
    }

    /**
     * Method to determine if the booking list is empty
     * @return boolean showing whether the list is empty.
     */
    public boolean isEmpty(){
        return bookings[0] == null;
    }
}

package com.example.clinicprojectv2.Booking;

import java.util.LinkedList;
import java.util.ListIterator;

public class BookingList {
    private LinkedList<Booking> bookings;

    // Constructor
    public BookingList(){
        bookings = new LinkedList();
    }

    // Method to add a booking.
    public void addBooking(Booking booking){
        bookings.addLast(booking);
    }

    // Method to remove a booking, if it's cancelled or if it's in the past.
    public void removeBooking(Booking booking){
        bookings.remove(booking);
    }

    // Method to see if an idetinifier is present in the list.
    public boolean findBooking(int identifier){
        for (Booking b : bookings){
            if (b.getIdentifier() == identifier){
                return true;
            }
        }
        return false;
    }

    public String getList(){
        String returnString = "";
        for (Booking b : bookings){
            returnString = returnString + b.toString();
        }
        return returnString;
    }
}

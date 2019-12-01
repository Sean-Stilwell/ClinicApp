package com.example.clinicprojectv2.Booking;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.ListIterator;

public class BookingList implements Serializable {
    private Booking[] bookings;

    // Constructor
    public BookingList(int size){
        bookings = new Booking[size];
    }

    // Method to add a booking.
    public void addBooking(Booking booking){
        int i = 0;
        while (bookings[i] != null){
            i++;
        }
        bookings[i] = booking;
    }

    // Method to remove a booking, if it's cancelled or if it's in the past.
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

    public int getSize(){
        int i = 1;
        while (bookings[i] != null){
            i++;
        }
        return i;
    }

    public boolean isEmpty(){
        return bookings[0] == null;
    }
}

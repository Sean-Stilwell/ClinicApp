package com.example.clinicprojectv2.Patient;
import com.example.clinicprojectv2.Account.Account;
import com.example.clinicprojectv2.Account.AccountType;
import com.example.clinicprojectv2.Booking.Booking;
import com.example.clinicprojectv2.Booking.BookingList;

public class Patient extends Account {

    private static final AccountType type = AccountType.PATIENT;
    //private BookingList bookings;

    /**
     * This method constructs an instance of an employee account.
     *
     * @param firstName the first name of the employee
     * @param lastName  the last name of the employee
     * @param email     the email of the employee
     */
    public Patient(String firstName, String lastName, String email, String id) {
        super(firstName,lastName,email,type,id);
        //bookings = new BookingList();
    }

    public Patient(){
        super();
        //bookings = new BookingList();
    }

//    public void addBooking(Booking booking){
//        bookings.addBooking(booking);
//    }
//    public void removeBooking(Booking booking){
//        bookings.removeBooking(booking);
//    }
//    public BookingList getBookings(){
//        return bookings;
//    }
}
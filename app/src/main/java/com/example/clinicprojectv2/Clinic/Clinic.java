package com.example.clinicprojectv2.Clinic;

import com.example.clinicprojectv2.Booking.Booking;
import com.example.clinicprojectv2.Booking.BookingList;
import com.example.clinicprojectv2.Service.Service;
import com.example.clinicprojectv2.Utility;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Clinic implements Serializable {

    public static final String[] PAYMENTMETHODS = {"Credit", "Cash", "Debit"};

    public static final String DEFAULTNAME = "Unamed";
    public static final String DEFAULTPHONE = "1111111111";

    public static final String[] PROVINCES = {  Address.NL, Address.PE,
                                                Address.NS, Address.NB,
                                                Address.QC, Address.ON,
                                                Address.MB, Address.SK,
                                                Address.AB, Address.BC,
                                                Address.YT, Address.NT,
                                                Address.NU };


    private String id;
    private String name;
    private Address address;
    private WorkWeek workWeek;
    private String phoneNumber;
    private List<String> insurances;
    private List<Service> linksToServices;
    private List<PaymentMethod> paymentMethods;



    //private BookingList bookings;


    public Clinic(String id){
        this();

        if(id!=null){
            this.id=id;
        }
    }

    public Clinic(){
        this.name = DEFAULTNAME;
        this.phoneNumber = DEFAULTPHONE;
        this.workWeek = new WorkWeek();
        this.address = new Address();
        this.insurances = new ArrayList<String>();
        this.paymentMethods = new ArrayList<PaymentMethod>();
        this.linksToServices = new ArrayList<Service>();

        //this.bookings = new BookingList();

    }


    public static CanadianProvince provinceFromPosition(int pos){

        switch(pos){
            case 0:
                return CanadianProvince.NL;
            case 1:
                return CanadianProvince.PE;
            case 2:
                return CanadianProvince.NS;
            case 3:
                return CanadianProvince.NB;
            case 4:
                return CanadianProvince.QC;
            case 5:
                return CanadianProvince.ON;
            case 6:
                return CanadianProvince.MB;
            case 7:
                return CanadianProvince.SK;
            case 8:
                return CanadianProvince.AB;
            case 9:
                return CanadianProvince.BC;
            case 10:
                return CanadianProvince.YT;
            case 11:
                return CanadianProvince.NT;
            case 12:
                return CanadianProvince.NU;
            default:
                return CanadianProvince.NU;
        }
    }

    public static List<PaymentMethod> paymentMethsAsEnumFromStringList(List<String> pay){

        List<PaymentMethod> tmp = new ArrayList<>();

        for(String e :pay){
            tmp.add(getPaymentEnumFromString(e));
        }
        return tmp;
    }




    public static PaymentMethod getPaymentEnumFromString(String payment){
        switch (payment){

            case "Credit":

                return PaymentMethod.CREDIT;

            case "Cash":
                return PaymentMethod.CASH;

            case "Debit":

                return PaymentMethod.DEBIT;

            default:
                return PaymentMethod.CREDIT;
        }
    }


    public static int positionFromProvince(String province){

        switch(province){
            case Address.NL:
                return 0;
            case Address.PE:
                return 1;
            case Address.NS:
                return 2;
            case Address.NB:
                return 3;
            case Address.QC:
                return 4;
            case Address.ON:
                return 5;
            case Address.MB:
                return 6;
            case Address.SK:
                return 7;
            case Address.AB:
                return 8;
            case Address.BC:
                return 9;
            case Address.YT:
                return 10;
            case Address.NT:
                return 11;
            case Address.NU:
                return 12;
            default:
                throw new IllegalStateException("Missing something.");
        }

    }



    public String getProvinceAsString(){
        return address.getProvinceAsString();
    }

    public String getName(){
        return this.name;
    }

    public Address getAddress(){
        return this.address;
    }

    public int getAddressNumber(){
        return this.address.getNumber();
    }

    public String getAddressCity(){
        return this.address.getCity();
    }

    public String getAddressStreet(){
        return this.address.getStreetName();
    }

    public CanadianProvince getAddressProvince(){
        return this.address.getProvince();
    }


    public String getPhoneNumber(){

        return this.phoneNumber;
    }

    public List<String> getInsurances(){
        return this.insurances;
    }

    public List<Service> getLinksToServicesAsString(){


        ////////////////////////////

        return null;


        ////////////////////////////


    }


    public List<Service> getLinksToServices(){
        return this.linksToServices;
    }

    public boolean hasLinkToService(Service service){
        if(service == null){
            throw new NullPointerException();
        }
        return linksToServices.contains(service);
    }

    public boolean isClosedOn(Day day){
        return this.workWeek.isClosedOn(day);
    }

    public Time getEndTimeFor(Day day){
        return this.workWeek.getEndTimeFor(day);
    }

    public Time getStartTimeFor(Day day){
        return this.workWeek.getStartTimeFor(day);
    }

    public List<Workday> getWorkdays(){
        return this.workWeek.getWorkdays();
    }

    public WorkWeek getWorkWeek(){
        return this.workWeek;
    }

    public List<PaymentMethod> getPaymentMethods(){
        return this.paymentMethods;
    }

    public List<String> getPaymentMethodsAsString(){
        List<String> tmp = new ArrayList<>();
        for(PaymentMethod e : getPaymentMethods()){
            if(e==PaymentMethod.CASH){
                tmp.add(PAYMENTMETHODS[1]);
            } else if(e==PaymentMethod.CREDIT){
                tmp.add(PAYMENTMETHODS[0]);
            } else {
                tmp.add(PAYMENTMETHODS[2]);
            }
        }
        return tmp;
    }

    public String getId(){
        return this.id;
    }


    public void setId(String newId){
        if(newId == null){
            throw new NullPointerException();
        }
        this.id = newId;
    }

    public void setName(String name){
        if(!Utility.isValidName(name)){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public void setProvince(CanadianProvince province){
        this.address.setProvince(province);
    }

    public void setCity(String city){
        this.address.setCity(city);
    }

    public void setNumber(int number){
        this.address.setNumber(number);
    }

    public void setStreetName(String newName){
        this.address.setStreetName(newName);
    }

    public void setPhoneNumber(String phone){

        if(!Utility.isValidPhoneNumber(phone)){
            throw new IllegalArgumentException();
        }
        this.phoneNumber = phone;
    }

    public void setStartTimeFor(Day day, Time newStartTime){
        this.workWeek.setStartTimeFor(day, newStartTime);
    }

    public void setEndTimeFor(Day day, Time newEndTime){
        this.workWeek.setEndTimeFor(day, newEndTime);
    }

    public void setClosedOn(Day day){
        this.workWeek.setClosedOn(day);
    }

    public void setOpenOn(Day day){
        this.workWeek.setOpenOn(day);
    }

    public void addInsurance(String insurance){
        if(insurance == null){
            throw new NullPointerException();
        }
        if(!this.getInsurances().contains(insurance)){
            this.getInsurances().add(insurance);
        }
    }
    public void removeInsurance(String insurance){
        if(insurance == null){
            throw new NullPointerException();
        }
        if(!this.getInsurances().contains(insurance)){
            throw new IllegalStateException();
        }
        this.getInsurances().remove(insurance);
    }

    public void removeLinkToService(Service service){
        if(service == null){
            throw new NullPointerException();
        }
        if(!linksToServices.contains(service)){
            throw new IllegalStateException();
        }
        this.linksToServices.remove(service);
    }

    public void addLinkToService(Service service){
        if(service == null){
            throw new NullPointerException();
        }
        if(!linksToServices.contains(service)){
            linksToServices.add(service);
        }
    }

    public void addPaymentMethod(PaymentMethod newPayMet){
        if(newPayMet == null){
            throw new NullPointerException();
        }
        if(!this.getPaymentMethods().contains(newPayMet)){
            this.getPaymentMethods().add(newPayMet);
        }
    }

    public void removePaymentMethod(PaymentMethod newPayMet){

        if(newPayMet == null){
            throw new NullPointerException();
        }
        if(!this.getPaymentMethods().contains(newPayMet)){
            throw new IllegalStateException();
        }
        this.getPaymentMethods().remove(newPayMet);
    }



    public void removeAllServicesAndSetTo(List<Service> newServices){

        if(newServices == null){
            throw new NullPointerException();
        }
        if(hasDuplicateServices(newServices)){
            throw new IllegalArgumentException();
        }

        this.linksToServices = newServices;
    }

    private static boolean hasDuplicateServices(List<Service> services){

        for (Service e: services) {
            int count = Collections.frequency(services, e);

            if(count>1){
                return true;
            }
        }
        return false;
    }


    public void removeAllPaymentMetAndSetTo(List<PaymentMethod> payMets){

        if(payMets == null){
            throw new NullPointerException();
        }
        if(hasDuplicatePayMets(payMets)){
            throw new IllegalArgumentException();
        }
        this.paymentMethods = payMets;
    }

    private static boolean hasDuplicatePayMets(List<PaymentMethod> payMets){

        for (PaymentMethod e: payMets) {
            int count = Collections.frequency(payMets, e);

            if(count>1){
                return true;
            }
        }
        return false;
    }


    public void removeInsurancesAndSetTo(List<String> insurances){

        if(insurances == null){
            throw new NullPointerException();
        }
        if(hasDuplicateInsurances(insurances)){
            throw new IllegalArgumentException();
        }
        this.insurances = insurances;
    }


    private static boolean hasDuplicateInsurances(List<String> insurances){
        for (String e: insurances) {
            int count = Collections.frequency(insurances, e);

            if(count>1){
                return true;
            }
        }
        return false;
    }

    //    public void addBooking(Booking booking){
    //        bookings.addBooking(booking);
    //    }

    //    public void removeBooking(Booking booking){
    //        bookings.removeBooking(booking);
    //    }

//    public void addBooking(Booking booking){
//        bookings.addBooking(booking);
//    }
//    public void removeBooking(Booking booking){
//        bookings.removeBooking(booking);
//    }

}


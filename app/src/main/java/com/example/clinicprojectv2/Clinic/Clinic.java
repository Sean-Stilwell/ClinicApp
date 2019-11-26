package com.example.clinicprojectv2.Clinic;

import com.example.clinicprojectv2.Service.Service;
import com.example.clinicprojectv2.Utility;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Clinic implements Serializable {

    public static final String DEFAULTNAME = "Unamed";
    public static final String DEFAULTPHONE = "1111111111";
    public static final String[] PROVINCES = {Address.NL, Address.PE,
                                                Address.NS, Address.NB,
                                                Address.QC, Address.ON,
                                                Address.MB, Address.SK,
                                                Address.AB, Address.BC,
                                                Address.YT, Address.NT,
                                                Address.NU};

    public static final String[] ALLPAYMENTMETHODS = {"CASH","DEBIT","CREDIT"} ;


    private String id;
    private String name;
    private Address address;
    private WorkWeek workWeek;
    private String phoneNumber;
    private List<String> insurances;
    private List<Service> linksToServices;
    private List<PaymentMethod> paymentMethods;


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
}


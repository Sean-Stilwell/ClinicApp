package com.example.clinicprojectv2.Clinic;

import com.example.clinicprojectv2.Utility;

public class Address {

    public static final CanadianProvince DEFAULTPROVINCE = CanadianProvince.ON;
    public static final int DEFAULTNUMBER = 100;
    public static final String DEFAULTSTREET = "Unamed";
    public static final String DEFAULTCITY = "Unamed";

    public static final String NL = "NL";
    public static final String PE = "PE";
    public static final String NS = "NS";
    public static final String NB = "NB";
    public static final String QC = "QC";
    public static final String ON = "ON";
    public static final String MB = "MB";
    public static final String SK = "SK";
    public static final String AB = "AB";
    public static final String BC = "BC";
    public static final String YT = "YT";
    public static final String NT = "NT";
    public static final String NU = "NU";


    private CanadianProvince province;
    private int number;
    private String streetName;
    private String city;


    public Address(CanadianProvince province, int number,String street, String city){

        if(!isValidAddress(province, number, street,city)){
            throw new IllegalArgumentException("Bad arguments address.");
        }
        this.province = province;
        this.number = number;
        this.streetName = street;
        this.city = city;
    }

    public Address(){ // Empty Constructor necessary for serialization.

        this.province = DEFAULTPROVINCE;
        this.number = DEFAULTNUMBER;
        this.streetName = DEFAULTSTREET;
        this.city = DEFAULTCITY;
    }


    public static boolean isValidAddress(CanadianProvince province, int number,String street, String city){

        if(province==null||street==null||city==null){
            return false;
        } else if (!Utility.isValidAddress(street)){
            return false;
        } else if (!Utility.isValidAddress(city)){
            return false;
        } else{
            return true;
        }
    }

    public CanadianProvince getProvince(){
        return this.getProvinceAsEnum();
    }

    public CanadianProvince getProvinceAsEnum(){
        return this.province;
    }

    public String getProvinceAsString(){

        switch(this.province){
            case NL:
                return NL;
            case PE:
                return PE;
            case NS:
                return NS;
            case NB:
                return NB;
            case QC:
                return QC;
            case ON:
                return ON;
            case MB:
                return MB;
            case SK:
                return SK;
            case AB:
                return AB;
            case BC:
                return BC;
            case YT:
                return YT;
            case NT:
                return NT;
            case NU:
                return NU;
            default:
                throw new IllegalStateException("Missing something.");
        }
    }

    public int getNumber(){
        return this.number;
    }

    public String getStreetName(){
        return this.streetName;
    }

    public String getCity(){
        return this.city;
    }


    public void setProvince(CanadianProvince province){

        if(province==null){
            throw new IllegalArgumentException("No good.");
        }
        this.province = province;
    }

    public void setCity(String city){

        if(!Utility.isValidAddress(city)){
            throw new IllegalArgumentException("No good.");
        }
        this.city = city;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public void setStreetName(String newName){

        if(!Utility.isValidAddress(newName)){
            throw new IllegalArgumentException("No good.");
        }
        this.streetName = newName;
    }
}

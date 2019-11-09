package com.example.clinicprojectv2.Service;
import com.example.clinicprojectv2.Utility;


public class Service {

    public static final String NURSE = "Nurse";
    public static final String DOCTOR = "Doctor";
    public static final String STAFF = "Staff";

    private String name;
    private ServicePerformer servicePerformer;
    private String id;

    public Service(String name, ServicePerformer servicePerformer, String id){

        if(!(this.serviceInfoIsValid(name, servicePerformer, id))){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.servicePerformer = servicePerformer;
        this.id = id;
    }

    public Service(){

    }

    public String getServicePerformerAsString(){

        switch (this.getServicePerformer()) {
            case NURSE:
                return NURSE;
            case DOCTOR:
                return DOCTOR;
            case STAFF:
                return STAFF;
            default:
                throw new IllegalArgumentException();
        }
    }

    public String getName(){
        return this.name;
    }

    public ServicePerformer getServicePerformer(){
        return this.servicePerformer;
    }

    public String getId(){
        return this.id;
    }

    public boolean serviceInfoIsValid(String name, ServicePerformer servicePerformer, String id){
        if(name == null || servicePerformer == null || id == null){
            return false;
        } else if (!(Utility.isValidServiceName(name))){
            return false;
        } else{
            return true;
        }
    }
}
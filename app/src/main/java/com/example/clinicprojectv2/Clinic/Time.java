package com.example.clinicprojectv2.Clinic;

public class Time {

    private int hour;
    private int minute;

    public Time(int hour, int minute){

        if(!isValidInput(hour,minute)){
            throw new IllegalArgumentException();
        }

        this.hour = hour;
        this.minute = minute;
    }

    public Time(){ // Empty Constructor necessary for serialization.

    }

    public int getHour(){
        return this.hour;
    }

    public int getMinute(){
        return this.minute;
    }

    public static boolean isValidInput(int hour, int minute){
        return (hour>=0&&hour<=24)&&(minute>=0 && minute <=59);
    }
}

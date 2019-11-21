package com.example.clinicprojectv2.Clinic;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class WorkWeek implements Serializable {

    private List<Workday> workdays;

    public WorkWeek(){
        this.initalizeWorkdays();
    }

    private void initalizeWorkdays(){

        this.workdays = new ArrayList<Workday>();

        workdays.add(new Workday(Day.MONDAY));
        workdays.add(new Workday(Day.TUESDAY));
        workdays.add(new Workday(Day.WEDNESDAY));
        workdays.add(new Workday(Day.THURSDAY));
        workdays.add(new Workday(Day.FRIDAY));
        workdays.add(new Workday(Day.SATURDAY));
        workdays.add(new Workday(Day.SUNDAY));
    }

    public List<Workday> getWorkdays(){

        return this.workdays;
    }

    public Time getStartTimeFor(Day day){
        if(day == null){
            throw new NullPointerException();
        }
        Time toReturn = null;
        for(Workday currDay : workdays){
            if (currDay.getWeekdayAsEnumType().equals(day)){
                toReturn = currDay.getStartTime();
            }
        }
        return toReturn;
    }

    public Time getEndTimeFor(Day day){
        if(day == null){
            throw new NullPointerException();
        }
        Time toReturn = null;
        for(Workday currDay : workdays){
            if (currDay.getWeekdayAsEnumType().equals(day)){
                toReturn = currDay.getEndTime();
            }
        }
        return toReturn;
    }

    public void setStartTimeFor(Day day, Time newStartTime){
        if(day == null){
            throw new NullPointerException();
        }
        for(Workday currDay : workdays){
            if (currDay.getWeekdayAsEnumType().equals(day)){
                currDay.setStartTime(newStartTime);
            }
        }
    }

    public void setEndTimeFor(Day day, Time newEndTime){
        if(day == null){
            throw new NullPointerException();
        }
        for(Workday currDay : workdays){
            if (currDay.getWeekdayAsEnumType().equals(day)){
                currDay.setEndTime(newEndTime);
            }
        }
    }

    public boolean isClosedOn(Day day){

        if(day == null){
            throw new NullPointerException();
        }

        boolean toReturn = false;

        for(Workday currDay : workdays){
            if (currDay.getWeekdayAsEnumType().equals(day)){
                toReturn = currDay.isClosed();
            }
        }
        return toReturn;
    }

    public void setClosedOn(Day day){
        if(day == null){
            throw new NullPointerException();
        }

        for(Workday currDay : workdays){
            if (currDay.getWeekdayAsEnumType().equals(day)){
                currDay.setClosed();
            }
        }
    }

    public void setOpenOn(Day day){
        if(day == null){
            throw new NullPointerException();
        }

        for(Workday currDay : workdays){
            if (currDay.getWeekdayAsEnumType().equals(day)){
                currDay.setOpen();
            }
        }
    }
}

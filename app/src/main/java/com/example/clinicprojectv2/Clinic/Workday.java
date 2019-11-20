package com.example.clinicprojectv2.Clinic;

public class Workday {

    private Day dayOfTheWeek;
    private Time startTime;
    private Time endTime;
    private boolean isClosed;

    /**
     * Constructor for the Workday object.
     * @param weekday The weekday as enumerated above (Monday through Sunday).
     * @param startTime Opening time for the current workday.
     * @param endTime Closing time for the current workday.
     * @param isClosed True if the clinic is closed on the current workday.
     */
    public Workday(Day weekday, Time startTime, Time endTime, boolean isClosed) {

        if(!isValidInput(weekday, startTime, endTime)){
            throw new IllegalArgumentException("No good.");
        }
        this.dayOfTheWeek = weekday;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isClosed = isClosed;
    }

    public Workday(Day weekday){

        if(weekday==null){
            throw new NullPointerException();
        }

        dayOfTheWeek = weekday;
        this.startTime = getDefaultStartTime();
        this.endTime = getDefaultEndTime();
        this.isClosed = false;
    }

    public Workday(){ // Empty Constructor necessary for serialization.

    }

    private static boolean isValidInput(Day weekday, Time startTime, Time endTime){

        if(weekday==null||startTime==null||endTime==null){
            return false;

        } else if (!isValidWorkingHours(startTime,endTime)){
            return false;

        } else {
            return true;
        }
    }

    /**
     * Checks if the specified closing time is after opening time.
     * @param startTime Opening time for the current workday.
     * @param endTime Closing time for the current workday.
     * @return True if the closing time is after opening time.
     */
    private static boolean isValidWorkingHours(Time startTime, Time endTime) {
        //if (startTime.compareTo(endTime) > 0) return true;
        //return false;

        //TODO: REIMPLEMENT

        return true;
    }

    // Getters

    public int getWeekdayAsInt(){
        switch(this.dayOfTheWeek){
            case MONDAY:
                return 0;
            case TUESDAY:
                return 1;
            case WEDNESDAY:
                return 2;
            case THURSDAY:
                return 3;
            case FRIDAY:
                return 4;
            case SATURDAY:
                return 5;
            case SUNDAY:
                return 6;
            default:
                throw new IllegalStateException("Missing something.");
        }
    }

    public Day getWeekdayAsEnumType() {
        return this.dayOfTheWeek;
    }

    public Time getStartTime() {
        return this.startTime;
    }

    public Time getEndTime() {
        return this.endTime;
    }

    public boolean isClosed() {
        return this.isClosed;
    }

    public Day getDayOfTheWeek(){
        return this.dayOfTheWeek;
    }


    public void setStartTime(Time newStartTime){

        if(newStartTime==null){
            throw new IllegalArgumentException();
        }

        this.startTime = newStartTime;
    }

    public void setEndTime(Time newEndTime){
        if(newEndTime==null){
            throw new IllegalArgumentException();
        }
        this.endTime = newEndTime;
    }

    public void setClosed(){
        this.isClosed = true;
    }

    public void setOpen(){
        this.isClosed = false;
    }


    public static Time getDefaultStartTime(){
        return new Time(9,0);
    }

    public static Time getDefaultEndTime(){
        return new Time(9,0);
    }
}

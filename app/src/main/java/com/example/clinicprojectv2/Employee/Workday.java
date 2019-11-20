package com.example.clinicprojectv2.Employee;

import java.time.LocalTime;

public class Workday {

    // Public constants
    public static final int MONDAY = 0;
    public static final int TUESDAY = 1;
    public static final int WEDNESDAY = 2;
    public static final int THURSDAY = 3;
    public static final int FRIDAY = 4;
    public static final int SATURDAY = 5;
    public static final int SUNDAY = 6;

    // Instance variables
    private String clinicId;
    private int weekday;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean isClosed;

    /**
     * Constructor for the com.example.clinicprojectv2.Employee.Workday object.
     * @param clinicId The unique ID of the clinic in question (FK).
     * @param weekday The weekday as enumerated above (Monday through Sunday).
     * @param startTime Opening time for the current workday.
     * @param endTime Closing time for the current workday.
     * @param isClosed True if the clinic is closed on the current workday.
     */
    public Workday(String clinicId, int weekday, LocalTime startTime, LocalTime endTime, boolean isClosed) {

        if (!isValidWeekday(weekday))
            throw new IllegalArgumentException("The specified weekday is invalid.");

        if (!isValidWorkingHours(startTime, endTime))
            throw new IllegalArgumentException("Opening time must be before closing time.");

        this.clinicId = clinicId;
        this.weekday = weekday;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isClosed = isClosed;
    }

    /**
     * Checks if the specified weekday is valid as enumerated above. (Monday through Sunday).
     * @param weekday The weekday as enumerated above (Monday through Sunday).
     * @return True if the weekday is valid.
     */
    private boolean isValidWeekday(int weekday) {
        return (weekday >= Workday.MONDAY && weekday <= Workday.SUNDAY);
    }

    /**
     * Checks if the specified closing time is after opening time.
     * @param startTime Opening time for the current workday.
     * @param endTime Closing time for the current workday.
     * @return True if the closing time is after opening time.
     */
    private boolean isValidWorkingHours(LocalTime startTime, LocalTime endTime) {
        return (startTime.compareTo(endTime) > 0);
    }

    // Getters
    public String getClinicId() { return this.clinicId; }
    public int getWeekday() { return this.weekday; }
    public LocalTime getStartTime() { return this.startTime; }
    public LocalTime getEndTime() { return this.endTime; }
    public boolean isClosed() { return this.isClosed; }

    public void setWeekday(int weekday) {
        if (!isValidWeekday(weekday))
            throw new IllegalArgumentException("The specified weekday is invalid.");

        this.weekday = weekday;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }
}

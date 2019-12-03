package com.example.clinicprojectv2.Clinic;

import org.junit.Test;

import static org.junit.Assert.*;

public class WorkdayTest {

    // This class tests some of the main methods found in Workday.java

    @Test
    public void setDayTest(){
        // This method ensures that the day of a workday can be set properly

        // By passing the day in the constructor parameter
        Workday workdayTest1 = new Workday(Day.MONDAY);
        assertEquals("The day could not be set properly", Day.MONDAY, workdayTest1.getDayOfTheWeek());

        // By passing the day in the second constructor parameters
        Time startTimeTest = new Time(6, 8);
        Time endTimeTest = new Time(18, 5);
        Workday workdayTest2 = new Workday(Day.THURSDAY, startTimeTest, endTimeTest, false);
        assertEquals("The day could not be set properly", Day.THURSDAY, workdayTest2.getDayOfTheWeek());
    }

    @Test
    public void setClosedAndOpenTest(){
        // This method ensures that a clinic can be set as closed or open during a day

        // Testing setClosed()
        Workday workdayTest1 = new Workday(Day.FRIDAY);
        workdayTest1.setClosed();
        assertTrue("The clinic could not be closed manually", workdayTest1.isClosed());

        // Testing setOpen()
        Time startTimeTest = new Time(1, 3);
        Time endTimeTest = new Time(4, 2);
        Workday workdayTest2 = new Workday(Day.TUESDAY, startTimeTest, endTimeTest, true);
        workdayTest2.setOpen();
        assertFalse("The clinic could not be opened manually", workdayTest2.isClosed());
    }

    @Test
    public void setEndTimeTest(){
        // This method ensures the end time of a day can be set properly

        // By passing the end time in the second constructor
        Time startTimeTest = new Time(5,2);
        Time endTimeTest = new Time(2, 42);
        Time newEndTimeTest = new Time(23, 2);
        Workday workdayTest1 = new Workday(Day.WEDNESDAY, startTimeTest, endTimeTest, false);
        workdayTest1.setEndTime(newEndTimeTest);
        assertEquals("End time could not be set properly", newEndTimeTest, workdayTest1.getEndTime());

        // By setting the end time of a workday initialized by the first constructor
        Time newEndTimeTest2 = new Time(24, 53);
        Workday workdayTest2 = new Workday(Day.SUNDAY);
        workdayTest2.setEndTime(newEndTimeTest2);
        assertEquals("End time could not be set properly", newEndTimeTest2, workdayTest2.getEndTime());
    }


}

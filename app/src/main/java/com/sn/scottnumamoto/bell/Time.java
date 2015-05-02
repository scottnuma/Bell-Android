package com.sn.scottnumamoto.bell;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

/**
 *
 * @author scottnumamoto
 */
public class Time {
    private int hour, minute;
    
    public Time ( int h, int m)
    {
        hour = h;
        minute = m;
    }
    
    public Time()
    {
        //Returns a time object with the current time
        
        if (!Schedule.TESTING)
        {
            Calendar temp = Calendar.getInstance();
            hour = temp.get(temp.HOUR_OF_DAY);
            minute = temp.get(temp.MINUTE);
        }
        else
        {
            hour = Schedule.TEST_HOUR;
            minute = Schedule.TEST_MIN;
        }
    }
    
    public int TimeOffset(Time before)
    {
        //Returns the amount of this - before in minutes
        return absoluteMinute() - before.absoluteMinute();
    }
    
    public int getHour()
    {
        return hour;
    }
    
    public int getMinute()
    {
        return minute;
    }
    
    public int absoluteMinute()
    {
        return hour * 60 + minute;
    }
    
    public String toString()
    {
        String result = "";
        if (hour > 12)
            result += hour - 12;
        else
            result += hour;
        
        result += ":";
        if (minute <= 9)
            result += "0";
        result += minute;
        
        return result;
    }
}

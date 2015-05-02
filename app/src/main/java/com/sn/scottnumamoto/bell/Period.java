package com.sn.scottnumamoto.bell;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author scottnumamoto
 */
public class Period {
    private String label;
    private Time start, stop;
    
    public Period(String l, Time s1, Time s2)
    {
        label = l;
        start = s1;
        stop = s2;
    }
    
    public String getLabel()
    {
        return label;
    }

    @Override
    public String toString()
    {
        return getComplete();
    }
    
    public Time getStart()
    {
        return start;
    }
    
    public Time getStop()
    {
        return stop;
    }
    
    public String getDuration()
    {
        return "" + start + " - " + stop;
    }
    
    public String getComplete()
    {
        return "" + getLabel() + ": " + getDuration();
    }
    
    public int timeUntilStart()
    {
        //Returns the number of minutes until the period starts
        Time temp = new Time();
        return start.TimeOffset(temp);
    }
    
    public int timeUntilStop()
    {
        //Returns the number of minutes until the period ends
        Time temp = new Time();
        return stop.TimeOffset(temp);
    }
    
    
    
}

package com.sn.scottnumamoto.bell;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author scottnumamoto
 */
public class Date {
    private int day, month;
    
    public boolean isIn( int[][] exceptionDays)
    {
        for ( int[] possibleDay : exceptionDays)
        {
            if (month == possibleDay[0] && day ==possibleDay[1] )
                return true;
        }
        return false;
    }
    private final static int[][] LATE_START_DAYS = {
        {9,2},{9,15}, {9,29},
        {10,20},
        {11,3}, {11,17},
        {12,1}, {12,15},
        {1,5},
        {2,3}, {2,23},
        {3,9}, {3,23},
        {4,20},
        {5,4}, {5,18},
        {6,1}
    };
        
    private final static int[][] MINIMUM_DAYS = {
        {9,17},{12,19},{4,3},{5,22}
    };
        
    private final static int[][] PEP_RALLY_DAYS = {
        {9,19}, {10,24}, {12,12}, {4,24}
    };
        
    private final static int[][] FINAL_DAYS = {
        {1,27}, {1,28}, {1,29},
        {6,16}, {6,17}, {6,18}
    };

    private final static int[][] ODD_BLOCK_DAYS = {
            {5,26}, {5,28}, {6,2}
    };

    private final static int[][] EVEN_BLOCK_DAYS = {
            {5,27}, {5,29}, {6,3}
    };
    
    public final static int[][][] EXCEPTION_DAYS = {
        LATE_START_DAYS, MINIMUM_DAYS, PEP_RALLY_DAYS, FINAL_DAYS, ODD_BLOCK_DAYS, EVEN_BLOCK_DAYS
    };
    
    public final static Map<int[][], String> SCHEDULE_MAP = new HashMap<int[][], String>() {{
        put(LATE_START_DAYS, "Late Start");
        put(MINIMUM_DAYS, "Minimum");
        put(LATE_START_DAYS, "Late Start");
        put(PEP_RALLY_DAYS, "Pep Rally");
        put(FINAL_DAYS, "Finals");
        put(ODD_BLOCK_DAYS, "Odd Block");
        put(EVEN_BLOCK_DAYS, "Even Block");
    }};
    
    
    
    public Date()
    {
        if (Schedule.TESTING)
        {
            day = Schedule.TEST_DAY;
            month = Schedule.TEST_MONTH;
        }
        else
        {
           day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
           month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        }
        
    }
    
    public Date(int m, int d)
    {
        day = d;
        month = m;
    }
    
    public int getDay()
    {
        return day;
    }
    
    public int getMonth()
    {
        return month;
    }
    
    public boolean compareTo(Date d)
    {
        return day == d.getDay() && month == d.getMonth();
    }
    
    public boolean equals(int[] d)
    {
        return day == d[1] && month == d[0];
    }
    
    public int[] toArray()
    {
        int[] a = { month, day};
        return a;
    }
    
    
    
}

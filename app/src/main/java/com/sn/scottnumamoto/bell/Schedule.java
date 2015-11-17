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

public class Schedule {
    public static boolean TESTING = false;

    //That is, the day of the month January *8TH*
    public static int TEST_DAY = 30;

    //For the scheduler
    public static String TEST_DAY_NAME = "Friday";
    public static int TEST_MONTH = Calendar.JANUARY + 1;
    public static int TEST_HOUR = 10;
    public static int TEST_MIN = 15;
    
    private String label;
    private Period[] periods;
    
    
    private final String[] SCHEDULE_NAMES = { 
        "Weekend", "Tutorial", "Non-Tutorial", "Minimum", "Late Start", "Pep Rally", "Final"
    };
    
    private final Period[] WEEKEND_ARRAY = {
        new Period("24",     new Time(0,0),      new Time(1,0)),
        new Period("1",    new Time (1,0),     new Time(2,0)),
        new Period("2",   new Time(2,0),      new Time(3,0)),
        new Period("3",    new Time(3,0),      new Time(4,0)),
        new Period("4",     new Time(4,0),      new Time(5,0)),
        new Period("5",    new Time (5,0),     new Time(6,0)),
        new Period("6",   new Time(6,0),      new Time(7,0)),
        new Period("7",  new Time(7,0),      new Time(8,0)),
        new Period("8",    new Time (8,0),     new Time(9,0)),
        new Period("9",     new Time(9,0),      new Time(10,0)),
        new Period("10",    new Time(10,0),     new Time(11,0)),
        new Period("11",   new Time (11,0),    new Time(12,0)),
        new Period("12",     new Time(12,0),     new Time(13,0)),
        new Period("13",    new Time (13,0),    new Time(14,0)),
        new Period("14",   new Time(14,0),     new Time(15,0)),
        new Period("15",    new Time(15,0),     new Time(16,0)),
        new Period("16",     new Time(16,0),     new Time(17,0)),
        new Period("17",    new Time (17,0),    new Time(18,0)),
        new Period("18",   new Time(18,0),     new Time(19,0)),
        new Period("19",  new Time(19,0),     new Time(20,0)),
        new Period("20",    new Time (20,0),    new Time(21,0)),
        new Period("21",     new Time(21,0),     new Time(22,0)),
        new Period("22",    new Time(22,0),     new Time(23,0)),
        new Period("23",   new Time (23,0),    new Time(24,0))
    };
    
    private final Period[] TUTORIAL_ARRAY = {
        new Period("1",     new Time(8,0),      new Time(8,55)),
        new Period("2",    new Time(9,0),      new Time(9,54)),
        new Period("Snack", new Time(9,54),     new Time(10,4)),
        new Period("3",   new Time(10,9),     new Time(11,3)),
        new Period("Tutorial",    new Time(11,8),    new Time(11,38)),
        new Period("4",    new Time(11,43),    new Time(12,37)),
        new Period("Lunch", new Time(12,37),    new Time(13,17)),
        new Period("5",     new Time(13,22),     new Time(14,16)),
        new Period("6",    new Time(14,21),    new Time(15,15))
    };

    private final Period[] NONTUTORIAL_ARRAY = {
        new Period("1",     new Time(8,0),      new Time(9,0)),
        new Period("2",    new Time(9,5),      new Time(10,5)),
        new Period("Snack", new Time(10,5),     new Time(10,15)),
        new Period("3",   new Time(10,20),    new Time(11,20)),
        new Period("4",    new Time(11,25),    new Time(12,25)),
        new Period("Lunch", new Time(12,25),    new Time(13,5)),
        new Period("5",     new Time(13,10),    new Time(14,10)),
        new Period("6",    new Time(14,15),    new Time(15,15))
    };

    private final Period[] MINIMUM_ARRAY = {
        new Period("1",     new Time(8,0),      new Time(8,40)),
        new Period("2",    new Time(8,45),     new Time(9,25)),
        new Period("3",   new Time(9,30),     new Time(10,10)),
        new Period("Lunch", new Time(10,10),    new Time(10,20)),
        new Period("4",    new Time(10,25),    new Time(11,05)),
        new Period("5",     new Time(11,10),    new Time(11,50)),
        new Period("6",    new Time(11,55),    new Time(12,35))
    };

    private final Period[] LATE_START_ARRAY = {
        new Period("1",     new Time(10,15),      new Time(10,55)),
        new Period("2",    new Time(11,00),     new Time(11,40)),
        new Period("3",   new Time(11,45),     new Time(12,25)),
        new Period("Lunch", new Time(12,25),    new Time(13,0)),
        new Period("4",    new Time(13,5),    new Time(13,45)),
        new Period("5",     new Time(13,50),    new Time(14,30)),
        new Period("6",    new Time(14,35),    new Time(15,15))
    };

    private final Period[] ODD_BLOCK_SCHEDULE = {
            new Period("1", new Time(8,0), new Time(10,5)),
            new Period("Break", new Time(10,5), new Time(10,20)),
            new Period("3", new Time(10,20), new Time(12,25)),
            new Period("Lunch", new Time(12,25), new Time(13,5)),
            new Period("5", new Time(13,10), new Time(15,15))
    };

    private final Period[] EVEN_BLOCK_SCHEDULE = {
            new Period("2", new Time(8,0), new Time(10,5)),
            new Period("Break", new Time(10,5), new Time(10,20)),
            new Period("4", new Time(10,20), new Time(12,25)),
            new Period("Lunch", new Time(12,25), new Time(13,5)),
            new Period("6", new Time(13,10), new Time(15,15))
    };
    private final Period[] PEP_RALLY_ARRAY = {
        new Period("1",     new Time(8,0),      new Time(8,55)),
        new Period("2",    new Time(9,0),      new Time(9,55)),
        new Period("Snack", new Time(9,55),     new Time(10,5)),
        new Period("3",   new Time(10,10),    new Time(11,40)),
        new Period("4",    new Time(11,45),    new Time(12,40)),
        new Period("Lunch", new Time(12,40),    new Time(13,15)),
        new Period("5",     new Time(13,20),    new Time(14,15)),
        new Period("6",    new Time(14,20),    new Time(15,10))
    };
    private final Period[] FINALS_ARRAY = {
        new Period("Final",     new Time(8,0),      new Time(10,0)),
        new Period("Snack",    new Time(10,0),      new Time(10,10)),
        new Period("Final", new Time(10,15),     new Time(12,15))
    };
    
    private final Map<String, Period[]> SCHEDULE_MAP = new HashMap<String, Period[]>() {{
        put("Weekend", WEEKEND_ARRAY);
        put("Tutorial", TUTORIAL_ARRAY);
        put("Non-Tutorial", NONTUTORIAL_ARRAY);
        put("Minimum", MINIMUM_ARRAY);
        put("Late Start", LATE_START_ARRAY);
        put("Pep Rally", PEP_RALLY_ARRAY);
        put("Finals", FINALS_ARRAY);
        put("Odd Block", ODD_BLOCK_SCHEDULE);
        put("Even Block", EVEN_BLOCK_SCHEDULE);
    }};
    

    
    public Schedule( String l, Period[] t)
    {
        label = l;
        periods = t;        
    }
    
    public Schedule()
    {
     
        
        
        if (isAnExceptionDay())
            label = Date.SCHEDULE_MAP.get(ExceptionDays());
        else
        {
            label = scheduleName();

        }
        periods = SCHEDULE_MAP.get(label);
   
    }
    
    public String dayName()
    {
        if (TESTING)
            return TEST_DAY_NAME;

        //Sets the weekday based schedules
        final String[] DAY_NAMES = { 
           "", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday","Saturday", 
        };
        
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK); 
        return DAY_NAMES[day];
    }
    
    public String scheduleName()
    {
        String dayName = dayName();

        switch(dayName){
            case "Monday":
            case "Friday":
                return "Non-Tutorial";
                
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
                return "Tutorial";

            case "Saturday":
            case "Sunday":
                return "Weekend";
                
            default:
                throw new IllegalStateException("Not a legal day: " + dayName);
        }
    }
    
    public boolean isAnExceptionDay()
    {
        Date d = new Date();
        
        for ( int[][] category : Date.EXCEPTION_DAYS )
        {
           if ( d.isIn(category))
               return true;
        }
        return false;
    }
    
    
    
    public int[][] ExceptionDays()
    {
        //Returns the set of dates upon an exception occurs
        //This set correlates to a specific schedule
        Date d = new Date();
        
        for ( int[][] category : Date.EXCEPTION_DAYS )
        {
           if (d.isIn(category))
           {
               return category;
           }
        }
        
        throw new IllegalStateException("This date is not an exception");
    }
    
   
    
    public String getLabel()
    {
        //Label of the schedule
        return label;
    }
    
    public ArrayList<String> getPeriodLabels()
    {
        //Returns ArrayList of the period names and times
        ArrayList<String> result = new ArrayList<>();
        for (Period temp : periods) {
            result.add(temp.getLabel());
        }
        return result;
    }
    
    public Period[] getPeriods()
    {
        //Returns the array of all the periods
        return periods;
    }
    
    private Period currentPeriod()
    {
        //Returns the current period object
        //Not public, as relevantPeriod should be used instead
        for (Period temp: periods)
        {
            if (temp.timeUntilStart() <= 0 && ! (temp.timeUntilStop() <= 0))
                //Checks if the period has already started but not ended
                return temp;
        }
        throw new IllegalStateException("There is no current period");
    }
    
    public Period relevantPeriod()
    {
        //Returns the relevant period
        try {
            return currentPeriod();
        } catch (IllegalStateException a) {
            try {
                return nextPeriod();
            } catch (IllegalStateException b) {
                throw new IllegalStateException("All periods finished for day");
            }
        }
    }
    
    private Period nextPeriod()
    {
        //Sometimes there is no current period
        //In this case, find the next period that will occur
        for (int i = 0; i < periods.length; i++)
        {
            Period temp = periods[i];
            
            //Find the first period to have no started
            if ( !(temp.timeUntilStart() <= 0 )&& ! (temp.timeUntilStop() <= 0))
            {
                return periods[ i ];
            }
        }
        
        throw new IllegalStateException("There is no next period");
    }
    
    public Period[] nextPeriods()
    {
        //Returns an array of the periods that are yet to come
        
        //Find the index of the relevant period
        int releIndex = Arrays.asList(periods).indexOf(relevantPeriod());
        
        //This statement requires checking for clipping
        return Arrays.copyOfRange(periods, releIndex, periods.length);
    }
    
    public boolean passedPeriod(Period p)
    {
        //Check if the argument period has yet passed

        int source = Arrays.asList(periods).indexOf(p);
        int current = Arrays.asList(periods).indexOf(relevantPeriod());
        return source < current;
    }
    
    public Period getPeriodByName(String name)
    {
        //Returns the period by name from the current schedule
        for (Period p : periods )
        {
            if (p.getLabel().equals(name))
            {
                return p;
            }
        }
        throw new IllegalStateException("There is no by period with name: " + name);
    }
    
    public boolean restTime()
    {
        //States whether it's currently class or not
        Period p = relevantPeriod();
        
        //Depends on the fact that the first letter of lunch and break is letter
        return !Character.isDigit(p.getLabel().charAt(0));
    }
    public Period previousPeriod()
    {
        //Return the period that just passed
        //No real use for this function
        for (int i = 1; i < periods.length; i++)
        {
            //Start at i = 1 to avoid the first period
            Period temp = periods[i];
            
            //Find the current period
            if ( (temp.timeUntilStart() <= 0 )&& ! (temp.timeUntilStop() <= 0))
            {
                
                return periods[ i - 1 ];
            }
        }
        throw new IllegalStateException("There is no previous period");
    }
    
    public int remainingTime()
    {
        Period relevant;
        //First see if there is a current period
       
        relevant = relevantPeriod();
        return relevant.timeUntilStop();
    } 
    
    

    
    
}

package com.company;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing the gym classes information
 * @author Constantin Mihail
 * @version 1.0.0
 *
 */
public class GymClass implements Serializable
{

    private String name;
    private Time time;
    private Time timeEnd;
    private Date date;
    private int spots;
    private int availableSpots;
    private String instructor;

    /**
     * A 7 parameter constructor
     * @param name the gym name to add to the list
     * @param time the gym class starting time to add to the list
     * @param timeEnd the gym class ending time to add to the list
     * @param date the gym class date to add to the list
     * @param instructor the gym class instructor to add to the list
     * @param spots the gym class spots to add to the list
     * @param availableSpots the gym class available spots to add to the list
     */
    public GymClass(String name, Time time, Time timeEnd, Date date, String instructor, int spots, int availableSpots)
    {
        this.name=name;
        this.spots=spots;
        this.availableSpots=availableSpots;
        this.instructor=instructor;
        this.date= date.copy();
        this.time= time.copy();
        this.timeEnd= timeEnd;
    }
    /**
     * A 6 parameter constructor
     * @param name the gym name to add to the list
     * @param time the gym class starting time to add to the list
     * @param endTime the gym class ending time to add to the list
     * @param date the gym class date to add to the list
     * @param spots the gym class spots to add to the list
     * @param availableSpots the gym class available spots to add to the list
     */
    public GymClass(String name, Time time, Time endTime, Date date, int spots, int availableSpots)
    {
        this.name=name;
        this.time=time.copy();
        this.timeEnd= endTime;
        this.date=date.copy();
        this.spots=spots;
        this.availableSpots=availableSpots;
        this.instructor=null;
    }

    /**
     * A get method for the name
     * @return the name of the gym class
     */
    public String getName()
    {
        return name;
    }
    /**
     * A string get method for the starting time. Required for the xml file
     * @return a string of the gym class start time
     */
    public String getTimeString()
    {
        return time.toString();
    }
    /**
     * A string get method for the ending time. Required for the xml file
     * @return a string of the gym class end time
     */
    public String getEndTimeString()
    {
        return timeEnd.toString();
    }
    /**
     * A string get method for the class date. Required for the xml file.
     * @return a string of the gym class date.
     */
    public String getDateString()
    {
        return date.toString();
    }
    /**
     * A string get method for the class instructor. Required for the xml file.
     * @return a string of the instructor name.
     */
    public String getInstructor()
    {
        return instructor;
    }
    /**
     * A string get method for the class spots. Required for the xml file.
     * @return a string of the gym class spots.
     */
    public String getSpotsString()
    {
        return String.valueOf(spots);
    }
    /**
     * A string get method of the class available spots. Required for the xml file.
     * @return a string of the available spots in the gym class.
     */
    public String getAvailableSpotsString()
    {
        return String.valueOf(availableSpots);
    }
    /**
     * A string get method for the occupied spots in a gym class. Required for the xml file.
     * @return a difference between the spots in a gym class and its available spots.
     */
    public String getCurrentSpotsString(){
        return String.valueOf(Integer.parseInt(getSpotsString())-Integer.parseInt(getAvailableSpotsString()));
    }

    /**
     * Normal getTime() method, used for comparing 2 classes
     * @return the time at which the class starts
     */
    public Time getTime()
    {
        return this.time;
    }

    /**
     * Normal getDate() method, used for comparing 2 classes
     * @return the date at which the class has been set
     */
    public Date getDate()
    {
        return this.date;
    }

    /**
     * Equals method, used for comparing 2 classes
     * @param obj
     * @return true if the classes are the same, false if otherwise
     */
    public boolean equals(Object obj)
    {
        if(!(obj instanceof GymClass))
            return false;
        GymClass other= (GymClass) obj;
        if(instructor != null)
        {
            return name.equals(other.name) && spots==other.spots && instructor.equals(other.instructor)
                && availableSpots==other.availableSpots && date.equals(other.date) && time.equals(other.time) && timeEnd.equals(other.timeEnd);
        }
        else
            return name.equals(other.name) && spots==other.spots && availableSpots==other.availableSpots
                && date.equals(other.date) && time.equals(other.time) && timeEnd.equals(other.timeEnd);
    }

    /**
     * ToString method, used to display the information of the class
     * @return
     */
    public String toString()
    {
        if(instructor !=null)
            return "The class:" + this.getName() +
                "\nDate: " + date.toString() +
                "\nStart time: " + time.toString() +
                "\nEnd time: " + timeEnd.toString() +
                "\nWith " + this.getSpotsString() +
                " spots and  " + this.getAvailableSpotsString() + " available" +
                "\nInstructor: " + instructor;
        else
            return "The class:" + this.getName() +
                "\n" + date.toString() +
                "\nStart time: " + time.toString() +
                "\nEnd time: " + timeEnd +
                "\nWith " + this.getSpotsString() +
                " spots and  " + this.getAvailableSpotsString() + " available";
    }
}

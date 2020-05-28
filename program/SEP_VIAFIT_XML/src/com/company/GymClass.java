package com.company;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class GymClass implements Serializable
{

    private String name;
    private Time time;
    private Time timeEnd;
    private Date date;
    private int spots;
    private int availableSpots;
    //private ArrayList<Member> members;
    private String instructor;

    ////////////////////////////////////////////////////////////////////////////Constructors
    public GymClass(String name, Time time, Time timeEnd, Date date, String instructor, int spots, int availableSpots)
    {
        this.name=name;
        this.spots=spots;
        this.availableSpots=availableSpots;
        this.instructor=instructor;
        this.date= date.copy();
        this.time= time.copy();
        this.timeEnd= timeEnd;
       // members = new ArrayList<>();
    }
    public GymClass(String name, Time time, Time endTime, Date date, int spots, int availableSpots)
    {
        this.name=name;
        this.time=time.copy();
        this.timeEnd= endTime;
        this.date=date.copy();
        this.spots=spots;
        this.availableSpots=availableSpots;
        this.instructor=null;
        //members = new ArrayList<>();
    }
    /*
    public void setMember(ArrayList<Member> members)
    {
    this.members=members;
     }
    */

    ////////////////////////////////////////////////////////////////////////////String methods needed for the xml file
    public String getName()
    {
        return name;
    }
    public String getTimeString()
    {
        return time.toString();
    }
    public String getEndTimeString()
    {
        return timeEnd.toString();
    }
    public String getDateString()
    {
        return date.toString();
    }
    public String getInstructor()
    {
        return instructor;
    }
    public String getSpotsString()
    {
        return String.valueOf(spots);
    }
    public String getAvailableSpotsString()
    {
        return String.valueOf(availableSpots);
    }
    public String getCurrentSpotsString(){
        return String.valueOf(Integer.parseInt(getSpotsString())-Integer.parseInt(getAvailableSpotsString()));
    }

    ////////////////////////////////////////////////////////////////////////////The equivalent methods
    public Time getTime()
    {
        return this.time;
    }
    public Time getTimeEnd()
    {
        return this.timeEnd;
    }
    public Date getDate()
    {
        return this.date;
    }
    public int getSpots()
    {
        return this.spots;
    }
    public int getAvailableSpots()
    {
        return this.availableSpots;
    }

    ////////////////////////////////////////////////////////////////////////////Instructor handling
    /*
    public void addInstructor(Instructor instructor)
    {
        this.instructor=instructor;
    }
    public void removeInstructor(Instructor instructor)
    {
        this.instructor=null;
    }
     */
    /*
    //////////////////////////////////////////////////////////////////////////Member handling
    public ArrayList<Member> getMember()
    {
    return members;
    }
    public void addMemberToClass(Member member)
    {
    if(availableSpots>0)
    {
    this.members.add(member);
    availableSpots--;
    }
    }
     public void removeMemberFromClass(Member member)
    {
    this.members.remove(this.members.lastIndexOf(member));
     availableSpots++;
    }
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
    public GymClass copy()
    {
        if(instructor!=null)
            return new GymClass(name,time,timeEnd,date,instructor,spots,availableSpots);
        else return new GymClass(name,time,timeEnd,date,spots,availableSpots);
    }
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

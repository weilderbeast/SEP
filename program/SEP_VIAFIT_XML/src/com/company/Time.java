package com.company;

import java.io.Serializable;

/**
 * Time class, that has hours minutes and seconds
 * @author Satish Gurung
 */
public class Time implements Serializable
{
  private int hour;
  private int minute;
  private int second;

  /**
   * 3 argument constructor
   * @param hour
   * @param minute
   * @param second
   */
  public Time(int hour,int minute,int second){
    this.hour=hour;
    this.minute=minute;
    this.second=second;
  }

  /**
   * 2 argument constructor
   * @param hour
   * @param minute
   */
  public Time(int hour,int minute)
  {
    this.hour=hour;
    this.minute=minute;
    this.second=0;
  }

  /**
   * copy method
   * @return returns a copy of a time object
   */
  public  Time copy()
  {
    return new Time(hour, minute, second);
  }

  /**
   * equals method
   * @param obj
   * @return returns true if the object is the same as the time, else it returns false
   */
  public boolean equals(Object obj){
    if(!(obj instanceof Time))
    {
      return false;
    }
    Time watch= (Time)obj;

    return hour==watch.hour && minute==watch.minute && second==watch.second;
  }

  /**
   * equals method that doesn't compare seconds
   * @param obj
   * @return true if the object is the same as the time, else it returns false
   */
  public boolean equalsNoSeconds(Object obj){
    if(!(obj instanceof Time))
    {
      return false;
    }
    Time watch= (Time)obj;

    return hour==watch.hour && minute==watch.minute;
  }

  /**
   * ToString method used to display the time
   * @return all information about time
   */
  public String toString(){
    return hour + ":" + minute + ":" +second;
  }
}

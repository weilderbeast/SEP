package com.company;

import java.io.Serializable;

/**
 * Date class, that has day, month and year
 * @author Satish Gurung
 * @version 1.0
 */
public class Date implements Serializable
{
  private int day;
  private int month;
  private int year;

  /**
   * 3 argument constructor
   * @param day
   * @param month
   * @param year
   */
  public Date(int day, int month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  /**
   * copy method
   * @return copy of the date
   */
  public Date copy(){
    return new Date(day,month,year);
  }

  /**
   * equals method
   * @param obj
   * @return returns true if the object is the same as the date, false if not
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Date))
    {
      return false;
    }
    Date other = (Date)obj;
    return day== other.day && month==other.month && year==other.year;
  }

  /**
   * ToString method used to display the date
   * @return all information of a date
   */
  public String toString(){
    return day + "/" + month + "/" + year;
  }
}


package com.company;

import java.io.Serializable;

public class Date implements Serializable
{
  private int day;
  private int month;
  private int year;

  public Date(int day, int month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
  }
  public Date copy(){
    return new Date(day,month,year);
  }


  public boolean equals(Object obj)
  {
    if (!(obj instanceof Date))
    {
      return false;
    }
    Date other = (Date)obj;
    return day== other.day && month==other.month && year==other.year;
  }

  public String toString(){
    return day + "/" + month + "/" + year;
  }
}


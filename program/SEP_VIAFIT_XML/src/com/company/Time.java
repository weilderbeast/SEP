package com.company;

import java.io.Serializable;

public class Time implements Serializable
{
  private int hour;
  private int minute;
  private int second;

  public Time(int hour,int minute,int second){
    this.hour=hour;
    this.minute=minute;
    this.second=second;
  }
  public Time(int hour,int minute)
  {
    this.hour=hour;
    this.minute=minute;
    this.second=0;
  }
  public  Time copy(){
    return new Time(hour,minute,second);
  }
  public int convertToSeconds(){
    return hour*3600 + minute*60 + second;
  }

  public boolean equals(Object obj){
    if(!(obj instanceof Time))
    {
      return false;
    }
    Time watch= (Time)obj;

    return hour==watch.hour && minute==watch.minute && second==watch.second;
  }
  public boolean equalsNoSeconds(Object obj){
    if(!(obj instanceof Time))
    {
      return false;
    }
    Time watch= (Time)obj;

    return hour==watch.hour && minute==watch.minute;
  }

  public String toString(){
    return hour + ":" + minute + ":" +second;
  }
}

package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Member extends Person implements Serializable
{
  private boolean subscription;
  //private ArrayList<GymClass> classesList;
  public Member(String firstName , String lastName , String address , String email , String phoneNumber, boolean hasPremium)
  {
    super(firstName , lastName , address , email , phoneNumber);
    this.subscription = hasPremium;
    //classesList = new ArrayList<>();
  }

  public boolean getSubscription()
  {
    return subscription;
  }

  public Member copy()
  {
    return new Member(this.getFirstName(),this.getLastName(),this.getAddress(),this.getEmail(),this.getPhoneNumber(),this.getSubscription());
  }

  public void bookTo(GymClass gymClass)
  {
    //classesList.add(gymClass);
  }
  public void removeBooking(GymClass gymClass)
  {
    //classesList.remove(gymClass);
  }
  public void changeSubscriptionTo(boolean value)
  {
    this.subscription=value;
  }

  /*
  public ArrayList<GymClass> getBookings()
  {
   return this.classesList;
  }
  */
  /*
  public void updateBookings(ArrayList<GymClass> updatedBookings)
  {
  classesList = updatedBookings;
  }
  */

  public boolean equals(Object obj)
  {
    if(!(obj instanceof Member))
    {
      return false;
    }
    Member member = (Member)obj;
    return  this.getFirstName().equals(member.getFirstName()) &&
            this.getLastName().equals(member.getLastName()) &&
            this.getEmail().equals(member.getEmail()) &&
            this.getAddress().equals(member.getAddress()) &&
            this.getPhoneNumber().equals(member.getPhoneNumber());
  }

  public String toString()
  {
    if(subscription)
    return super.toString() + "with a premium subscription";
    else return super.toString() + "with a normal subscription";
  }
}

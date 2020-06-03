package com.company;

import java.io.Serializable;

/**
 * Member class used for creating a new member
 * @author Satish Gurung
 * @version 1.0
 */
public class Member extends Person implements Serializable
{
  private boolean subscription;

  /**
   * 6 argument constructor for creating a new member
   * @param firstName
   * @param lastName
   * @param address
   * @param email
   * @param phoneNumber
   * @param hasPremium
   */
  public Member(String firstName , String lastName , String address , String email , String phoneNumber, boolean hasPremium)
  {
    super(firstName , lastName , address , email , phoneNumber);
    this.subscription = hasPremium;
  }

  /**
   * Equals method used to compare the member with another object
   * @param obj
   * @return true if they are the same, false if not
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

  /**
   * ToString method used to display the member's data
   * @return the member's data
   */
  public String toString()
  {
    if(subscription)
    return super.toString() + "with a premium subscription";
    else return super.toString() + "with a normal subscription";
  }
}

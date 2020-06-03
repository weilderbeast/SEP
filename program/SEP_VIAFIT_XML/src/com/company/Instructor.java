package com.company;
import java.io.Serializable;

/**
 * Instructor class for, you guessed it, creating a new instructor, using the person class
 * This was supposed to be more complicated, and it was, but because I couldn't finish in time, I left it as it is.
 * @author Cirstoiu Bogdan-Florin
 * @version 1.2
 */
public class Instructor extends Person implements Serializable
{
  /**
   * 5 argument constructor used to create a new instructor
   * @param firstName
   * @param lastName
   * @param address
   * @param email
   * @param phoneNumber
   */
  public Instructor(String firstName , String lastName , String address , String email , String phoneNumber)
  {
    super(firstName,lastName,address,email,phoneNumber);
  }

  /**
   * Equals method that takes an object as a parameter and compares it to an instructor
   * @param obj
   * @return if they are the same, return true, otherwise return false
   */
  public boolean equals(Object obj)
  {
      if(!(obj instanceof Instructor))
          return false;
      Instructor other= (Instructor)obj;
          return  this.getLastName().equals(other.getLastName()) &&
                  this.getFirstName().equals(other.getFirstName()) &&
                  this.getAddress().equals(other.getAddress()) &&
                  this.getPhoneNumber().equals(other.getPhoneNumber()) &&
                  this.getEmail().equals(other.getEmail());
  }

  /**
   * ToString method for displaying the instructor information
   * @return the data of the instructor
   */
  public String toString()
  {
    return super.toString();
  }

}

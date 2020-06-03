package com.company;

import java.io.Serializable;

/**
 * A class that is used to store basic data about a person,
 * that's used for members and instructors
 * @author Hadi Ismail Abdallah
 */
public class Person implements Serializable
{
  private String firstName;
  private String lastName;
  private String address;
  private String email;
  private String phoneNumber;

  /**
   * 5 argument constructor used to create a new person
   * @param firstName
   * @param lastName
   * @param address
   * @param email
   * @param phoneNumber
   */
  public Person(String firstName , String lastName , String address , String email , String phoneNumber)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  /**
   * String method used to return the full name of a person
   * @return full name of a person
   */
  public String getFullName()
  {
    return firstName + " " + lastName;
  }

  /**
   * String method used to return the first name of a person
   * @return the first name of a person
   */
  public String getFirstName()
  {
    return firstName;
  }

  /**
   * String method used to return the last name of a person
   * @return the last name of a person
   */
  public String getLastName()
  {
    return lastName;
  }

  /**
   * String method used to return the address of a person
   * @return the address of a person
   */
  public String getAddress()
  {
    return address;
  }

  /**
   * String method used to return the email of a person
   * @return the email of a person
   */
  public String getEmail()
  {
    return email;
  }

  /**
   * String method used to return the phone number of a person
   * @return the phone number of a person
   */
  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  /**
   * ToString method used to display all information about a person
   * @return all information of a person
   */
  public String toString()
  {
    return this.getFullName()+"  |  Address: "+address+"  |  Email: "+email+"  |  Phone number: "+phoneNumber+"\n";
  }
}

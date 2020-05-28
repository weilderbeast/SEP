package com.company;

import java.io.Serializable;

public class Person implements Serializable
{
  private String firstName;
  private String lastName;
  private String address;
  private String email;
  private String phoneNumber;
  public Person(String firstName , String lastName , String address , String email , String phoneNumber)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }
  public String getFullName()
  {
    return firstName + " " + lastName;
  }
  public String getFirstName()
  {
    return firstName;
  }
  public String getLastName()
  {
    return lastName;
  }
  public String getAddress()
  {
    return address;
  }
  public String getEmail()
  {
    return email;
  }
  public String getPhoneNumber()
  {
    return phoneNumber;
  }
  public String getPhoneNumberString() { return phoneNumber;}
  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }
  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }
  public void setAddress(String address)
  {
    this.address = address;
  }
  public void setEmail(String email)
  {
    this.email = email;
  }
  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }
  public String toString()
  {
    return this.getFullName()+"  |  Address: "+address+"  |  Email: "+email+"  |  Phone number: "+phoneNumber+"\n";
  }
}

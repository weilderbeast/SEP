package com.company;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Instructor extends Person implements Serializable
{
  //private ArrayList<GymClass> classList;
  public Instructor(String firstName , String lastName , String address , String email , String phoneNumber)
  {
    super(firstName,lastName,address,email,phoneNumber);
    //ArrayList<GymClass> classList= new ArrayList<>();
  }
  /*
 public Instructor(String firstName, String lastName, String address, String email, String phoneNumber,ArrayList<GymClass> classList)
  {
  super(firstName,lastName,address,email,phoneNumber);
  this.classList = classList;
  }
 */

  /*
  public ArrayList<GymClass> getClassList()
  {
  return this.classList;
   }
  public void addClass(GymClass gymClass)
  {
   this.classList.add(gymClass);
  }
  public void removeClass(GymClass gymClass)
  {
   this.classList.remove(gymClass);
  }
  public boolean checkForSameClass(GymClass gymClass)
  {
   for(int i=0;i<classList.size();i++)
  {
   if(gymClass.equals(classList.get(i)))
  {
   System.out.println("the class "+gymClass+" exists already.");
  return false;
  }
   }
   return true;
  }
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
  public Instructor copy()
  {
      return new Instructor(this.getFirstName(),this.getLastName(),this.getAddress(),this.getEmail(),this.getPhoneNumber());
  }
  public String toString()
  {
    return super.toString();
  }

}

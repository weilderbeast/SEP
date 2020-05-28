package com.company;

import java.io.*;
import java.util.ArrayList;
import javax.swing.text.TabExpander;
import java.util.Scanner;

public class InstructorHandler implements Serializable
{
  private FileManager fileManager;

  public InstructorHandler()
  {
    fileManager = new FileManager();
  }
  public void addInstructor(Instructor instructor)
  {
    fileManager.saveInstructor(instructor);
  }
  public Instructor getInstructorByName(String name,String lastName)
  {
    ArrayList<Instructor> instructorArrayList = getAllFromFile();
    for(int i=0;i<instructorArrayList.size();i++)
    {
      if(instructorArrayList.get(i).getFirstName() != null && instructorArrayList.get(i).getLastName() != null)
      if(instructorArrayList.get(i).getFirstName().equals(name) && instructorArrayList.get(i).getLastName().equals(lastName))
        return instructorArrayList.get(i);
    }
    return null;
  }
  public Instructor getInstructorByPhoneNumber(String phoneNumber)
  {
    ArrayList<Instructor> instructorArrayList = getAllFromFile();
    for(int i=0;i<instructorArrayList.size();i++)
    {
      if(instructorArrayList.get(i).getPhoneNumber() != null)
      if(instructorArrayList.get(i).getPhoneNumber().equals(phoneNumber))
        return instructorArrayList.get(i);
    }
    return null;
  }
  public void removeInstructor(Instructor instructor)
  {
    fileManager.removeInstructor(instructor);
  }
  public ArrayList<Instructor> getAllFromFile()
  {
    return fileManager.getAllInstructors();
  }
  public boolean checkForAdding(Instructor instructor)
  {
    ArrayList<Instructor> currentInstructors = getAllFromFile();
    for(int i=0;i<currentInstructors.size();i++)
    {
      if(instructor.getLastName().equals(currentInstructors.get(i).getLastName()))
      {
        System.out.println("last name check false");
        return false;
      }
      if(instructor.getPhoneNumber().equals(currentInstructors.get(i).getPhoneNumber()))
      {
        System.out.println("phone number check false");
        return false;
      }
      if(instructor.getEmail().equals(currentInstructors.get(i).getEmail()))
      {
        System.out.println("email check false");
        return false;
      }
    }
    System.out.println("passed all checks");
    return true;
  }
  public boolean checkForEditing(Instructor instructor,int index)
  {
    ArrayList<Instructor> currentInstructors = getAllFromFile();
    for(int i=0;i<currentInstructors.size();i++)
    {
      if(i != index)
      {
        if(instructor.getLastName().equals(currentInstructors.get(i).getLastName()))
        {
          System.out.println("last name check false");
          return false;
        }
        if(instructor.getPhoneNumber().equals(currentInstructors.get(i).getPhoneNumber()))
        {
          System.out.println("phone number check false");
          return false;
        }
        if(instructor.getEmail().equals(currentInstructors.get(i).getEmail()))
        {
          System.out.println("email check false");
          return false;
        }
      }
    }
    return true;
  }
  public int getIndexOf(Instructor instructor)
  {
    ArrayList<Instructor> currentInstructors = getAllFromFile();
    for(int i=0;i<currentInstructors.size();i++)
    {
      if(currentInstructors.get(i).equals(instructor))
      {
        return i;
      }
    }
    return -1;
  }
}

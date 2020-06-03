package com.company;

import java.io.*;
import java.util.ArrayList;

/**
 * Instructor handler method, used for adding, editing, removing and comparing instructors
 * @author Cirstoiu Bogdan-Florin
 */
public class InstructorHandler implements Serializable
{
  private FileManager fileManager;

  /**
   * No argument constructor to initialize the file manager
   */
  public InstructorHandler()
  {
    fileManager = new FileManager();
  }

  /**
   * Method used for adding an instructor, using the file manager
   * @param instructor
   */
  public void addInstructor(Instructor instructor)
  {
    fileManager.saveInstructor(instructor);
  }

  /**
   * Method used for searching an instructor by his/hers full name
   * @param name
   * @param lastName
   * @return if an instructor is found with the specified information, it will be returned, otherwise the method will return null
   */
  public Instructor getInstructorByName(String name,String lastName)
  {
    ArrayList<Instructor> instructorArrayList = new ArrayList<>();
    if(getAllFromFile() != null)
      instructorArrayList = getAllFromFile();
    for(int i=0;i<instructorArrayList.size();i++)
    {
      if(instructorArrayList.get(i).getFirstName() != null && instructorArrayList.get(i).getLastName() != null)
      if(instructorArrayList.get(i).getFirstName().equals(name) && instructorArrayList.get(i).getLastName().equals(lastName))
        return instructorArrayList.get(i);
    }
    return null;
  }

  /**
   * Method used for searching an instructor by phone number
   * @param phoneNumber
   * @return if the phone number matches any other phone number in the file, the method returns the instructor that had that phone number,
   * otherwise, it will return null
   */
  public Instructor getInstructorByPhoneNumber(String phoneNumber)
  {
    ArrayList<Instructor> instructorArrayList = new ArrayList<>();
    if(getAllFromFile() != null)
      instructorArrayList = getAllFromFile();
    for(int i=0;i<instructorArrayList.size();i++)
    {
      if(instructorArrayList.get(i).getPhoneNumber() != null)
      if(instructorArrayList.get(i).getPhoneNumber().equals(phoneNumber))
        return instructorArrayList.get(i);
    }
    return null;
  }

  /**
   * Method used for removing an instructor using the file manager
   * @param instructor
   */
  public void removeInstructor(Instructor instructor)
  {
    fileManager.removeInstructor(instructor);
  }

  /**
   * Method used to get all instructors from the file, using the file manager
   * @return an array list of all instructors
   */
  public ArrayList<Instructor> getAllFromFile()
  {
    return fileManager.getAllInstructors();
  }

  /**
   * Method used to check if an instructor can be added with the given information.
   * @param instructor
   * @return the method returns true if no conflicts would arise from adding this instructor to the list, otherwise it will return false
   */
  public boolean checkForAdding(Instructor instructor)
  {
    ArrayList<Instructor> currentInstructors = new ArrayList<>();
    if(getAllFromFile() != null)
      currentInstructors = getAllFromFile();
    for(int i=0;i<currentInstructors.size();i++)
    {
      //i used to have these in one if statement, but for some reason, it would randomly return correct, or wrong,
      //and splitting them fixed the issue
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

  /**
   * A method that also takes the index as a parameter when checking if editing an instructor with the given data would
   * conflict with any other instructor, aside from the one we're trying to edit, hence we take the index of that instructor,
   * so the method can skip it while checking
   * @param instructor
   * @param index
   * @return true if the editing would not result in any conflicts, false otherwise
   */
  public boolean checkForEditing(Instructor instructor,int index)
  {
    ArrayList<Instructor> currentInstructors = new ArrayList<>();
    if(getAllFromFile() != null)
      currentInstructors = getAllFromFile();
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

  /**
   * Method used to get the index of an instructor from the list
   * @param instructor
   * @return if that instructor exists, return it's index, otherwise return -1
   */
  public int getIndexOf(Instructor instructor)
  {
    ArrayList<Instructor> currentInstructors = new ArrayList<>();
    if(getAllFromFile() != null)
      currentInstructors = getAllFromFile();
    for(int i=0;i<currentInstructors.size();i++)
    {
      if(currentInstructors.get(i).equals(instructor))
      {
        return i;
      }
    }
    return -1;
  }

  /**
   * Method used to remove all instructors using the file manager
   */
  public void removeAllInstructors()
  {
    fileManager.removeAllFromInstructorsFile();
  }
}

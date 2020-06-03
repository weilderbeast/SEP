package com.company;
import java.io.*;
import java.util.ArrayList;
import javax.swing.text.TabExpander;
import java.util.Scanner;

/**
 * A class that handles all of the gym classes necessities
 * @author Constantin Mihail
 * @version 1.0.0
 */
public class ClassesHandler implements Serializable
{
  private FileManager fileManager;

  /**
   * No argument constructor that initializes the file manager
   */
  public ClassesHandler() { fileManager = new FileManager(); }
  /**
   * A method which adds a new class to the file
   * @param gymClass the class that needs to be added
   */
  public void addClass(GymClass gymClass) { fileManager.saveClass(gymClass); }

  /**
   * A method that returns a class with given name, date and time, by first
   * getting the whole list and checking for each class
   * @param name the name of the class
   * @param date the date of the class
   * @param time the starting time of the class
   * @return the respective gym class after the search has been done
   */
  public GymClass getClassByName(String name,Date date,Time time)
  {
    ArrayList<GymClass> classesArrayList = getAllFromFile();
    for(int i=0;i<classesArrayList.size();i++)
    {
      if (classesArrayList.get(i).getName().equals(name))
      {
        System.out.println("passed name check");
        if (classesArrayList.get(i).getDate().equals(date))
        {
          System.out.println("passed date check");
          if (classesArrayList.get(i).getTime().equalsNoSeconds(time))
          {
            System.out.println("passed time check");
            return classesArrayList.get(i);
          }
        }
      }
    }
    return null;
  }
  /**
   * A method that checks if the added information is not already in the list
   * @param gymClass the gym class that contains the information which needs to be checked
   * @return a boolean that is true if the class information exists and false if it does not
   */
  public boolean checkForAdding(GymClass gymClass)
  {
    ArrayList<GymClass> allClasses = getAllFromFile();
    for(int i=0;i<allClasses.size();i++)
    {
      if(allClasses.get(i).getDate().equals(gymClass.getDate()))
      {
        System.out.println("failed date check");
        if(allClasses.get(i).getTime().equalsNoSeconds(gymClass.getTime()))
        {
          System.out.println("failed time check");
          return false;
        }
      }
    }
      return true;
  }
  /**
   * A method that removes a gym class from the list
   * @param gymClass the gym class that needs to be removed
   */
  public void removeClass(GymClass gymClass)
  {
    fileManager.removeClass(gymClass);
  }
  /**
   * A method that gets all the classes from a file
   * @return an array list with all of the classes
   */
  public ArrayList<GymClass> getAllFromFile()
  {
    return fileManager.getAllClasses();
  }
}


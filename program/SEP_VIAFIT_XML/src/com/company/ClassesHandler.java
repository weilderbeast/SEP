package com.company;
import java.io.*;
import java.util.ArrayList;
import javax.swing.text.TabExpander;
import java.util.Scanner;

public class ClassesHandler implements Serializable
{
  private FileManager fileManager;

  public ClassesHandler() { fileManager = new FileManager(); }
  public void addClass(GymClass gymClass) { fileManager.saveClass(gymClass); }

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
  public boolean checkDateAndTime(Date date,Time time,int index)
  {
    ArrayList<GymClass> allClasses = getAllFromFile();
    for(int i=0;i<allClasses.size();i++)
    {
      if(i != index)
        if(allClasses.get(i).getDate().equals(date) &&
              allClasses.get(i).getTime().equals(time))
        {
          return false;
        }
    }
    return true;
  }
  public GymClass searchByDateAndTimeAndName(Date date,Time time,String name)
  {
    ArrayList<GymClass> allClasses = getAllFromFile();
    for(int i=0;i<allClasses.size();i++)
    {
        if(allClasses.get(i).getDate().equals(date) &&
            allClasses.get(i).getTime().equals(time) &&
            allClasses.get(i).getName().equals(name)
        )
        {
          return allClasses.get(i);
        }
    }
    return null;
  }
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
  public boolean checkForEditing(GymClass gymClass,int index)
  {
    ArrayList<GymClass> allClasses = getAllFromFile();
    return true;
  }
  public void removeClass(GymClass gymClass)
  {
    fileManager.removeClasses(gymClass);
  }
  public ArrayList<GymClass> getAllFromFile()
  {
    return fileManager.getAllClasses();
  }
  public int getIndexOf(GymClass gymClass)
  {
    ArrayList<GymClass> allClasses = getAllFromFile();
    for(int i=0;i<allClasses.size();i++)
    {
      if(allClasses.get(i).equals(gymClass)) return i;
    }
    return -1;
  }
}


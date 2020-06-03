package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A class that manages the information from the file
 * @author Bogdan Cirstoiu (Instructors)
 * @author Constantin Mihail (Classes)
 * @author Satish Gurung (Members)
 * @version 1.0.0
 */
public class FileManager implements Serializable
{
  private MyFileIO myFile;

  /**
   * These are the relative paths for the .bin files, but sometimes they don't work, and the absolute
   * path has to be added. I still have no idea why. - Cirstoiu Bogdan
   */
  private String memberFileName = "src\\com\\company\\members.bin";
  private String instructorFileName = "src\\com\\company\\instructors.bin";
  private String classesFileName= "src\\com\\company\\classes.bin";

  /**
   * A no parameters constructor that initializes the file handler
   */
  public FileManager()
  {
    myFile = new MyFileIO();
  }

  /**
   * A method that saves an instructor into the binary file by first getting the full list of already
   * created instructors, adding the specified instructor to that list, and writing it back to the file.
   * @param object the object that needs to be saved
   */
  public void saveInstructor(Object object)
  {
    ArrayList<Instructor> existingInstructors = new ArrayList<>();
    if(getAllInstructors() != null)
      existingInstructors = getAllInstructors();
    existingInstructors.add((Instructor)object);
    try{
      myFile.writeToFile(instructorFileName,existingInstructors);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      e.printStackTrace();
      System.out.println("IO error in saveInstructor");
    }
  }
  /**
   * A method that removes an instructor from the file, by first getting the full list of instructors,
   * and then searching for the one we want to remove, removing it, and then re-writing the list to the file.
   * @param instructor the instructor that needs to get removed
   */
  public void removeInstructor(Instructor instructor)
  {
    ArrayList<Instructor> existingInstructors = getAllInstructors();
    for(int i=0;i<existingInstructors.size();i++)
    {
      if(existingInstructors.get(i).equals(instructor))
      {
        existingInstructors.remove(instructor);
      }
    }
    try
    {
      myFile.writeToFile(instructorFileName,existingInstructors);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    System.out.println("Successfully removed instructor " + instructor.getFullName());
  }
  /**
   * A method that returns all the instructors from the binary file by reading the list from the file
   * and casting it to the instructor type, and then returning that list
   * @return instructorArrayList, an ArrayList of all the instructors
   */
  public ArrayList<Instructor> getAllInstructors()
  {
    ArrayList<Instructor> instructorArrayList = new ArrayList<>();
    try
    {
      if((ArrayList<Instructor>)myFile.readObjectFromFile(instructorFileName) != null)
      instructorArrayList = (ArrayList<Instructor>)myFile.readObjectFromFile(instructorFileName);
    }
    catch (IOException e)
    {
      e.printStackTrace();
      System.out.println("Io error in getAllInstructors");
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return instructorArrayList;
  }
  /**
   * A method that removes everything the from instructor file by writing an empty list in the file
   */
  public void removeAllFromInstructorsFile()
  {
    ArrayList<Instructor> existingInstructors = new ArrayList<>();
    try
    {
      myFile.writeToFile(instructorFileName,existingInstructors);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    System.out.println("did remove all");
  }


  /**
   * A method that saves a new class by first getting the full list of classes, adding it, and then
   * re-writing the list to the file
   * @param object the class that needs to be saved
   */
  public void saveClass(GymClass object)
  {
    ArrayList<GymClass> existingClasses = new ArrayList<>();
    if(getAllClasses() != null)
      existingClasses = getAllClasses();
    existingClasses.add(object);
    try{
      myFile.writeToFile(classesFileName,existingClasses);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      e.printStackTrace();
      System.out.println("IO error in saveClass");
    }
  }
  /**
   * A method that removes a certain class from the binary file
   * @param gymClass the class that needs to be removed
   */
  public void removeClass(GymClass gymClass)
  {
    ArrayList<GymClass> existingClasses = getAllClasses();
    for(int i=0;i<existingClasses.size();i++)
    {
      if(existingClasses.get(i).equals(gymClass))
      {
        existingClasses.remove(gymClass);
      }
    }
    try
    {
      myFile.writeToFile(classesFileName,existingClasses);
    }
    catch (IOException e)
    {
      e.printStackTrace();
      System.out.println("IO removeClass error");
    }
    System.out.println("Successfully removed class " + gymClass.getName());
  }
  /**
   * A method that returns all the classes from the binary file
   * @return an ArrayList of all the classes
   */
  public ArrayList<GymClass> getAllClasses()
  {
    ArrayList<GymClass> classArrayList = new ArrayList<>();
    try
    {
      if(((ArrayList<GymClass>)myFile.readObjectFromFile(classesFileName)) != null)
      classArrayList = (ArrayList<GymClass>)myFile.readObjectFromFile(classesFileName);
    }
    catch (IOException e)
    {
      e.printStackTrace();
      System.out.println("IO error in getAllClasses");
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return classArrayList;
  }

  /**
   * A method that saves a member to the binary file by getting the full list of already existing ones,
   * adding it into the list and then re-writing it to the file
   * @param member the member that needs to be saved
   */
  public void saveMember(Member member)
  {
    ArrayList<Member> existingMembers = new ArrayList<>();
    if(getAllMembers() != null)
      existingMembers = getAllMembers();
    existingMembers.add(member);
    try{
      myFile.writeToFile(memberFileName,existingMembers);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      e.printStackTrace();
      System.out.println("IO error in saveMember");
    }
  }
  /**
   * A method that removes a certain member from the file
   * @param member the member that needs to be removed
   */
  public void removeMember(Member member)
  {
    ArrayList<Member> existingMembers = getAllMembers();
    for(int i=0;i<existingMembers.size();i++)
    {
      if(existingMembers.get(i).equals(member))
        existingMembers.remove(member);
    }
    try{
      myFile.writeToFile(memberFileName,existingMembers);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      e.printStackTrace();
      System.out.println("IO error in removeMember");
    }
  }
  /**
   * A method that gets all of the members from the binary file
   * @return an ArrayList that contains all of the members
   */
  public ArrayList<Member> getAllMembers()
  {
    ArrayList<Member> existingMembers = new ArrayList<>();
    try
    {
      if((myFile.readObjectFromFile(memberFileName)) != null)
        existingMembers = (ArrayList<Member>)myFile.readObjectFromFile(memberFileName);
    }
    catch (IOException e)
    {
      e.printStackTrace();
      System.out.println("IO error in getAllMembers");
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return existingMembers;
  }
}

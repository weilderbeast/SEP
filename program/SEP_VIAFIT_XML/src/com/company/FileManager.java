package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FileManager implements Serializable
{
  private MyFileIO myFile;
  private String memberFileName = "src\\com\\company\\members.bin";
  private String instructorFileName = "src\\com\\company\\instructors.bin";
  private String classesFileName= "src\\com\\company\\classes.bin";

  public FileManager()
  {
    myFile = new MyFileIO();
  }

  //Instructors part
  public void saveInstructor(Object object)
  {
    ArrayList<Instructor> existingInstructors = getAllInstructors();
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
  public void removeAllFromInstructorFile()
  {
    ArrayList<Instructor> existingInstructors = getAllInstructors();
    for(int i=0;i<existingInstructors.size();i++)
    {
      existingInstructors.remove(i);
    }
    existingInstructors = new ArrayList<>();
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


  //classes part
  public void saveClass(GymClass object)
  {
    ArrayList<GymClass> existingClasses = getAllClasses();
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
  public void saveClass(GymClass object,int index)
  {
    ArrayList<GymClass> existingClasses = getAllClasses();
    existingClasses.set(index,object);

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
  public void removeClasses(GymClass gymClass)
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
      System.out.println("removeClass error");
    }
    System.out.println("Successfully removed class " + gymClass.getName());
  }
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

  //members part
  public void saveMember(Member member)
  {
    ArrayList<Member> existingMembers = getAllMembers();
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

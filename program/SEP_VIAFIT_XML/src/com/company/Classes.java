package com.company;

public class Classes
{
  private String className;
  private int classSize;
  public Classes(String className , int classSize)
  {
    this.className = className;
    this.classSize = classSize;
  }

  public String toString()
  {
    return "Class Name: " + className + "\nClass Size: " + classSize;
  }
}

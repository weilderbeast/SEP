package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MemberHandler
{
  private FileManager fileManager;
  public MemberHandler()
  {
    fileManager = new FileManager();
  }
  public void addMember(Member member)
  {
    fileManager.saveMember(member);
  }
  public void removeMember(Member member)
  {
    fileManager.removeMember(member);
  }
  public ArrayList<Member> getAllMembersFromFile()
  {
    return fileManager.getAllMembers();
  }
  public int getIndexOf(Member member)
  {
    ArrayList<Member> currentMembers = getAllMembersFromFile();
    for(int i=0;i<currentMembers.size();i++)
    {
      System.out.println("Checking for :"+member);
      System.out.println("Against : "+currentMembers.get(i));
      if(currentMembers.get(i).equals(member))
      {
        return i;
      }
    }
    return -1;
  }
  public boolean checkForAdding(Member member)
  {
    ArrayList<Member> currentMembers = getAllMembersFromFile();
    for(int i=0;i<currentMembers.size();i++)
    {
      if(currentMembers.get(i).getLastName().equals(member.getLastName()))
      {
        System.out.println("last name check false");
        return false;
      }
      if(currentMembers.get(i).getEmail().equals(member.getEmail()))
      {
        System.out.println("email check false");
        return false;
      }
      if(currentMembers.get(i).getPhoneNumber().equals(member.getPhoneNumber()))
      {
        System.out.println("phone number check false");
        return false;
      }
    }
    System.out.println("passed all checks");
    return true;
  }

  public Member searchMemberByName(String firstName, String lastName)
  {
    ArrayList<Member> currentMembers = getAllMembersFromFile();
    for(int i=0;i<currentMembers.size();i++)
    {
      if(currentMembers.get(i).getFirstName().equals(firstName)
          &&currentMembers.get(i).getLastName().equals(lastName))
      {
        System.out.println("found member :"+ currentMembers.get(i).getFullName());
        return currentMembers.get(i);
      }
    }
    System.out.println("found no member with specified name");
    return null;
  }
  public Member searchMemberByPhoneNumber(String phoneNumber)
  {
    ArrayList<Member> currentMembers = getAllMembersFromFile();
    for(int i=0;i<currentMembers.size();i++)
    {
      if(currentMembers.get(i).getPhoneNumber().equals(phoneNumber))
      {
        System.out.println("found member: "+currentMembers.get(i).getFullName());
        return currentMembers.get(i);
      }
    }
    System.out.println("found no member with specified phone number");
    return null;
  }

  public boolean checkForEditing(Member member,int index)
  {
    ArrayList<Member> currentMembers = getAllMembersFromFile();
    for(int i=0;i<currentMembers.size();i++)
    {
      if(i != index)
      {
        if(currentMembers.get(i).getLastName().equals(member.getLastName()))
        {
          System.out.println("last name check false");
          return false;
        }
        if(currentMembers.get(i).getEmail().equals(member.getEmail()))
        {
          System.out.println("email check false");
          return false;
        }
        if(currentMembers.get(i).getPhoneNumber().equals(member.getPhoneNumber()))
        {
          System.out.println("phone number check false");
          return false;
        }
      }
    }
    System.out.println("passed all checks");
    return true;
  }
}

package com.company;

import java.util.ArrayList;

/**
 * Member handler, used to communicate with the file manager
 * @author Satish Gurung
 * @author Cirstoiu Bogdan
 */
public class MemberHandler
{
  private FileManager fileManager;

  /**
   * No argument constructor to initialize the file manager
   */
  public MemberHandler()
  {
    fileManager = new FileManager();
  }

  /**
   * Method used for adding a member using the file manager
   * @param member
   */
  public void addMember(Member member)
  {
    fileManager.saveMember(member);
  }

  /**
   * Method used for removing a member using the file manager
   * @param member
   */
  public void removeMember(Member member)
  {
    fileManager.removeMember(member);
  }

  /**
   * Method used to get all the members from the file using the file manager
   * @return an array list of all members
   */
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

  /**
   * Method used for checking if adding the specified member to the list would result in any conflicts.
   * @param member
   * @return if there are no conflicts, return true, if there are conflicts, return false
   */
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

  /**
   * Method used to search a member by his/hers full name
   * @param firstName
   * @param lastName
   * @return if that member exists, return that member, otherwise return null
   */
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

  /**
   * Method used to search a member by phone number.
   * @param phoneNumber
   * @return if there's a member with that phone number, return that member, otherwise return null
   */
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

  /**
   * A method that checks if editing a member would result in any conflicts with the current members, by comparing each one with the
   * edited one, and using it's index to skip it when comparing, so we don't get a false negative
   * @param member
   * @param index
   * @return
   */
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

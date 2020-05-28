package com.company;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.rmi.activation.ActivationID;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class JavaFXGUIController
{
  //Main layout
  @FXML private AnchorPane homePane;
  @FXML private AnchorPane classesPane;
  @FXML private AnchorPane membersPane;
  @FXML private AnchorPane instructorsPane;
  @FXML private Button homeButton;
  @FXML private Button classesButton;
  @FXML private Button membersButton;
  @FXML private Button instructorsButton;

  //Instructor panes, buttons, text fields and list views
  @FXML private AnchorPane editInstructorPane;
  @FXML private AnchorPane registerInstructorPane;
  @FXML private AnchorPane allInstructorsPane;
  @FXML private AnchorPane searchInstructorByNamePane;
  @FXML private AnchorPane searchInstructorByPhoneNumberPane;
  @FXML private AnchorPane searchResult;
  @FXML private AnchorPane editSelectedInstructor;
  @FXML private AnchorPane instructorsMain;
  @FXML private AnchorPane searchInstructorBy;
  @FXML private Button editInstructor;
  @FXML private Button registerInstructor;
  @FXML private Button allInstructors;
  @FXML private Button searchInstructorByName;
  @FXML private Button searchInstructorByPhoneNumber;
  @FXML private Button addInstructor;
  @FXML private Button searchInstructorByNameButton;
  @FXML private Button SearchInstructorByPhoneNumberButton;
  @FXML private Button editInstructorButton;
  @FXML private Button removeInstructorButton;
  @FXML private Button refreshList;
  @FXML private Button saveChangesInstructor;
  @FXML private TextField searchInstructorName;
  @FXML private TextField searchInstructorLastName;
  @FXML private TextField searchInstructorPhoneNumber;
  @FXML private TextField instructorNameField;
  @FXML private TextField instructorLastNameField;
  @FXML private TextField instructorAddressField;
  @FXML private TextField instructorPhNrField;
  @FXML private TextField instructorEmailField;
  @FXML private TextField newName;
  @FXML private TextField newLastName;
  @FXML private TextField newEmail;
  @FXML private TextField newAddress;
  @FXML private TextField newPhNumber;
  @FXML private ListView searchResultList;
  @FXML private ListView fullInstructorList;
  @FXML private ListView currentInstructorData;


  //Classes
  @FXML private Button viewAllClasses;
  @FXML private Button editClass;
  @FXML private Button createClass;
  @FXML private Button refreshClasses;
  @FXML private Button removeAllClasses;
  @FXML private Button searchClassesByName;
  @FXML private Button searchClassesByNameButton;
  @FXML private Button editClassButton;
  @FXML private Button removeCLassButton;
  @FXML private Button saveChangesClass;
  @FXML private Button saveClass;
  @FXML private AnchorPane classesMain;
  @FXML private AnchorPane viewAllClassesPane;
  @FXML private AnchorPane searchClassesPane;
  @FXML private AnchorPane searchClassesByNamePane;
  @FXML private AnchorPane classesSearchResultPane;
  @FXML private AnchorPane editClassPane;
  @FXML private AnchorPane createClassPane;
  @FXML private AnchorPane classesMainSearch;
  @FXML private ListView allClassesList;
  @FXML private ListView classSearchResult;
  @FXML private ListView classEditResult;
  @FXML private TextField className1;
  @FXML private TextField className;
  @FXML private TextField classStartHour;
  @FXML private TextField classStartMinute;
  @FXML private TextField classEndHour;
  @FXML private TextField classEndMinute;
  @FXML private TextField classSpots;
  @FXML private TextField classAvailableSpots;
  @FXML private TextField newClassName;
  @FXML private TextField newClassStartHour;
  @FXML private TextField newClassStartMinute;
  @FXML private TextField newClassEndHour;
  @FXML private TextField newClassEndMinute;
  @FXML private TextField newClassSpots;
  @FXML private TextField newClassAvailableSpots;
  @FXML private TextField newClassInstructor;
  @FXML private DatePicker classDate1;
  @FXML private DatePicker classDate;
  @FXML private DatePicker newClassDate;


  @FXML private AnchorPane mainMembersPane;
  @FXML private AnchorPane allMembersPane;
  @FXML private AnchorPane editMembersPane;
  @FXML private AnchorPane registerMembersPane;
  @FXML private AnchorPane searchMembersPane;
  @FXML private AnchorPane searchMemberByNamePane;
  @FXML private AnchorPane searchMemberByPhoneNumberPane;
  @FXML private AnchorPane memberSearchResultPane;
  @FXML private AnchorPane editSelectedMemberPane;

  @FXML private Button viewMembers;
  @FXML private Button registerMember;
  @FXML private Button searchMembers;
  @FXML private Button refreshAllMembersList;
  @FXML private Button removeAllMembers;
  @FXML private Button registerMemberButton;
  @FXML private Button searchMemberByName;
  @FXML private Button searchMemberByPhone;
  @FXML private Button searchMemberByNameButton;
  @FXML private Button searchMemberByPhoneButton;
  @FXML private Button editMember;
  @FXML private Button removeMember;
  @FXML private Button saveMember;

  @FXML private TextField memberName;
  @FXML private TextField memberLastName;
  @FXML private TextField memberEmail;
  @FXML private TextField memberAddress;
  @FXML private TextField memberPhoneNumber;
  @FXML private TextField newMemberName;
  @FXML private TextField newMemberLastName;
  @FXML private TextField newMemberEmail;
  @FXML private TextField newMemberAddress;
  @FXML private TextField newMemberPhoneNumber;
  @FXML private TextField memberSearchName;
  @FXML private TextField memberSearchLastName;
  @FXML private TextField memberSearchPhoneNumber;

  @FXML private ListView allMembersList;
  @FXML private ListView memberSearchResultList;
  @FXML private ListView memberEditList;

  @FXML private RadioButton premium;
  @FXML private RadioButton basic;

  @FXML private RadioButton newPremium;
  @FXML private RadioButton newBasic;

  @FXML private Button export;

  @FXML private TextField classInstructor;

  @FXML private TextField classSearchTimeHour;
  @FXML private TextField classSearchTimeMinute;

  Instructor placeHolderInstructor;
  Member placeHolderMember;
  GymClass placeHolderClass;


  Member memberSource;
  public void membersHandle(ActionEvent e){

    //member handler, contains all the methods needed to write to and from the file
    MemberHandler memberHandler = new MemberHandler();
    if(e.getSource() == viewMembers)
    {
      //switching layout
      allMembersPane.setVisible(true);
      registerMembersPane.setVisible(false);
      editMembersPane.setVisible(false);

      //getting the list ready
      allMembersList.getItems().clear();

      //trying to update the list if there are members
      //if not, do nothing, avoids "EOf" exception
      ArrayList<Member> allMembers = new ArrayList<>();
      if(memberHandler.getAllMembersFromFile() != null)
      {
        //get all members from the file
        allMembers = memberHandler.getAllMembersFromFile();
        //adding them to the list
        for(int i=0;i<allMembers.size();i++)
        {
          allMembersList.getItems().add(allMembers.get(i));
        }
      }
      else{
        System.out.println("member list empty. did not update.");
      }
    }
    //the refresh button, has the exact same functionality as the code above
    if(e.getSource() == refreshAllMembersList)
    {
      allMembersList.getItems().clear();
      ArrayList<Member> allMembers = new ArrayList<>();
      if(memberHandler.getAllMembersFromFile() != null)
      {
        allMembers = memberHandler.getAllMembersFromFile();
        for(int i=0;i<allMembers.size();i++)
        {
          allMembersList.getItems().add(allMembers.get(i));
        }
      }
      else{
        System.out.println("member list empty. did not update.");
      }
    }

    //switching layout to the register member pane
    if(e.getSource() == registerMember)
    {
      registerMembersPane.setVisible(true);
      allMembersPane.setVisible(false);
      editMembersPane.setVisible(false);
      premium.setSelected(false);
      basic.setSelected(true);
    }

    //logic for adding a member to the list
    if(e.getSource() == registerMemberButton)
    {
      //boolean to get the type of subscription
      //true = premium, false = basic
      boolean hasPremium = false;
      if(premium.isSelected()) {hasPremium = true;basic.setSelected(false);}
      else{premium.setSelected(false);basic.setSelected(true);}

      //checking if the fields aren't empty
      if(
          memberName.getText() != null &&
          memberLastName.getText() != null &&
          memberEmail.getText() != null &&
          memberAddress.getText() != null &&
          memberPhoneNumber.getText() != null
      )
      {
        //creating a temporary new member
        memberSource = new Member(
            memberName.getText(),
            memberLastName.getText(),
            memberAddress.getText(),
            memberEmail.getText(),
            memberPhoneNumber.getText(),
            hasPremium);

        //checking the temp new member for conflicts in the file
        if(memberHandler.checkForAdding(memberSource))
        {
          //succeeded, passed all checks, it is added to the file
          memberHandler.addMember(memberSource);

          //clearing all the fields so they're ready for the next time they have to be used
          memberName.clear();
          memberLastName.clear();
          memberEmail.clear();
          memberAddress.clear();
          memberPhoneNumber.clear();
          premium.setSelected(false);
          basic.setSelected(true);

          //confirmation alert for the user
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
          alert.setTitle("Operation complete");
          alert.setHeaderText("Member added to the list.");
          alert.setContentText("You can close this window now.");

          //console confirmation for debugging
          System.out.println("Successfully added "+memberSource.getFullName()+" to the list.");
        }
        else{
          //console log for debugging
          System.out.println("Member already exists with the specified info.");

          //alert message that tells the user the inputted data is conflicting
          Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setTitle("Operation failed");
          alert.setHeaderText("There is already a member with this info in the system.");
          alert.setContentText("Please try again.");
        }
      }
      else{
        System.out.println("Not all fields have been completed.");

        //alert for the user that some fields are empty
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Operation failed");
        alert.setHeaderText("Not all fields have been completed.");
        alert.setContentText("Please try again.");
      }
    }

    //switching layout to search members pane
    if(e.getSource() == searchMembers)
    {
      editMembersPane.setVisible(true);
      searchMembersPane.setVisible(true);
      allMembersPane.setVisible(false);
      editSelectedMemberPane.setVisible(false);
      memberSearchResultPane.setVisible(false);
      searchMemberByPhoneNumberPane.setVisible(false);
      searchMemberByNamePane.setVisible(false);
    }

    //switching layout to the search by name pane
    if(e.getSource() == searchMemberByName)
    {
      searchMemberByNamePane.setVisible(true);
      searchMemberByPhoneNumberPane.setVisible(false);
      editSelectedMemberPane.setVisible(false);
      memberSearchResultPane.setVisible(false);
    }

    //switching layout to the search by phone number pane
    if(e.getSource() == searchMemberByPhone)
    {
      searchMemberByPhoneNumberPane.setVisible(true);
      memberSearchResultPane.setVisible(false);
      searchMemberByNamePane.setVisible(false);
      editSelectedMemberPane.setVisible(false);
    }

    //logic for searching by name
    if(e.getSource() == searchMemberByNameButton)
    {
      //creating a temp member
      memberSource = memberHandler.searchMemberByName(memberSearchName.getText(),memberSearchLastName.getText());

      //checking if it exists
      if(memberSource != null)
      {
        //switching layout to the search result layout
        memberSearchResultPane.setVisible(true);
        searchMemberByNamePane.setVisible(false);
        editSelectedMemberPane.setVisible(false);

        //clearing the search result list
        memberSearchResultList.getItems().clear();

        //adding the search result to the list
        memberSearchResultList.getItems().add(memberSource);
      }
      else{
        //alert that there is no such member in the system
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Operation failed");
        alert.setHeaderText("There is no member with this name in the system.");
        alert.setContentText("Please try again.");
        memberSearchResultList.getItems().clear();
      }
    }

    //logic for searching by phone number
    if(e.getSource() == searchMemberByPhoneButton)
    {
      //creating a temp member
      memberSource = memberHandler.searchMemberByPhoneNumber(memberSearchPhoneNumber.getText());

      //checking if it exists
      if(memberSource != null)
      {
        //switching to the search result layout
        memberSearchResultPane.setVisible(true);
        editSelectedMemberPane.setVisible(false);
        searchMemberByPhoneNumberPane.setVisible(false);

        //clear the search result list
        memberSearchResultList.getItems().clear();

        //adding the result to the search result list
        memberSearchResultList.getItems().add(memberSource);
      }
      else{
        //alert if there is no such member
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Operation failed");
        alert.setHeaderText("There is no member with this phone number in the system.");
        alert.setContentText("Please try again.");
        memberSearchResultList.getItems().clear();
      }
    }

    //switching layout to the edit member layout
    if(e.getSource() == editMember)
    {
      editSelectedMemberPane.setVisible(true);
      memberSearchResultPane.setVisible(false);
      searchMemberByPhoneNumberPane.setVisible(false);
      searchMemberByNamePane.setVisible(false);

      //displaying the search result
      memberEditList.getItems().clear();
      memberEditList.getItems().add(memberSource);

      newBasic.setSelected(true);
      newPremium.setSelected(false);
    }

    //logic for editing a member
    if(e.getSource() == saveMember)
    {
      //boolean to check for type of subscription
      boolean hasPremium=false;

      //getting the index of the member we want to edit
      int index = memberHandler.getIndexOf(memberSource);

      //checking for premium subscription
      if(newPremium.isSelected()) hasPremium=true;

      //checking the fields aren't null
      if(
          newMemberName.getText() != null &&
          newMemberLastName.getText() != null &&
          newMemberEmail.getText() != null &&
          newMemberPhoneNumber.getText() != null &&
          newMemberAddress.getText() != null
      )
      {
        //creating a temp member with the data from the fields
        Member newMember = new Member(
            newMemberName.getText(),
            newMemberLastName.getText(),
            newMemberAddress.getText(),
            newMemberEmail.getText(),
            newMemberPhoneNumber.getText(),
            hasPremium);

        //checking for conflicts with the current data
        if(memberHandler.checkForEditing(newMember,index))
        {
          //removing the current member
          memberHandler.removeMember(memberSource);

          //adding the edited version
          memberHandler.addMember(newMember);

          //console log for debugging
          System.out.println("editing member complete.");

          //alert for the user that everything went fine
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
          alert.setTitle("Operation completed");
          alert.setHeaderText("The member has been updated.");
          alert.setContentText("You can close this window now.");

          //updating the search result list so that when you're done, you can see the changes immediately
          memberSearchResultList.getItems().clear();
          memberSearchResultList.getItems().add(newMember);
        }
        else{
          //console log for debugging
          System.out.println("conflicting member data");

          //alert for the user if the data is conflicting
          Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setTitle("Operation failed");
          alert.setHeaderText("The info you typed already exists on another member.");
          alert.setContentText("Please try again.");
          memberSearchResultList.getItems().clear();
        }
      }
      else{
        //console log for debugging
        System.out.println("some fields are empty");

        //alert for the user if some fields are empty
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Operation failed");
        alert.setHeaderText("Some of the fields are empty.");
        alert.setContentText("Please try again.");
        memberSearchResultList.getItems().clear();
      }
    }

    //switching to the add member to class pane
    //not working
    /*
    if(e.getSource() == bookMemberToClass)
    {
      addMemberToClassPane.setVisible(true);
      registerMembersPane.setVisible(false);

      //getting all classes for displaying in the list when adding
      addMemberToClassList.getItems().clear();
      ClassesHandler classesHandler = new ClassesHandler();
      ArrayList<GymClass> allClasses = classesHandler.getAllFromFile();
      if(!(allClasses.isEmpty()))
        for(int i=0;i<allClasses.size();i++)
        {
          addMemberToClassList.getItems().add(allClasses.get(i));
        }
      else{
        //console log for debugging
        System.out.println("classes list empty. did not update.");

        //should add alert that list is empty, and that there's no class to book to, and send you back
      }
    }
     */

    //not properly working
    /*
    if(e.getSource() == addMemberToClass)
    {
      //class handler
      ClassesHandler classesHandler = new ClassesHandler();

      //checking subscription type
      boolean hasPremium=false;
      if(newPremium.isSelected()) hasPremium=true;

      memberSource = new Member(
          memberName.getText(),
          memberLastName.getText(),
          memberAddress.getText(),
          memberEmail.getText(),
          memberPhoneNumber.getText(),
          hasPremium);
      //problem : the classList is not updating
      //solution : ? no fucking idea
      //the constructor makes the list void, and then you have to update it
      //why is it still blank?
      //also the class spots don't go down when you book a member // you need to re-write the class in the file
      LocalDate localDate = memberClassDate.getValue();
      Date neededDate = new Date(localDate.getDayOfMonth(),localDate.getMonthValue(),localDate.getYear());
      Time time = new Time(Integer.parseInt(memberClassStartHour.getText()),Integer.parseInt(memberClassStartMinute.getText()));
      if(
          memberClassName.getText() != null &&
              memberClassDate.getValue() != null &&
              memberClassStartHour.getText() != null &&
              memberClassStartMinute.getText() != null
      )
      {
        GymClass temp = classesHandler.getClassByName(memberClassName.getText(),neededDate,time);
        if(temp != null
            && temp.getAvailableSpots()>0)
        {
          int index = classesHandler.getIndexOf(temp);
          memberSource.bookTo(temp);
          temp.removeOneSpot();
          System.out.println("index: "+ index);
          classesHandler.addClass(temp,index);
          System.out.println("booked "+memberName.getText()+" to the class "+temp.getName());
          addMemberToClassPane.setVisible(false);
          registerMembersPane.setVisible(true);
          mainMembersPane.setVisible(true);
        }
        else{
          System.out.println("did not find specified class");
        }
      }
      else{
        System.out.println("some fields are empty");
      }
    }
     */
    /*
    if(e.getSource() == editBookings)
    {
      editBookingsPane.setVisible(true);
      editSelectedMemberPane.setVisible(false);
      allBookingsList.getItems().clear();
      ArrayList<GymClass> currentBookings;
      if(!(memberSource.getBookings().isEmpty()))
      {
        currentBookings = memberSource.getBookings();
        System.out.println("got to here");
        System.out.println("current bookings: "+currentBookings);
        for(int i=0;i<currentBookings.size();i++)
        {
          allBookingsList.getItems().add(currentBookings.get(i));
        }
      }
      else{
        System.out.println("no current bookings, did not update list");
      }
    }
    */
    /*
    if(e.getSource() == removeBooking)
    {
      editCurrentBookingsPane.setVisible(true);
      editBookingsPane.setVisible(false);
    }
    */
    /*
    if(e.getSource() == removeSelectedBooking)
    {
      if(
          removeBookingDate.getValue() != null &&
          removeBookingName.getText() != null &&
          removeBookingStartHour.getText() != null  &&
          removeBookingStartMinute.getText() != null
      )
      {
        ArrayList<GymClass> currentBookings = new ArrayList<>();
        //currentBookings = memberSource.getBookings();

        LocalDate localDate = removeBookingDate.getValue();
        Date neededDate = new Date(localDate.getDayOfMonth(),localDate.getMonthValue(),localDate.getYear());
        Time time = new Time(Integer.parseInt(removeBookingStartHour.getText()),Integer.parseInt(removeBookingStartMinute.getText()));

        for(int i=0;i<currentBookings.size();i++)
        {
          if(currentBookings.get(i).getName().equals(removeBookingName.getText()) &&
              currentBookings.get(i).getDate().equals(neededDate) &&
                currentBookings.get(i).equals(time))
          {
            currentBookings.remove(i);
            //memberSource.updateBookings(currentBookings);
            currentBookingsList.getItems().remove(currentBookings.get(i));
            currentBookingsList.refresh();
            System.out.println("removed booking");
            removeBookingName.clear();
            removeBookingStartHour.clear();
            removeBookingStartMinute.clear();
          }
        }
      }
      else{
        System.out.println("some fields are empty");
      }
    }*/

    if(e.getSource() == removeMember)
    {
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Warning");
      alert.setHeaderText("Are you sure you want to remove the selected member?");
      alert.setContentText("This cannot be undone.");

      Optional<ButtonType> result = alert.showAndWait();
      if (result.get() == ButtonType.OK){
        memberHandler.removeMember(memberSource);
        alert.close();
        editMembersPane.setVisible(false);
        allMembersPane.setVisible(true);
        allMembersList.getItems().clear();
        ArrayList<Member> allMembers= memberHandler.getAllMembersFromFile();
        for(int i=0;i<allMembers.size();i++)
        {
          allMembersList.getItems().add(allMembers.get(i));
        }
      } else {
        alert.close();
      }
    }

    }







  GymClass classSource;
  public void classesHandle(ActionEvent e){
    ClassesHandler classesHandler = new ClassesHandler();

    if(e.getSource() == export)
    {
      ComponentHandling componentHandler = new ComponentHandling();
      ArrayList<GymClass> allClasses = classesHandler.getAllFromFile();
      for(int i=0;i<allClasses.size();i++)
      {
        componentHandler.createClassElement(allClasses.get(i));
        componentHandler.Finalizer();
      }
    }

    /*
    if(e.getSource() == addInstructorToClass)
    {
      addInstructorToClassPane.setVisible(true);
      createClassPane.setVisible(false);

      InstructorHandler instructorHandler = new InstructorHandler();
      ArrayList<Instructor> allInstructorsList;
      if(instructorHandler.getAllFromFile() != null)
      {
        allInstructorsList = instructorHandler.getAllFromFile();
        allAvailableInstructors.getItems().clear();
        for(int i=0;i<allInstructorsList.size();i++)
        {
          allAvailableInstructors.getItems().add(allInstructorsList.get(i));
        }
      }
      else{
        System.out.println("no instructors currently");
      }
    }
    if(e.getSource() == saveInstructorToClass)
    {
      InstructorHandler instructorHandler = new InstructorHandler();
      Instructor instructor = instructorHandler.getInstructorByName(addInstructorToClassName.getText(),addInstructorToClassLastName.getText());
      if(instructor != null)
      {
        //creating prerequisites for the new class
        LocalDate localDate = classDate.getValue();
        Date neededDate = new Date(localDate.getDayOfMonth(),localDate.getMonthValue(),localDate.getYear());
        Time time = new Time(Integer.parseInt(classStartHour.getText()),Integer.parseInt(classStartMinute.getText()));
        Time endTime = new Time(Integer.parseInt(classEndHour.getText()),Integer.parseInt(classEndMinute.getText()));

        classSource = new GymClass(
            className.getText(),time,endTime,neededDate,Integer.parseInt(classSpots.getText()),Integer.parseInt(classAvailableSpots.getText())
        );
        //checking for conflicting data
        if(classesHandler.checkForAdding(classSource))
        {
          //adding the data to the file
          classesHandler.addClass(classSource);
          //console confirmation
          System.out.println("Added class "+classSource.getName()+" with the instructor "+instructor);

          //clearing all the fields so they're ready the next time you want to use them
          className.clear();
          classStartHour.clear();
          classStartMinute.clear();
          classEndHour.clear();
          classEndMinute.clear();
          classSpots.clear();
          classAvailableSpots.clear();

          //switching the panes to the viewAllClasses pane
          createClassPane.setVisible(false);
          addInstructorToClassPane.setVisible(false);
          viewAllClassesPane.setVisible(true);

          //clearing the list so it's ready for the update
          allClassesList.getItems().clear();

          //updating the listView to display the new data
          ArrayList<GymClass> classesList = classesHandler.getAllFromFile();
          for(int i=0;i<classesList.size();i++)
          {
            allClassesList.getItems().add(classesList.get(i));
          }

          //little console confirmation message
          System.out.println("Showing all classes done");
        }
        else
        {
          //alerting if the data is conflicting
          Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setTitle("Warning");
          alert.setContentText("There is already a class at that time and date.");
          alert.setHeaderText("Please try again.");
          alert.showAndWait();
        }

      }
    }*/

    if(e.getSource() == classesButton)
    {
      classesPane.setVisible(true);
      classesMain.setVisible(true);
      viewAllClassesPane.setVisible(true);
      classesMainSearch.setVisible(false);
      createClassPane.setVisible(false);
      membersPane.setVisible(false);

      allClassesList.getItems().clear();
      ArrayList<GymClass> allClasses;
      if(classesHandler.getAllFromFile() != null)
      {
        allClasses = classesHandler.getAllFromFile();
        for(int i=0;i<allClasses.size();i++)
        {
          allClassesList.getItems().add(allClasses.get(i));
        }
        System.out.println("Showing all classes done");
      }
      else{
        System.out.println("No classes to show");
      }

    }
    if(e.getSource() == viewAllClasses)
    {
      viewAllClassesPane.setVisible(true);
      createClassPane.setVisible(false);
      classesMainSearch.setVisible(false);

      allClassesList.getItems().clear();
      ArrayList<GymClass> classesList = classesHandler.getAllFromFile();
      for(int i=0;i<classesList.size();i++)
      {
        allClassesList.getItems().add(classesList.get(i));
      }
      System.out.println("Showing all classes done");

    }
    if(e.getSource() == editClass)
    {
      classesMainSearch.setVisible(true);
      searchClassesPane.setVisible(true);
      editClassPane.setVisible(false);
      createClassPane.setVisible(false);
      viewAllClassesPane.setVisible(false);
      searchClassesByNamePane.setVisible(false);
      viewAllClassesPane.setVisible(false);
      classesSearchResultPane.setVisible(false);
    }
    if(e.getSource() == createClass)
    {
      createClassPane.setVisible(true);
      editClassPane.setVisible(false);
      viewAllClassesPane.setVisible(false);
      classesMainSearch.setVisible(false);
      className.clear();
      classStartHour.clear();
      classStartMinute.clear();
      classEndHour.clear();
      classEndMinute.clear();
      classSpots.clear();
      classAvailableSpots.clear();
    }
    if(e.getSource() == saveClass)
    {
      //checking that all fields are completed
      if(
          className.getText() != null &&
          classDate.getValue() != null &&
          classStartHour.getText() != null &&
          classStartMinute.getText() != null &&
          classEndHour.getText() != null &&
          classEndMinute.getText() != null &&
          classSpots.getText() != null &&
          classAvailableSpots.getText() != null &&
          classInstructor.getText() != null
      )
      {
        //creating prerequisites for the new class
        LocalDate localDate = classDate.getValue();
        Date neededDate = new Date(localDate.getDayOfMonth(),localDate.getMonthValue(),localDate.getYear());
        Time time = new Time(Integer.parseInt(classStartHour.getText()),Integer.parseInt(classStartMinute.getText()));
        Time endTime = new Time(Integer.parseInt(classEndHour.getText()),Integer.parseInt(classEndMinute.getText()));

        //creating the new class
        classSource = new GymClass(
          className.getText(),time,endTime,neededDate,classInstructor.getText(),Integer.parseInt(classSpots.getText()),Integer.parseInt(classAvailableSpots.getText())
        );

        //checking for conflicting data
        if(classesHandler.checkForAdding(classSource))
        {
          //adding the data to the file
          classesHandler.addClass(classSource);

          //console confirmation
          System.out.println("Added class "+classSource.getName());

          //clearing all the fields so they're ready the next time you want to use them
          className.clear();
          classStartHour.clear();
          classStartMinute.clear();
          classEndHour.clear();
          classEndMinute.clear();
          classSpots.clear();
          classAvailableSpots.clear();
          classDate.setValue(null);

          //switching the panes to the viewAllClasses pane
          createClassPane.setVisible(false);
          viewAllClassesPane.setVisible(true);

          //clearing the list so it's ready for the update
          allClassesList.getItems().clear();

          //updating the listView to display the new data
          ArrayList<GymClass> classesList = classesHandler.getAllFromFile();
          for(int i=0;i<classesList.size();i++)
          {
            allClassesList.getItems().add(classesList.get(i));
          }

          //little console confirmation message
          System.out.println("Showing all classes done");
        }
        else
          {
            //alerting if the data is conflicting
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("There is already a class at that time and date.");
            alert.setHeaderText("Please try again.");
            alert.showAndWait();
          }
      }
      else
      {
        //alerting it any of the fields are empty
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setContentText("Empty fields.");
        alert.setHeaderText("Please fill in all the fields.");
        alert.showAndWait();
      }
    }
    if(e.getSource() == searchClassesByName)
    {
      searchClassesByNamePane.setVisible(true);
      classesSearchResultPane.setVisible(false);
      editClassPane.setVisible(false);
    }
    if(e.getSource() == searchClassesByNameButton)
    {
      LocalDate localDate = classDate1.getValue();
      Date neededDate = new Date(localDate.getDayOfMonth(),localDate.getMonthValue(),localDate.getYear());
      Time time = new Time(Integer.parseInt(classSearchTimeHour.getText()),Integer.parseInt(classSearchTimeMinute.getText()));
      if(classesHandler.getClassByName(className1.getText(),neededDate,time) != null)
      {
        classSource = classesHandler.getClassByName(className1.getText(),neededDate,time);
        classSearchResult.getItems().clear();
        classSearchResult.getItems().add(classSource);
        System.out.println("Search result: "+classSource.getName());
        searchClassesByNamePane.setVisible(false);
        classesSearchResultPane.setVisible(true);
        className1.clear();
        classSearchTimeHour.clear();
        classSearchTimeMinute.clear();
        classDate1.setValue(null);
      }
      else{
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setContentText("No class was found.");
        alert.setHeaderText("Please try again.");
        alert.showAndWait();
        className1.clear();
      }
    }

    if(e.getSource() == editClassButton)
    {
      editClassPane.setVisible(true);
      searchClassesByNamePane.setVisible(false);
      classesSearchResultPane.setVisible(false);
      classEditResult.getItems().clear();
      classEditResult.getItems().add(classSource);
    }
    if(e.getSource() == saveChangesClass)
    {
      //check the fields aren't null
      if(newClassName.getText() != null &&
          newClassDate.getValue() != null &&
          newClassStartHour.getText() != null &&
          newClassStartMinute.getText() != null &&
          newClassEndHour.getText() != null &&
          newClassEndMinute.getText() != null &&
          newClassSpots.getText() != null &&
          newClassAvailableSpots.getText() != null &&
          newClassInstructor.getText() != null
      )
      {
        //getting the index of the class we want to edit
        //so we can skip it when checking for conflicting data
        int index = classesHandler.getIndexOf(classSource);

        //creating prerequisites for the new class
        LocalDate localDate = newClassDate.getValue();
        Date neededDate = new Date(localDate.getDayOfMonth(),localDate.getMonthValue(),localDate.getYear());
        Time time = new Time(Integer.parseInt(newClassStartHour.getText()),Integer.parseInt(newClassStartMinute.getText()));
        Time endTime = new Time(Integer.parseInt(newClassEndHour.getText()),Integer.parseInt(newClassEndMinute.getText()));

        //creating the new class
        GymClass newClassSource = new GymClass(
            newClassName.getText(),
            time,
            endTime,
            neededDate,
            newClassInstructor.getText(),
            Integer.parseInt(newClassSpots.getText()),
            Integer.parseInt(newClassAvailableSpots.getText())
        );

          //checking if the data is conflicting
          if(classesHandler.checkForAdding(newClassSource))
          {
            //removing the old data
            classesHandler.removeClass(classSource);

            //adding the new data
            classesHandler.addClass(newClassSource);

            //console confirmation
            System.out.println("Class edited successfully");

            //clearing the fields so they're empty for the next time you want to edit something
            newClassName.clear();
            newClassStartHour.clear();
            newClassStartMinute.clear();
            newClassEndMinute.clear();
            newClassEndHour.clear();
            newClassSpots.clear();
            newClassAvailableSpots.clear();
            newClassInstructor.clear();
            newClassDate.setValue(null);
            classEditResult.getItems().clear();

            //clearing the allClassesList listView when changing from this pane to the one with all the classes
            allClassesList.getItems().clear();

            //refreshing the list with the new data
            ArrayList<GymClass> classesList = classesHandler.getAllFromFile();
            for(int i=0;i<classesList.size();i++)
            {
              allClassesList.getItems().add(classesList.get(i));
            }
            System.out.println("Showing all classes done");

            //switching panes
            classesMainSearch.setVisible(false);
            viewAllClassesPane.setVisible(true);
        }
        else
          {
            //alert if the data is conflicting
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("There is already a class with that info. Please try again.");
            alert.setHeaderText("Did not update.");
            alert.showAndWait();
          }
      }
      else{
        //alert if any of the fields are empty
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setContentText("Fields are empty.");
        alert.setHeaderText("Please fill all of the fields.");
        alert.showAndWait();
      }
    }

    if(e.getSource() == removeCLassButton)
    {
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Warning");
      alert.setHeaderText("Are you sure you want to remove the selected class?");
      alert.setContentText("This cannot be undone.");

      Optional<ButtonType> result = alert.showAndWait();
      if (result.get() == ButtonType.OK){
        classesHandler.removeClass(classSource);
        alert.close();
        editInstructorPane.setVisible(false);
        allInstructorsPane.setVisible(true);
        ArrayList<GymClass> allClasses = classesHandler.getAllFromFile();
        for(int i=0;i<allClasses.size();i++)
        {
          allClassesList.getItems().add(allClasses.get(i));
        }
      } else {
        alert.close();
      }
    }

  }



  //this holds the info when an instructor is searched for, safer option, minimizes the possibility of errors
  Instructor source;



  @FXML private AnchorPane InstructorToClassPane;
  @FXML private TextField instructorToClassName;
  @FXML private TextField instructorToClassStartHour;
  @FXML private TextField instructorToClassStartMinute;
  @FXML private DatePicker instructorToClassDate;
  @FXML private ListView allAvailableClasses;
  public void instructorHandle(ActionEvent e)
  {
    //initializing the handler for the instructors
    InstructorHandler instructorHandler = new InstructorHandler();

    if(e.getSource() == refreshList)
    {
      //checking if the list has stuff in it so we avoid a null pointer exception
      if(instructorHandler.getAllFromFile() != null)
      {
        //clearing the list so it's ready for refreshing
        fullInstructorList.getItems().clear();

        //refreshing the list
        ArrayList<Instructor> allInstructors = instructorHandler.getAllFromFile();
        for(int i=0;i<allInstructors.size();i++)
        {
          fullInstructorList.getItems().add(allInstructors.get(i));
        }
        System.out.println("Refreshing list complete");
      }
    }

    if(e.getSource() == addInstructor)
    {
      //checking all fields so none is blank
      if(
          instructorNameField.getText() != null &&
          instructorLastNameField.getText() != null &&
          instructorEmailField.getText() != null &&
          instructorAddressField.getText() != null &&
          instructorPhNrField.getText() !=null
      )
      {
        //creating a new instructor
        source = new Instructor(
          instructorNameField.getText(),
          instructorLastNameField.getText(),
          instructorAddressField.getText(),
          instructorEmailField.getText(),
          instructorPhNrField.getText()
          );
        //checking if data is conflicting
        if(instructorHandler.checkForAdding(source))
        {
          instructorHandler.addInstructor(source);

          //clearing the fields so they're empty next time you want to add another instructor
          instructorNameField.clear();
          instructorLastNameField.clear();
          instructorAddressField.clear();
          instructorEmailField.clear();
          instructorPhNrField.clear();

          //little console confirmation
          System.out.println("Saved instructor data.");
        }
        else{
          System.out.println("this data is conflicting with existing data");
        }
      }
      else{
        //alert in case the fields weren't filled properly or the data already exists
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setContentText("There is already an instructor with that info. Please try again.");
        alert.setHeaderText("Did not update.");
        alert.showAndWait();
      }
    }

    if(e.getSource() == searchInstructorByNameButton)
    {
      if(instructorHandler.getInstructorByName(searchInstructorName.getText(),searchInstructorLastName.getText()) != null)
      {
        source = instructorHandler.getInstructorByName(searchInstructorName.getText(),searchInstructorLastName.getText());
        searchResultList.getItems().add("Name: "+source.getFullName());
        searchResultList.getItems().add("Email: "+source.getEmail());
        searchResultList.getItems().add("Phone number: "+source.getPhoneNumber());
        searchResultList.getItems().add("Address: "+source.getAddress());
        searchInstructorName.clear();
        searchInstructorLastName.clear();
        searchInstructorByNamePane.setVisible(false);
        searchInstructorByPhoneNumberPane.setVisible(false);
        searchResult.setVisible(true);
        editSelectedInstructor.setVisible(false);
        System.out.println("Search result: "+source.getFullName());
      }
      else{
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setContentText("No instructor was found.");
        alert.setHeaderText("Please try again.");
        alert.showAndWait();
        searchInstructorName.clear();
        searchInstructorLastName.clear();
      }
    }
    if(e.getSource() == SearchInstructorByPhoneNumberButton)
    {
      if(instructorHandler.getInstructorByPhoneNumber(searchInstructorPhoneNumber.getText()) != null)
      {
        source = instructorHandler.getInstructorByPhoneNumber(searchInstructorPhoneNumber.getText());
        searchResultList.getItems().add("Name: "+source.getFullName());
        searchResultList.getItems().add("Email: "+source.getEmail());
        searchResultList.getItems().add("Phone number: "+source.getPhoneNumber());
        searchResultList.getItems().add("Address: "+source.getAddress());
        searchInstructorPhoneNumber.clear();
        searchInstructorByNamePane.setVisible(false);
        searchInstructorByPhoneNumberPane.setVisible(false);
        searchResult.setVisible(true);
        System.out.println("Search result: "+source.getFullName());
        editSelectedInstructor.setVisible(false);
      }
      else{
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setContentText("No instructor was found.");
        alert.setHeaderText("Please try again.");
        alert.showAndWait();
        searchInstructorPhoneNumber.clear();
      }
    }
    if(e.getSource() == removeInstructorButton)
    {
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Warning");
      alert.setHeaderText("Are you sure you want to remove the selected instructor?");
      alert.setContentText("This cannot be undone.");

      Optional<ButtonType> result = alert.showAndWait();
      if (result.get() == ButtonType.OK){
        instructorHandler.removeInstructor(source);
        alert.close();
        editInstructorPane.setVisible(false);
        allInstructorsPane.setVisible(true);
        ArrayList<Instructor> allInstructors = instructorHandler.getAllFromFile();
        for(int i=0;i<allInstructors.size();i++)
        {
          fullInstructorList.getItems().add(allInstructors.get(i));
        }
      } else {
        alert.close();
      }
    }
    if(e.getSource() == editInstructorButton)
    {
      editSelectedInstructor.setVisible(true);
      searchResult.setVisible(false);
      currentInstructorData.getItems().add("Name: "+source.getFullName());
      currentInstructorData.getItems().add("Email: "+source.getEmail());
      currentInstructorData.getItems().add("Phone number: "+source.getPhoneNumber());
      currentInstructorData.getItems().add("Address: "+source.getAddress());
    }
    if(e.getSource() == saveChangesInstructor)
    {
      //getting the index of the instructor we want to edit (aka the one we searched for)
      //so we skip it when checking for conflicting info
      int index = instructorHandler.getIndexOf(source);

      //checking that all fields have been completed
      if(
          newName.getText() != null &&
          newLastName.getText() !=null &&
          newAddress.getText() != null &&
          newEmail.getText() != null &&
          newPhNumber.getText() != null
      )
      {
        //creating the new instructor with the new data
        Instructor copy = new Instructor(
          newName.getText(),newLastName.getText(),newAddress.getText(),newEmail.getText(),newPhNumber.getText()
        );

        //checking for conflicting data
        if(instructorHandler.checkForEditing(copy,index))
        {
          //removing the old instructor
          instructorHandler.removeInstructor(source);

          //adding the new one
          instructorHandler.addInstructor(copy);
          //alert that confirms everything went fine
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
          alert.setTitle("Edit instructor data");
          alert.setContentText("Edit successful.");
          alert.showAndWait();

          //clearing the fields so they're ready next time you want to edit another instructor
          newName.clear();
          newLastName.clear();
          newAddress.clear();
          newEmail.clear();
          newPhNumber.clear();

          //switching panes to the allInstructors pane
          editSelectedInstructor.setVisible(false);
          allInstructorsPane.setVisible(true);

          //clearing the fullInstructorList listView so it's ready for refreshing
          fullInstructorList.getItems().clear();

          //this is done to refresh the fullInstructorList listView when switching back to the allInstructors pane.
          ArrayList<Instructor> allInstructors = instructorHandler.getAllFromFile();
          for(int i=0;i<allInstructors.size();i++)
          {
            fullInstructorList.getItems().add(allInstructors.get(i));
          }

          //little console confirmation
          System.out.println("Done editing the instructor.");
        }
        else
          {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("There is already an instructor with that info. Please try again.");
            alert.setHeaderText("Did not update.");
            alert.showAndWait();
          }
      }
      else{
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setContentText("Empty fields.");
        alert.setHeaderText("Please complete all fields.");
        alert.showAndWait();
      }
    }

  }

  public void handleClickMe(ActionEvent e)
  {
    if(e.getSource() == homeButton)
    {
      homePane.setVisible(true);

      classesPane.setVisible(false);
      membersPane.setVisible(false);
      instructorsPane.setVisible(false);
    }
    if(e.getSource() ==  membersButton)
    {
      membersPane.setVisible(true);
      mainMembersPane.setVisible(true);
      allMembersPane.setVisible(true);
      classesPane.setVisible(false);
      instructorsPane.setVisible(false);
      homePane.setVisible(false);
      registerMembersPane.setVisible(false);
      editMembersPane.setVisible(false);

      MemberHandler memberHandler = new MemberHandler();
      allMembersList.getItems().clear();
      ArrayList<Member> allMembers = memberHandler.getAllMembersFromFile();
      if(!(allMembers.isEmpty()))
        for(int i=0;i<allMembers.size();i++)
        {
          allMembersList.getItems().add(allMembers.get(i));
        }
      else{
        System.out.println("member list empty. did not update.");
      }
    }
    if(e.getSource() == instructorsButton)
    {
      instructorsPane.setVisible(true);
      instructorsMain.setVisible(true);
      allInstructorsPane.setVisible(true);

      InstructorHandler instructorHandler = new InstructorHandler();
      ArrayList<Instructor> allInstructors = instructorHandler.getAllFromFile();
      for(int i=0;i<allInstructors.size();i++)
      {
        fullInstructorList.getItems().add(allInstructors.get(i));
      }
      System.out.println("Refreshing list complete");

      classesPane.setVisible(false);
      membersPane.setVisible(false);
      homePane.setVisible(false);
    }


    if(e.getSource() == editInstructor)
    {
      editInstructorPane.setVisible(true);
      searchInstructorBy.setVisible(true);
      searchInstructorByNamePane.setVisible(false);
      searchInstructorByPhoneNumberPane.setVisible(false);
      searchResult.setVisible(false);
      registerInstructorPane.setVisible(false);
      allInstructorsPane.setVisible(false);
      editSelectedInstructor.setVisible(false);
    }
    if(e.getSource() == registerInstructor)
    {
      registerInstructorPane.setVisible(true);
      editInstructorPane.setVisible(false);
      allInstructorsPane.setVisible(false);
      editSelectedInstructor.setVisible(false);
    }
    if(e.getSource() == allInstructors)
    {
      allInstructorsPane.setVisible(true);
      registerInstructorPane.setVisible(false);
      editInstructorPane.setVisible(false);
      editSelectedInstructor.setVisible(false);
      fullInstructorList.getItems().clear();
      InstructorHandler instructorHandler = new InstructorHandler();
      ArrayList<Instructor> allInstructors = instructorHandler.getAllFromFile();
      for(int i=0;i<allInstructors.size();i++)
      {
        fullInstructorList.getItems().add(allInstructors.get(i));
      }
      System.out.println("Refreshing list complete");
    }

    if(e.getSource() == searchInstructorByName)
    {
      searchInstructorByNamePane.setVisible(true);
      searchInstructorByPhoneNumberPane.setVisible(false);
      searchResult.setVisible(false);
      editSelectedInstructor.setVisible(false);
      searchResultList.getItems().clear();
      currentInstructorData.getItems().clear();
    }
    if(e.getSource() == searchInstructorByPhoneNumber)
    {
      searchInstructorByNamePane.setVisible(false);
      searchInstructorByPhoneNumberPane.setVisible(true);
      searchResult.setVisible(false);
      editSelectedInstructor.setVisible(false);
      searchResultList.getItems().clear();
      currentInstructorData.getItems().clear();
    }
  }
  public void initialize()
  {
    homePane.setVisible(true);
    membersPane.setVisible(false);
    instructorsPane.setVisible(false);
    classesPane.setVisible(false);

    //
    searchResult.setVisible(false);
    allInstructorsPane.setVisible(false);
    instructorsMain.setVisible(false);
    registerInstructorPane.setVisible(false);
    editInstructorPane.setVisible(false);
  }
}

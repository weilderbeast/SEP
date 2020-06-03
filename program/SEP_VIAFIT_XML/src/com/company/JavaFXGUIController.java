package com.company;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/**
 * The main Controller class for the GUI, this chonky boi has so many lines, dang.
 * @author Cirstoiu Bogdan-Florin
 * @version 1.7
 *
 */

public class JavaFXGUIController
{
  /**
   * All of the declared fx id's needed for the layout, i tried grouping them together,
   * but since there's so many of them and i went through a bunch of iterations,
   * some of them are out of place (this is version 1.7).
   */
  //Main layout
  @FXML private AnchorPane homePane;
  @FXML private AnchorPane classesPane;
  @FXML private AnchorPane membersPane;
  @FXML private AnchorPane instructorsPane;
  @FXML private Button homeButton;
  @FXML private Button classesButton;
  @FXML private Button membersButton;
  @FXML private Button instructorsButton;


  @FXML private TextField currentDate;
  @FXML private TextField currentInstructors;
  @FXML private TextField currentClasses;
  @FXML private TextField currentMembers;
  @FXML private TextField currentTime;


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

  @FXML private Button removeAllInstructors;

  /**
   * @author Cirstoiu Bogdan-Florin
   * The method were all actions regarding a member take place. This includes
   * adding, editing, and removing members. It also handles the layout part of it.
   * The code is further documented using comments.
   */

  /**This variable holds the data of a member when it's either being added, edited,
   * or searched for
   */
  Member memberSource;
  public void membersHandle(ActionEvent e){

    /**
     * Member handler, contains all the methods needed to write to and from the file,
     * for more info see the MemberHandler.java class
     */
    MemberHandler memberHandler = new MemberHandler();

    /**
     * If statement that checks for input to switch to the "allMembersPane" pane.
     * It works by first switching the layout to the desired pane, hiding the other
     * ones, and then getting the list ready for input by clearing it, after which
     * the program checks if there is anything to read from the file to avoid errors,
     * when finally, if there's something to read, the items are added to the list, otherwise,
     * nothing happens.
     * @param viewMembers button
     */
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
      ArrayList<Member> allMembers;
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
    /**
     * The refresh button, used to refresh the allMembersList list,
     * in the allMembersPane.
     * It works by first clearing the list of any data, and then checking if there's anything
     * in the file, to avoid errors, after which, if there's any data in there, it will be
     * displayed in the list, otherwise, nothing will happen.
     * @param refreshAllMembersList
     */
    if(e.getSource() == refreshAllMembersList)
    {
      //clearing the list
      allMembersList.getItems().clear();

      //checking if there is anything to read from the file before trying to update
      //the list, avoids "EOf" exception and "NullPointer" exception
      ArrayList<Member> allMembers;
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

    /**
     * If statement used for switching layout to the register member pane.
     * It works by first making the pane visible, and hiding the other ones.
     */
    if(e.getSource() == registerMember)
    {
      registerMembersPane.setVisible(true);
      allMembersPane.setVisible(false);
      editMembersPane.setVisible(false);
      premium.setSelected(false);
      basic.setSelected(true);
    }

    /**
     * If statement used for adding a member to the list.
     * Although long, it contains basically everything needed within one statement.
     * It first checks for the type of subscription, either premium or basic.
     * It then checks to see if any of the input fields are null. If so, an alert window
     * will appear, notifying the user.
     * If none of the fields are null, a temporary user is being created, and then used to
     * check for conflicts using the ".checkForAdding()" method of the "memberHandler" variable.
     * For more information about that see the MemberHandler.java class.
     * If the inputted data already exists in the system, the program alerts the user with an alert window,
     * after which he is prompted to try again.
     * If the inputted data does not conflict with any existing data, the member is added to the system,
     * and the user is notified that the operation completed successfully.
     * Then the layout is changed to the main member pane, where the user can see that the member has been added.
     */
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

        //checking the temp member for conflicts in the file with other members
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

    /**
     * If statement used for switching the layout to the "editMembersPane" pane
     * by hiding the previous panes and displaying the correct one.
     * @param searchMembers button.
     */
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

    /**
     * If statement used to switch the layout to the "searchMemberByNamePane" pane.
     * @param searchMemberByName button
     */
    //switching layout to the search by name pane
    if(e.getSource() == searchMemberByName)
    {
      searchMemberByNamePane.setVisible(true);
      searchMemberByPhoneNumberPane.setVisible(false);
      editSelectedMemberPane.setVisible(false);
      memberSearchResultPane.setVisible(false);
    }

    /**
     * If statement used to switch the layout to the "searchMemberByPhoneNumberPane" pane.
     * @param searchMemberByPhone button
     */
    //switching layout to the search by phone number pane
    if(e.getSource() == searchMemberByPhone)
    {
      searchMemberByPhoneNumberPane.setVisible(true);
      memberSearchResultPane.setVisible(false);
      searchMemberByNamePane.setVisible(false);
      editSelectedMemberPane.setVisible(false);
    }

    /**
     * If statement used to search a member by name.
     * It works by first creating a temp member with the data provided by the user,
     * and at the same time, checking if the data matches any existing data in the system.
     * If so, the layout is then changed to the search result pane, and the searched member is
     * displayed on a list.
     * If not, an alert window will appear to notify the user that no member was found.
     * @param searchMemberByNameButton button
     */
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

    /**
     * If statement used to search a member by phone number.
     * The same logic applies here, although, the temp member is used to search for
     * a phone number amongst all the members in the system, after which, the same steps are applied.
     * If one was found, the layout is changed to the search result pane, and the searched member is
     * displayed on a list, and if no member was found, the user is alerted.
     * @param searchMemberByPhoneButton button
     */
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

    /**
     * If statement used to switch to the "editSelectedMemberPane" pane.
     * @param editMember button
     */
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

    /**
     * Logic for editing a member.
     * It works by first checking the type of subscription of the member,
     * after which the program gets the index of the member we want to edit.
     * This is needed because, when checking for conflicts within the .bin file,
     * we want to skip the position of our member, otherwise, you'd have to change
     * all of the fields for it to save.
     * We first check if the input fields aren't null, if they are, we alert the user,
     * if not, we create a temp member that we use to check for conflicting data with
     * existing members. If the data is conflicting, the user is alerted and the fields are reset.
     * If not, the old member is removed from the system, and the "new" edited version of it will take it's place,
     * and the user is alerted that the operation has been completed successfully.
     * @param saveMember button
     */
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

    /**
     * Logic for removing a member. First we warn the user that this action
     * cannot be undone, after which, if the user chooses to continue,
     * the member is removed from the system, and the layout is changed back to
     * the allMembersPane pane.
     * @param removeMember button
     */
    //logic for removing a member
    if(e.getSource() == removeMember)
    {
      //first alerting the user that this operation cannot be undone
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Warning");
      alert.setHeaderText("Are you sure you want to remove the selected member?");
      alert.setContentText("This cannot be undone.");

      //if the user chooses yes, we remove the member and switch the layout back
      //to the allMembers pane, if not, the alert closes and nothing happens.
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



  /**
   * @param classSource , a variable that stores all the info of the current class operation,
   * such as adding a new class, removing, or editing an existing class.
   */
  GymClass classSource;

  /**
   * @author Cirstoiu Bogdan-Florin
   * Method used for all operations regarding classes,
   * such as adding, removing, or editing classes in the system, but also used
   * for switching the layout in the classes section.
   * @param e the event listener
   */
  public void classesHandle(ActionEvent e){
    /**
     * class handler, that contains all methods needed for operations using classes
     */
    //class handler used throughout the method
    ClassesHandler classesHandler = new ClassesHandler();

    /**
     * The export button, that, when clicked, exports the schedule to an external xml file,
     * by using the componentHandler class. For more information, check the ComponentHandling.java class.
     */
    //the export button, used to export the xml file for the schedule.
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

    /**
     * If statement used to switch the layout to the classes section, while also
     * refreshing the list with all the classes.
     */
    if(e.getSource() == classesButton)
    {
      //switching the layout
      classesPane.setVisible(true);
      classesMain.setVisible(true);
      viewAllClassesPane.setVisible(true);
      classesMainSearch.setVisible(false);
      createClassPane.setVisible(false);
      membersPane.setVisible(false);
      homePane.setVisible(false);

      //refreshing the list with all the classes

      //clearing
      allClassesList.getItems().clear();
      ArrayList<GymClass> allClasses;
      //checking for data in the file to avoid "EOf" and "NullPointer" exceptions
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

    /**
     * If statement used to switch the layout to the main classes pane, while also
     * refreshing the list that contains all the classes
     */
    //switching the layout to see all classes, while also refreshing the list with all classes
    if(e.getSource() == viewAllClasses)
    {
      //switching layout
      viewAllClassesPane.setVisible(true);
      createClassPane.setVisible(false);
      classesMainSearch.setVisible(false);

      //clearing the list
      allClassesList.getItems().clear();
      ArrayList<GymClass> allClasses;

      //checking for data in the file to avoid "EOf" and "NullPointer" exceptions
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

    /**
     * Switching the layout to the main search pane for classes
     */
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

    /**
     * Switching the layout to the create pane for classes
     */
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

    /**
     * Logic for creating and adding a new class to the system.
     * First, the program checks all input fields so none of them are empty, and if they are,
     * the user is prompted to try again and complete all of them, otherwise, if all of them have been completed,
     * the program creates a new temp class, that is used to check for conflicts against existing data, and if none are found,
     * the class is added to the system, otherwise, the user is prompted with an alert that the added class already exists.
     */
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

    /**
     * Switching the layout to the search by name pane for classes
     */
    if(e.getSource() == searchClassesByName)
    {
      searchClassesByNamePane.setVisible(true);
      classesSearchResultPane.setVisible(false);
      editClassPane.setVisible(false);
    }
    /**
     * Logic for searching a class by name, date and time.
     * First, we create a new class, that we use to search through the class list, and if we get a result,
     * the result is then displayed on the search result pane, where the user can interact with it, otherwise,
     * an alert is prompted to the user that shows no class has been found.
     */
    if(e.getSource() == searchClassesByNameButton)
    {
      //creating prerequisites for the search, using the text fields the user has to fill
      LocalDate localDate = classDate1.getValue();
      Date neededDate = new Date(localDate.getDayOfMonth(),localDate.getMonthValue(),localDate.getYear());
      Time time = new Time(Integer.parseInt(classSearchTimeHour.getText()),Integer.parseInt(classSearchTimeMinute.getText()));

      //if we get a result, we then display it on another pane, in a list, where the user can interact with it
      if(classesHandler.getClassByName(className1.getText(),neededDate,time) != null)
      {
        //adding the result to the list
        classSource = classesHandler.getClassByName(className1.getText(),neededDate,time);
        classSearchResult.getItems().clear();
        classSearchResult.getItems().add(classSource);

        //system print for debugging
        System.out.println("Search result: "+classSource.getName());

        //switching the layout
        searchClassesByNamePane.setVisible(false);
        classesSearchResultPane.setVisible(true);
        className1.clear();
        classSearchTimeHour.clear();
        classSearchTimeMinute.clear();
        classDate1.setValue(null);
      }
      else{
        //alert for the user in case no class has been found
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setContentText("No class was found.");
        alert.setHeaderText("Please try again.");
        alert.showAndWait();
        className1.clear();
      }
    }

    /**
     * Switching the layout to the editClassPane
     */
    if(e.getSource() == editClassButton)
    {
      editClassPane.setVisible(true);
      searchClassesByNamePane.setVisible(false);
      classesSearchResultPane.setVisible(false);
      classEditResult.getItems().clear();
      classEditResult.getItems().add(classSource);
    }

    /**
     * Logic for editing a class.
     * First, we check that the input fields aren't empty, if they are, we prompt the user to fill all of them.
     * If the fields are not empty, we first create a new class using the data the user has provided, and then
     * use that class to check for conflicts, mainly if that same class exists already, and if so, we prompt the user
     * that the class already exists, and he has to try again.
     * If there is no conflicting data, the class is added to the system, the user is prompted that the operation has been completed
     * successfully, and the layout is switched to the main classes pane, where all classes are shown.
     */
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

    /**
     * Logic for removing a class from the system
     */
    if(e.getSource() == removeCLassButton)
    {
      //alert for the user that this operation cannot be undone
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Warning");
      alert.setHeaderText("Are you sure you want to remove the selected class?");
      alert.setContentText("This cannot be undone.");

      //if the user chooses yes, the class is removed and the layout is switched back to the
      //main page for classes where they're all displayed
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
        //if the user chooses no, nothing happens
        alert.close();
      }
    }

  }

  /**
   * Variable used to create a new instructor each time one is needed, such as when
   * we add, edit, remove, or search for one.
   */
  Instructor source;

  /**
   * @author Cirstoiu Bogdan-Florin
   * Main method used for interacting with instructors, whether that means adding, editing, removing, or
   * searching for one, also used to navigate the layout in the instructors section.
   * @param e
   */
  public void instructorHandle(ActionEvent e)
  {
    /**
     * Instructor handler, used throughout the method, that contains all methods necessary
     */
    //initializing the handler for the instructors
    InstructorHandler instructorHandler = new InstructorHandler();

    /**
     * Logic for the refresh button on the viewAllInstructors pane
     */
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

    /**
     * Logic for the removeAllInstructors button, which, you guessed it, removes all instructors
     */
    if(e.getSource() == removeAllInstructors)
    {
      instructorHandler.removeAllInstructors();
    }

    /**
     * Logic for adding an instructor to the system.
     * We first check if all the input fields have been completed, if not, the user is prompted to fill all of them
     * before continuing, and if all of them have been completed, a temp instructor is created, that is used to
     * check for conflicts with existing data. If there are any, the user is prompted to try again by an alert.
     * If not, then the instructor is added to the list, the layout is changed to the main instructors pane,
     * where all instructors are displayed
     */
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

    /**
     * Logic for searching an instructor by name.
     * We first check if that instructor exists in the system, using the instructor handler. For more
     * information about that check the InstructorHandler.java class.
     * If the instructor exists, the layout is switched to the search result pane, where the result of the
     * search is displayed, and the user can continue to interact with it
     */
    if(e.getSource() == searchInstructorByNameButton)
    {
      //checking if the instructor exists
      if(instructorHandler.getInstructorByName(searchInstructorName.getText(),searchInstructorLastName.getText()) != null)
      {
        //adding it to the list
        source = instructorHandler.getInstructorByName(searchInstructorName.getText(),searchInstructorLastName.getText());
        searchResultList.getItems().add("Name: "+source.getFullName());
        searchResultList.getItems().add("Email: "+source.getEmail());
        searchResultList.getItems().add("Phone number: "+source.getPhoneNumber());
        searchResultList.getItems().add("Address: "+source.getAddress());

        //clearing the fields for the next time they'll be used
        searchInstructorName.clear();
        searchInstructorLastName.clear();

        //switching the layout to the search result page
        searchInstructorByNamePane.setVisible(false);
        searchInstructorByPhoneNumberPane.setVisible(false);
        searchResult.setVisible(true);
        editSelectedInstructor.setVisible(false);

        //console log used for debugging
        System.out.println("Search result: "+source.getFullName());
      }
      else{
        //alert if no instructor has been found
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setContentText("No instructor was found.");
        alert.setHeaderText("Please try again.");
        alert.showAndWait();
        searchInstructorName.clear();
        searchInstructorLastName.clear();
      }
    }

    /**
     * Logic for searching an instructor by phone number.
     * Using the instructor handler, we check if the data inputted by the user corresponds with any instructor
     * in the system, and if so, it is then showed in the search result pane, where the user can continue
     * to interact with it
     */
    if(e.getSource() == SearchInstructorByPhoneNumberButton)
    {
      //check to see if the instructor exists
      if(instructorHandler.getInstructorByPhoneNumber(searchInstructorPhoneNumber.getText()) != null)
      {
        //add it to the display list
        source = instructorHandler.getInstructorByPhoneNumber(searchInstructorPhoneNumber.getText());
        searchResultList.getItems().add("Name: "+source.getFullName());
        searchResultList.getItems().add("Email: "+source.getEmail());
        searchResultList.getItems().add("Phone number: "+source.getPhoneNumber());
        searchResultList.getItems().add("Address: "+source.getAddress());
        searchInstructorPhoneNumber.clear();

        //switching the layout
        searchInstructorByNamePane.setVisible(false);
        searchInstructorByPhoneNumberPane.setVisible(false);
        searchResult.setVisible(true);
        editSelectedInstructor.setVisible(false);

        //console log for debugging
        System.out.println("Search result: "+source.getFullName());
      }
      else{
        //alert if no instructor has been found
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setContentText("No instructor was found.");
        alert.setHeaderText("Please try again.");
        alert.showAndWait();
        searchInstructorPhoneNumber.clear();
      }
    }

    /**
     * Logic for removing an instructor.
     * First, the user is prompted to choose if he/she wants to continue and notified that the operation
     * cannot be undone, and if he/she chooses to continue, the instructor is then removed, otherwise nothing happens.
     */
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

    /**
     * Logic for switching to the edit instructor pane,
     * also adding the instructor to a list so that all information is available while editing
     */
    if(e.getSource() == editInstructorButton)
    {
      editSelectedInstructor.setVisible(true);
      searchResult.setVisible(false);
      currentInstructorData.getItems().add("Name: "+source.getFullName());
      currentInstructorData.getItems().add("Email: "+source.getEmail());
      currentInstructorData.getItems().add("Phone number: "+source.getPhoneNumber());
      currentInstructorData.getItems().add("Address: "+source.getAddress());
    }
    /**
     * Logic for editing an instructor.
     * The method works by first getting the index of the instructor, that will then be used
     * when checking for conflicts.
     * The method then checks all fields so that none are empty when the user tries to edit the instructor,
     * and if either one of them is empty, the user is prompted by an alert that he needs to complete everything before
     * continuing. If everything is completed, then the program creates a temp instructor using the information provided,
     * and uses it to check for conflicts. The reason we also need the index of the instructor we're editing, is because we have to
     * skip him when comparing, otherwise, you would have to edit all of his information for the changes to save.
     * If there's conflicting information with another instructor, the user is prompted to try again, otherwise, the changes are saved,
     * the old instructor is removed, and the new one takes place.
     * (at first i wanted to be able to edit only one field at a time if the user chose to, and then just edit the information inside
     * the instructor, but that would add unnecessary complexity to the program).
     */
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

  /**
   * This method is used to handle only the main buttons on the left-side nav, while also
   * having some code to run. For example, when you click the classes button, the layout switches to the main classes pane,
   * and at the same time, refresh the list so that the user can see the whole list whenever he wants.
   * @param e
   */
  public void handleClickMe(ActionEvent e)
  {
    /**
     * Logic for the home page, where we show the date and time, and also the number of classes, members and instructors
     * The date, time, and number of classes, members and instructors was done by Satish Gurung
     */
    if(e.getSource() == homeButton)
    {
      //switching the layout
      homePane.setVisible(true);
      classesPane.setVisible(false);
      membersPane.setVisible(false);
      instructorsPane.setVisible(false);

      //dateTimeFormatter, self explanatory
      DateTimeFormatter Date = DateTimeFormatter.ofPattern("yyyy/MM/dd");
      DateTimeFormatter Time = DateTimeFormatter.ofPattern("hh:mm a");
      LocalDateTime now = LocalDateTime.now();

      //adding the date
      currentDate.setAlignment(Pos.BASELINE_CENTER);
      currentDate.setText(Date.format(now));

      //adding the time
      currentTime.setAlignment(Pos.BASELINE_CENTER);
      currentTime.setText(Time.format(now));

      //number of classes
      ClassesHandler classesHandler=new ClassesHandler();
      currentClasses.setAlignment(Pos.BASELINE_CENTER);
      if(classesHandler.getAllFromFile() != null)
        currentClasses.setText(String.valueOf(classesHandler.getAllFromFile().size()));
      else { currentClasses.setText("0");}

      //number of members
      MemberHandler memberHandler=new MemberHandler();
      currentMembers.setAlignment(Pos.BASELINE_CENTER);
      if(memberHandler.getAllMembersFromFile() != null)
        currentMembers.setText(String.valueOf(memberHandler.getAllMembersFromFile().size()));
      else { currentMembers.setText("0");}

      //number of instructors
      InstructorHandler instructorHandler=new InstructorHandler();
      currentInstructors.setAlignment(Pos.BASELINE_CENTER);
      if(instructorHandler.getAllFromFile() != null)
        currentInstructors.setText(String.valueOf(instructorHandler.getAllFromFile().size()));
      else{ currentInstructors.setText("0");}

    }
    /**
     * Logic for the member button, which switches the layout to the main member pane,
     * and also refreshes the list to display all members
     */
    if(e.getSource() ==  membersButton)
    {
      //switching the layout
      membersPane.setVisible(true);
      mainMembersPane.setVisible(true);
      allMembersPane.setVisible(true);
      classesPane.setVisible(false);
      instructorsPane.setVisible(false);
      homePane.setVisible(false);
      registerMembersPane.setVisible(false);
      editMembersPane.setVisible(false);

      //refreshing the list
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

    /**
     * Logic for the instructor button, that swtiches the layout to the main instructor pane,
     * and also refreshes the list so that all instructors are visible to the user upon clicking the button
     */
    if(e.getSource() == instructorsButton)
    {
      //switching the layout
      instructorsPane.setVisible(true);
      instructorsMain.setVisible(true);
      allInstructorsPane.setVisible(true);
      editInstructorPane.setVisible(false);
      registerInstructorPane.setVisible(false);
      classesPane.setVisible(false);
      membersPane.setVisible(false);
      homePane.setVisible(false);

      //refreshing the list
      fullInstructorList.getItems().clear();
      InstructorHandler instructorHandler = new InstructorHandler();
      if(instructorHandler.getAllFromFile() != null)
      {
        ArrayList<Instructor> allInstructors = instructorHandler.getAllFromFile();
        for(int i=0;i<allInstructors.size();i++)
        {
          fullInstructorList.getItems().add(allInstructors.get(i));
        }
        System.out.println("Refreshing list complete");
      }
      else{
        System.out.println("list empty, did not update");
      }
    }


    //this shouldn't be here
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

  /**
   * Initialize function used to set up the program upon start, just switching the layout
   * to the main page, and doing the same thing as before, adding the date, time, and number of
   * members, classes and instructors for the user to see upon start-up
   */
  public void initialize()
  {
    //switching the layout
    homePane.setVisible(true);
    membersPane.setVisible(false);
    instructorsPane.setVisible(false);
    classesPane.setVisible(false);

    //dateTimeFormatter, self explanatory
    DateTimeFormatter Date = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    DateTimeFormatter Time = DateTimeFormatter.ofPattern("hh:mm a");
    LocalDateTime now = LocalDateTime.now();

    //adding the date
    currentDate.setAlignment(Pos.BASELINE_CENTER);
    currentDate.setText(Date.format(now));

    //adding the time
    currentTime.setAlignment(Pos.BASELINE_CENTER);
    currentTime.setText(Time.format(now));

    //number of classes
    ClassesHandler classesHandler=new ClassesHandler();
    currentClasses.setAlignment(Pos.BASELINE_CENTER);
    if(classesHandler.getAllFromFile() != null)
    currentClasses.setText(String.valueOf(classesHandler.getAllFromFile().size()));
    else { currentClasses.setText("0");}

    //number of members
    MemberHandler memberHandler=new MemberHandler();
    currentMembers.setAlignment(Pos.BASELINE_CENTER);
    if(memberHandler.getAllMembersFromFile() != null)
    currentMembers.setText(String.valueOf(memberHandler.getAllMembersFromFile().size()));
    else { currentMembers.setText("0");}

    //number of instructors
    InstructorHandler instructorHandler=new InstructorHandler();
    currentInstructors.setAlignment(Pos.BASELINE_CENTER);
    if(instructorHandler.getAllFromFile() != null)
    currentInstructors.setText(String.valueOf(instructorHandler.getAllFromFile().size()));
    else{ currentInstructors.setText("0");}
  }
}

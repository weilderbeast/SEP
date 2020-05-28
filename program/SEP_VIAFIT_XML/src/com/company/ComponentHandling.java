package com.company;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ComponentHandling
{
  private static final String filePath = "src\\com\\company\\xmltest.xml";
  private DocumentBuilderFactory documentBuilderFactory;
  private DocumentBuilder documentBuilder;
  private Document document;
  private Element schedule;
  private Element root;

  //initializing the handler
  public ComponentHandling()
  {
    //initializing prerequisites
    this.documentBuilderFactory = DocumentBuilderFactory.newInstance();
    try
    {
      this.documentBuilder = documentBuilderFactory.newDocumentBuilder();
    }
    catch (ParserConfigurationException e)
    {
      e.printStackTrace();
    }
    this.document = documentBuilder.newDocument();

    //creating the base layout
    //root element of the xml
    Element root = document.createElement("VIAFIT");
    document.appendChild(root);
    this.root=root;
    //creating the schedule
    Element schedule = document.createElement("schedule");
    this.schedule = schedule;
    root.appendChild(schedule);
  }

  //adding a class to the list
  public void createClassElement(String id,String name,String time,String endTime,String instructor,String numberOfMembers,String spots,String avSpots,String date)
  {
    //creating the class element
    Element gymClass = document.createElement("class");
    gymClass.setAttribute("id",id);

    //creating the elements for the class
    Element className = document.createElement("name");
    Element classTime = document.createElement("time");
    Element classTimeEnd = document.createElement("endTime");
    Element classInstructor = document.createElement("instructor");
    Element classMemberNumber = document.createElement("numberOfMembers");
    Element classSpots = document.createElement("spots");
    Element classAvSpots = document.createElement("avSpots");
    Element classDate = document.createElement("date");

    //adding the values to the elements
    className.setTextContent(name);
    classTime.setTextContent(time);
    classTimeEnd.setTextContent(endTime);
    classInstructor.setTextContent(instructor);
    classMemberNumber.setTextContent(numberOfMembers);
    classSpots.setTextContent(spots);
    classAvSpots.setTextContent(avSpots);
    classDate.setTextContent(date);

    //appending all the elements to the class element
    gymClass.appendChild(className);
    gymClass.appendChild(classTime);
    gymClass.appendChild(classTimeEnd);
    gymClass.appendChild(classInstructor);
    gymClass.appendChild(classMemberNumber);
    gymClass.appendChild(classSpots);
    gymClass.appendChild(classAvSpots);
    gymClass.appendChild(classDate);

    //add the element to the schedule
    schedule.appendChild(gymClass);
  }
  public void createClassElement(GymClass class_gym)
  {
    //creating the class element
    Element gymClass = document.createElement("class");

    //creating the elements for the class
    Element className = document.createElement("name");
    Element classTime = document.createElement("time");
    Element classTimeEnd = document.createElement("endTime");
    Element classInstructor = document.createElement("instructor");
    Element classMemberNumber = document.createElement("numberOfMembers");
    Element classSpots = document.createElement("spots");
    Element classAvSpots = document.createElement("avSpots");
    Element classDate = document.createElement("date");

    //adding the values to the elements
    className.setTextContent(class_gym.getName());
    classTime.setTextContent(class_gym.getTimeString());
    classTimeEnd.setTextContent(class_gym.getEndTimeString());
    //no instructor for now
    //classInstructor.setTextContent(class_gym.getInstructor());
    classMemberNumber.setTextContent(class_gym.getCurrentSpotsString());
    classSpots.setTextContent(class_gym.getSpotsString());
    classAvSpots.setTextContent(class_gym.getAvailableSpotsString());
    classDate.setTextContent(class_gym.getDateString());

    //appending all the elements to the class element
    gymClass.appendChild(className);
    gymClass.appendChild(classTime);
    gymClass.appendChild(classTimeEnd);
    gymClass.appendChild(classInstructor);
    gymClass.appendChild(classMemberNumber);
    gymClass.appendChild(classSpots);
    gymClass.appendChild(classAvSpots);
    gymClass.appendChild(classDate);

    //add the element to the schedule
    schedule.appendChild(gymClass);
  }

  //finalizer that puts the dom in the file
  public void Finalizer()
  {
    //create the xml file
    //transform the DOM obj into an xml file
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = null;
    try
    {
      transformer = transformerFactory.newTransformer();
    }
    catch (TransformerConfigurationException e)
    {
      e.printStackTrace();
    }
    DOMSource domSource = new DOMSource(document);

    //editing the file
    File file = new File(filePath);
    StreamResult streamResult = new StreamResult(file);

    //finalizing (finalizing in the finalizer lol)
    try
    {
      transformer.transform(domSource,streamResult);
    }
    catch (TransformerException e)
    {
      e.printStackTrace();
    }
    System.out.println("Done");
  }
}

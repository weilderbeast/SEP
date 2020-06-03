package com.company;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MyFileIO
{
   /**
    * Method that writes an object to the file, with a given file path.
    * @param fileName
    * @param obj
    * @throws FileNotFoundException
    * @throws IOException
    */
   public void writeToFile(String fileName, Object obj) throws FileNotFoundException, IOException
   {
      ObjectOutputStream writeToFile = null;

      try
      {
         FileOutputStream fileOutStream = new FileOutputStream(fileName);
         writeToFile = new ObjectOutputStream(fileOutStream);

         writeToFile.writeObject(obj);
      }
      finally
      {
         if (writeToFile != null)
         {
            try
            {
               writeToFile.close();
            }
            catch (IOException e)
            {
               System.out.println("IO Error closing file " + fileName);
            }
         }
      }
   }

   /**
    * Method used to return the first object from the file, in our case, an array list.
    * @param fileName
    * @return the method returns an object which will then be casted to it's true type in another method
    * @throws FileNotFoundException
    * @throws IOException
    * @throws ClassNotFoundException
    */
   public Object readObjectFromFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException
   {
      Object obj = null;
      ObjectInputStream readFromFile = null;
      try
      {
         FileInputStream fileInStream = new FileInputStream(fileName);
         readFromFile = new ObjectInputStream(fileInStream);
         try
         {
            obj = readFromFile.readObject();
         }
         catch (EOFException eof)
         {
           //Done reading
         }
      }
      finally
      {
         if (readFromFile != null)
         {
            try
            {
               readFromFile.close();
            }
            catch (IOException e)
            {
               System.out.println("IO Error closing file " + fileName);
            }
         }
      }
      return obj;
   }
 }

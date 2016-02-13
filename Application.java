package Application;

// Created by Clayton Paplaczyk
// Description: The Application class displays a menu of choices
//               (add online student or on campus student,
//               compute their tuition, count certain students, list students,
//               quit, display menu) to a user.
//               Then it performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered.

import java.io.*;         //to use InputStreamReader and BufferedReader
import java.util.*;       //to use ArrayList

public class Application
 {
  public static void main (String[] args)
   {
	//allows files to be automatically inputed into Eclipse
	  /*try{
		  System.setIn(new FileInputStream("./test/input3.txt")); // inputs test .txt file
		  }catch(IOException e){
			  e.printStackTrace();
		  } */
	  
     char input1;
     String inputInfo = new String();
     String line = new String();
     boolean operation;
     int i;

     // ArrayList object is used to store student objects
     ArrayList studentList = new ArrayList();

     try
      {
       printMenu();     // print out menu

       // create a BufferedReader object to read input from a keyboard
       InputStreamReader isr = new InputStreamReader (System.in);
       BufferedReader stdin = new BufferedReader (isr);

       do
        {
         System.out.println("What action would you like to perform?");//prompts user to enter action from display
         line = stdin.readLine().trim();
         input1 = line.charAt(0);
         input1 = Character.toUpperCase(input1);//changes input to upper case letter

         if (line.length() == 1)
          {
           switch (input1)
            {
             case 'A':   //Add Student
               System.out.print("Please enter a student information to add:\n");
               inputInfo = stdin.readLine().trim();
               Student stu = StudentParser.parseStringToStudent(inputInfo);
               studentList.add(stu); 
               break;
             case 'C':   //Compute Tuition
            	for(i=0;i<studentList.size();i++){
            		((Student)studentList.get(i)).computeTuition();//gets computeTuition method from Student class
            	}
                System.out.print("tuition computed\n");// prints tuition was computed
               break;
             case 'D':   //Count certain students
               System.out.print("Please enter a number of credits:\n");
               inputInfo = stdin.readLine().trim();
               int credits = Integer.parseInt(inputInfo);
               int count = 0;
               
               for(i=0;i<studentList.size();i++){//for loop goes through each student object within array list
            	   if(((Student) studentList.get(i)).getCreditNum()==credits)//checks if students credits are equal to inputed credits
            		   count++;//increases counter of students with specific number of credits
               }

                System.out.println("The number of students who are taking " + credits
                                   + " credits is: " + count);
               break;
             case 'L':   //List Students
            	 if(studentList.size() == 0)//checks if there are no students created yet
         	   		System.out.print("no student\n");
            	 else{
            		 for(i=0;i<studentList.size();i++)//for loop runs through each object stu
            			 System.out.print(studentList.get(i));//lists all objects stu
            	 	 }
               break;
             case 'Q':   //Quit
               break;
             case '?':   //Display Menu
               printMenu();
               break;
             default:
               System.out.print("Unknown action\n");
               break;
            }
         }
        else
         {
           System.out.print("Unknown action\n");
          }
        } while (input1 != 'Q'); // stop the loop when Q is read
      }
     catch (IOException exception)
      {
        System.out.println("IO Exception");
      }
  }

  /** The method printMenu displays the menu to a user **/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                      "------\t\t------\n" +
                      "A\t\tAdd Student\n" +
                      "C\t\tCompute Tuition\n" +
                      "D\t\tCount Certain Students\n" +
                      "L\t\tList Students\n" +
                      "Q\t\tQuit\n" +
                      "?\t\tDisplay Help\n\n");
  }
} //end class
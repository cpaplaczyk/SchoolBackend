package Application;

// Created by Clayton Paplaczyk
// Description: OnlineStudent is a subclass of Student class. It represents an online student who takes courses only online. 
//				 It has the following attribute in addition to the inherited ones computingFee.

import java.text.DecimalFormat;//allows use of DecimalFormat

public class OnlineStudent extends Student{ 
	
	private double computingFee; //Computing Fee for the student
	
	DecimalFormat fmt1 = new DecimalFormat ("$0.00"); //sets fmt1 to specific decimal format
	
	public OnlineStudent(String fName, String lName, String id, int credits, double rate, double compFee)//constructor method
	{
		super(fName, lName, id, credits, rate);//calls variables from Student class
		computingFee = compFee;//sets computingFee equal to compFee
	}
	
	public void computeTuition()//method that computes tuition for onlin students
	{
		tuition = (rate + computingFee) * creditNum; //Computes the tuition
	}
	
	public String toString()//returns online student information
	{
		String onlineStudentInfo = ("\nOnline Student:" + super.toString() + "Computing Fee:\t\t" + fmt1.format(computingFee) + "\n\n");
		
		return onlineStudentInfo;
	}
	
} //end class

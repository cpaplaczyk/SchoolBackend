package Application;

// Created by Clayton Paplaczyk
// Description: Student is an abstract class, which represents the basic attributes
//               of any student in a university . It is used as the root of the student
//				 hierarchy. It has the following attributes firstName, lastName, studentID,
//				 creditNumber, rate, tuition.

import java.text.*;//allows use of DecimalFormat

public abstract class Student {
	
	protected String firstName; //First name of the student
	protected String lastName; // Last name of the student
	protected String studentID; //Student ID of the student
	protected int creditNum; //Number of Credits that the student is taking
	protected double rate; //Tuition rate for the student
	protected double tuition; //Tuition amount of the student to be computed
	
	DecimalFormat fmt1 = new DecimalFormat ("$#,##0.00"); //sets fmt1 to specific decimal format
	
	public Student(String fName, String lName, String id, int credits, double rate)//constructor method provided to initialize instance variables
	{
		firstName = fName;
		lastName = lName;
		studentID = id;
		creditNum = credits;
		tuition = 0.0;
		this.rate = rate;
	}

	public int getCreditNum() //accessor method returns creditNum
	{
		return creditNum;
	}
	
	public abstract void computeTuition();//abstract method to update tuition amount
	
	public String toString()//returns stu information
	{
		String studentInfo = ("\nFirst name:\t\t" + firstName + "\nLast name:\t\t" + lastName 
				+ "\nStudent ID:\t\t" + studentID + "\nCredits:\t\t" + creditNum + 
				"\nRate:\t\t\t" + fmt1.format(rate) + "\nTuition:\t\t" + fmt1.format(tuition) + "\n");
		
		return studentInfo;
	}
	
} //end class

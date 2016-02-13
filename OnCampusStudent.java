package Application;

// Created by Clayton Paplaczyk
// Description: OnCampusStudent is a subclass of Student class. It represents an on campus student in a
//				 university. It has the following additional attributes resident, credUpperbound, studentProgramFee.

import java.text.DecimalFormat;//allows use of DecimalFormat

public class OnCampusStudent extends Student{

	private boolean resident; //Its value is true if the student is a state resident, and false otherwise (non-resident)
	private int creditUpperbound; //The upper bound of credits. If the number of credits is greater than or equals to this bound, the tuition will not increase.
	private double studentProgramFee; //Student Program Fee that will be added to the tuition
	
	DecimalFormat fmt1 = new DecimalFormat ("$0.00"); //sets fmt1 to specific decimal format

	public OnCampusStudent(String fName, String lName, String id, int credits, double rate, boolean resident, double programFee)//constructor method
	{
		super(fName, lName, id, credits, rate);//calls variables from Student class
		studentProgramFee = programFee;
		this.resident=resident;
		
		if(resident){  //setting the creditUpperbound for resident and non-resident to computer tuition
			creditUpperbound = 7;
		}
		else{
			creditUpperbound = 12;
		}
	}
	
	public void computeTuition()//method to compute tuition for non-resident and resident students
	{
		if (creditNum >= creditUpperbound)
			tuition = rate*creditUpperbound+studentProgramFee;
		else
			tuition = rate*creditNum+studentProgramFee;
	}
	
	public String toString()//returns on campus student information
	{
		if(resident){  //if student is resident
		String onCampStudInfo = ("\nOnCampus Student:\nResident Status" + super.toString() + "Student"
						+ " Program Fee:\t" + fmt1.format(studentProgramFee) + "\n\n");
		
		return onCampStudInfo;
		}
		
		else{ //if student is non-resident
			String onCampStudInfo = ("\nOnCampus Student:\nNonResident Status" + super.toString() + "Student"
						+ " Program Fee:\t" + fmt1.format(studentProgramFee) + "\n\n");
		
		return onCampStudInfo;
		}
	}
	
	
}//end class

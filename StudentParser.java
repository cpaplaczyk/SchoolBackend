package Application;

// Created by Clayton Paplaczyk
// Description: The StudentParser class is a utility class that will be used to create a
//				 student object (one of an online student or an on-campus student object)
//				 from a parsable string. The StudentParser class object will not be instantiated.

import java.io.*;//to use InputStreamReader and BufferedReader
import java.util.*; //to use ArrayList

public class StudentParser {

	public static Student parseStringToStudent(String lineToParse)
	{
		Scanner parseStringToStudent = new Scanner(lineToParse);
		parseStringToStudent.useDelimiter("/");
			
			String type = parseStringToStudent.next();//sets type of student from input
			String fName = parseStringToStudent.next();//sets fName of the student from input
			String lName = parseStringToStudent.next();//sets lName of student from input
			String id = parseStringToStudent.next();//sets id number of student from input
			int credits = Integer.parseInt(parseStringToStudent.next());//sets credits of student from input to an int from string
			double rate = Double.parseDouble(parseStringToStudent.next());//sets rate of student from input to a double from string
			
		Student stu;//creates object stu for student information
		
		if(type.equals("Online")){//if online student
			double compFee = Double.parseDouble(parseStringToStudent.next()); 
			stu = new OnlineStudent(fName, lName, id, credits, rate, compFee);//sets stu object for online student
		}
		else{//if on campus student
			String resident = parseStringToStudent.next();
			boolean res;
			if(resident.equals("Resident"))
				res = true;
			else
				res = false;
				
			double programFee = Double.parseDouble(parseStringToStudent.next());//sets programFee to double from a string
				
			stu = new OnCampusStudent(fName, lName, id, credits, rate, res, programFee);//sets stu object for on campus student
		}
	return stu;//returns stu object
	}
}//end class

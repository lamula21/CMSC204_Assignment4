import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


/**
 * This is the Data Manager class of the Course Data Base
 * @author Jose Valdivia
 */
public class CourseDBManager implements CourseDBManagerInterface {

	private CourseDBStructure dataBase = new CourseDBStructure(20);
	
	

	/**
	 * Adds a course to the database with the given parameters
	 * @param id the CourseID of the class 
	 * @param crn the CRN code of the course
	 * @param credits the total of credits of the course
	 * @param roomNum the room number of the class
	 * @param instructor the teacher's name
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {

		dataBase.add(new CourseDBElement(id, crn, credits, roomNum, instructor));

	}

	
	/**
	 * Returns the course from the database depending on the CRN code
	 * @param crn the CRN code of the course
	 * @return the course
	 */
	@Override
	public CourseDBElement get(int crn) {
		
		try {
			return dataBase.get(crn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Reads an input file of courses, then adds them to the database
	 * @param input the text file of courses
	 * @throws FileNotFoundException thrown if input text file does not exist
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {


		Scanner scanner = new Scanner(input);
		
		while (scanner.hasNextLine()) 
		{
			// Store whole line into the String line
			String line = scanner.nextLine();
			
			// Split each word of the line and store it into an array
			String [] arrayOfLine = line.split(" ");
			
			// Get the courseID which is the first element of the array
			String courseID = arrayOfLine[0];
			
			// Get the crn which is the second element of the array
			int crn = Integer.parseInt(arrayOfLine[1]);
			
			// Get the credit which is the third element of the array
			int credit = Integer.parseInt(arrayOfLine[2]);
			
			
			
			// Set boolean if teacher's name has middleName
			boolean midName = false;
			
			// Store the size of the array
			int arraySize = arrayOfLine.length;
			
			
			// First Step
			// Search for middle name in the lineArray, if has, set midName to true
			for( int i=0; i<arrayOfLine.length; i++ ) 
			{
				if ( arrayOfLine[i].length() == 2   &&     arrayOfLine[i].charAt(arrayOfLine[i].length()-1) == '.' )
					midName = true;
			}
					
			
			// Second step
			// If else statement - if lineArray has middleName
			if(midName) {
				
				String roomNum = "";
				
				// roomNum is always the "3rd or 3rd + 4th" index of the array 
				for (int i=3; i<arraySize-3; i++)
				{
					roomNum += arrayOfLine[i];
				}
				
				// When teacher has middleName, the Professor's full name is always the last 3 elements of the array
				String teacherName = arrayOfLine[arraySize-3] + arrayOfLine[arraySize-2] + arrayOfLine[arraySize-1];
				
				// Call the "add method" from this CourseDBManager to add the input file read and add them to the database
				this.add(courseID, crn, credit, roomNum, teacherName);
			}
			else {
				
				// if lineArray has NO middleName
				
				// Initialize roomNum
				String roomNum = "";
				
				// roomNum is always the "3rd or 3rd + 4th" index of the array 
				for (int i=3; i<arraySize-2; i++)
				{
					roomNum += arrayOfLine[i];
				}
				
				// When teacher has No middleName, the Professor's full name is always the last 2 elements of the array
				String teacherName = arrayOfLine[arraySize-2] + arrayOfLine[arraySize-1];
				
				// Call the "add method" from this CourseDBManager to add the input file read and add them to the database
				this.add(courseID, crn, credit, roomNum, teacherName);
				
			}
			
			
			
		}
	}

	
	/**
	 * Displays all the courses from the database
	 * @return an ArrayList of courses 
	 */
	@Override
	public ArrayList<String> showAll() {

		// Create an ArrayList to print out all courses
		ArrayList<String> showOutput = new ArrayList<String>();
		
		// Enhanced for loop to print out each course from the HashTable
		for (LinkedList<CourseDBElement> chainOfanIndex : dataBase.hashTableOfCourses) {
			
			// If the index of the Array of Linked List is not null
			if(chainOfanIndex != null) {
				
				// Loop throw the chain,  get the toString, and save it into a new String
				// Add the new String into the ArrayList of Strings
				for (int i = 0; i < chainOfanIndex.size(); i++) {
					String courseData = chainOfanIndex.get(i).toString();
					showOutput.add(courseData);
				}
			}
		}
		return showOutput;
	}

	
	
	
	
	
	
	
}

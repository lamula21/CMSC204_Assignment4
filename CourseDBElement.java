
/**
 * This is the Data Element class of the Data Base of Courses
 * @author Jose Valdivia
 *
 */
public class CourseDBElement {

	private String courseID, roomNum, instructor;
	private int crn, credits;
	
	
	/**
	 * Constructor empty data element
	 */
	public CourseDBElement() {
		this.courseID = null;
		this.crn = 0;
		this.credits = 0;
		this.roomNum = null;
		this.instructor = null;
	}
	
	
	/**
	 * Constructor a data element with their information
	 * @param id the Course ID
	 * @param crn the unique CRN code of the class
	 * @param credits the number of credits of the class
	 * @param roomNum the room number of the class
	 * @param instructor the instructor of the class
	 */
	public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor) {
		this.courseID = id;
		this.crn = crn;
		this.credits = credits;
		this.roomNum = roomNum;
		this.instructor = instructor;
	}

	
	/**
	 * Returns the hashCode of the element
	 * Depeneding on the hashCode of the crn code as a string
	 * @return the hashCode of the data element
	 */
	public int hashCode() {
		String code = Integer.toString(crn);
		return code.hashCode();
	}
	
	
	/**
	 * Converts the data element to a String
	 * @return the element as a string
	 */
	public String toString() {
		return "\nCourse:" + courseID +" CRN:" + crn + " Credits:" + credits + " Instructor:" + instructor + " Room:" + roomNum;
	}
	
	
	
	


	
	// Getters and Setters
	public String getId() {
		return courseID;
	}

	public void setId(String id) {
		this.courseID = id;
	}

	public int getCRN() {
		return crn;
	}

	public void setCRN(int crn) {
		this.crn = crn;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	
	
	
}

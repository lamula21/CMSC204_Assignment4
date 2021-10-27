import java.io.IOException;
import java.util.LinkedList;

/**
 * This is the Data Structure class of the Course Data Base
 * @author Jose Valdivia
 */
public class CourseDBStructure implements CourseDBStructureInterface {

	protected LinkedList<CourseDBElement>[] hashTableOfCourses;	// Array of Linked Lists
	

	/**
	 * Constructor to initialize the Hash Table or Array of Linked Lists
	 * @param size of the hash table
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(int size) {
		
		hashTableOfCourses = new LinkedList[size];
	}

	
	/**
	 * Constructor will take in a String and an int.  
	 * @param testing specifies that this constructor is used only for "testing"
	 * @param size of the hash table
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(String testing, int size) {
		
		hashTableOfCourses = new LinkedList[size];
	}


	/**
	 * Adds elements on the Hash Table depending on its hashCode index
	 * If the CourseDatabaseElement does not exist in the hashtable,
	 * add it to the hashtable.
	 * 
	 * @param element the element course to be added
	 */
	@Override
	public void add(CourseDBElement element) {
		
		int index = element.hashCode() % hashTableOfCourses.length;
		System.out.println(element.hashCode());
		System.out.println(index);
		
		if ( hashTableOfCourses[index] == null ) {
			
			LinkedList<CourseDBElement> chain = new LinkedList<>();
			chain.add(element);
			hashTableOfCourses[index] = chain;

		} else {
			
			hashTableOfCourses[index].add(element);
		}
		
		
		
		
	}

	
	/**
	 * Return element from the Hash Table based on the crn
	 * @param crn code Course 
	 * @return the course from the database according to its CRN
	 * @throws IOException
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		
		String crnString = Integer.toString(crn);
		int index = crnString.hashCode() % getTableSize();
		
	
		if (hashTableOfCourses[index] != null) 
		{
			
			for (int i = 0; i <hashTableOfCourses[index].size(); i++) 
			{
				if (hashTableOfCourses[index].get(i).getCRN() == crn)
					return hashTableOfCourses[index].get(i);	
			}
			
			throw new IOException();
			
	
		} else 
			throw new IOException();
		
		
	}

	
	/**
	 * Returns the size of the number of indexes in the array
	 * @return the length of the array of linkedLists
	 */
	@Override
	public int getTableSize() {
		
		return hashTableOfCourses.length;
		
	}

	
}

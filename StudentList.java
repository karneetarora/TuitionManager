public class StudentList {
	
	private final int NOT_FOUND = -1;
	private final int GROW_SIZE = 4;
	private Student [] studentList; // container
	private int numStudents;

	
	/**
	 * Constructor for StudentList class, initializes an array of size 4 students.
	 */
	public StudentList() {
		studentList = new Student[GROW_SIZE];
		numStudents = 0;
	}
	
	

	/**
	 * This method adds a student to the Student List
	 * @param student being added to the list
	 */
	public void add(Student s) {

		if (studentList.length == numStudents) {
			grow();
			studentList[numStudents] = s;
			numStudents++;
		} else {
			studentList[numStudents] = s;
			numStudents++;
		}
	}

	
	/**
	 * This method removes a student from the Student List
	 * @param student being removed from the list
	 */
	public boolean remove(Student s) {
		
		int indexToRemove = find(s);
		if (numStudents == 1) {
			studentList[indexToRemove] = null;
		} else {
			studentList[indexToRemove] = studentList[numStudents - 1];
			studentList[numStudents - 1] = null;
		}
		numStudents--;
		return true;
	}
	
	
	
	
	
	
	
	/**
	 * print() This method prints the Student List 
	 */
	public void print() {
		for (int i = 0; i < numStudents; i++) {
			System.out.println(studentList[i].toString());
		}
	}
	
	

	/**
	 * isEmpty() is a helper method that checks if studentList has 0 student
	 * @return true if studentList is empty, false otherwise
	 */

	public boolean isEmpty() {
		return (numStudents == 0);
	}


	/**
	 * checks if member exists in team
	 * 
	 * @param team Member consisting of a name and a date
	 * @return whether or not m is a member of team
	 */
	public boolean contains(Student m) {
		if (find(m) == NOT_FOUND) {
			return false;
		}
		return true;
	}
	

	/**
	 * find(Student m) is a helper method that locates the index of Student in studentList 
	 * @param m : a student
	 * @return index of student if found, else: -1
	 */

	private int find(Student m) {
		for (int i = 0; i < numStudents; i++) {
			if (studentList[i].compareTo(m) == 0) { // compares only fname and lname
				return i;
			}
		}
		return NOT_FOUND;
	}
	
	
	/**
	 * Grows array holding team members by 4 cells if no space left by moving
	 * members from old array to new one.
	 */

	private void grow() {
		Student[] newArray = new Student[studentList.length + 4];
		int index = 0;
		for (Student s : studentList) {
			newArray[index] = studentList[index]; // probably wrong? do I need to do "new"?
			index++;
		}
		studentList = newArray;
	}
	

}



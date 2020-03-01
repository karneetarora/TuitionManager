 /**
 * Outstate class is a subclass of Student Class which is used for Outstate Students
 * Calculates the tuition amount and returns all information as a String
 * Methods include - toString(), and tuitionDue()
 * @author Karneet Arora, Manel Bermad
 *
 */
public class Outstate extends Student {
	private boolean tristate; 
	
	/**
	 * Constructor for Outstate students 
	 * @param fname, lname, credit, isTriState
	 */
	public Outstate(String fname, String lname, int credit, boolean isTriState) {		
		super(fname, lname, credit);
		this.tristate = isTriState; 
	}
	
	 /**
	  * Computes the total Tuition Due by an OutState Student
	  * The Student pays $756/credit, regardless of enrollment type
	  * More than 15 credits, counts as 15 credits when calculating TuitionDue
	  * Part Time Student(<12 credits), pay $846 for University Fee
	  * Full Time Student(>=12 credits), pay $1,441 for University Fee
	  * TriState Student get a discount of $200/credit
	  * @return total tuition amount due 
	  */
	public int tuitionDue() {
		int tuitionDue; 
		
		if(credit < 12) {
				tuitionDue = 846 + 756 * credit; 
		}
		else if(credit < 15) {
			if(tristate) 
				tuitionDue = 1441 + (756 - 200) * credit;
			else
				tuitionDue = 1441 + 756 * credit; 
		}
		else {
			if(tristate) 
				tuitionDue = 1441 + (756-200) * 15;  
			else
				tuitionDue = 1441 + 756 * 15; 
		}
		return tuitionDue; 
	}
	
	 /**
	  * toString() calls the superclass toString() method and adds it's own additional fields
	  * @return string with name, last name, credit, tristate, tuitionDue 
	  */
	public String toString(){
		boolean skip = false; 
		String tuitionAmt = ""; 
		if(Integer.toString(tuitionDue()).length() == 4) {
			char tuition[] = new char[5];
			for(int i = 0; i <5; i++) {
				if(i == 1) {
					tuition[i] = ',';
					skip = true; 
				}
				else {
					if(skip) 
						tuition[i] = Integer.toString(tuitionDue()).charAt(i-1);
					else
						tuition[i] = Integer.toString(tuitionDue()).charAt(i);
				}
			}
			for(int i = 0; i < 5; i++) {
			  tuitionAmt = tuitionAmt + tuition[i];
			}
		}
		else if(Integer.toString(tuitionDue()).length() == 5) {
			char tuition[] = new char[6];
			for(int i = 0; i <6; i++) {
				if(i == 2) {
					tuition[i] = ',';
					skip = true; 
				}
				else {
					if(skip) 
						tuition[i] = Integer.toString(tuitionDue()).charAt(i-1);
					else
						tuition[i] = Integer.toString(tuitionDue()).charAt(i);
				}
			}
			for(int i = 0; i < 6; i++) {
				  tuitionAmt = tuitionAmt + tuition[i];
			}
		}	
		return super.toString() + "\n" + "-Tristate: " + tristate + "\n" + "-Total Tuition Due: $" + tuitionAmt; 
	}
	
	/**
	 * The following is a test bed for Outstate Students
	 * Each test invokes the toString() and tuitionDue() methods
	 * The corresponding expected input/output can be found in the test doc 
	 */
	public static void main(String[] args) {
		
		Outstate student1 = new Outstate("Mary", "Anderson", 17, false);
		System.out.println("Student 1 Entry: " + student1.toString()); 
		
		Outstate student = new Outstate("Lauren", "Brown", 17, true);
		System.out.println("Student 2 Entry: " + student.toString()); 
		
		Outstate student2 = new Outstate("Simons", "Michael", 8, false);
		System.out.println("Student 3 Entry: " + student2.toString()); 
		
		Outstate student3 = new Outstate("Stiller", "Anderson", 8, true);
		System.out.println("Student 4 Entry: " + student3.toString()); 
		
		Outstate student4 = new Outstate("Good", "Man", 12, false);
		System.out.println("Student 5 Entry: " + student4.toString()); 
		
		Outstate student5 = new Outstate("John", "White", 12, true);
		System.out.println("Student 6 Entry: " + student5.toString()); 
	
	}

}

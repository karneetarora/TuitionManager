 /**
 * Instate class is a subclass of Student Class which is used for Instate Objects
 * Calculates the tuition amount and returns all information as a String
 * Methods include toString(), and tuitionDue()
 * @author Karneet Arora, Manel Bermad
 *
 */
public class Instate extends Student {
	private int funds; 
	
	/**
	 * Constructor for Instate students 
	 * @param fname, lname, credit, aid
	 */
	public Instate(String fname, String lname, int credit, int aid) { 
		super(fname, lname, credit);
		funds = aid; 
	}
	
		   
	 /**
	  * Computes the total tuition amount due by an InState Student
	  * Instate students pay 433/credit regardless of enrollment type
	  * More than 15 credits, counts as 15 credits when calculating TuitionDue
	  * Part Time Students(<12 credits),  pay $846 for University Fee
	  * Full Time Students(>=12 credits), pay $1,441 for University Fee 
	  * Only Instate Full Time students get funds which decreases their tuition amount
	  * @return total tuition amount due 
	  */
	 public int tuitionDue(){
		 int tuitionDue; 
		 if(credit < 12)
			 tuitionDue = 846 + 433 * credit; 
		 else if(credit < 15)
			 tuitionDue = 1441 + 433 * credit - funds; 
		 else 
			 tuitionDue = 1441 + 433 * 15 - funds; ;
		 return tuitionDue; 
	 }  
	 
	 
	 /**
	  * toString() calls the superclass toString() method and adds it's own additional fields
	  * @return string with name, last name, credit, funds, tuitionDue 
	  */
	 public String toString() {
		return super.toString() + " " + funds + " " + tuitionDue();  
	}     
	 
	
	/**
	 * The following is a test bed for Instate Students
	 * Each test invokes the toString() and tuitionDue() methods
	 * The corresponding expected input/output can be found in the test doc 
	 */
	public static void main(String[] args) {
		
		Instate student1 = new Instate("Peter", "Parker", 8, 0);
		System.out.println("Student 1 Entry: " + student1.toString()); 
		System.out.println("Total Tuition Due: $" + student1.tuitionDue());
		
		Instate student = new Instate("Wilson", "Long", 8, 1000);
		System.out.println("Student 2 Entry: " + student.toString()); 
		System.out.println("Total Tuition Due: $" + student.tuitionDue());
		
		Instate student2 = new Instate("Peter", "Liang", 12, 0);
		System.out.println("Student 3 Entry: " + student2.toString()); 
		System.out.println("Total Tuition Due: $" + student2.tuitionDue());
		
		Instate student3 = new Instate("John", "Young", 12, 1000);
		System.out.println("Student 4 Entry: " + student3.toString()); 
		System.out.println("Total Tuition Due: $" + student3.tuitionDue());
		
		Instate student4 = new Instate("Michael", "Chamber", 17, 0);
		System.out.println("Student 5 Entry: " + student4.toString()); 
		System.out.println("Total Tuition Due: $" + student4.tuitionDue());
		
		Instate student5 = new Instate("John", "Smith", 17, 1000);
		System.out.println("Student 6 Entry: " + student5.toString()); 
		System.out.println("Total Tuition Due: $" + student5.tuitionDue());
		

	}
}

/**
 * International class is a subclass of Student Class, used for International Students
 * Calculates the tuition amount and returns all information as a String
 * Methods include - toString(), and tuitionDue()
 * @author Karneet Arora, Manel Bermad
 */
public class International extends Student {
	private boolean exchange; 
	
	
	/**
	 * Constructor for International Students 
	 * @param fname, lname, credit, isExchange
	 */
	public International(String fname, String lname, int credit, boolean isExchange) {
		super(fname, lname, credit); 
		exchange = isExchange; 
	}
	
	
	/**
	  * This method computes the total tuition amount due for an International Student
	  * The student pays $945/credit taken, regardless if the student is full time or part time 
	  * More than 15 credits, counts as 15 credits when calculating TuitionDue
	  * If the Student is part time(<12 credits), they pay $846 for University Fee
	  * If the Student is full time(>=12 credits), they pay $1,441 for University Fee
	  * International Fee for students is $350
	  * International Exchange students only pay university + international fee 
	  * @return total tuition amount due 
	  */
	public int tuitionDue() { 
		int tuitionDue; 
		if(credit < 12 && credit >= 9) {
			if(exchange)
				tuitionDue = 846 + 350; 
			else
				tuitionDue = 846 + 350 + 945 * credit; 
		}
		else if(credit >= 12 && credit < 15) {
			if(exchange)
				tuitionDue = 1441 + 350; 
			else
				tuitionDue = 1441 + 350 +  945 * credit ; 
		}
		else if(credit >= 15) {
			if(exchange)
				tuitionDue = 1441 + 350; 
			else
				tuitionDue = 1441 + 350 +  945 * 15 ; 
		}
		else
			tuitionDue = 0;
		return tuitionDue; 
	}
	
	
	 /**
	  * toString() calls the superclass toString() method and adds it's own additional fields
	  * @return string with name, last name, credit, exchange, tuitionDue 
	  */
	 public String toString() {
		 return super.toString() + " " + exchange + " " + tuitionDue();  
	 }    
	 
	 /**
	  * The following is a test bed for International Students
	  * Each test invokes the toString() and tuitionDue() methods
	  * The corresponding expected input/output can be found in the test doc 
	  */
	 public static void main(String[] args) {
		International student1 = new International("David", "Lee", 12, false);
		System.out.println("Student 1 Entry: " + student1.toString()); 
		System.out.println("Total Tuition Due: $" + student1.tuitionDue());
						
		International student = new International("Joe", "Kim", 12, true);
		System.out.println("Student 2 Entry: " + student.toString()); 
		System.out.println("Total Tuition Due: $" + student.tuitionDue());
			
		International student2 = new International("April", "Young", 17, false);
		System.out.println("Student 3 Entry: " + student2.toString()); 
		System.out.println("Total Tuition Due: $" + student2.tuitionDue());
			
		International student3 = new International("Mary", "Yang", 17, true);
		System.out.println("Student 4 Entry: " + student3.toString()); 
		System.out.println("Total Tuition Due: $" + student3.tuitionDue());
			
		International student4 = new International("Clifford", "Dog", 9, false);
		System.out.println("Student 5 Entry: " + student4.toString()); 
		System.out.println("Total Tuition Due: $" + student4.tuitionDue());
			
		International student5 = new International("Jimmy", "Neutron", 9, true);
		System.out.println("Student 6 Entry: " + student5.toString()); 
		System.out.println("Total Tuition Due: $" + student5.tuitionDue());

		}
	
}

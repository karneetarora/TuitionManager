
public class Instate extends Student {
	private int funds; 
	public Instate(String fname, String lname, int credit, int aid) { 
		super(fname, lname, credit);
		funds = aid; 
	}
	
	
	public int compareTo(Object obj) {
		 if(obj instanceof Student) {
			 Student temp = (Student) obj; 
		
		 }
		 
	 }
	
	    
	 public String toString() {
		 return super.toString() + " " + funds;  
	 }     
	   
	 /**
	  * This method computes the total tuition amount due by an InState Student
	  * If a Student is part time(<12 credits), they pay 846 for University Fee
	  * If a Student is full time(>=12 credits), they pay $1,441 for University Fee
	  * Instate students get funding which decreases their tuition amount
	  * @return total tuition amount due 
	  */
	 public int tuitionDue(){
		 int tuitionDue; 
		 if(credit < 12)
			 tuitionDue = 846 + 433 * credit - funds; 
		 else
			 tuitionDue = 1441 + 433 * credit - funds; 
		 return tuitionDue; 
	 }  

}

/**
 * Tuition - $433/credit 
 * University Fee - $846 (part time) if credits less than 12
 * University Fee - $1,441 (full time) if credits greater than 12
 * Only full time students may get various amounts of funds
 */

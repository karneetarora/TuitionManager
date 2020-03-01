 /**
 * Student class implements the Comparable Interface.
 * Methods include - compareTo(Object obj),toString() , and the abstract method: tuitionDue()
 * 
 * @author Karneet Arora, Manel Bermad
 */
public abstract class Student implements Comparable {
	 private String fname;    
	 private String lname;    
	 protected int credit;        
	 
	//constructor 
	 public Student(String fname, String lname, int credit) {
		 this.fname = fname; 
		 this.lname = lname; 
		 this.credit = credit; 
	 }       
	
/**
 * @param obj : object to compare to this.
 * @return return 0 if fname and lname are equal, -1 if this < obj, 1 if this > obj. 
 */

	 public int compareTo(Object obj) {
		 if(obj instanceof Student) {
			 Student temp = (Student) obj;
			 int fnameComparaison  = temp.fname.compareTo(this.fname);
			 int lnameComparaison  = temp.lname.compareTo(this.lname);

			 if (fnameComparaison == 0 && lnameComparaison == 0) {
				 return 0;
				 }
			 else if(fnameComparaison > 0 ){
				 return 1;
			 }
			 }
		return -1;
			 
			// if (temp.fname.equals(this.fname) && temp.lname.equals( this.lname))
			//		 return 0;  }
		// return -1; 
	 }
	
	 /**
	  * toString print the first name, last name, and credit hour of the specified object.
	  * @return information about the object.
	  */
	 public String toString() {
		 return this.fname + " " + this.lname + " " + this.credit; 
	 }     
	   
	 /**
	  * tuitionDue() is an abstract method that computes the total tuition amount
	  * The subclasses perform the calculations       
	  */
	 public abstract int tuitionDue();
		 
}

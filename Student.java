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
	
	 //must implement compareTo method because Student class implements the Comparable Interface    
	 //return 0 if fname and lname are equal, -1 if this < obj, 1 if this > obj    
	 public int compareTo(Object obj) {
		 if(obj instanceof Student) {
			 Student temp = (Student) obj; 
			 if (temp.fname == this.lname)
					 return 0; 	
		 }
		 return -1; 
	 }
	
	 //return a string with fname, lname and credit hours; subclasses will be using this method.    
	 public String toString() {
		 return fname + " " + lname + " " + credit; 
	 }     
	   
	 /**
	  * An abstract method to compute the total tuition amount
	  * The subclasses perform the calculations       
	  */
	 public abstract int tuitionDue();
		 
}

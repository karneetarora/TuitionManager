public class Outstate extends Student {
	private boolean tristate; 
	
	/**
	 * This is a constructor for Outstate students 
	 * 
	 * @param 
	 */
	public Outstate(String fname, String lname, int credit, boolean isTriState) {		
		super(fname, lname, credit);
		this.tristate = isTriState; 
	}
	
	 /**
	  * This method computes the total tuition amount due by an OutState Student
	  * If a Student is part time(<12 credits), they pay 846 for University Fee
	  * If a Student is full time(>=12 credits), they pay $1,441 for University Fee
	  * Outstate students who are in TriState get a discount of $200/credit
	  * @return total tuition amount due 
	  */
	public int tuitionDue() {
		int tuitionDue; 
		if(credit < 12)
			tuitionDue = 846 + 756 * credit; 
		else
			tuitionDue = 1441 + 756 * credit; 
		if(tristate) 
			tuitionDue = tuitionDue - 200 * credit; 
		
		return tuitionDue; 
	}

}


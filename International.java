public class International extends Student {
	private boolean exchange; 
	
	public International(String fname, String lname, int credit, boolean isExchange) {
		super(fname, lname, credit); 
		exchange = isExchange; 
	}
	
	public int tuitionDue() { 
		int tuitionDue; 
		if(credit < 12) {
			if(exchange)
				tuitionDue = 846 + 350; 
			else
				tuitionDue = 846 + 350 + 945 * credit; 
		}
		else {
			if(exchange)
				tuitionDue = 1441 + 350; 
			else
				tuitionDue = 1441 + 350 +  945 * credit ; 
		}
		return tuitionDue; 
	}

}

/**
 * Tuition - $945/credit 
 * University Fee - $846 (part time) if credits less than 12
 * University Fee - $1,441 (full time) if credits greater than 12
 * International fee - $350
 * Exchange students only pay university + international fee
 */

/**
 * TuitionManager Class - parses through the input and runs the correct method
 * Methods include - add(), remove(), print()
 @author Manel Bermad, Karneet Arora 
 */

import java.util.Scanner;

public class TuitionManager {
	

    static String command, fname, lname;
    static Object data;// type-specific data>
    static int credit;
    static StudentList list;

	public static void main(String[] args) {

		Scanner stdin;
	    boolean done = false;
	    
		 list = new StudentList();
		
	      while ( !done )
	      {
	    	 stdin =  new Scanner(System.in);
	    	 int lineSize = 0;
	    	 String line = "";	    	 
	    	 
	    	 while(stdin.hasNextLine()){
	    		 line = stdin.nextLine();
	    		 String w[]= line.split(" ");
	    		 
	    		 lineSize = w.length;

	             if(lineSize == 5){
	            	 command= w[0];
	            	 switch (command)
	            	 {
	            	 case "I":
	            		 fname = w[1];
	            		 lname = w[2];

	            		 try{ 
	            			 credit = Integer.parseInt(w[3]);
	            		 } catch (NumberFormatException e) {
	            			 System.out.println("Credit wrongly formatted.");
	            			 credit = 0;
	            			 break;
	            		 }
	            		 try{ 
	            			 data = Integer.parseInt(w[4]);
	            		 } catch (NumberFormatException e) {
	            			 System.out.println("Dollar amount wrongly formatted.");
	            			 data = 0;
	            			 break;
	            		 }
	            		 
	            		 if (credit < 1){
	            			 System.out.println("Credit wrongly formatted.");
	            			 break;
	            		 }else{
	            			 add();
	            		 }
	            		 
	            		 break;
	            		 
	            	 case "O":
	            		 fname = w[1];
	            		 lname = w[2];
	            		 // credit thingy
	            		 try{ 
	            			 credit = Integer.parseInt(w[3]);
	            		 } catch (NumberFormatException e) {
	            			 System.out.println("Credit wrongly formatted.");
	            			 credit = 0;
	            			 break;
	            		 }
	            		 
	            		 if (credit < 1){
	            			 System.out.println("Credit wrongly formatted.");
	            			 break;
	            		 }
	            		 
	            		 
	            		 if(w[4].equals("T")){
	            			 data = true;
	            			 add();
	            		 }else if (w[4].equals("F")){
	            			 data = false;
	            			 add();
	            		 }
	            		 else{
		            		 System.out.println("Input not well-formatted.");
		            		 break;
	            		 }
	            		 break;
	            		 
	            		 
	            		 
	            	 case "N":
	            		 fname = w[1];
	            		 lname = w[2];
	            		 
	            		 // credit thingy
	            		 try{ 
	            			 credit = Integer.parseInt(w[3]);
	            		 } catch (NumberFormatException e) {
	            			 System.out.println("Credit wrongly formatted.");
	            			 credit = 0;
	            			 break;
	            		 }
	            		 
	            		 if (credit < 9){
	            			 System.out.println("Credit wrongly formatted(redit < 1).");
	            			 break;
	            		 }
	            		 
	            		 
	            		 if(w[4].equals("T")){
	            			 data = true;
	            			 add();
	            		 }else if (w[4].equals("F")){
	            			 data = false;
	            			 add();
	            		 }
	            		 else{
		            		 System.out.println("Input not well-formatted.");
		            		 break;
	            		 }
	            		 break;
	            		 
	            		 
	            		 
	            		 
	            	 default:
	            		 System.out.println("Command '"+ command +"' not supported!");

	            	 }
	            	 
	             }else if(lineSize == 3){
	            	 command= w[0];
	            	 if(command.equals("R")){
	            		 fname = w[1];
	            		 lname = w[2];
	            		 remove();
	            	 }
	            
	             }else if(lineSize == 1){
	            	 command = w[0];
	            	 switch (command)   
	                 {   
	                    case "P": print(); 
	        		      break;               
	                    case "Q": System.out.println("Program terminated."); 
	                    		  stdin.close();
	    	 					  done = true;
	                    		  System.exit(0);
	                    	break;
	                    default: 
	                    	System.out.println("Command '"+ command +"' not supported!");
	                 }  
	             
	             }else{
	            	 System.out.println("Wrong input!");
	             }
	            
	    	 }

	}	      
}
	
	

	   /**
	    * add() adds a student to the student List  if it is well formated and if it doesn't exist already.
	    */
	   private static void add()
	   {	
		   // create dummy Student since only fname and lname are compared.
		   Student dummyStudent = new Instate( fname,  lname, 0, 0); 
		   
		   if(!list.contains(dummyStudent)){
			   Student s;
			   if(command.equals("I")){
				   s = new Instate( fname,  lname,  credit,  (int) data); 
			   }else if(command.equals("O")){
				   s = new Outstate( fname,  lname,  credit,  (boolean) data); 
			   }else{ // if international N
				   s = new International( fname,  lname,  credit,  (boolean) data); 
			   }
			   list.add(s);
		   
		   }else{
			   System.out.println("Student is already in the list.");
		   }
	   }
	   
	   
	   /**
	    * remove() removes the specified student from student List if 
	    * it is well formatted and if it exists in list.
	    */
	   private static void remove(){
		   
		   // create dummy Student since only fname and lname are compared.
		   Student s = new Instate( fname,  lname, 0, 0); 
		   if(!list.contains(s)){
			   // issue!
			   System.out.println("Student not in the list.");
		   }else{
			   list.remove(s);
		   }
	   }
	   
	   /**
	    * print() outputs the students in the student List.
	    */
	   private static void print(){
		   if (list.isEmpty()){
			   System.out.println("There are 0 students.");
		   }else{
			   list.print();
		   }  
	 
	   }   

	} 


package Assignment;

import java.util.ArrayList;
import java.util.Iterator;

public class HandleConcurrentModificationException {
	public static void main(String[] args) {
		//Creating an object of ArrayList Object 
        ArrayList<String> arr 
            = new ArrayList<String>(); 
  
        arr.add("One"); 
        arr.add("Two"); 
        arr.add("Three"); 
        arr.add("Four"); 
  
        try { 
            // Printing the elements 
            System.out.println( 
                "ArrayList: "); 
            Iterator<String> iter 
                = arr.iterator(); 
  
            while (iter.hasNext()) { 
                System.out.print(iter.next() 
                                 + ", "); 
            } 
  
            // No exception is raised as 
            // a modification is done 
            // after the iteration 
            System.out.println( 
                "\n\nTrying to add"
                + " an element in "
                + "between iteration: "
                + arr.add("Five")); 
  
            // Printing the elements 
            System.out.println( 
                "\nUpdated ArrayList: "); 
            iter = arr.iterator(); 
  
            while (iter.hasNext()) { 
                System.out.print(iter.next() 
                                 + ", "); 
            } 
        } 
        catch (Exception e) { 
            System.out.println(e); 
        } 

	}

}

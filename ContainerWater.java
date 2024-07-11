package Assignment;

import java.util.*;

class ContainerWater{
	//Time Complexity: O(n). 
	//Space Complexity: O(1). 

 public static int maxArea(int A[], int len)
 {
	 
	 System.out.println("Checking for the values");

	  Arrays.stream(A).forEach(element -> System.out.print(element+"\t"));
	  System.out.println();
	  
     int l = 0;
     int r = len -1;
     int area = 0;
  
     while (l < r)
     {
         // Calculating the max area
         area = Math.max(area, 
                     Math.min(A[l], A[r]) * (r - l));
                      
         if (A[l] < A[r])
             l += 1;
              
         else
             r -= 1;
     }
     return area;
 }
  
 public static void main(String[] args)
 {
     int a[] = {1, 5, 4, 3};
     int b[] = {3, 1, 2, 4, 5};
  
     int len1 = 4;
     System.out.println("Max Area computed:"+ maxArea(a, len1)+"\n" );
  
     int len2 = 5;
     System.out.println("Max Area computed:"+ maxArea(b, len2) );
 }
 
}

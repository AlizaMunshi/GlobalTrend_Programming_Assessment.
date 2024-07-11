package Assignment;

import java.util.Arrays;

public class KthSmallestElement {
	public static int kthSmallest(Integer[] arr, int K)
    {
		System.out.println("\nElements are :");
	    Arrays.stream(arr).forEach(element -> System.out.print(element+"\t"));
	    System.out.println("\nFinding for K="+K);	
        // Sort the given array
        Arrays.sort(arr);

        // Return K'th element in
        // the sorted array
        return arr[K - 1];
    }

    // driver's code
    public static void main(String[] args)
    {
      
        // Function call
        System.out.println("K'th smallest element is "
                         + kthSmallest(new Integer[] { 12, 3, 5, 7, 19 }, 2));
        System.out.println("K'th smallest element is "
                + kthSmallest(new Integer[] { 7, 10, 4, 3, 20, 15 }, 3));
        System.out.println("K'th smallest element is "
                + kthSmallest(new Integer[] {10, 5, 4, 3, 48, 6, 2, 33, 53, 10}, 4));
    }
}

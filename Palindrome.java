package Assignment;

public class Palindrome {
	public static boolean isPalindrome(int i, int j, String A) {
		
// comparing the two pointers
		if (i >= j) {
			return true;
		}

// comparing the characters on those pointers
		if (A.charAt(i) != A.charAt(j)) {
			return false;
		}

// checking everything again recursively
		return isPalindrome(i + 1, j - 1, A);
	}

	public static boolean isPalindrome(String A) {
		return isPalindrome(0, A.length() - 1, A);
	}

// main function
	public static void main(String[] args) {
		String input1 ="RaceCar";
		System.out.println("Checking for "+input1);
		System.out.println(isPalindrome(input1.toLowerCase())?input1+" is Palindrome":input1+" is not Palindrome");
		
		String input2 ="GlobalTrend";
		System.out.println("Checking for "+input2);
		System.out.println(isPalindrome(input2.toLowerCase())?input2+" is Palindrome":input2+" is not Palindrome");
	}

}

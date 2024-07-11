package Assignment;

public class ValidStringBracket {
	/*
	 * Time Complexity: O(N), Iteration over the string of size N one time.
		Auxiliary Space: O(1)
	 */
	
	public static boolean areBracketsBalanced(String s)
    {
		System.out.println("\nChecking for string : "+s);
        int i = -1;
        char[] stack = new char[s.length()];
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                stack[++i] = ch;
            else {
                if (i >= 0
                    && ((stack[i] == '(' && ch == ')')
                        || (stack[i] == '{' && ch == '}')
                        || (stack[i] == '[' && ch == ']')))
                    i--;
                else
                    return false;
            }
        }
        return i == -1;
    }

    public static void main(String[] args)
    {
    	System.out.println(areBracketsBalanced("[()]{}{[()()]()}")? "Valid String": "InValid String");
    	System.out.println(areBracketsBalanced("[(])")? "Valid String": "InValid String");
    	System.out.println(areBracketsBalanced("{()}[]")? "Valid String": "InValid String");
    }

}

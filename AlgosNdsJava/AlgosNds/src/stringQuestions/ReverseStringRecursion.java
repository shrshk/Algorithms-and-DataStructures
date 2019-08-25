package stringQuestions;

public class ReverseStringRecursion {
	static String reverseString(String str) {
		if (str.isEmpty())
            return str;
        //Calling Function Recursively
		// System.out.println(str.substring(1));
		System.out.println(str.charAt(0));
        return reverseString(str.substring(1)) + str.charAt(0);
	}
	public static void main(String[] args) {
		System.out.println(reverseString("shirish"));
	}
}
package leetcode.TopInterviewQuestions.Strings;

public class ReverseString {
	
	static String reverseString(char[] s) {
		int start = 0;
		int mid = s.length/2;
		for (int i=s.length-1; i>=mid; i--) {
			char temp = s[start];
			s[start] = s[i];
			s[i] = temp;
			start++;
		}		
		return String.valueOf(s);
	}

	public static void main(String[] args) {
		System.out.println(reverseString("shirk".toCharArray()));
	}

}
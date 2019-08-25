package leetcode.GoogleInterviewQuestions;

import java.util.HashSet;
import java.util.Set;

// NOT COMPLETED REVISIT.
public class RepeatedStringMatch {
	
	static int repeatedString(String A, String B) {
		Set<Character> s1 = new HashSet<>();
		Set<Character> s2 = new HashSet<>();
		
		for(int i=0; i<A.length();i++) {
			s1.add(A.charAt(i));
		}
		
		for (int j=0; j<A.length(); j++) {
			s2.add(A.charAt(j));
		}
		
		if(!s1.equals(s2)) {
			return -1;
		}
		int tempFactor = 1;// abc abc abc abc  cabcabca     abcabcabc
		while (A.indexOf(B)==-1) {
			A = A + A;
			tempFactor++;
		}
		
		return tempFactor;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(repeatedString("abc", "cabcabca"));
		//System.out.println("abcabcabcabc".indexOf("cabcabca"));
		

	}

}

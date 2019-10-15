package leetcode.TopInterviewQuestions.Strings;

import java.util.ArrayList;
import java.util.List;

public class FirstNonRepeating {
	static int firstNonRepeating(String s) {
		List<Character> repeating = new ArrayList<>();
		List<Character> nonRepeating = new ArrayList<>();
		for (int i=0; i<s.length();i++) {
			Character temp = s.charAt(i);
			if(repeating.contains(temp)) {
			    nonRepeating.remove(temp);
			} else {
				repeating.add(temp);
				nonRepeating.add(temp);
			}
		}
		char c = nonRepeating.size()>0 ? nonRepeating.get(0) : ' ';
		int result = c!=' ' && s.indexOf(c)>=0 ? s.indexOf(c) : -1;
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(firstNonRepeating("ii"));
	}
}
// s h i r i sh
// r
//    r

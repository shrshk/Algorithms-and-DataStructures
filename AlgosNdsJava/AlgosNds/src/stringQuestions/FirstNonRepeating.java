package stringQuestions;

import java.util.ArrayList;
import java.util.List;

public class FirstNonRepeating {
	static char nonRepeating(String s) {
	    List<Character> repeating = new ArrayList<>();
	    List<Character> nonRepeating = new ArrayList<>();
	    for(int i=0; i<s.length();i++) {
	    	if (repeating.contains(s.charAt(i)))
	    		continue;
	    	if(nonRepeating.contains(s.charAt(i))) {
	    		nonRepeating.remove((Character) s.charAt(i));
	    		repeating.add(s.charAt(i));
	    	} else{
	    		nonRepeating.add(s.charAt(i));
	    	}
	    }
	    return nonRepeating.get(0);
	}
	public static void main(String[] args) {
		System.out.println(nonRepeating("shirish")); // s h i r 
		                               // r
	}
}

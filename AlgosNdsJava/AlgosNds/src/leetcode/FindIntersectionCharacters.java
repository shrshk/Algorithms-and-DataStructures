package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindIntersectionCharacters {
	
	static boolean commonChars(char[] ch1, char[] ch2) {
		List<Character> result = new ArrayList<Character>();
		Set<Character> set = new HashSet<Character>();
		for (int i=0; i<ch1.length;i++) {
			set.add(ch1[i]);
		}
		
		for(int i=0;i<ch2.length;i++) {
			if(set.contains(ch2[i])) {
				result.add(ch2[i]);
			}
		}
		System.out.println(result.size());
		
		return result.size()>0;
	}
	public static void main(String[] args) {
		System.out.println(commonChars(new char[] {'a','b','c','x'}, new char[] {'z','y','i'}));
	}

}

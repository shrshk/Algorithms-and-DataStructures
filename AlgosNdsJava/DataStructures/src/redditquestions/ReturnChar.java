package redditquestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReturnChar {
	
	public static char retChar(String s) {
		List<Character> chList = new ArrayList<Character>();
		List<Character> chList2 = new ArrayList<Character>();
		
		for(int i=0;i<s.length();i++) {
			if (!chList.contains(s.charAt(i))) {
				chList.add(s.charAt(i));
				chList2.add(s.charAt(i));
			} else if (chList.contains(s.charAt(i))) {
				chList.add(s.charAt(i));
				chList2.remove(s.charAt(i));
			}
		}
		
		if (chList2.isEmpty()) {
			return '_';
		}
		
		return chList2.get(0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		String s = "ngrhhqbhnsipkcoqjyviikvxbxyphsnjpdxkhtadltsuxbfbrkof";		
		System.out.println(retChar(s));
	}
}

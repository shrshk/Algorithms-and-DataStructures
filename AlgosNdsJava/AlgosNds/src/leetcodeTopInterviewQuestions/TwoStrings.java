package leetcodeTopInterviewQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoStrings {
	void twoStrings(List<String> a, List<String> b) {
		int len = Math.min(a.size(), b.size());

		int idx = 0;
		while (idx < len) {
			String aStr = a.get(idx);
			String bStr = b.get(idx);
			if (intersection(aStr, bStr)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}				
			idx++;
		}

	}
	
	boolean intersection(String a, String b) {
		Set<Character> set = new HashSet<>();
		for (char c: a.toCharArray()) {
			set.add(c);
		}
		
		for (char c: b.toCharArray()) {
			if (set.contains(c))
				return true;
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
		new TwoStrings().twoStrings(Arrays.asList("ab","cd","ef"), Arrays.asList("af","ee","ef"));
	}
}

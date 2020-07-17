package twilioPrep.longestCommonPrefix;

import java.util.HashSet;
import java.util.Set;

public class LongestWithoutRepeating {
	// nndNfdfdf
	public static long solution(String s) {
		// Type your solution here
		// nndNfdfdf

		int i = 0;
		int n = s.length();
		int maxLen = 0;

		while (i < n) {
			int j = i+1;
			Set<Character> set = new HashSet<>();
			while (j < n && !set.contains(s.charAt(j))) {
				set.add(s.charAt(j));
				j++;				
			}	
			maxLen = Math.max(set.size(), maxLen);
			i++;
		}

		return maxLen;

	}
	
	public static void main(String[] args) {
		System.out.println(solution("nndNfdfdf"));
	}
}

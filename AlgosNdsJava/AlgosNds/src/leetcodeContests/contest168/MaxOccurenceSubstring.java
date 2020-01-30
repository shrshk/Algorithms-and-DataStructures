package leetcodeContests.contest168;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxOccurenceSubstring {
	// String s, int maxLetters, int minSize, int maxSize
	public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
		// slide window on maxLetters and maxSize else inc. string
		int i = 0, j = 1;
		Map<String, Integer> freqMap = new HashMap<>();
		String temp = "";
		int max = 0;
		while (i < s.length() && j <= s.length()) {
			temp = s.substring(i, j);
			if (temp.length() < minSize)
				j++;
			else {
				if (criteria(temp, maxLetters, maxSize)) {
					freqMap.put(temp, freqMap.getOrDefault(temp, 0) + 1);
					max = Math.max(max, freqMap.get(temp));
				}
				i++;
				j = i + 1;
			}
		}
		return max;
	}

	private boolean criteria(String s, int maxLetters, int maxSize) {
		Set<Character> set = new HashSet<>();
		for (char c : s.toCharArray())
			set.add(c);
		if (set.size() > maxLetters)
			return false;
		if (s.length() > maxSize)
			return false;
		return true;
	}

	public static void main(String[] args) {
		// System.out.println("aababcaab".substring(0, 1));
		System.out.println(new MaxOccurenceSubstring().maxFreq("aababcaab", 2, 3, 4)); // aa
																						// //aab
		// aa
		// slide window whe
	}
}

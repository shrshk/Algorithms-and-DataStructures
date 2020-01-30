package amazonLeetCode.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SmallestWindowInString {
	public String minWindow(String s, String t) {
		int[] map = new int[128];
		for (char c : t.toCharArray()) {
			map[c]++;
		}
		int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
		while (end < s.length()) {
			// S = "ADOBEC ODEBANC", T = "ABC"
			final char c1 = s.charAt(end);
			if (map[c1] > 0)
				counter--;
			map[c1]--;
			end++;
			while (counter == 0) {
				if (minLen > end - start) {
					minLen = end - start;
					minStart = start;
				}
				final char c2 = s.charAt(start);
				map[c2]++; // A DOBEC ODEBANC
				if (map[c2] > 0)
					counter++;
				start++;
			}
		}

		return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
	}

	// this assumes no duplicates in t
	public String smallestWindowSet(String s, String t) {
		int minLen = Integer.MAX_VALUE;
		String minString = "";
		// sliding window
		// swipe the string to until all chars in t are found
		// reset map count after all chars are found
		// get the window side update minLen.
		Set<Character> set = new HashSet<>();
		t.chars().forEach(c -> set.add((char) c));
		int i = 0, j = 0;
		while (i < s.length() && j < s.length()) {
			if (set.contains(s.charAt(j))) {
				set.remove(s.charAt(j));
			}
			if (set.isEmpty()) {
				t.chars().forEach(c -> set.add((char) c));
				if (minLen > j - i + 1) {
					minLen = j - i + 1;
					minString = s.substring(i, j + 1);
				}
				minLen = Math.min(minLen, j - i + 1);
				i++;
				j = i;
			} else {
				j++;
			}

		}

		return minString;
	}

	// duplicates in t are possible
	public String smallestWindow(String s, String t) {
		int minLen = Integer.MAX_VALUE;
		String minString = "";
		// sliding window
		// swipe the string to until all chars in t are found
		// reset map count after all chars are found
		// get the window side update minLen.
		// Map<Character, Integer> map = new HashMap<>();
		// for (char c: t.toCharArray()) {
		// if (!map.containsKey(c))
		// map.put(c, 1);
		// else
		// map.put(c, map.get(c)+1);
		// }
		List<Character> list = new ArrayList<>();
		t.chars().forEach(c -> list.add((char) c));
		int i = 0, j = 0;
		while (i < s.length() && j < s.length()) {
			if (list.contains(s.charAt(j))) {
				list.remove((Character) s.charAt(j));
			}
			// "ADOBECODEBANC", "ABC"
			if (list.isEmpty()) {
				// reset map
				t.chars().forEach(c -> list.add((char) c));
				if (minLen > j - i + 1) {
					minLen = j - i + 1;
					minString = s.substring(i, j + 1);
				}
				minLen = Math.min(minLen, j - i + 1);
				i++;
				j = i;
			} else {
				j++;
			}

		}

		return minString;
	}

	public String smallWindowSubStr(String s, String t) {
		// steps
		// make a map of t chars
		// swipe thru S to find the window with all t chars
		// while loop thru s and adjust map and counter accordingly
		// when counter is 0 i.e. all chars in t are found
		// update minLen
		// reset map and move to start till the counter is 0

		Map<Character, Integer> map = new HashMap<>();

		for (char c : t.toCharArray()) {
			if (!map.containsKey(c))
				map.put(c, 1);
			else
				map.put(c, map.get(c) + 1);
		}

		int i = 0, j = 0, counter = t.length(), minStart = 0, minLen = Integer.MAX_VALUE;
		while (j < s.length()) {
			char c1 = s.charAt(j);
			if (map.containsKey(c1)) {
				map.put(c1, map.get(c1) - 1);
				if (map.get(c1)>=0)
					counter--;								
			}
			j++;
			while (counter == 0) {
				if (minLen > j - i) {
					minLen = j - i;
					minStart = i;
				}
				char c2 = s.charAt(i);
				if (map.containsKey(c2)) {
					if (map.get(c2)>=0)
						counter++;
					map.put(c2, map.get(c2) + 1);					
				}
				i++;
			}
		}

		return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart+minLen);
	}

	public static void main(String[] args) {
		//System.out.println(new SmallestWindowInString().smallWindowSubStr("ADOBECODEBANC", "ABC"));
		System.out.println(new SmallestWindowInString().smallWindowSubStr("bba", "ab"));
	}
}

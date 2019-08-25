package leetcode.shirishFavsList;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SmallestSubStringWithAllChars {
	static String smallestSubString(String s, char[] arr) {
		// xyyzyzyx //
		char[] c = s.toCharArray();
		if (s.length() == 0 || arr.length == 0 || s.length() < arr.length)
			return "";
		int i = 0;
		int j = i;
		String smallest = "";
		int minLen = Integer.MAX_VALUE;
		Map<Character, Boolean> map = charMap(arr);
		while (i < c.length & j < c.length) {
			if (map.containsKey(c[j]) && !map.get(c[j])) {
				map.put(c[j], true);
				if (allCharsFound(map)) {
					if (minLen > j - i) {
						minLen = j - i;
						smallest = s.substring(i, j + 1);
					}
					j = i + 1;
					i++;
					map = charMap(arr);
				} else {
					j++;
				}
			} else {
				j++;
			}

		}

		return smallest;
	}

	static Map<Character, Boolean> charMap(char[] arr) {
		Map<Character, Boolean> map = new HashMap<>();
		for (char c : arr) {
			map.put(c, false);
		}
		return map;
	}

	static Boolean allCharsFound(Map<Character, Boolean> map) {
		for (Entry<Character, Boolean> entry : map.entrySet()) {
			if (!entry.getValue())
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(smallestSubString("a", new char[] { 'b' }));
	}
}

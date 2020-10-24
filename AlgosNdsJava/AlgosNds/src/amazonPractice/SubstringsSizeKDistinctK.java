package amazonPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SubstringsSizeKDistinctK {
	List<String> res;
	Set<String> set;

	public List<String> subStringsKDistinctOptimized(String s, int k) {
		res = new ArrayList<>();

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0, j = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				j = Math.max(j, map.get(c));
			}

			if (i - j + 1 == k && !res.contains(s.substring(j, i + 1))) {
				res.add(s.substring(j, i + 1));
				j++;
			}
			map.put(c, i + 1);
		}

		return res;
	}

	public List<String> subStringsKDistinctList(String s, int k) {
		res = new ArrayList<>();
		set = new HashSet<>();
		int len = s.length();

		for (int i = 0; i < len; i++) {
			helper(i, s, new StringBuilder(), k);
		}

		return res;
	}

	private void helper(int start, String s, StringBuilder sb, int k) {
		for (int i = start; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!isUnique(sb)) {
				return;
			}
			if (sb.length() == k) {
				String ans = sb.toString();
				if (!set.contains(ans)) {
					set.add(ans);
					res.add(ans);
				}
				return;
			}
			sb.append(c);
		}

	}

	private boolean isUnique(StringBuilder sb) {
		Set<Character> unique = new HashSet<>();
		for (int i = 0; i < sb.length(); i++) {
			if (unique.contains(sb.charAt(i))) {
				return false;
			}
			unique.add(sb.charAt(i));
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new SubstringsSizeKDistinctK().subStringsKDistinctOptimized("awaglknagawunagwkwagl", 4));
		// "wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna",
		// "unag", "nagw", "agwk", "kwag"
		// wagl, aglk, glkn, lkna, knag, gawu, awun, wuna, unag, nagw, agwk,
		// kwag
	}
}

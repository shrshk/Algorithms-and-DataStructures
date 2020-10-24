package bloombergPractice;

import java.util.HashMap;
import java.util.Map;

// not sure this is correct
public class CandyCrush1DFollowUp {
	public String candyCrush1DFollowUp(String s, int k) {
		Map<String, String> cache = new HashMap<>();
		return dfs(s, 0, k, cache);
	}

	private String dfs(String s, int start, int k, Map<String, String> cache) {
		if (cache.containsKey(s))
			return cache.get(s);

		if (start >= s.length())
			return s;

		if (!kConsecutive(s, start, k)) {
			return dfs(s, start + 1, k, cache);
		}

		int next = start + k;

		char repeated = s.charAt(start);

		while (next < s.length() && s.charAt(next) == repeated) {
			next++;
		}

		String nextStr = s.substring(0, start) + s.substring(next, s.length());

		String uncrushed = dfs(s, next, k, cache);
		String crushed = dfs(nextStr, 0, k, cache);

		if (uncrushed.length() < crushed.length()) {
			cache.put(s, uncrushed);
		} else {
			cache.put(s, crushed);
		}

		return cache.get(s);
	}

	private boolean kConsecutive(String s, int start, int k) {
		int idx = start + k - 1;
		if (idx >= s.length())
			return false;
		char curr = s.charAt(start);
		while (idx >= start && s.charAt(idx) == curr) {
			idx--;
		}
		return idx <= start;
	}

	public static void main(String[] args) {
		System.out.println(new CandyCrush1DFollowUp().candyCrush1DFollowUp("aaabbbacd", 2));
	}
}

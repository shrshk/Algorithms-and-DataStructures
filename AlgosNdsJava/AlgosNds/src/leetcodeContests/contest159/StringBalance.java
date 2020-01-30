package leetcodeContests.contest159;

import java.util.HashMap;
import java.util.Map;

public class StringBalance {
	// EQRW
	// EEEQRRRR
	// EEQQ
	// QWER
	// QQEE
	// QQQW
	/*
	 * { Q:1 -> 0 E:3 -> 2 -> 1 -> 0 W:0 R:4 }
	 */

	// EE EQRR RR
	// EE WWQQ RR

	//

	public int balancedString(String s) {
		int[] count = new int[128];
		int n = s.length(), res = n, i = 0;
		for (int j = 0; j < n; ++j) {
			++count[s.charAt(j)];
		}
		for (int j = 0; j < n; ++j) {
			--count[s.charAt(j)];
			while (i < n && count['Q'] <= n / 4 && count['W'] <= n / 4 && count['E'] <= n / 4 && count['R'] <= n / 4) {
				res = Math.min(res, j - i + 1);
				++count[s.charAt(i++)];
			}
		}
		return res;
	}

	public int balancedStringWithHashMap(String s) {
		// EE EQRR RR given string
		// EE WWQQ RR result string
		int n = s.length();
		int res = n;
		int i = 0;
		// initialize map
		Map<Character, Integer> map = new HashMap<>();
		map.put('Q', 0);
		map.put('W', 0);
		map.put('E', 0);
		map.put('R', 0);

		// update counts
		for (Character c : s.toCharArray()) {
			map.put(c, map.get(c) + 1);
		}

		// sliding window
		for (int j = 0; j < s.length(); j++) {
			char current = s.charAt(j);
			// update count for the current character
			map.put(current, map.get(current) - 1);
			// after a swipe of QWER is done where all the max. count conditions for Q W E R are met reset the map counts.
			while (i < n && map.get('Q') <= n / 4 && map.get('W') <= n / 4 && map.get('E') <= n / 4
					&& map.get('R') <= n / 4) {
				res = Math.min(res, j - i + 1); // update the found window.
				// reset map counts outside the found window to find a smaller window.
				char resetChar = s.charAt(i);
				map.put(resetChar, map.get(resetChar) + 1);
				i++;
			}
		}

		return res;

	}

	public static void main(String[] args) {
		//System.out.println(new StringBalance().balancedString("EEEQRRRR"));
		System.out.println(new StringBalance().balancedStringWithHashMap("EEEQRRRR"));
	}

}

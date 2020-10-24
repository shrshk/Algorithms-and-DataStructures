package amazonPractice;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		int n = s.length();
		Boolean[][] cache = new Boolean[n][n];
		for (int i = n; i > 0; i--) {
			for (int j = 0; j <= n - i; j++) {
				if (isPalindrome(s, j, i + j - 1, cache)) {
					return s.substring(j, j + i);
				}
			}
		}

		return "";
	}

	private boolean isPalindrome(String s, int i, int j, Boolean[][] mem) {
		if (i >= j)
			return true;
		if (mem[i][j] != null)
			return mem[i][j];
		// String key = i + "_" + j;
		// if (cache.containsKey(key))
		// return cache.get(key);

		Boolean isPalin = s.charAt(i) == s.charAt(j) && isPalindrome(s, i + 1, j - 1, mem);

		mem[i][j] = isPalin;

		return mem[i][j];
	}

}

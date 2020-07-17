package leetcode30DayChallenge.may;

public class EditDistance {
	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				dp[i][j] = -1;
			}
		}

		return helper(word1, word2, 0, 0, dp);
	}

	private int helper(String word1, String word2, int i, int j, int[][] dp) {

		if (dp[i][j] != -1)
			return dp[i][j];

		if (word1.length() == i) {
			return word2.length() - j;
		}

		if (word2.length() == j) {
			return word1.length() - i;
		}

		if (word1.charAt(i) == word2.charAt(j)) {
			return dp[i][j] = helper(word1, word2, i + 1, j + 1, dp);
		}

		return dp[i][j] = 1 + Math.min(helper(word1, word2, i + 1, j, dp), // delete
				Math.min(helper(word1, word2, i, j + 1, dp), // insert
						helper(word1, word2, i + 1, j + 1, dp))); // replace a
																	// char

	}
}

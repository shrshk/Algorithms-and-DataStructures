package dynamicProgramming;

public class LongestCommonSubsequence {
	public int longestCommonDp(String s1, String s2) {
		int m = s1.length(), n = s2.length();
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[m][n];
	}

	public int longestCommonRecursion(String s1, String s2) {
		return helper(0,0,s1,s2);
	}

	private int helper(int i, int j, String s1, String s2) {
		// bd
		// a
		int m = s1.length();
		int n = s2.length();

		if (i >= m || j >= n) {
			return 0;
		}

		if (s1.charAt(i) == s2.charAt(j)) {
			return 1 + helper(i + 1, j + 1, s1, s2);
		}

		return Math.max(helper(i+1,j, s1, s2), helper(i,j+1,s1,s2));
	}

	public static void main(String[] args) {
		System.out.println(new LongestCommonSubsequence().longestCommonDp("bd", "abcd"));
		System.out.println(new LongestCommonSubsequence().longestCommonRecursion("bd", "abcd"));
	}

}

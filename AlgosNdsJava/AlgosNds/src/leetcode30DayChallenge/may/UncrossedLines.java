package leetcode30DayChallenge.may;

public class UncrossedLines {
	public int maxUncrossedLines(int[] A, int[] B) {
		// A = [2,5,1,2,5], B = [10,5,2,1,5,2]
		// 2 5 1 2 5
		// 10 5 2 1 5 2

		int m = A.length;
		int n = B.length;

		int[][] dp = new int[m+1][n+1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (A[i - 1] == B[j - 1]) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[m][n];
	}

	public static void main(String[] args) {
		int[] A = new int[]{2,5,1,2,5};
		int[] B = new int[]{10,5,2,1,5,2};
		System.out.println(new UncrossedLines().maxUncrossedLines(A, B));
	}
}

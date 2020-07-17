package leetcodeContests.contest190;

public class MaxDotProduct {
	public int maxDotProduct(int[] nums1, int[] nums2) {
		// nums1 = [2,1,-2,5], nums2 = [3,0,-6]
		int m = nums1.length, n = nums2.length;
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			dp[i][0] = -1001;
		}

		for (int j = 0; j <= n; j++) {
			dp[0][j] = -1001;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				int prev = Math.max(dp[i - 1][j], dp[i][j - 1]);
				int curr = nums1[i - 1] * nums2[j - 1];
				int prevMaxWithcurr = curr + dp[i - 1][j - 1];
				dp[i][j] = Math.max(prev, Math.max(curr, prevMaxWithcurr));
			}
		}

		return dp[m][n];

	}
}

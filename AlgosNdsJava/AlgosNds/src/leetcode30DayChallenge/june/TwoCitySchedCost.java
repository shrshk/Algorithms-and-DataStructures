package leetcode30DayChallenge.june;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TwoCitySchedCost {
	public int twoCitySchedCost(int[][] costs) {
		// [[10,20],[30,200],[400,50],[30,20]]
		// 10,30
		// 10 30
		// [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
		//

		Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] - a[1] - (b[0] - b[1]);
			}
		});

		// 2N
		int N = costs.length / 2;

		int minCost = 0;

		for (int i = 0; i < costs.length; i++) {
			if (i < N) {
				minCost += costs[i][0];
			} else {
				minCost += costs[i][1];
			}

		}

		return minCost;
	}

	public int twoCitySchedCostDP(int[][] costs) {
		int N = costs.length / 2;
		int[][] dp = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			dp[i][0] = dp[i - 1][0] + costs[i - 1][0];
			System.out.println(dp[i][0]);
		}
		for (int j = 1; j <= N; j++) {
			dp[0][j] = dp[0][j - 1] + costs[j - 1][1];
			System.out.println(dp[0][j]);
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = Math.min(dp[i - 1][j] + costs[i + j - 1][0], dp[i][j - 1] + costs[i + j - 1][1]);
				System.out.println(dp[i][j]);
			}
		}
		return dp[N][N];
	}

	public int twoCitySchedCostBacktrack(int[][] costs) {
		Map<String, Integer> cache = new HashMap<>();
		int res = backtrack(cache, costs, 0, 0, 0);
		System.out.println(cache.toString());
		return res;
	}

	private int backtrack(Map<String, Integer> cache, int[][] costs, int A, int B, int i) {
		String key = i + "_" + A + "_" + B;
		if (cache.containsKey(key)) {
			return cache.get(key);
		}

		int N = costs.length / 2;

		if (A == N && B == N)
			return 0;

		if (i == costs.length)
			return 1001;

		int Achosen = backtrack(cache, costs, A + 1, B, i + 1);
		int Bchosen = backtrack(cache, costs, A, B + 1, i + 1);

		int minCost = Math.min(costs[i][0] + Achosen, costs[i][1] + Bchosen);

		cache.put(key, minCost);

		return minCost;
	}

	public static void main(String[] args) {
		// [[10,20],[30,200],[400,50],[30,20]]
		int[][] costs = new int[][] { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } };

		System.out.println(new TwoCitySchedCost().twoCitySchedCostBacktrack(costs));
	}
}

package leetcode30DayChallenge.june;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {
	int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 } };
	Map<String, Integer> cache = new HashMap<>();

	public int uniquePaths(int m, int n) {
		return dfs(0, 0, m, n);
	}

	private int dfs(int i, int j, int m, int n) {

		String key = i + "_" + j;
		
		if (cache.containsKey(key))
			return cache.get(key);

		if (i == m - 1 && j == n - 1) {
			return 1;
		}
		
		int path = 0;

		for (int[] dir : dirs) {
			int x = i + dir[0];
			int y = j + dir[1];
			if (x >= m || y >= n)
				continue;
			path += dfs(x, y, m, n);
			cache.put(key, path);
		}

		return cache.get(key);

	}

	public static void main(String[] args) {
		System.out.println(new UniquePaths().uniquePaths(23,12));
	}
}

package leetcode30DayChallenge.june;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class DungeonGame {

	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length, n = dungeon[0].length;
		Map<String, Integer> cache = new HashMap<>();
		return dfs(dungeon, 0, 0, m, n, cache);
	}

	private int dfs(int[][] dungeon, int i, int j, int m, int n, Map<String, Integer> cache) {
		String key = i + "_" + j;

		if (i >= m || j >= n)
			return Integer.MAX_VALUE;

		if (cache.containsKey(key))
			return cache.get(key);

		int downPath = dfs(dungeon, i + 1, j, m, n, cache);
		int rightPath = dfs(dungeon, i, j + 1, m, n, cache);

		if (downPath == Integer.MAX_VALUE && rightPath == Integer.MIN_VALUE) {
			int health = dungeon[i][j] > 0 ? 1 : Math.abs(dungeon[i][j]) + 1;
			cache.put(key, health);
			return health;
		}

		int bestPath = Math.min(downPath, rightPath);
		int health = 0;
		if (dungeon[i][j] > 0) {
			health = Math.max(bestPath - dungeon[i][j], 1);
		} else {
			health = Math.abs(dungeon[i][j]) + bestPath;
		}

		cache.put(key, health);
		return health;
	}

	private int dfsX(int i, int j, int[][] dungeon, int m, int n) {
		// if (i >= m || j >= n)
		// return -1000;
		if (i == m - 1 && j == n - 1)
			return dungeon[i][j] > 0 ? 1 : -dungeon[i][j] + 1;

		if (i == m - 1)
			return Math.max(1, dfsX(i, j + 1, dungeon, m, n) - dungeon[i][j]);

		if (i == n - 1)
			return Math.max(1, dfsX(i + 1, j, dungeon, m, n) - dungeon[i][j]);

		int downPath = dfsX(i + 1, j, dungeon, m, n) - dungeon[i][j];
		int rightPath = dfsX(i, j + 1, dungeon, m, n) - dungeon[i][j];

		return Math.max(1, Math.min(rightPath, downPath));
	}

	public int calculateMinimumHPBFS(int[][] dungeon) {
		// -2 -1 -1 -2 2 -3
		int m = dungeon.length, n = dungeon[0].length;

		int health = BFS(dungeon, m, n);

		int lastCell = dungeon[m - 1][n - 1];
		int finalHealth = health + lastCell;

		int minHealth = finalHealth <= 0 ? Math.abs(finalHealth) + 1 : 1;

		return minHealth;

	}

	private int BFS(int[][] dungeon, int m, int n) {

		Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] a, int[] b) {
				int x1 = a[0], y1 = a[1];
				int x2 = b[0], y2 = b[1];
				int val1 = dungeon[x1][y1];
				int val2 = dungeon[x2][y2];

				if (val1 > 0 && val2 < 0)
					return -1;

				if (val1 < 0 && val2 > 0)
					return 1;

				if (val1 < 0 && val2 < 0)
					return val2 - val1;

				return val1 - val2;
			}

		});
		boolean[][] visited = new boolean[m][n];
		int health = Integer.MAX_VALUE;
		q.add(new int[] { 0, 0 });
		int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 } };

		while (!q.isEmpty()) {
			int[] loc = q.poll();
			if (visited[loc[0]][loc[1]])
				continue;
			visited[loc[0]][loc[1]] = true;
			if (loc[0] == m - 1 && loc[1] == n - 1)
				return health;
			health = Math.min(health, dungeon[loc[0]][loc[1]]);
			System.out.println(loc[0] + " " + loc[1]);
			for (int[] dir : dirs) {
				int x = loc[0] + dir[0];
				int y = loc[1] + dir[1];

				if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y])
					continue;

				if (x == m - 1 && y == n - 1)
					return health;

				q.add(new int[] { x, y });

			}
		}
		return health;
	}

	public static void main(String[] args) {
		// [[-2,-3,3],[-5,-10,1],[10,30,-5]]
		int[][] dungeon = new int[][] { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		System.out.println(new DungeonGame().calculateMinimumHP(dungeon));
	}
}

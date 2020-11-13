package amazonLeetCode.treesAndGraphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumOfIslands {

	public int numIslands(char[][] grid) {

		if (grid == null || grid.length == 0)
			return 0;

		int m = grid.length, n = grid[0].length;
		int total = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					dfs(grid, m, n, i, j);
					total++;
				}
			}
		}

		return total;
	}

	private void dfs(char[][] grid, int m, int n, int i, int j) {
		if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0')
			return;
		grid[i][j] = '0';
		int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		for (int[] dir : dirs) {
			int x = i + dir[0];
			int y = j + dir[1];
			dfs(grid, m, n, x, y);
		}
	}

	public int numOfIslandsOld(int[][] grid) {
		int numOfIslands = 0;
		List<int[]> lands = new ArrayList<>();
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1)
					lands.add(new int[] { i, j });
			}
		}
		int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 },
				{ -1, -1 } };
		for (int[] land : lands) {
			int landX = land[0];
			int landY = land[1];
			Queue<int[]> q = new ArrayDeque<>();
			if (visited[landX][landY])
				continue;
			q.add(new int[] { landX, landY });
			while (!q.isEmpty()) {
				int[] conn = q.poll();
				int connX = conn[0];
				int connY = conn[1];
				if (visited[connX][connY])
					continue;
				visited[connX][connY] = true;
				for (int[] dir : dirs) {
					int x = connX + dir[0];
					int y = connY + dir[1];
					if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y] && grid[x][y] == 1) {
						q.add(new int[] { x, y });
					}
				}
			}
		}

		return numOfIslands;
	}

	public int numIslandsOld2(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] marked = new boolean[m][n]; // or visit by setting value as
												// '0'
		int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int islandCount = 0;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (!marked[i][j] && grid[i][j] == '1') {
					bfs(i, j, grid, marked, direction);
					++islandCount;
				}
			}
		}
		return islandCount;
	}

	private void bfs(int i, int j, char[][] grid, boolean[][] marked, int[][] direction) {
		int m = grid.length;
		int n = grid[0].length;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { i, j });
		marked[i][j] = true;
		// bfs
		while (queue.size() > 0) {
			int[] curr = queue.poll();
			for (int[] dir : direction) {
				int x = curr[0] + dir[0];
				int y = curr[1] + dir[1];
				if (x >= 0 && x < m && y >= 0 && y < n) {
					if (!marked[x][y] && grid[x][y] == '1') {
						queue.offer(new int[] { x, y });
						marked[x][y] = true; // mark when enqueued
					}
				}
			}
		}
	}

	public static void main(String[] args) {
//		int[][] grid = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
//				{ 1, 0, 1, 0, 1 } };
//		int[][] grid2 = new int[][] { { 1, 1, 1, 1, 0 }, { 1, 1, 0, 1, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
		// System.out.println(new NumOfIslands().numOfIslands(grid2));
	}
}

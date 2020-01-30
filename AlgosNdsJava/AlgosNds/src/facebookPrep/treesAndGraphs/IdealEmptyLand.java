package facebookPrep.treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IdealEmptyLand {
	// count sum of distance from 0 to all building
	int[][] distance;
	// count how many building each '0' can be reached
	int[][] reach;
	int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	public int shortestDistance(int[][] grid) {
		if (grid == null || grid[0].length == 0)
			return 0;
		int m = grid.length, n = grid[0].length;
		distance = new int[m][n];
		reach = new int[m][n];
		int buildingNum = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					buildingNum++;
					bfs(grid, i, j);
				}
			}
		}
		int shortest = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
					shortest = Math.min(shortest, distance[i][j]);
				}
			}
		}
		return shortest == Integer.MAX_VALUE ? -1 : shortest;

	}

	private void bfs(int[][] grid, int x, int y) {
		int m = grid.length, n = grid[0].length;
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { x, y });
		boolean[][] visited = new boolean[m][n];
		int level = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] curr = q.poll();
				for (int[] dir : dirs) {
					int x1 = dir[0] + curr[0];
					int y1 = dir[1] + curr[1];
					if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n)
						continue;
					if (grid[x1][y1] != 0 || visited[x1][y1])
						continue;
					// find next 0: level++;
					distance[x1][y1] += level;
					reach[x1][y1]++;
					visited[x1][y1]=true;
					q.offer(new int[] { x1, y1 });
				}
			}
			level++;
		}
	}

	/*
	 * [1,0,2,0,1], [0,0,0,0,0], [0,0,1,0,0]
	 */
	public int shortDistanceNW(int[][] grid) {
		// steps
		// for every empty land count dist till all houses r reached
		// if dist is less than minDist update minDist
		int m = grid.length;
		int n = grid[0].length;
		int minDist = Integer.MAX_VALUE;

		int numOfLands = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1)
					numOfLands++;
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// call bfs
				if (grid[i][j] == 0)
					minDist = Math.min(minDist, bfsNW(grid, m, n, new int[] { i, j }, numOfLands));
			}
		}
		return minDist;
	}

	private int bfsNW(int[][] grid, int m, int n, int[] loc, int numOfLands) {
		int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		boolean[][] visited = new boolean[m][n];
		LinkedList<int[]> q = new LinkedList<>();
		q.add(loc);
		int totalDist = 0;
		int currDist = 0;
		List<int[]> lands = new ArrayList<>();
		while (!q.isEmpty() && lands.size() < numOfLands) {
			int[] pos = q.remove();
			int posX = pos[0];
			int posY = pos[1];
			visited[posX][posY] = true;
			for (int[] dir : dirs) {
				int x = posX + dir[0];
				int y = posY + dir[1];

				if (x > 0 && y > 0 && x < m && y < m && !visited[x][y]) {
					if (grid[x][y] == 0) {
						q.addLast(new int[] { x, y });
						currDist++;
					}
					if (grid[x][y] == 1 && !lands.contains(new int[] { x, y })) {
						lands.add(new int[] { x, y });
						visited = new boolean[m][n];
						currDist++;
						q.clear();
						q.add(loc);
						totalDist = totalDist + currDist;
						currDist = 0;
					}

				}

			}
		}

		return totalDist;
	}

	public static void main(String[] args) {
		// [1,0,2,0,1], [0,0,0,0,0], [0,0,1,0,0]
		int[][] grid = new int[][] { { 1, 0, 2, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 } };
		System.out.println(new IdealEmptyLand().shortestDistance(grid));
	}
}

package amazonLeetCode.treesAndGraphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NumOfIslands {
	public int numOfIslands(int[][] grid) {
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
					if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y] && grid[x][y]==1) {
						q.add(new int[] { x, y });
					}
				}
			}
		}

		return numOfIslands;
	}
	
	public static void main(String[] args) {
		int[][] grid = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };
		int[][] grid2 = new int[][]{{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
		System.out.println(new NumOfIslands().numOfIslands(grid2));
	}
}

package leetcodeContests.contest162;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NumOfClosedIslands {

	public int closedIsland(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		int numOfClosedIslands = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0 && !visited[i][j]) {
					if (bfsHelper(grid, new int[] { i, j }, visited)) {
						numOfClosedIslands++;
					}
				}
			}
		}

		return numOfClosedIslands;
	}

	private boolean bfsHelper(int[][] grid, int[] cell, boolean[][] visited) {
		int[][] dirs = new int[][] { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 }};
		int cellX = cell[0];
		int cellY = cell[1];

		Queue<int[]> q = new ArrayDeque<>();
		q.add(cell);
		visited[cellX][cellY] = true;
		boolean isClosed = true;
		
		while (!q.isEmpty()) {
			int[] current = q.poll();
			for (int[] dir: dirs) {
				int x = current[0] + dir[0];
				int y = current[1] + dir[1];
				if (!withinGrid(grid, new int[]{x,y})) {
					isClosed = false;
				} else if (!visited[x][y] && grid[x][y]==0) {
					visited[x][y] = true;
					q.add(new int[]{x,y});
				}
			}
		}		

		return isClosed;
	}
	
	private boolean withinGrid(int[][] grid, int[] loc) {
		int x = loc[0];
		int y = loc[1];
		
		return x>=0 && x<grid.length && y>=0 && y<grid[0].length;
	}
	
	
	

	public int closedIslandX(int[][] grid) {
		// steps
		// for all zeros when check all directions to add other zeros(lands)
		//
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		int numOfClosedIslands = 0;

		List<int[]> lands = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0) {
					lands.add(new int[] { i, j });
				}
			}
		}

		int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 },
				{ -1, -1 } };

		for (int[] land : lands) {
			int landX = land[0];
			int landY = land[1];
			if (visited[landX][landY])
				continue;
			Queue<int[]> q = new ArrayDeque<>();
			q.add(new int[] { landX, landY });
			boolean isClosed = true;

			while (!q.isEmpty()) {
				int[] current = q.poll();
				int currentX = current[0];
				int currentY = current[1];

				if (visited[currentX][currentY])
					continue;
				visited[currentX][currentY] = true;
				for (int[] dir : dirs) {
					int x = currentX + dir[0];
					int y = currentY + dir[1];

					if (x >= 0 && x < m && y >= 0 && y < n) {
						if (!visited[x][y] && grid[x][y] == 0)
							q.add(new int[] { x, y });
					} else {
						isClosed = false;
					}

				}

			}
			if (isClosed)
				numOfClosedIslands++;

		}

		return numOfClosedIslands;
	}

}

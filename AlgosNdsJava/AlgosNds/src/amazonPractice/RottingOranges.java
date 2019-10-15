package amazonPractice;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {
	static int rottingOranges(int[][] grid) {
		if (grid == null || grid.length == 0) return 0;
		int time = 0;
		Queue<int[]> q = new ArrayDeque<>();
		int m = grid.length;
		int n = grid[0].length;
		int freshCount = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 2) {
					q.add(new int[] { i, j });
				}
				if (grid[i][j] == 1)
					freshCount++;
			}
		}
		
		if (freshCount == 0) return 0;
		int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		while (!q.isEmpty()) {
			time++;	
			int size = q.size();
			for (int i=0; i<size; i++) {
				int[] pos = q.poll();
				for (int[] dir : dirs) {
					int x = pos[0] + dir[0];
					int y = pos[1] + dir[1];

					if (x < 0 || y < 0 || x>=m || y>=n || grid[x][y] == 2 || grid[x][y] == 0)
						continue;
					grid[x][y] = 2;
					q.add(new int[]{x,y});
					freshCount--;
					if (freshCount == 0)
						return time;

				}
			}
		}

		return -1;
	}
	
	public static void main(String[] args) {
		// [[2,1,1],[1,1,0],[0,1,1]]

		int[][] grid = new int[3][3];

		grid[0][0] = 2;
		grid[0][1] = 1;
		grid[0][2] = 1;
		grid[1][0] = 1;
		grid[1][1] = 1;
		grid[1][2] = 0;
		grid[2][0] = 0;
		grid[2][1] = 1;
		grid[2][2] = 1;
		
		int[][] x = new int[4][1];
		
		x[0][0] = 1;
		x[1][0] = 2;
		x[2][0] = 1;
		x[3][0] = 1;

		System.out.println(rottingOranges(x));

	}
}

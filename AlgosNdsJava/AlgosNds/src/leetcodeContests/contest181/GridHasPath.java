package leetcodeContests.contest181;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GridHasPath {
	// 2 4 3
	// 6 5 2

	// 1 2 1 // 1 ------ [val, []] [] // 2, (4,6) 0,1 (1,0) -1,-1 1,-1 0,0
	// 1 2 1
	public boolean hasValidPath(int[][] grid) {
		if (grid == null || grid.length == 0)
			return false;
		Map<Integer, int[][]> roads = new HashMap<>();
		roads.put(1, new int[][] { { 0, -1 }, { 0, 1 } });
		roads.put(2, new int[][] { { -1, 0 }, { 1, 0 } });
		roads.put(3, new int[][] { { 0, -1 }, { 1, 0 } });
		roads.put(4, new int[][] { { 1, 0 }, { 0, 1 } });
		roads.put(5, new int[][] { { 0, -1 }, { -1, 0 } });
		roads.put(6, new int[][] { { -1, 0 }, { 0, 1 } });

		int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
		// steps
		// start from origin
		// using above dirs check if current node is connected to either down
		// node or right node
		// if connected add node to the q
		// mark visited and check boundary conditions
		// if no connection found return false
		// if final node is found return true
		int m = grid.length - 1;
		int n = grid[0].length - 1;
		boolean[][] visited = new boolean[m + 1][n + 1];

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0 });

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int currX = curr[0];
			int currY = curr[1];

			if (currX == m && currY == n)
				return true;

			visited[currX][currY] = true;

			for (int[] dir : dirs) {
				int x = currX + dir[0];
				int y = currY + dir[1];		

				if (x >= 0 && y >= 0 && x <= m && y <= n && !visited[x][y]) {
					int val = grid[x][y];
					int[][] roadDirs = roads.get(val);
					
					List<int[]> tempDirs = new ArrayList<>();
					for (int[] roadDir : roadDirs) {
						int a = x + roadDir[0];
						int b = y + roadDir[1];
						if (a == currX && b == currY) {
							tempDirs.add(new int[]{x,y});
							if (x == m && y == n)
								return true;
						}
						if (a < 0 || b < 0 || a > m || b > n) {
							tempDirs = new ArrayList<>();
						}
					}

					for (int[] tempDir : tempDirs) {
						q.add(new int[] { tempDir[0], tempDir[1] });
						visited[x][y] = true;
					}

				}

			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[][] grid = new int[][] { { 2, 4, 3 }, { 6, 5, 2 } };
		System.out.println(new GridHasPath().hasValidPath(grid));
	}

}

package leetcode30DayChallenge.september;

public class UniquePaths3 {

	// [1,0,0,0]
	// [0,0,0,0]
	// [0,0,2,-1]

	public int uniquePathsIII(int[][] grid) {
		int totalStops = 0;
		int m = grid.length;
		int n = grid[0].length;
		int[] start = new int[] { 0, 0 };
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					start = new int[] { i, j };
				} else if (grid[i][j] == 0) {
					totalStops++;
				}
			}
		}

		return backtrack(start, grid, m, n, totalStops);
	}

	private int backtrack(int[] curr, int[][] grid, int m, int n, int totalStops) {

		int x = curr[0], y = curr[1];

		if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == -1) {
			return 0;
		}

		if (grid[x][y] == 2) {
			return totalStops == -1 ? 1 : 0;
		}

		grid[x][y] = -1;

		totalStops--;

		int total = 0;

		int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		for (int[] dir : dirs) {
			int i = x + dir[0];
			int j = y + dir[1];

			total += backtrack(new int[] { i, j }, grid, m, n, totalStops);
		}

		grid[x][y] = 0;

		totalStops++;

		return total;
	}

	// private void backtrackOld(List<int[]> tmpList, int[][] grid, int m, int
	// n) {
	//
	// int[] curr = tmpList.get(tmpList.size() - 1);
	//
	// int x = curr[0], y = curr[1];
	//
	// if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == -1 || grid[x][y]
	// == -2) {
	// return;
	// }
	//
	// if (grid[x][y] == 2) {
	// if (tmpList.size() - 2 == totalStops)
	// result++;
	// return;
	// }
	//
	// grid[x][y] = -2;
	//
	// int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	//
	// for (int[] dir : dirs) {
	// int i = x + dir[0];
	// int j = y + dir[1];
	//
	// tmpList.add(new int[] { i, j });
	//
	// backtrack(tmpList, grid, m, n);
	//
	// int[] last = tmpList.remove(tmpList.size() - 1);
	//
	// int X = last[0], Y = last[1];
	//
	// if (X >= 0 && Y >= 0 && X < m && Y < n && grid[X][Y] == -2) {
	// grid[X][Y] = 0;
	// }
	// }
	//
	// }

	public static void main(String[] args) {
		int[][] grid = new int[][] { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };
		System.out.println(new UniquePaths3().uniquePathsIII(grid));
	}

}

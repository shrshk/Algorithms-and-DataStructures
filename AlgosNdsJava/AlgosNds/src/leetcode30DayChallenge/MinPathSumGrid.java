package leetcode30DayChallenge;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class MinPathSumGrid {
	// can't be solved this way since the minPath is not in order hence DP
	public int minPathSum(int[][] grid) {
		// steps
		// bfs
		// pq

		int m = grid.length;
		int n = grid[0].length;
		Queue<int[]> pq = new PriorityQueue<>((n1, n2) -> (grid[n1[0]][n1[1]] - grid[n2[0]][n2[1]]));

		Set<int[]> visited = new HashSet<>();

		pq.add(new int[] { 0, 0 });

		int minSum = 0;

		int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 } };
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int currX = curr[0];
			int currY = curr[1];
			minSum += grid[currX][currY];
			if (currX == m-1 && currY == n-1) {
				return minSum;
			}
			visited.add(curr);

			for (int[] dir : dirs) {
				int x = dir[0] + currX;
				int y = dir[1] + currY;

				if (x >= 0 && y >= 0 && x < m && y < n && !visited.contains(new int[] { x, y })) {
					pq.add(new int[] { x, y });
				}

			}

		}

		return minSum;

	}
	
	public static void main(String[] args) {
		// [1,3,1],[1,5,1],[4,2,1]
		int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(new MinPathSumGrid().minPathSum(grid));
	}
}

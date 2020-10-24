package leetcode30DayChallenge.may;

import java.util.ArrayDeque;
import java.util.Queue;

public class FloodFill {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

		int m = image.length;
		int n = image[0].length;

		Queue<int[]> q = new ArrayDeque<>();

		q.add(new int[] { sr, sc });
		int color = image[sr][sc];
		int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		boolean[][] visited = new boolean[m][n];

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			image[curr[0]][curr[1]] = newColor;
			visited[curr[0]][curr[1]] = true;
			for (int[] dir : dirs) {
				int x = curr[0] + dir[0];
				int y = curr[1] + dir[1];
				if (x >= 0 && y >= 0 && x < m && y < n && image[x][y] == color && !visited[x][y]) {
					q.add(new int[] { x, y });
				}
			}
		}

		return image;
	}

	public static void main(String[] args) {
		// [[0,0,0],[0,1,1]]
		int[][] image = new int[][] { { 0, 0, 0 }, { 0, 1, 1 } };
		System.out.println(new FloodFill().floodFill(image, 1, 1, 1));
	}
}

package leetcode30DayChallenge.june;

import java.util.ArrayDeque;
import java.util.Queue;

public class SurroundingRegions {
	public void solve(char[][] board) {
		// steps
		// mark all Xs as visited
		// start from x
		// if 0 is encountered and isn't connected to border 0 flip to x and
		// mark visited

		if (board == null || board.length == 0)
			return;
		int m = board.length;
		int n = board[0].length;

		Queue<int[]> q = new ArrayDeque<>();

		for (int j = 0; j < n; j++) {
			if (board[0][j] == 'O') {
				board[0][j] = 'Y';
				q.add(new int[] { 0, j });
			}

			if (board[m - 1][j] == 'O') {
				board[m - 1][j] = 'Y';
				q.add(new int[] { m - 1, j });
			}

		}

		for (int i = 0; i < m; i++) {
			if (board[i][0] == 'O') {
				board[i][0] = 'Y';
				q.add(new int[] { i, 0 });
			}

			if (board[i][n - 1] == 'O') {
				board[i][n - 1] = 'Y';
				q.add(new int[] { i, n - 1 });
			}

		}

		BFS(q, board, m, n);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'Y')
					board[i][j] = 'O';
				if (board[i][j] == 'O')
					board[i][j] = 'X';
			}
		}

	}

	private void BFS(Queue<int[]> q, char[][] board, int m, int n) {
		int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int[] dir : dirs) {
				int x = curr[0] + dir[0];
				int y = curr[1] + dir[1];

				if (x < 0 || y < 0 || x >= m || y >= n || board[x][y] != 'O')
					continue;
				
				q.add(new int[]{x,y});

				board[x][y] = 'Y';

			}
		}
	}
}

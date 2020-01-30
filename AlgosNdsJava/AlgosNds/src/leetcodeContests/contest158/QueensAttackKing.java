package leetcodeContests.contest158;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

// Input: queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
// Output: [[0,1],[1,0],[3,3]]

// direction of travel 
// steps
// queen cant attack king if there's an obstacle or if it cant reach the dest.
// build a grid and fill queen posts with 1 king positin 2 remaining 0
// take all the qns into a queue for each queen move in all directions possible one direction at a time
// if an obstacle is encountered break out of the loop and continue for other direction
// if destination is reached add position to a list.

public class QueensAttackKing {
	public List<List<Integer>> queensAttack(int[][] queens, int[] king) {
		int[][] ds = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
		boolean[][] board = new boolean[8][8];
		for (int[] q : queens) {
			board[q[0]][q[1]] = true;
		}
		int x = king[0], y = king[1];
		List<List<Integer>> res = new ArrayList<>();
		for (int[] d : ds) {
			for (int i = x + d[0], j = y + d[1]; i > -1 && i < 8 && j > -1 && j < 8; i += d[0], j += d[1]) {
				if (board[i][j]) {
					res.add(Arrays.asList(i, j));
					break;
				}
			}
		}
		return res;
	}

	// working
	public List<List<Integer>> queenAttackKingB(int[][] queens, int[] king) {
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { -1, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 } };
		List<List<Integer>> result = new ArrayList<>();
		int[][] board = new int[8][8];
		for (int i = 0; i < queens.length; i++) {
			int qX = queens[i][0];
			int qY = queens[i][1];
			board[qX][qY] = 1;
		}

		for (int[] dir : dirs) {

			for (int x = king[0] + dir[0], y = king[1] + dir[1]; x >= 0 && x < 8 && y >= 0
					&& y < 8; x = x + dir[0], y = y + dir[1]) {
				if (board[x][y] == 1) {
					result.add(Arrays.asList(x, y));
					break;
				}

			}

		}

		return result;
	}

	public List<List<Integer>> queenAttackKing(int[][] queens, int[] king) {
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { -1, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 } };
		List<List<Integer>> result = new ArrayList<>();
		int[][] board = new int[8][8];
		for (int i = 0; i < queens.length; i++) {
			int qX = queens[i][0];
			int qY = queens[i][1];
			board[qX][qY] = 1;
		}

		for (int[] dir : dirs) {
			int x = king[0];
			int y = king[1];
			while (x >= 0 && y >= 0 && x < 8 && y < 8) {
				x = x + dir[0];
				y = y + dir[1];
				if (board[x][y] == 1) {
					result.add(Arrays.asList(x, y));
					break;
				}

			}

		}

		return result;
	}

	// not working
	public List<List<Integer>> queenAttack(int[][] queens, int[] king) {
		// 0,0 1,2
		List<List<Integer>> result = new ArrayList<>();
		int[][] grid = new int[8][8];

		grid[king[0]][king[1]] = 2;
		Queue<int[]> q = new ArrayDeque<>();

		for (int i = 0; i < queens.length; i++) {
			int qX = queens[i][0];
			int qY = queens[i][1];
			grid[qX][qY] = 1;
			q.add(new int[] { qX, qY });
		}

		// all directions
		// 0,j
		// 0,-j
		// i,0
		// -i,0
		// i-1,j-1
		// i+1,j+1
		// i+1,j-1
		// i-1,j+1

		// List<List<Integer>> dirs = new ArrayList<>();
		// int i = 0, j = 0;
		// while (i < 8 && j < 8) {
		// dirs.add(Arrays.asList(0, j));
		// dirs.add(Arrays.asList(0, -j));
		// dirs.add(Arrays.asList(i, 0));
		// dirs.add(Arrays.asList(-i, 0));
		// dirs.add(Arrays.asList(i - 1, j - 1));
		// dirs.add(Arrays.asList(i + 1, j + 1));
		// dirs.add(Arrays.asList(i + 1, j - 1));
		// dirs.add(Arrays.asList(i - 1, j + 1));
		// i++;
		// j++;
		// }

		while (!q.isEmpty()) {
			int[] current = q.poll();
			int posX = current[0];
			int posY = current[1];

			// can q attack king
			// directionally possible ?
			// figure out the direction
			// move in that direction
			// no obstacle

			// int x = posX + dir.get(0);
			// int y = posY + dir.get(1);
			//
			// if (x < 0 || y < 0 || x > 7 || y > 7 || grid[x][y] == 1)
			// continue;
			// if (grid[x][y] == 2) {
			// result.add(Arrays.asList(posX, posY));
			// }

		}

		return result;
	}

	public static void main(String[] args) {
		// queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
		int[][] queens = new int[][] { { 0, 1 }, { 1, 0 }, { 4, 0 }, { 0, 4 }, { 3, 3 }, { 2, 4 } };
		int[] king = new int[] { 0, 0 };
		System.out.println(new QueensAttackKing().queenAttackKingB(queens, king));
	}
}

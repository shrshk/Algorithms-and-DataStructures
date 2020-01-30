package golmansachs.practice;

public class GameOfLife {
	int DEAD = 0;
	int ALIVE = 1;
	int ALIVETODEAD = 2;
	int DEADTOALIVE = 3;

	public void gameOfLife(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int lives = countLives(board, i, j);
				if (board[i][j] == DEAD && lives == 3) {
					board[i][j] = DEADTOALIVE;
				} else if (board[i][j] == ALIVE) {
					if (lives == 2 || lives == 3) {
						continue;
					}
					if (lives > 3 || lives < 2) {
						board[i][j] = ALIVETODEAD;
					}
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == ALIVETODEAD) {
					board[i][j] = DEAD;
				}
				if (board[i][j] == DEADTOALIVE) {
					board[i][j] = ALIVE;
				}
			}
		}

	}

	private int countLives(int[][] board, int i, int j) {
		int count = 0;
		int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

		for (int[] dir : dirs) {
			int x = i + dir[0];
			int y = j + dir[1];

			if (x >= 0 && y >= 0 && x < board.length && y < board[0].length) {

				if (board[x][y] == ALIVE || board[x][y] == ALIVETODEAD)
					count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int[][] board = new int[][] { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
		new GameOfLife().gameOfLife(board);
	}
}

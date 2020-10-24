package twilioPrep;

import java.util.ArrayList;
import java.util.List;

public class KnightDialer2 {

	int[][] grid = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
	int res = 0;

	public int breakSafe(int N) {

		List<Integer> tmpList = new ArrayList<>();
		tmpList.add(2);
		backtrack(0, 1, N, tmpList);
		return res;
	}

	private void backtrack(int i, int j, int N, List<Integer> tmpList) {
		if (tmpList.size() == N) {
			res++;
			return;
		}
			
		int[][] dirs = new int[][] { { -2, -1 }, { 2, -1 }, { -2, 1 }, { 2, 1 }, { 1, -2 }, { -1, 2 }, { -1, -2 },
				{ 1, 2 } };
		for (int[] dir : dirs) {

			int x = i + dir[0];
			int y = j + dir[1];

			if (x < 0 || y < 0 || x > 2 || y > 2 || grid[x][y] == 1 || grid[x][y] == 5)
				continue;

			tmpList.add(grid[x][y]);
			backtrack(x, y, N, tmpList);			
			tmpList.remove(tmpList.size() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(new KnightDialer2().breakSafe(4));
	}
}

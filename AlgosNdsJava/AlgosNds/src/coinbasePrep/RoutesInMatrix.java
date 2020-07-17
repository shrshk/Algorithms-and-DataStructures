package coinbasePrep;

import java.util.ArrayList;
import java.util.List;

public class RoutesInMatrix {
	List<List<int[]>> res = new ArrayList<>();

	public List<List<int[]>> findPaths(int[][] matrix) {
		getPath(matrix, new ArrayList<>(), new int[] { 0, 0 });

		return res;
	}

	private void getPath(int[][] matrix, List<int[]> path, int[] curr) {
		int m = matrix.length;
		int n = matrix[0].length;
		int i = curr[0];
		int j = curr[1];
		if (i == m - 1 && j == n - 1) {
			res.add(path);
			return;
		}
		path.add(new int[] { i, j });

		if (i >= 0 && i < m && j + 1 >= 0 && j + 1 < n) {
			getPath(matrix, path, new int[] { i, j + 1 });
		}

		if (i + 1 >= 0 && i + 1 < m && j >= 0 && j < n) {
			getPath(matrix, path, new int[] { i + 1, j });
		}

		path.remove(path.size() - 1);

	}

	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1,2},{4,5},{7,8}};
		System.out.println(new RoutesInMatrix().findPaths(matrix).size());
	}
}

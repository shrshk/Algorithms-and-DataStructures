package leetcodeContests.contest180;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LuckyNumbersMatrix {
	public List<Integer> luckyNumbers(int[][] matrix) {
		// [[3,7,8],[9,11,13],[15,16,17]]
		if (matrix == null || matrix.length == 0)
			return new ArrayList<>();
		List<Integer> res = new ArrayList<>();

		Map<Integer, Integer> minRow = new HashMap<>();
		Map<Integer, Integer> maxCol = new HashMap<>();

		for (int i = 0; i < matrix.length; i++) {
			int[] row = matrix[i];
			int min = Integer.MAX_VALUE;
			for (int val : row) {
				min = Math.min(min, val);
			}
			minRow.put(i, min);
		}

		for (int i = 0; i < matrix[0].length; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < matrix.length; j++) {
				max = Math.max(max, matrix[j][i]);
			}
			maxCol.put(i, max);
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int val = matrix[i][j];
				if (val <= minRow.get(i) && val >= maxCol.get(j))
					res.add(val);
			}
		}

		return res;
	}
	
	public static void main(String[] args) {
		// [[3,7,8],[9,11,13],[15,16,17]]
		// [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
		int[][] matrix = new int[][]{{1,10,4,2},{9,3,8,7},{15,16,17,12}};
		System.out.println(new LuckyNumbersMatrix().luckyNumbers(matrix));
	}
}

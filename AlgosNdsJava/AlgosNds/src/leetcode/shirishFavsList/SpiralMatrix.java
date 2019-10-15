package leetcode.shirishFavsList;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	static List<Integer> printSpiralMatrix(int[][] matrix) {
		int rowBegin = 0;
		int rowEnd = matrix.length - 1;
		int colBegin = 0;
		int colEnd = matrix[0].length - 1;
		List<Integer> res = new ArrayList<Integer>();

		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			// going right
			for (int i = colBegin; i <= colEnd; i++) {
				res.add(matrix[rowBegin][i]);
			}
			rowBegin++;
			// going down
			for (int i = rowBegin; i <= rowEnd; i++) {
				res.add(matrix[i][colEnd]);
			}
			colEnd--;
			if (rowBegin <= rowEnd) {
				// going left
				for (int i = colEnd; i >= colBegin; i--) {
					res.add(matrix[rowEnd][i]);
				}
			}
			rowEnd--;
			if (colBegin <= colEnd) {
				// going up
				for (int i = rowEnd; i >= rowBegin; i--) {
					res.add(matrix[i][colBegin]);
				}
			}
			colBegin++;
		}

		return res;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[3][3];
		int x = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				matrix[i][j] = x++;
			}
		}

		System.out.println(printSpiralMatrix(matrix));
	}

}

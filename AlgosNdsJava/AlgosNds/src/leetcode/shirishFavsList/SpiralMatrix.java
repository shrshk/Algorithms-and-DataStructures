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

	int equilibrium(int arr[]) {
		int n = arr.length;
		int left, right;
		int leftsum, rightsum;

		/*
		 * Check for indexes one by one until an equilibrium index is found
		 */
		for (left = 0; left < n; ++left) {

			/* get left sum */
			leftsum = 0;
			for (right = 0; right < left; right++)
				leftsum += arr[right];

			/* get right sum */
			rightsum = 0;
			for (right = left + 1; right < n; right++)
				rightsum += arr[right];

			/*
			 * if leftsum and rightsum are same, then we are done
			 */
			if (leftsum == rightsum)
				return left;
		}

		/* return -1 if no equilibrium index is found */
		return -1;
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

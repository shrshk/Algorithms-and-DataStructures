package leetcodeContests.contest165;

import java.util.Arrays;

public class CountSquareSubMatrices {
	public int countSquares(int[][] matrix) {
		int res = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] > 0 && i > 0 && j > 0) {
					matrix[i][j] = Math.min(matrix[i - 1][j], Math.min(matrix[i][j - 1], matrix[i - 1][j - 1])) + 1;
				}
				res += matrix[i][j];
			}
		}

		for (int[] x : matrix) {
			System.out.println(Arrays.toString(x));
		}

		return res;
	}

	public int maximalSquare(char[][] matrix) {
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1' && i > 0 && j > 0) {
					int a = matrix[i - 1][j] - '0';
					int b = matrix[i][j - 1] - '0';
					int c = matrix[i - 1][j - 1] - '0';
					matrix[i][j] = (char) ((char) (Math.min(a, Math.min(b, c))) + '1');
				}

				max = Math.max(max, matrix[i][j] - '0');

			}
		}
		return max * max;
	}

	public int maxSideLengthWrong(int[][] matrix, int threshold) {
		int max = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] > 0 && i > 0 && j > 0) {
					matrix[i][j] = Math.min(matrix[i - 1][j], Math.min(matrix[i][j - 1], matrix[i - 1][j - 1])) + 1;
				}
				if (matrix[i][j] < threshold) {
					max = Math.max(max, matrix[i][j]);
				}
			}
		}

		for (int[] x : matrix) {
			System.out.println(Arrays.toString(x));
		}

		return max;
	}

	public int maxSideLength(int[][] mat, int threshold) {
		int m = mat.length;
		int n = mat[0].length;
		int[][] sum = new int[m + 1][n + 1];

		int res = 0;
		int len = 1; // square side length

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
				if (i >= len && j >= len && sum[i][j] - sum[i - len][j] - sum[i][j - len] + sum[i - len][j - len] <= threshold) {
					System.out.println(sum[i][j] - sum[i - len][j] - sum[i][j - len] + sum[i - len][j - len]);
					res = len++;
				}

			}
		}

		for (int[] x : sum) {
			System.out.println(Arrays.toString(x));
		}

		return res;
	}

	public static void main(String[] args) {
		// int[][] matrix = new int[][]{{1,0,1},{1,1,0},{1,1,0}};
		int[][] matrix = new int[][] { { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } };
		// System.out.println(new
		// CountSquareSubMatrices().countSquares(matrix));
		char[][] cMatrix = new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
				{ '1', '1', '1', '1', '1' }, { '1', '0', '1', '1', '0' } };
		// System.out.println(new
		// CountSquareSubMatrices().maximalSquare(cMatrix));
		System.out.println(new CountSquareSubMatrices().maxSideLength(matrix, 6));
	}
}

/*
 * 
 * The idea is as follows (very simple) Let me denote the original matrix by A
 * and the dynamic matrix we build by D. D(i,j) = the maximal area of a square
 * s.t. (i,j) is in the right down corner of that square (notice there might be
 * bigger square containing (i,j))
 * 
 * Now we need to understand how to build D recursively. The case A(i,j) = 0 is
 * obvious --> D(i,j) = 0 If A(i,j)=1 we claim D(i,j) = min(D(i-1,j) , D(i,j-1)
 * , D(i-1,j-1)) + 1 Why it is true? Imagine you have a square of size k where
 * (i,j) is in the right down corner of it. Then D(i-1.j) is at least of size
 * k-1 (as a sub square) and the same is true for D(i,j-1) and D(i-1,j-1) -->
 * therefore min(D(i-1,j) , D(i,j-1) , D(i-1,j-1)) is at least k-1. Now for the
 * "other direction" if the minimum expression is of size more than k-1 (by
 * negation let's say) then by considering the overlapping 3 squares and the
 * square A(i,j) we would have a square of size more than k. That proves the
 * recursive relation.
 * 
 * (t,k) = The index of the right down corner of the maximal square D(t,k) is
 * the solution.
 * 
 * 
 * :) Got it?
 */
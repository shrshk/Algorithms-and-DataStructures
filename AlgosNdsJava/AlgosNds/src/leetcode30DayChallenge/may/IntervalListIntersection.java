package leetcode30DayChallenge.may;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersection {
	public int[][] intervalIntersection(int[][] A, int[][] B) {
		if (A == null || A.length == 0 || B == null || B.length == 0)
			return new int[][] {};
		List<int[]> res = new ArrayList<>();
		int m = A.length;
		int n = B.length;

		int i = 0, j = 0;
		int startMax, endMin;

		while (i < m && j < n) {
			// steps
			// keep track of startMax and endMIn
			// if the newInterval end is eq to endMin incr. pointer
			startMax = Math.max(A[i][0], B[j][0]);
			endMin = Math.min(A[i][1], B[j][1]);
			if (endMin >= startMax) {
				res.add(new int[] { startMax, endMin });
			}
			if (A[i][1] == endMin)
				i++;
			if (B[j][1] == endMin)
				j++;

		}

		return res.toArray(new int[res.size()][]);

	}

	public static void main(String[] args) {
		int[][] A = new int[][] { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
		int[][] B = new int[][] { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } }; // [],[],[],[]
		System.out.println(new IntervalListIntersection().intervalIntersection(A, B));
	}
}

package leetcode30DayChallenge.october;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinArrowShots {
	public int findMinArrowShots(int[][] points) {
		// [[10,16],[2,8],[1,6],[7,12]]
		// 1,6 2,8 7,12 10,16
		Arrays.sort(points, (a, b) -> (a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]));
		List<int[]> intervals = new ArrayList<>();
		int[] curr = points[0];
		intervals.add(curr);
		for (int i = 1; i < points.length; i++) {
			if (curr[1] >= points[i][0]) {
				curr[1] = Math.min(curr[1], points[i][1]);
			} else {
				intervals.add(points[i]);
				curr = points[i];
			}
		}

		return intervals.size();
	}
	
	public static void main(String[] args) {
		System.out.println(new MinArrowShots().findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}}));
	}
}

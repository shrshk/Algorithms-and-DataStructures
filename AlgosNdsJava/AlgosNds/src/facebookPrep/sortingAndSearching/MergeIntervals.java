package facebookPrep.sortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length == 0)
			return intervals;

		Arrays.sort(intervals, (i1, i2) -> (i1[0] - i2[0]));

		List<int[]> res = new ArrayList<>();

		int[] currInterval = intervals[0];

		res.add(currInterval);

		for (int[] newInterval : intervals) {
			if (newInterval[0] <= currInterval[1]) {
				currInterval[1] = Math.max(currInterval[1], newInterval[1]);
			} else {
				res.add(newInterval);
				currInterval = newInterval;
			}
		}

		return res.toArray(new int[res.size()][]);

	}

	public static void main(String[] args) {
		int[][] res = new MergeIntervals().merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 } });
		for (int[] i : res) {
			System.out.println(Arrays.toString(i));
		}

	}
}

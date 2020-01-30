package facebookPrep.sortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Carpooling {
	public boolean carPoolingScrap(int[][] trips, int capacity) {
		// trips = [[2,1,5],[3,3,7]], capacity = 4

		// if overlapping intervals numOfPass = sum of intervals else numOfpass
		// = interval
		// if numOfPass>capa false else true;

		int[][] starts = new int[trips.length][];
		int[][] ends = new int[trips.length][];

		int idx = 0;
		for (int[] trip : trips) {
			starts[idx][0] = trip[0];
			starts[idx][1] = trip[1];
			ends[idx][0] = trip[0];
			ends[idx][1] = trip[2];
			idx++;
		}

		// [[3,2,7],[8,3,5],[3,7,9]]
		Arrays.sort(starts, (s1, s2) -> (s1[1] - s2[1]));
		Arrays.sort(ends, (s1, s2) -> (s1[1] - s2[1]));

		int endIdx = 0;

		// 1 3
		// 5 7

		List<int[]> combinedIntervals = new ArrayList<>();

		int[] currInterval = trips[0];

		combinedIntervals.add(currInterval);

		for (int[] start : starts) {
			if (start[2] <= ends[endIdx][1]) {

			}
		}

		return true;
	}

	public boolean carPooling(int[][] trips, int capacity) {
		// trips = [[2,1,5],[3,3,7]], capacity = 4 [[5,1,7]

		// if overlapping intervals numOfPass = sum of intervals else numOfpass
		// = interval
		// if numOfPass>capa false else true;

		// Arrays.sort(trips, (a1, a2) -> (a1[1] - a2[1]));

		List<int[]> mergeIntervals = new ArrayList<>();

		int[] currInt = trips[0];

		mergeIntervals.add(currInt);

		for (int i = 1; i < trips.length; i++) {
			int[] newInt = trips[i];
			if (newInt[1] < currInt[2]) {
				currInt[0] = currInt[0] + newInt[0];
				currInt[2] = Math.max(currInt[2], newInt[2]);
			} else {
				mergeIntervals.add(newInt);
				currInt = newInt;
			}
		}

		for (int[] interval : mergeIntervals) {
			System.out.println(Arrays.toString(interval));
			if (interval[0] > capacity)
				return false;
		}

		return true;
	}

	public boolean carPoolingOpt(int[][] trips, int capacity) {
		// trips = [[2,1,5],[3,3,7]], capacity = 4 [[5,1,7]
		// [[2,1,5],[3,5,7]]

		// if overlapping intervals numOfPass = sum of intervals else numOfpass
		// = interval
		// if numOfPass>capa false else true;

		// [[3,2,7],[3,7,9],[8,3,9]] 11
		// 3,2,7 8,3,9 3,7,9 // 11 2 9 3 7 9 //

		Arrays.sort(trips, (a1, a2) -> (a1[1] - a2[1]));

		int[] currInt = trips[0];

		for (int i = 1; i < trips.length; i++) {
			int[] newInt = trips[i];
			if (newInt[1] < currInt[2]) {
				currInt[0] = currInt[0] + newInt[0];
				if (currInt[0] > capacity)
					return false;
				currInt[2] = Math.max(currInt[2], newInt[2]);
			} else {
				currInt = newInt;
			}
		}

		return true;
	}

	public boolean carPoolingCorrect(int[][] trips, int capacity) {
		int[] stops = new int[1001];
		for (int[] trip : trips) {
			stops[trip[1]] += trip[0];
			stops[trip[2]] -= trip[0];
		}

		for (int i = 0; i < 1001 && capacity >= 0; i++)
			capacity -= stops[i];

		return capacity >= 0;

	}

	public static void main(String[] args) {
		// [[3,2,7],[3,7,9],[8,3,9]] 11
		// [[2,2,6],[2,4,7],[8,6,7]] 11
		// 2,2,

		int[][] trips = new int[][] { { 3, 2, 7 }, { 3, 7, 9 }, { 8, 3, 9 } };
		int capacity = 11;
		// System.out.println(new Carpooling().carPooling(trips, capacity));
		System.out.println(new Carpooling().carPoolingCorrect(trips, capacity));
	}
}

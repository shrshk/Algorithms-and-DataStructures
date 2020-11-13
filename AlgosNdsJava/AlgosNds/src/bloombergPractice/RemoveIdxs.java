package bloombergPractice;

import java.util.ArrayList;
import java.util.List;

public class RemoveIdxs {
	public List<Integer> rmvIdxs(int[] arr, int[][] ranges) {
		List<Integer> res = new ArrayList<>();
		int len = arr.length;

		int[] lookupArr = new int[len];

		for (int[] range : ranges) {
			int start = range[0];
			int end = range[1];

			if (start < len)
				lookupArr[start] += 1;
			if (end < len)
				lookupArr[end] -= 1;

		}

		int sum = 0;

		for (int i = 0; i < len; i++) {
			sum += lookupArr[i];
			if (sum == 0)
				res.add(arr[i]);
		}

		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{-8, 3, -5, 1, 51, 56, 0, -5, 29, 43, 78, 75, 32, 76, 73, 76};
		// [[5, 8], [10, 13], [3, 6], [20, 25]]
		int[][] ranges = new int[][]{{0,2},{5, 8}, {10, 13}, {3, 6}, {20, 25}};
		System.out.println(new RemoveIdxs().rmvIdxs(arr, ranges));
	}
}

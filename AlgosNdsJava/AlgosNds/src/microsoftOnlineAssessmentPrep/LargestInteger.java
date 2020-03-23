package microsoftOnlineAssessmentPrep;

import java.util.HashSet;
import java.util.Set;

public class LargestInteger {
	public int largestInteger(int[] arr) {
		int res = 0;
		Set<Integer> set = new HashSet<>();
		for (int num : arr) {
			if (num < 0) {
				int val = Math.abs(num);
				if (set.contains(val)) {
					res = Math.max(res, val);
				}
			} else {
				set.add(num);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3, -4};
		System.out.println(new LargestInteger().largestInteger(arr));
	}
}

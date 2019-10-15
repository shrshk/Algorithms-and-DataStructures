package amazonPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumLargestPair {
	static int[] twoSumLargestPair(int[] nums, int target) {
		int max = Integer.MIN_VALUE;
		Map<Integer, Integer> map = new HashMap<>();
		int k = target - 30;
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				if (Math.max(nums[i], nums[map.get(nums[i])]) > max) {
					max = Math.max(nums[i], nums[map.get(nums[i])]);
					res[0] = i;
					res[1] = map.get(nums[i]);
				}
			}
			map.put(k - nums[i], i);
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSumLargestPair(new int[] { 20, 50, 40, 25, 30, 10 }, 90)));
	}
}

package facebookPrep.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class SubArrayKSum {
	public int subarraySum(int[] nums, int k) {
		// 1,1,1

		// while(i<n && j<n) {
		// sum = sum + nums[j];
		// if (sum==k) {
		// count++;
		// i=j;
		// sum=0;
		// } else {
		// j++;
		// }
		// }
		int n = nums.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			int curr = nums[i];
			if (curr == k)
				count++;
			for (int j = i + 1; j < n; j++) {
				curr += nums[j];
				if (curr == k)
					count++;
				if (curr > k) {

				}
			}
		}

		return count;
	}

	public int subarraySumOpt(int[] nums, int k) {
		int n = nums.length;
		int count = 0;

		Map<Integer, Integer> map = new HashMap<>();

		map.put(0, 1);
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}
			// if (map.containsKey(sum))
			// map.put(sum, map.get(sum)+1);
			// else
			// map.put(sum, 1);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		System.out.println(map.toString());

		return count;
	}

	public static void main(String[] args) {
		System.out.println(new SubArrayKSum().subarraySumOpt(new int[] { 100, 1, 2, 3, 4 }, 6));
	}
}

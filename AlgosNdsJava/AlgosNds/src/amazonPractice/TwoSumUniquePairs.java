package amazonPractice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSumUniquePairs {
	static int uniquePairsTwoSum(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();

		int count=0;
		for (int i=0; i<nums.length; i++) {
			int complement = target-nums[i];
			if (map.containsKey(nums[i])) {
			   if (!set.contains(nums[i])) {
					count++;
					set.add(complement);
					set.add(nums[i]);
			   }
			}else {
				map.put(complement, nums[i]);
			}
		}
		return count;
	}
	
	static int uniquePairsTwoSumOneHashMap(int[] nums, int target) {
		int count = 0;
		Map<Integer, Boolean> map = new HashMap<>();
		for (int num: nums) {
			int complement = target-num;
			if (map.containsKey(complement)) {
				if (!map.get(complement)) {
					count++;
					map.put(complement, true);
					map.put(num, true);
				}
			} else {
				map.put(complement, false);
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		// System.out.println(uniquePairsTwoSum(new int[]{1,5,1,5,1,5,1,5}, 6));
		System.out.println(uniquePairsTwoSumOneHashMap(new int[]{1,5,1,5,1,5,1,5}, 6));
	}
}

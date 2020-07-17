package leetcode30DayChallenge.june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
	// steps
	// same as subsets problem except check for divisibility 
	// you may have already checked for a larger subset starting at index i so maintain a cache to avoid duplication
	// eg. 1 2 3 4 9 
	// 1,2,4 of size 3 is your solution but 1,3,9 is also your solution no need to go down that recurrence tree 
	public List<Integer> largestDivisibleSubset(int[] nums) {
		Arrays.sort(nums);
		int[] cache = new int[nums.length];
		Arrays.fill(cache, -1);
		List<Integer> res = new ArrayList<>();
		List<Integer> tmpList = new ArrayList<>();
		backtrack(res, nums, 0, tmpList, 1, cache);
		return res;
	}

	private void backtrack(List<Integer> res, int[] nums, int start, List<Integer> tmpList, int prev, int[] cache) {
		if (tmpList.size() > res.size()) {			
			res.clear();
			res.addAll(tmpList);
		}

		for (int i = start; i < nums.length; i++) {	
			if (tmpList.size() <= cache[i] || nums[i] % prev != 0)
				continue;
			cache[i] = tmpList.size();
			tmpList.add(nums[i]);
			backtrack(res, nums, i + 1, tmpList, nums[i], cache);
			tmpList.remove(tmpList.size() - 1);
		}

	}

	public static void main(String[] args) {
		System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(new int[] { 1,2,3,4,9 }));
	}

}

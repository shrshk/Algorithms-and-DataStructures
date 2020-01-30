package facebookPrep.recursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(res, new ArrayList<>(), target, candidates, 0);
		return res;
	}

	private void backtrack(List<List<Integer>> res, List<Integer> tmpList, int remain, int[] nums, int start) {
		if (remain < 0)
			return;
		if (remain == 0) {
			res.add(new ArrayList<>(tmpList));
			return;
		}

		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1])
				continue;
			tmpList.add(nums[i]);
			backtrack(res, tmpList, remain - nums[i], nums, i + 1);
			tmpList.remove(tmpList.size() - 1);
		}

	}
	
	public static void main(String[] args) {
		System.out.println(new CombinationSum().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
	}
}

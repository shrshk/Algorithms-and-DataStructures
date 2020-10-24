package leetcode30DayChallenge.may;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			res.add(formRange(lower, upper));
			return res;
		}

		if (nums[0] > lower) {
			res.add(formRange(lower, nums[0] - 1));
		}

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i + 1] != nums[i] && nums[i + 1] > nums[i] + 1) {
				res.add(formRange(nums[i] + 1, nums[i + 1] - 1));
			}
		}

		if (nums[nums.length - 1] < upper) {
			res.add(formRange(nums[nums.length - 1] + 1, upper));
		}

		return res;

	}

	private String formRange(int low, int high) {
		return low == high ? String.valueOf(low) : String.valueOf(low + "->" + high);
	}

}

package googlePrep.onsite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSequences {
	public List<List<Integer>> findSubsequences(int[] nums) {
		// [4, 6, 7, 7]
		// [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7],
		// [4,7,7]]
		// Arrays.sort(nums);

		List<List<Integer>> res = new ArrayList<>();
		Set<List<Integer>> set = new HashSet<>();
		List<Integer> tmpList = new ArrayList<>();
		backtrack(tmpList, 0, nums, set);
		for (List<Integer> list: set)
			res.add(list);
		return res;
	}

	private void backtrack(List<Integer> tmpList, int start, int[] nums, Set<List<Integer>> set) {
		if (tmpList.size() > 1) {
			set.add(new ArrayList<>(tmpList));
		}

		for (int i = start; i < nums.length; i++) {
			if (tmpList.isEmpty())
				tmpList.add(nums[i]);
			if (!tmpList.isEmpty() && tmpList.get(tmpList.size()-1)<nums[i])
				tmpList.add(nums[i]);			
//			while (i < nums.length - 1 && nums[i] == nums[i + 1])
//				i++;
			backtrack(tmpList, i + 1, nums, set);
			if (!tmpList.isEmpty())
				tmpList.remove(tmpList.size() - 1);
		}

	}

	public static void main(String[] args) {
		int[] nums = new int[] { 4, 6, 7, 7 };
		System.out.println(new IncreasingSequences().findSubsequences(nums));
	}
}

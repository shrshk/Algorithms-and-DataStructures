package googlePrep.onsite;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		// [1,2,3]
		// steps
		// 0,[],
		// have an index to keep track of backtracking index
		// recursively get all possible solutions by inc backtracking index
		// remove the last value in tmpList to explore another path.

		List<List<Integer>> res = new ArrayList<>();
		List<Integer> tmpList = new ArrayList<>();
		backtrack(tmpList, 0, res, nums);

		return res;
	}

	private void backtrack(List<Integer> tmpList, int start, List<List<Integer>> res, int[] nums) {
		res.add(new ArrayList<>(tmpList));
		for (int i=start; i<nums.length; i++) {
			tmpList.add(nums[i]);
			backtrack(tmpList, i+1, res, nums);
			tmpList.remove(tmpList.size()-1);
		}

	}
	
	public static void main(String[] args) {
		System.out.println(new Subsets().subsets(new int[]{1,2,3}));
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> tmpList = new ArrayList<>();
		res.add(tmpList);
		tmpList.add(1);
		res.add(tmpList);
		System.out.println(res.toString());
	}

}

package facebookPrep.recursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	
	public List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		backtrack(result, new ArrayList<>(), nums, 0);
		return result;		
	}
	
	private void backtrack(List<List<Integer>> result, List<Integer> tmpList, int[] nums, int start) {
		result.add(new ArrayList<>(tmpList));
		for (int i=start; i<nums.length; i++) {
			tmpList.add(nums[i]);
			backtrack(result, tmpList, nums, i+1);
			tmpList.remove(tmpList.size()-1);
		}
	}
	
	public List<List<Integer>> subsetsBFS(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		for (int num: nums) {
			int size = result.size();
			for (int i=0; i<size; i++) {
				List<Integer> subset = new ArrayList<>(result.get(i));
				subset.add(num);
				result.add(subset);
			}
		}
		return result;
	}
	
//	public List<List<Integer>> subsetsBFSDups(int[] nums) {
//		Arrays.sort(nums);
//		List<List<Integer>> result = new ArrayList<>();
//		result.add(new ArrayList<>());
//		for (int idx=0; idx<nums.length; idx++) {
//			if (idx>start && nums[idx]==nums[idx-1])
//				continue;
//			int size = result.size();
//			for (int i=0; i<size; i++) {
//				List<Integer> subset = new ArrayList<>(result.get(i));
//				subset.add(nums[idx]);
//				result.add(subset);
//			}
//		}
//		return result;
//	}
	
	public static void main(String[] args) {
		System.out.println(new Subsets().subsets(new int[]{1,2,3}));
		//System.out.println(new Subsets().subsetsBFS(new int[]{1,2,3}));
		// System.out.println(new Subsets().subsetsBFSDups(new int[]{1,1,3}));
	}
}

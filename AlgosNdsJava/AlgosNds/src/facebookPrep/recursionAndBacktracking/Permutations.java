package facebookPrep.recursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(result, new ArrayList<>(), nums);
		return result;
	}
	
	private void backtrack(List<List<Integer>> result, List<Integer> tmpList, int[] nums) {
		if (tmpList.size()==nums.length) {
			result.add(new ArrayList<>(tmpList));
			return;
		}
		
		for(int i=0; i<nums.length; i++) {
			if (tmpList.contains(nums[i]))
				continue;
			tmpList.add(nums[i]);
			backtrack(result, tmpList, nums);
			tmpList.remove(tmpList.size()-1);
		}		
		
	}	
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		backtrackUnique(result, new ArrayList<>(), nums, new boolean[nums.length]);
		return result;
    }
	
	private void backtrackUnique(List<List<Integer>> result, List<Integer> tmpList, int[] nums, boolean[] used) {
		if (tmpList.size()==nums.length) {
//			List<Integer> tmpResult = new ArrayList<>();
//			tmpList.forEach(i -> {
//				tmpResult.add(nums[i]);
//			});
//			result.add(tmpResult);
			result.add(new ArrayList<>(tmpList));
			return;		
		}
		
		for(int i=0; i<nums.length; i++) {
			if (used[i] || (i>0 && nums[i]==nums[i-1] && !used[i-1]))
				continue;
			tmpList.add(nums[i]);
			used[i] = true;
			backtrackUnique(result, tmpList, nums, used);
			used[i] = false;
			tmpList.remove(tmpList.size()-1);
		}
	}
	
	public List<String> stringPermutations(int[] A) {
		String str = "";
		for (int i: A)
			str+=i;	
		List<String> permutations = new ArrayList<>(); 
		boolean[] used = new boolean[str.length()];
		backtrack(str, new StringBuilder(), permutations, used);
		return permutations;
	}
	
	private void backtrack(String s, StringBuilder tmp, List<String> res, boolean[] used) {
		if (tmp.length() == s.length())
			res.add(tmp.toString());
		for (int i=0; i<s.length(); i++) {
			if (used[i])
				continue;
			tmp.append(s.charAt(i));
			used[i] = true;
			backtrack(s, tmp, res, used);
			used[i] = false;
			tmp.deleteCharAt(tmp.length()-1);
		}		
	}
	
	public static void main(String[] args) {
		// System.out.println(new Permutations().permute(new int[]{1,2,3}));
		// System.out.println(new Permutations().permuteUnique(new int[]{1,1,2}));
		// System.out.println(new Permutations().stringPermutations(new int[]{1,2,3,4}));
		System.out.println("22:59".compareTo("23:59"));
		System.out.println("23".compareTo("24"));
	}
	
}



/*
[1,2,3]
1,2,3

*/
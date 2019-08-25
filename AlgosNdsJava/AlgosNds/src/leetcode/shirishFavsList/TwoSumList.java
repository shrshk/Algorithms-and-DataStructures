package leetcode.shirishFavsList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumList {
	static List<List<Integer>> twoSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i=0; i<nums.length; i++) {
			int complement = target - nums[i];// 2 7 11 15  { 7 : 0, 2 : 1} 
			if (map.containsKey(complement)) {	
				List<Integer> list = new ArrayList<>();
				list.add(map.get(complement));
				list.add(i);
				result.add(list);				
			}
			map.put(nums[i], i);
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(twoSum(new int[]{2,7,8,10,11,15}, 18));
	}

}

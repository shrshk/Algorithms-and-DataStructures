package leetcodeContests.contest168;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ArrayKConsecutiveNums {
    public boolean isPossibleDivide(int[] nums, int k) {
    	if (nums.length%k!=0)
    		return false;
    	List<List<Integer>> kList = new ArrayList<>();
    	Arrays.sort(nums);
    	int numOfLists = nums.length/k;
    	for (int i=0; i<numOfLists; i++)
    		kList.add(new ArrayList<>());
    	
    	Map<Integer,Integer> map = new LinkedHashMap<>();
    	
    	for (int num : nums) {
    		map.put(num, map.getOrDefault(num, 0)+1);
    	}
    	
    	System.out.println(map.toString());
    	
    	for (int i=0; i<numOfLists; i++) {
			for (int num : map.keySet()) {
				if (map.get(num)>0) {
					kList.get(i).add(num);
					map.put(num, map.get(num)-1);
				}
				if (kList.get(i).size()==k)
					break;
			} 
    	}
    	
    	System.out.println(kList.toString());
    	
    	for (List<Integer> list : kList) {
    		for (int i=0; i<list.size()-1; i++) {
    			if (list.get(i)+1!=list.get(i+1))
    				return false;
    		}
    	}
        
        return true;
    }
    
	public static void main(String[] args) {
		int[] nums = new int[]{13,14,15,7,8,9,20,21,22,4,5,6};		
		System.out.println(new ArrayKConsecutiveNums().isPossibleDivide(nums, 3));
	}
}

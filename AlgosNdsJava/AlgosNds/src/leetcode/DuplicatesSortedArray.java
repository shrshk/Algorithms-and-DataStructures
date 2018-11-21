package leetcode;

import java.util.HashSet;
import java.util.Set;


public class DuplicatesSortedArray {
//	public static int[] removeDuplicates(int[] nums) {
//        Set<Integer> vals = new HashSet<Integer>();
//        for(int i=0;i<nums.length;i++) {
//        	vals.add(nums[i]);
//        } 
//        // Collection<Integer> = new Collection<Integer>();
//        int[] array = vals.stream().mapToInt(Number::intValue).toArray();
//        return array;
//    }
	
	public int removeDuplicates(int[] nums) {
		int count = 0;
		int temp = Integer.MIN_VALUE;
		
		for(int i=0; i<nums.length; i++) {
			if(temp==nums[i]) continue; //seems unnecessary but it is faster than without it
			if(nums[i]>temp) { 
				temp=nums[i];
				nums[count++] = temp;
			
			}

		}
		return count;
	}
	
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,1,2,2,3,4,4}; // 1,2
		System.out.println(new DuplicatesSortedArray().removeDuplicates(arr));
	}
}

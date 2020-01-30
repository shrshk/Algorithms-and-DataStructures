package facebookPrep.recursionAndBacktracking;

import java.util.Arrays;

public class CanPartition {
	
    public boolean canPartition(int[] nums) {
    	int sum = 0;
    	for (int i=0; i<nums.length; i++) {
    		sum+=nums[i];
    	}
    	if (sum%2!=0)
    		return false;
    	sum/=2;    	
        Arrays.sort(nums);        
        return backtrack(nums, sum, 0);
    }
    
    private boolean backtrack(int[] nums, int sum, int index) {
    	if (sum==nums[index])
    		return true;
    	if (sum<nums[index]) 
    		return false;
    	return backtrack(nums, sum-nums[index], index+1) || backtrack(nums, sum, index+1);
    }
    

	// 1,5,5,11
	
	public static void main(String[] args) {
		
		System.out.println(new CanPartition().canPartition(new int[]{1,5,11,5}));
	}
}

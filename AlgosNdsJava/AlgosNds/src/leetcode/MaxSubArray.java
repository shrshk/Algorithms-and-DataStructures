package leetcode;
	
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++) {
        	sum = sum + nums[i];
        	if(sum < nums[i]){
        		sum = nums[i];
        	}
        	if(max<sum) {
        		max = sum;
        	}
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new MaxSubArray().maxSubArray(nums));
    }
}



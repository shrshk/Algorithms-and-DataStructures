package leetcode;

public class InsertPosition {
	
	public static int searchInsert(int[] nums, int target) {
    	if(nums[0]>target) {
    		return 0;
    	}
    	if(nums[nums.length-1]<target) {
    		return nums.length;
    	}
    	int i=0;
    	while(i<nums.length) {
    		if(nums[i]==target || nums[i]>target) {
        		return i;
        	}
    		i++;
    	}
    	return -1;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{1,3,5,6};
		System.out.println(searchInsert(arr, 5));
	}

}

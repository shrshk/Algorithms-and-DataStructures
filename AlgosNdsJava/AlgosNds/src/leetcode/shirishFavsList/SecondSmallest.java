package leetcode.shirishFavsList;

public class SecondSmallest {
	//0,2,10,3,-3
	// sm 2nd       // sm=0 
	// >sm <2nd 2nd=2  
	static int secondSmallest(int[] nums) {
		int smallest = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;
		for (int i=0; i<nums.length;i++) {
			if(nums[i]<smallest){
				second = smallest;
				smallest = nums[i];				
			}
			if(nums[i]<second && nums[i]>smallest) {
				second = nums[i];
			}
		}
		return second;
	}
	
	public static void main(String[] args) {
		System.out.println(secondSmallest(new int[]{0,2,10,3,-3,-2}));
	}
}

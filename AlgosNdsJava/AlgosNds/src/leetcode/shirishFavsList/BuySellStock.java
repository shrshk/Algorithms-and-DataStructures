package leetcode.shirishFavsList;

public class BuySellStock {
	static int maxProfit(int[] nums) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int i=0; i<nums.length;i++) {
			if (minPrice>nums[i]) {
				minPrice = nums[i];
			}else if(nums[i]-minPrice>maxProfit) {
				maxProfit = nums[i]-minPrice;
			}
		}
		return maxProfit;
	}
	
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
	}
}

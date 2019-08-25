package leetcode.shirishFavsList;

import java.util.Arrays;

public class MoveZeros {
	static void moveZeros(int[] nums) {
		int count = nums.length-1;
		for (int i=nums.length-1;i>0;i--) {
			if(nums[i]!=0) {
				nums[count--]=nums[i];
			}
		}
		while(count>0) {
			nums[count--] = 0;
		}
		System.out.println(Arrays.toString(nums));
	}
	
	public static void main(String[] args) {
		moveZeros(new int[]{0,1,0,3,12});
	}
}

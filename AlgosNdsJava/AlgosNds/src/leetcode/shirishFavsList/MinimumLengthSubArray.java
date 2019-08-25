package leetcode.shirishFavsList;

public class MinimumLengthSubArray {
	static int minLengthSubArray(int s, int[] nums) {
		int n = nums.length;
		int i=0,j=0;
		int minLength = n;
		while(i<n) {
			int count=0;
			while(j<n && count<s) {
				count = count + nums[j++];
			}
			if (count<s && j-i == n) {
				minLength = 0;
			}else if(count > s && j-i<n) {
				minLength = Math.min(minLength, j-i);
			}else if(count == s && j-i==n) {
				minLength = j-i;
			}else if (count==s){
				minLength = Math.min(minLength, j-i);
			}
			i++;
			j=i;
		}
		return minLength;
	}
	
	public static void main(String[] args) {
		System.out.println(minLengthSubArray(15, new int[]{1,2,3,4,5}));
	}
}
// 2 3 1 1 4 3

// i j
package leetcode.shirishFavsList;

import java.util.Arrays;

public class MergeSortedArray {
	static void mergeSortedArray(int[] nums1, int m, int[] nums2, int n){
		int i=m-1, j=n-1, k=m+n-1;
		while(i>=0 && j>=0) {
			nums1[k--] = nums1[i]>nums2[j]?nums1[i--]:nums2[j--];		    
		}
		while (i==-1 && j>=0) 
	        nums1[j] = nums2[j--];
		System.out.println(Arrays.toString(nums1));
	}
	public static void main(String[] args) {
		int[] nums1 = new int[]{1,2,3,0,0,0}; // 1 2  
		int[] nums2 = new int[]{2,5,6};
		mergeSortedArray(nums1, 3, nums2, 3);
	}
}

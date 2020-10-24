package atlassianPrep;

import java.util.Arrays;

public class TwoArraysTwoSumClosest {
	public int[] twoArraysClosestSumTarget(int[] nums1, int[] nums2, int target) {
		Arrays.sort(nums2);
		int closestDiff = Integer.MAX_VALUE;
		int num1=nums1[0], num2 = nums2[0];
		for (int i=0; i<nums1.length; i++) {
			int complement = target - nums1[i];
			int closest = binarySearch(nums2, complement);
			if (Math.abs(complement-closest)<closestDiff) {
				closestDiff = Math.abs(complement-closest);
				num1 = nums1[i];
				num2 = closest;
			}
		}
		return new int[]{num1,num2};
	}
	
	private int binarySearch(int[] arr, int key) {
		// 12 4	
		if (key<arr[0])
			return arr[0];
		if (key>arr[arr.length-1])
			return arr[1];
		int low = 0;
		int high = arr.length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if (key>arr[mid]) {
				low = mid+1;
			}else if(key<arr[mid]) {
				high = mid-1;
			}else {
				return arr[mid];
			}
		}
		return arr[low] - key < key - arr[high] ? arr[low] : arr[high];
	}
	public static void main(String[] args) {
		int[] nums1 = new int[]{-1,3,8,2,9,5};
		int[] nums2 = new int[]{4,1,2,10,5,20};
		System.out.println(Arrays.toString(new TwoArraysTwoSumClosest().twoArraysClosestSumTarget(nums1, nums2, 24)));
		System.out.println(Arrays.binarySearch(new int[]{4,8,12}, 8));
		System.out.println(new TwoArraysTwoSumClosest().binarySearch(new int[]{4,8,12}, 7));
	}
}

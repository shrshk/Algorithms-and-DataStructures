package leetcode30DayChallenge;

public class SearchRotatedSortedArray {
	public int search(int[] nums, int target) {
		// 4,5,6,7,0,1,2
		if (nums == null || nums.length == 0)
			return -1;
		
		int pivotIdx = getPivotIdx(nums);
		
		if (pivotIdx == -1)
			return binarySearch(nums, 0, nums.length, target);
		
		if (target > nums[nums.length - 1]) {
			return binarySearch(nums, 0, pivotIdx, target);
		}

		if (target <= nums[nums.length - 1]) {
			return binarySearch(nums, pivotIdx, nums.length, target);
		}

		return -1;
	}

	private int binarySearch(int[] nums, int low, int high, int key) {
		while (low < high) {
			int mid = (high + low) / 2;
			if (key > nums[mid]) {
				low = mid + 1;
			} else if (key < nums[mid]) {
				high = mid;
			} else {
				return mid;
			}
		}

		return -1;
	}

	private int getPivotIdx(int[] nums) {
		if (nums.length<2)
			return -1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1])
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1 };
		System.out.println(new SearchRotatedSortedArray().search(nums, 0));
	}
}

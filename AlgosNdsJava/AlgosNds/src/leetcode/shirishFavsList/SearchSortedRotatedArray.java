package leetcode.shirishFavsList;

public class SearchSortedRotatedArray {
	static int searchSortedRotatedArray(int[] nums, int target) {
	    int lo = 0, hi = nums.length - 1;
	    while (lo < hi) {
	        int mid = (lo + hi) / 2;	        
	        if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
	            lo = mid + 1;
	        else
	            hi = mid;
	    }
	    return lo == hi && nums[lo] == target ? lo : -1;
	}
	// if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
	// nums[0] <= target < nums[mid] || target < nums[mid] < nums[0] || nums[mid] < nums[0] <= target
	public static void main(String[] args) {
		System.out.println(searchSortedRotatedArray(new int[]{4,5,6,7,0,1,2}, 0));
	}
}

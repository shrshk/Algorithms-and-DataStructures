package leetcode30DayChallenge.may;

public class SingleElementSortedArray {
    public int singleNonDuplicate(int[] nums) {
        // binary search
        int n=nums.length, lo=0, hi=n/2;
        while (lo < hi) {
            int m = (lo + hi) / 2;
            System.out.println(m);
            if (nums[2*m]!=nums[2*m+1]) hi = m;
            else lo = m+1;
        }
        return nums[2*lo];
    }
    
    public static void main(String[] args) {
    	int[] nums = new int[]{3,3,7,7,10,10,11};
		System.out.println(new SingleElementSortedArray().singleNonDuplicate(nums));
	}
}

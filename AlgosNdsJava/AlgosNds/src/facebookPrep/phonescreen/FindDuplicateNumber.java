package facebookPrep.phonescreen;

public class FindDuplicateNumber {
	public int findDuplicate(int[] nums) {
        // 1 3 4 2 2 
        // count = 3 < mid so 2nd half has the dupl.
        int low = 0;
        int high = nums.length-1;        
        while (low < high) {
            int mid = low + (high-low)/2;
            int count = 0;
            for (int num : nums) {
                if (num<=mid) {
                    count++;
                }                
            }
            if (count<=mid) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        
        return low;
    }
	
	public static void main(String[] args) {
		// 
		int[] nums = new int[]{1,3,4,2,2};
		// System.out.println(new FindDuplicateNumber().findDuplicate(nums));
		System.out.println("213".compareTo(String.valueOf(100000000)));
	}
}

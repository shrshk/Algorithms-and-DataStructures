package atlassianPrep;

import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
        // 123 // 132
        // 4521 // 1 2 
        // 1234 // 1243        1243 
        // 115 // 4521 // 5
        // 123
        // 45521 // 321 // 
        int j=nums.length-2;
        while(j>=0 && nums[j]>=nums[j+1]) {
            j--;
        }
        
        if (j>=0) {
            int i = nums.length-1;
            while(nums[i]<=nums[j])
                i--;
            swap(nums, j, i);
        }
        
        reverse(nums, j+1, nums.length-1); // 5 5 4 2 1 // 5 1 2 4 5 
        
        System.out.println(Arrays.toString(nums));
        
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
    
    private void reverse(int[] nums, int i, int j) {
        while(i<j)
            swap(nums, i++, j--);
    }
    
    public static void main(String[] args) {
		new NextPermutation().nextPermutation(new int[]{4,5,5,2,1});
	}
}

package leetcodeContests.contest178;

import java.util.Arrays;

public class SmallerThanCurrentNumber {
	public int[] smallerNumbersThanCurrent(int[] nums) {
        // 8,1,2,2,3
        // 8 3 2 2 1
		
		// {8:  }      // [1,2,3,8] // 12238
        // Queue<int[]> pq = new PriorityQueue<>((int[] arr1, int[] arr2) -> (arr2[1]-arr1[1]));
        int[] res = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            int count = 0;
           for (int j=0; j<nums.length; j++) {               
               if (i!=j) {
                   if (nums[i]>nums[j]) {
                       count++;
                   }
               }
           }
            res[i] = count;
        }        
        
        return res;
    }
	
	public int[] smallerNumbersThanCurrentBS(int[] nums) {
        // 8,1,2,2,3
        // 8 3 2 2 1
		
		// {8:  }      // [1,2,3,8] // 12238
        // Queue<int[]> pq = new PriorityQueue<>((int[] arr1, int[] arr2) -> (arr2[1]-arr1[1]));
        int[] temp = new int[nums.length];
        int[] res = new int[nums.length];
        int idx=0;
        for (int num: nums) {
        	temp[idx++] = num;
        }
        Arrays.sort(temp);
        
        for (int num: nums) {
        	
        }
        
        
        
        return res;
    }
}

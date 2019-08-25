package codility;

import java.util.HashSet;
import java.util.stream.IntStream;

public class SmallestPositiveNotPresent {
	static int smallestPositive(int[] arr) {
		int max = 0;
		
		for (int i=0; i<arr.length;i++) {
			if (arr[i]>max)
				max=arr[i];
		}
		
		int j=1;
		
		while (j<max) {
			int temp = j;
			if (!IntStream.of(arr).anyMatch(x -> x == temp))
				return j;
			j++;
		}
		
		if (j==max) 
			return max+1;
		
		return 1;
		
	}
	static int smallPost(int[] nums) {
		int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0 && nums[i] < n && (nums[nums[i] - 1] != nums[i])){
                swap(nums,nums[i] - 1, i);
                i--;
            }
        }
        for (int i = 1; i <= n; i++){
            if(nums[i - 1] != i) return i;
        }
        return n+1;
	}
	
	static int hashSetSol(int[] nums) {
		HashSet<Integer> myset = new HashSet<Integer>();
        int result = 0;
        if(nums.length == 0) return 1;
		for(int i = 0; i< nums.length; i++){
        myset.add(nums[i]);
        }
        for(int j = 1; j <= nums.length+1; j++){
            if(!myset.contains(j)){
                result = j;
                break;
            }
        }
        return result;
	}
	
	static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
	
	public static void main(String[] args) {
		System.out.println(hashSetSol(new int[]{1,2,0}));
	}
}

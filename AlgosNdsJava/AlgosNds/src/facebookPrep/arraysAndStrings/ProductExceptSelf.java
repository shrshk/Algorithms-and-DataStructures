package facebookPrep.arraysAndStrings;

import java.util.Arrays;

public class ProductExceptSelf {

	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] leftArr = new int[n];
		int[] rightArr = new int[n];
		int[] res = new int[n];

		leftArr[0] = 1;
		rightArr[n - 1] = 1;

		// Input: [1,2,3,4]
		for (int i = 1; i < n; i++) {
			leftArr[i] = nums[i - 1] * leftArr[i - 1]; // [1,(1*1),(2*1),(3*2)]
														// // [1,1,2,6] // //
														// [24,12,4,1]
		}

		for (int j = n - 2; j >= 0; j--) {
			rightArr[j] = nums[j + 1] * rightArr[j + 1];
		}

		for (int i = 0; i < n; i++) {
			res[i] = leftArr[i] * rightArr[i];
		}

		return res;
	}
	
    public int[] productExceptSelfOptimized(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        res[0] = 1;
        // 1 2 3 4
        for (int i=1; i<n; i++) {
            res[i] = nums[i-1] * res[i-1];
        }
        
        System.out.println(Arrays.toString(res));
        
        int right = 1;
        
        for (int i=n-1; i>=0; i--) {
            res[i] = res[i] * right;
            right = right * nums[i];
            System.out.println(right);
         }
        
        return res;
    }

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new ProductExceptSelf().productExceptSelfOptimized(new int[] { 1, 2, 3, 4 })));
	}
}

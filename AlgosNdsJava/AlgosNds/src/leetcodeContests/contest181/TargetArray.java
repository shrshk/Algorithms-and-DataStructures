package leetcodeContests.contest181;

import java.util.Arrays;

public class TargetArray {
	public int[] createTargetArray(int[] nums, int[] index) {
		int n = nums.length;
		int[] target = new int[n];
		int i = 0;
		while (i < n) {
			if (index[i] < i) {
				insertAndMoveItemsToRight(nums[i], index[i], target);
			} else {
				target[index[i]] = nums[i];
			}
			i++;
		}

		return target;
	}

	private void insertAndMoveItemsToRight(int num, int idx, int[] target) {
		// 1_23
		int j = target.length - 1;
		while (j >= idx && j-1>=0) {
			target[j] = target[j - 1];
			j--;
		}

		target[idx] = num;
	}

	public static void main(String[] args) {
		// nums = [0,1,2,3,4], index = [0,1,2,2,1]
		int[] nums = new int[] {0, 1,2,3,4 };
		int[] index = new int[] { 0, 1, 2, 2, 1 };
		System.out.println(Arrays.toString(new TargetArray().createTargetArray(nums, index)));
	}
}

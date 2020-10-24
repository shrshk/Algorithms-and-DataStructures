package leetcodeContests.contest187;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LongestSubArrayLessThanLimit {
	public int longestSubarray(int[] nums, int limit) {
		// Input: nums = [8,2,4,7], limit = 4

		// {0}

		int left = 0;
		int maxLen = 1;

		Deque<Integer> maxD = new LinkedList<>();
		Deque<Integer> minD = new LinkedList<>();

		for (int right = 0; right < nums.length; right++) {
			while (!maxD.isEmpty() && maxD.peekLast() < nums[right])
				maxD.removeLast();
			maxD.addLast(nums[right]);

			while (!minD.isEmpty() && minD.peekLast() > nums[right])
				minD.removeLast();
			minD.addLast(nums[right]);

			while (Math.abs(maxD.peekFirst() - minD.peekFirst()) > limit) {
				if (maxD.peekFirst() == nums[left])
					maxD.pollFirst();
				if (minD.peekFirst() == nums[left])
					minD.pollFirst();
				++left;
			}

			maxLen = Math.max(right - left + 1, maxLen);
		}

		return maxLen;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString("openmate,dealerId1:shirishLot1".split(",")));
		System.out.println(Arrays.toString("hyperion".split(",")));
	}
}

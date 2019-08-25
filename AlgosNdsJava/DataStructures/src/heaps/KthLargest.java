package heaps;

import java.util.PriorityQueue;

class KthLargest {
	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			q.add(nums[i]);
		}
		for (int i = k; i < nums.length; i++) {
			if (nums[i] > q.peek()) {
				q.poll();
				q.add(nums[i]);
			}
		}
		return q.peek();

	}
	
	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[]{7,4,6,3,9}, 2)); // 3 4 6 7 9  5th 5
	}
}
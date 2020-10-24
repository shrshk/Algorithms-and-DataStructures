package leetcode30DayChallenge.september;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LargestNumber {
	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0)
			return "0";
		Queue<String> q = new PriorityQueue<>(new Comparator<String>() {

			@Override
			public int compare(String one, String two) {

				String a = one + two;
				String b = two + one;

				return b.compareTo(a);
			}

		});
		for (int num : nums) {
			q.add(String.valueOf(num));
		}

		if (q.peek().charAt(0) == '0')
			return "0";

		StringBuilder sb = new StringBuilder();

		while (!q.isEmpty()) {
			sb.append(q.poll());
		}

		return sb.toString();
	}
}

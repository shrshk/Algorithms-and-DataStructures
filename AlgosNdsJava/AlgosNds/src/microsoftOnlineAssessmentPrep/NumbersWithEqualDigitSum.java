package microsoftOnlineAssessmentPrep;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class NumbersWithEqualDigitSum {
	public int numbersWithEqualDigitSum(int[] A) {
		// 51,71,17,42
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
		for (int num : A) {
			int sum = 0;
			String numS = String.valueOf(num);
			for (char c : numS.toCharArray())
				sum += c - '0';
			map.putIfAbsent(sum, new PriorityQueue<Integer>((a, b) -> (b - a)));
			PriorityQueue<Integer> nums = map.get(sum);
			nums.add(num);
			map.put(sum, nums);
		}

		int res = -1;

		for (PriorityQueue<Integer> nums : map.values()) {
			int sum = 0;
			if (nums.size() < 2)
				continue;
			sum += nums.poll() + nums.poll();
			res = Math.max(res, sum);
		}

		return res;
	}

	public static void main(String[] args) {
		int[] A = new int[] { 51, 32, 43 };
		System.out.println(new NumbersWithEqualDigitSum()
				.numbersWithEqualDigitSum(A));
	}
}

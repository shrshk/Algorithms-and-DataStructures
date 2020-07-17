package leetcode30DayChallenge.june;

import java.util.HashMap;
import java.util.Map;

// int count = 0;
//
// while (n >= 1) {
// if (isPerfectSquare(n)) {
// count++;
// break;
// }
// int val = (int) Math.floor(Math.sqrt(n));
// n = n - (val * val);
// count++;
// }
//while (val >= 1) {
//val = (int) Math.floor(Math.sqrt(num));
//int path = 1 + backtrack(num - val);
//count = Math.min(count, path);
//}

public class PerfectSquares {
	public int numSquares(int n) {
		Map<Integer, Integer> cache = new HashMap<>();
		return backtrack(n, cache);
	}

	private int backtrack(int num, Map<Integer, Integer> cache) {
		if (num < 4)
			return num;
		if (cache.containsKey(num))
			return cache.get(num);
		int count = num;
		for (int i = 1; i * i <= num; i++) {
			int nextNum = num - (i * i);
			int pathVal = 1 + backtrack(nextNum, cache);
			count = Math.min(count, pathVal);
			cache.put(num, count);
		}

		return cache.get(num);
	}

	private boolean isPerfectSquare(int num) {
		double val = Math.sqrt(num);
		return (val - Math.floor(val)) == 0;
	}

	public static void main(String[] args) {
		System.out.println(new PerfectSquares().numSquares(2));
	}

}

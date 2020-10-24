package leetcode30DayChallenge.july;

import java.util.HashMap;
import java.util.Map;

public class NthUglyNumber {
	public int nthUglyNumber(int n) {
		Map<Integer, Integer> ugly = new HashMap<>();
		ugly.put(1, 1);
		int idx2 = 1, idx3 = 1, idx5 = 1;
		int f2 = 2, f3 = 3, f5 = 5;
		for (int i = 2; i <= n; i++) {
			int min = Math.min(Math.min(f2, f3), f5);
			ugly.put(i, min);
			if (min == f2)
				f2 = 2 * ugly.get(++idx2);
			if (min == f3)
				f3 = 3 * ugly.get(++idx3);
			if (min == f5)
				f5 = 5 * ugly.get(++idx5);

		}
		return ugly.get(n);
	}

	public static void main(String[] args) {
		System.out.println(new NthUglyNumber().nthUglyNumber(10));
	}
}

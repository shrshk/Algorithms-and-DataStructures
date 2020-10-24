package leetcode30DayChallenge.august;

import java.util.HashMap;
import java.util.Map;

public class BuySellStock3 {

	Map<String, Integer> cache;
	int n;
	int[] p;

	public int maxProfit(int[] prices) {
		cache = new HashMap<>();
		n = prices.length;
		p = prices;
		int ans = dfs(0, 0, 0);
		System.out.println(cache.toString());
		return ans;
	}

	private int dfs(int idx, int state, int count) {
		if (idx == n || count == 2)
			return 0;
		String key = idx + "_" + state + "_" + count;
		if (cache.containsKey(key))
			return cache.get(key);

		if (state == 0) {
			int op1 = dfs(idx + 1, 0, count);
			int op2 = dfs(idx + 1, 1, count) - p[idx];
			cache.put(key, Math.max(op1, op2));
//			System.out.println(key + "__" + cache.get(key));
			return cache.get(key);
		}
		if (state == 1) {
			int op1 = dfs(idx + 1, 1, count);
			int op2 = dfs(idx + 1, 0, count + 1) + p[idx];
			cache.put(key, Math.max(op1, op2));
			return cache.get(key);
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new BuySellStock3().maxProfit(new int[] { 1,2,3 }));
	}

}

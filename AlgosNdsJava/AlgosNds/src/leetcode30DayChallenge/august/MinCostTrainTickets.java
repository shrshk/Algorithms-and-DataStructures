package leetcode30DayChallenge.august;

import java.util.HashMap;
import java.util.Map;

public class MinCostTrainTickets {
	Map<Integer, Integer> cache;

	public int mincostTickets(int[] days, int[] costs) {
		cache = new HashMap<>();
		return helper(0, days, costs);
	}

	private int helper(int start, int[] days, int[] costs) {
		if (start == days.length)
			return 0;

		if (cache.containsKey(start))
			return cache.get(start);

		for (int i = start; i < days.length; i++) {
			int dayIdx = getIdx(days, start, 1);
			int sevenIdx = getIdx(days, start, 7);
			int thirtyIdx = getIdx(days, start, 30);

			int oneDayPassCost = costs[0] + helper(dayIdx, days, costs);
			int sevenDayPassCost = costs[1] + helper(sevenIdx, days, costs);
			int thirtyDayPassCost = costs[2] + helper(thirtyIdx, days, costs);
			int minCost = Math.min(oneDayPassCost, Math.min(sevenDayPassCost, thirtyDayPassCost));
			cache.put(start, minCost);
		}

		return cache.get(start);
	}

	private int getIdx(int[] days, int start, int count) {
		int endDay = days[start] + count - 1;
		int nextIdx = start;
		while (nextIdx < days.length && days[nextIdx] <= endDay) {
			nextIdx++;
		}

		return nextIdx;
	}
	
	public static void main(String[] args) {
		int[] days = new int[]{1,2,8,20};
		int[] costs = new int[]{2,7,15};
		System.out.println(new MinCostTrainTickets().mincostTickets(days, costs));
	}
}
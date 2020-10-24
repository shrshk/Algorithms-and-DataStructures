package leetcodeContests.contest210;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximalNetworkRank {
	public int maximalNetworkRank(int n, int[][] roads) {
		// n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]

		Map<Integer, List<Integer>> adjMap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			adjMap.put(i, new ArrayList<>());
		}

		for (int i = 0; i < roads.length; i++) {
			int[] road = roads[i];
			List<Integer> link1 = adjMap.get(road[0]);
			List<Integer> link2 = adjMap.get(road[1]);
			link1.add(road[1]);
			link2.add(road[0]);
		}

		int max = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				max = Math.max(max, maxNetworkRank(adjMap.get(i), adjMap.get(j), i, j));
			}
		}

		return max;
	}

	public int maxNetworkRank(List<Integer> A, List<Integer> B, int city1, int city2) {
		int intersec = 0;
		if (A.contains(city2)) {
			intersec = 1;
		}

		return A.size() + B.size() - intersec;
	}
}

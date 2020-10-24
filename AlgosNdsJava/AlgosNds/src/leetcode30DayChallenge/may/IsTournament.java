package leetcode30DayChallenge.may;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsTournament {
	public boolean isTournament(int n, int[] fromV, int[] toV) {
		Map<Integer, List<Integer>> adjMap = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			adjMap.put(i, new ArrayList<>());
		}

		for (int i = 0; i < fromV.length; i++) {
			List<Integer> list = adjMap.get(fromV[i]);
			list.add(toV[i]);
			adjMap.put(fromV[i], list);
		}

		for (int i = 1; i <= n; i++) {
			List<Integer> neighbors = adjMap.get(i);
			for (int neighbor : neighbors) {
				List<Integer> vals = adjMap.get(neighbor);
				if (vals.contains(i))
					return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int[] fromV = new int[] { 2, 1, 3, 4, 4, 4, 1, 2, 3, 4, 2 };
		int[] toV = new int[] { 3, 2, 1, 3, 2, 1, 5, 5, 5, 5, 4 };
		System.out.println(new IsTournament().isTournament(5, fromV, toV));
	}
}

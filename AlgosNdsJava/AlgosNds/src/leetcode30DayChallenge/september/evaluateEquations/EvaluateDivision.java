package leetcode30DayChallenge.september.evaluateEquations;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		Map<String, Map<String, Double>> adjMap = new HashMap<>();

		for (int i = 0; i < equations.size(); i++) {
			List<String> eq = equations.get(i);
			String src = eq.get(0);
			String target = eq.get(1);
			Double cost = values[i];

			adjMap.putIfAbsent(src, new HashMap<>());
			adjMap.putIfAbsent(target, new HashMap<>());

			adjMap.get(src).put(target, cost);
			adjMap.get(target).put(src, 1 / cost);
		}

		double[] res = new double[queries.size()];

		for (int i = 0; i < queries.size(); i++) {
			List<String> q = queries.get(i);
			String start = q.get(0);
			String end = q.get(1);
			res[i] = DFS(adjMap, start, end, 1.0, new HashSet<>());
		}

		return res;
	}

	private double DFS(Map<String, Map<String, Double>> adjMap, String start, String end, double r, Set<String> seen) {
		if (!adjMap.containsKey(start) || !seen.add(start))
			return -1;
		if (start.equals(end))
			return r;
		Map<String, Double> links = adjMap.get(start);
		for (String link : links.keySet()) {
			double result = DFS(adjMap, link, end, r * links.get(link), seen);
			if (result == -1)
				continue;
			return result;
		}

		return -1;
	}
}

package amazonLeetCode.phonescreen;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LCSGraph {

	public int LCS(List<int[]> edges) {
		int max = 0;
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int[] edge : edges) {
			List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
			list.add(edge[1]);
			map.put(edge[0], list);
		}

		for (Integer node : map.keySet()) {
			max = Math.max(max, bfs(map, node));
		}

		return max;
	}

	private int bfs(Map<Integer, List<Integer>> map, int node) {
		List<Integer> visited = new ArrayList<>();

		Queue<Integer> q = new ArrayDeque<>();
		q.add(node);
		int count = 1;

		while (!q.isEmpty()) {
			int curr = q.poll();
			visited.add(curr);
			List<Integer> adjList = map.get(curr);
			
			int temp = curr;
			while (adjList.contains(temp + 1) && !visited.contains(temp + 1)) {
				q.add(temp + 1);
				visited.add(temp+1);
				temp++;
			}
			count += temp - curr;
		}

		return count;
	}
	
	public static void main(String[] args) {
		List<int[]> edges = Arrays.asList(new int[]{1,3}, new int[]{3,1}, new int[]{2,3}, new int[]{3,2}, new int[]{2,4}, new int[]{4,2}, new int[]{4,3}, new int[]{3,4});
		System.out.println(new LCSGraph().LCS(edges));
	}

}

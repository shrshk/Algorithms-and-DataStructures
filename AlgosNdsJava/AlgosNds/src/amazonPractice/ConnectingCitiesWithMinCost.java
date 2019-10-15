package amazonPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class NodeC {
	int val;
	int price;

	NodeC(int val, int price) {
		this.val = val;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Node [val=" + val + ", price=" + price + "]";
	}
}

class GraphC {
	Map<Integer, List<NodeC>> adjMap = new HashMap<>();

	GraphC(int[][] connections, int n) {
		for (int i = 0; i <= n; i++) {
			adjMap.put(i, new ArrayList<>());
		}
		for (int i = 0; i < connections.length; i++) {
			int src = connections[i][0];
			int target = connections[i][1];
			int price = connections[i][2];
			List<NodeC> srcList = adjMap.get(src);
			srcList.add(new NodeC(target, price));
			List<NodeC> targetList = adjMap.get(target);
			targetList.add(new NodeC(src, price));
		}
	}

}

public class ConnectingCitiesWithMinCost {

	static int minCost(int n, int[][] connections) {
		if (n == 1)
			return 0;
		GraphC g = new GraphC(connections, n);
		boolean[] visited = new boolean[n + 1]; // because cities are numbered
												// from 1 and not 0
		Queue<NodeC> pq = new PriorityQueue<>((NodeC n1, NodeC n2) -> n1.price - n2.price);
		int cost = 0, numOfVisitedCities = 0;
		pq.add(new NodeC(1, 0));

		while (!pq.isEmpty()) {
			NodeC current = pq.poll();
			if (visited[current.val])
				continue;
			visited[current.val] = true;
			cost += current.price;
			numOfVisitedCities++;
			for (NodeC node : g.adjMap.get(current.val)) {
				if (!visited[node.val])
					pq.add(node);
			}
		}

		return numOfVisitedCities == n ? cost : -1;
	}

	public static void main(String[] args) {

		// N = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
//		int n = 3;
//		int[][] connections = new int[][] { { 1, 2, 5 }, { 1, 3, 6 }, { 2, 3, 1 } };

		int n2 = 5;

		int[][] cns = new int[][] { { 2, 1, 50459 }, { 3, 2, 47477 }, { 4, 2, 52585 }, { 5, 3, 16477 } };

		// 5
		// [[2,1,50459],[3,2,47477],[4,2,52585],[5,3,16477]]

		System.out.println(minCost(n2, cns));

		// GraphC g = new GraphC(connections, n);
		//
		// System.out.println(g.adjMap.toString());

	}
}

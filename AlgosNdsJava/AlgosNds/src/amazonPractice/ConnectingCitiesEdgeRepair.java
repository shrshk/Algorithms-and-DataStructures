package amazonPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//steps

//build graph with edges and 0 cost and update the cost with edgesToRepair

//start with the first node {1,0}, run bfs, push connected nodes into pq. (comparator cost)

//update cost after exploring a node for the first time.

//return cost after exploring all cities.

class ConnectNode {
	int vertex;
	int cost;

	ConnectNode(int vertex, int cost) {
		this.vertex = vertex;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "ConnectNode [vertex=" + vertex + ", cost=" + cost + "]";
	}
}

class CityGraph {
	Map<Integer, List<ConnectNode>> adjMap = new HashMap<>();

	CityGraph(int[][] edges, int[][] edgesToRepair, int N) {
		for (int i = 1; i <= N; i++) {
			adjMap.put(i, new ArrayList<>());
		}
		for (int i = 0; i < edges.length; i++) {
			int src = edges[i][0];
			int target = edges[i][1];
			List<ConnectNode> srcList = adjMap.get(src);
			srcList.add(new ConnectNode(target, 0));
			List<ConnectNode> targetList = adjMap.get(target);
			targetList.add(new ConnectNode(src, 0));
		}

		for (int i = 0; i < edgesToRepair.length; i++) {
			int src = edgesToRepair[i][0];
			int target = edgesToRepair[i][1];
			int cost = edgesToRepair[i][2];
			List<ConnectNode> srcList = adjMap.get(src);
			List<ConnectNode> targetList = adjMap.get(target);
			for (ConnectNode node : srcList) {
				if (node.vertex == target)
					node.cost = cost;
			}
			for (ConnectNode node : targetList) {
				if (node.vertex == src)
					node.cost = cost;
			}
		}
	}
}

public class ConnectingCitiesEdgeRepair {
	static int minCostEdgesToRepair(int N, int[][] edges, int[][] edgesToRepair) {
		CityGraph g = new CityGraph(edges, edgesToRepair, N);
		Queue<ConnectNode> pq = new PriorityQueue<>((ConnectNode n1, ConnectNode n2) -> (n1.cost-n2.cost));
		boolean[] visited = new boolean[N+1];
		int minCost = 0;		
		pq.add(new ConnectNode(1,0));
		
		while(!pq.isEmpty()) {
			ConnectNode current = pq.poll();
			if (visited[current.vertex]) continue;
			visited[current.vertex] = true;
			minCost+=current.cost;
			for (ConnectNode node: g.adjMap.get(current.vertex)) {
				if (!visited[node.vertex])
					pq.add(node);
			}
		}		
		
		return minCost;
	}
	public static void main(String[] args) {
		int N = 5; // [[1, 2], [2, 3], [3, 4], [4, 5], [1, 5]]
		int[][] edges = new int[][]{{1,2},{2,3},{3,4},{4,5},{1,5}}; // [[1, 2, 12], [3, 4, 30], [1, 5, 8]]
		int[][] edgesToRepair = new int[][]{{1, 2, 12},{3, 4, 30},{1, 5, 8}};
		System.out.println(minCostEdgesToRepair(N, edges, edgesToRepair));
	}

}
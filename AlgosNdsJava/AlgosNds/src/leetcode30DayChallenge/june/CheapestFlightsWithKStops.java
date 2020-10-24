package leetcode30DayChallenge.june;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

enum Status {
	NOT_VISITED, VISITED
}

class Node {
	int val;
	Status status;
	int cost;
	Map<Node, Integer> neighborMap;

	Node(int val) {
		this.val = val;
		this.cost = 0;
		this.status = Status.NOT_VISITED;
		neighborMap = new HashMap<>();
	}

	void addNeighbor(Node node, int cost) {
		neighborMap.put(node, cost);
	}
}

class Graph {
	Map<Integer, Node> map;
	List<Node> nodes;

	Graph(int n, int[][] edges) {
		map = new HashMap<>();
		this.nodes = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			Node node = new Node(i);
			map.put(i, node);
			nodes.add(node);
		}

		for (int[] edge : edges) {
			int src = edge[0];
			int dest = edge[1];
			int cost = edge[2];
			Node srcNode = map.get(src);
			Node destNode = map.get(dest);
			srcNode.addNeighbor(destNode, cost);
		}

	}

}

public class CheapestFlightsWithKStops {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

		// steps
		// build a graph with flights info
		// use bfs with k being each level
		// traverse the graph until K levels are reached, maintain minPrice
		// update it when dst is reached
		// mark visited nodes except dest.
		// return minPrice

		Graph g = new Graph(n, flights);
		Node start = g.map.get(src);
		Node end = g.map.get(dst);
		int minPrice = BFS(g, start, end, K);

		return minPrice == Integer.MAX_VALUE ? -1 : minPrice;
	}

	private int BFS(Graph g, Node start, Node end, int K) {
		int minPrice = Integer.MAX_VALUE;

		Queue<Node> q = new PriorityQueue<>((n1, n2) -> (n1.cost - n2.cost));

		q.add(start);
		int level = -1;

		while (!q.isEmpty() && level > K) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node curr = q.poll();

				for (Node neighbor : curr.neighborMap.keySet()) {
					if (neighbor.val == end.val) {
						minPrice = Math.min(minPrice, curr.cost + curr.neighborMap.get(neighbor));
						return minPrice;
					}
					if (neighbor.status == Status.NOT_VISITED) {
						neighbor.cost = curr.cost + curr.neighborMap.get(neighbor);
						q.add(neighbor);
					}
				}
			}
			level++;
		}

		return minPrice;
	}	
	

	public static void main(String[] args) {
		// n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
		// src = 0, dst = 2, k = 1
		int n = 3, K = 1, src = 0, dst = 2;
		int[][] flights = new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
		System.out.println(new CheapestFlightsWithKStops().findCheapestPrice(n, flights, src, dst, K));
	}

}

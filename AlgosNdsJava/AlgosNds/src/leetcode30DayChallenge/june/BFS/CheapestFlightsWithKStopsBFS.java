package leetcode30DayChallenge.june.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import javafx.util.Pair;

class Graph {
	Map<Integer, List<Pair<Integer, Integer>>> map;

	Graph(int n, int[][] edges) {
		map = new HashMap<>();
		for (int i=0; i<n; i++) {
			map.put(i, new ArrayList<>());
		}
		for (int[] edge : edges) {
			List<Pair<Integer, Integer>> dstWithCost = map.get(edge[0]);
			dstWithCost.add(new Pair<>(edge[1], edge[2]));
			map.put(edge[0], dstWithCost);
		}
	}
}

class Flight {
	int stops;
	int dest;
	int cost;

	Flight(int stops, int dest, int cost) {
		this.stops = stops;
		this.dest = dest;
		this.cost = cost;
	}
}

public class CheapestFlightsWithKStopsBFS {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

		// steps
		// build a graph with flights info
		// use bfs with k being each level
		// traverse the graph until K levels are reached, maintain minPrice
		// update it when dst is reached
		// mark visited nodes except dest.
		// return minPrice

		Graph g = new Graph(n, flights);

		return BFS(g, src, dst, K);
	}

	private int BFS(Graph g, int src, int dst, int K) {

		Queue<Flight> pq = new PriorityQueue<>((f1, f2) -> (f1.cost - f2.cost));
		pq.add(new Flight(0, src, 0));

		while (!pq.isEmpty()) {
			Flight curr = pq.poll();
			if (curr.stops > K + 1)
				continue;
			if (curr.dest == dst)
				return curr.cost;

			for (Pair<Integer, Integer> next : g.map.get(curr.dest)) {
				pq.add(new Flight(curr.stops + 1, next.getKey(), curr.cost + next.getValue()));
			}

		}

		return -1;
	}

	public static void main(String[] args) {
		// n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
		// src = 0, dst = 2, k = 1
		int n = 3, K = 2, src = 0, dst = 2;
		int[][] flights = new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
		System.out.println(new CheapestFlightsWithKStopsBFS().findCheapestPrice(n, flights, src, dst, K));
	}

}

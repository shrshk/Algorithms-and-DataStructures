package graphs.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Edge {
	int src, dest;

	Edge(int src, int dest) {
		this.src = src;
		this.dest = dest;
	}
}

class Graph {
	List<List<Integer>> adjList = new ArrayList<>();

	Graph(List<Edge> edges, int N) {
		for (int i = 0; i < N; i++) {
			adjList.add(i, new ArrayList<>());
		}

		for (int j = 0; j < edges.size(); j++) {
			int src = edges.get(j).src;
			int dest = edges.get(j).dest;

			adjList.get(src).add(dest);
			adjList.get(dest).add(src);

		}

	}

}

public class BFS {
	
	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList(
				new Edge(1, 2), new Edge(1, 3), new Edge(1, 4),
				new Edge(2, 5), new Edge(2, 6), new Edge(5, 9),
				new Edge(5, 10), new Edge(4, 7), new Edge(4, 8),
				new Edge(7, 11), new Edge(7, 12)
		);
		
		final int N = 15;
		Graph graph = new Graph(edges, N);
	}

}

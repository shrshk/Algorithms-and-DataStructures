package googlePrep.onsite;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TopologicalSort {

	private void DFS(Graph g, int vertex, Deque<Integer> topSort, Set<Integer> visited) {
		visited.add(vertex);
		List<Integer> conns = g.adjMap.get(vertex);
		if (conns == null) {
			topSort.add(vertex);
			return;
		}
		for (int conn : conns) {
			if (!visited.contains(conn))
				DFS(g, conn, topSort, visited);
		}

		topSort.offerFirst(vertex);

	}

	public Deque<Integer> topologicalSort(Graph g) {
		Deque<Integer> topSort = new ArrayDeque<>();
		Set<Integer> visited = new HashSet<>();

		Set<Integer> vertices = g.vertices;

		for (int v : vertices) {
			if (!visited.contains(v))
				DFS(g, v, topSort, visited);
		}

		return topSort;
	}

	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList(new Edge(0, 6), new Edge(1, 2), new Edge(1, 4), new Edge(1, 6), new Edge(3, 0),
				new Edge(3, 4), new Edge(5, 1), new Edge(7, 0), new Edge(7, 1));

		Graph g = new Graph(edges);
		
		System.out.println(g.adjMap.toString());

		System.out.println(new TopologicalSort().topologicalSort(g));
	}

}

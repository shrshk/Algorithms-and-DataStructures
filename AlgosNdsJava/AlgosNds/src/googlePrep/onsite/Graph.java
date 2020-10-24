package googlePrep.onsite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Edge {
	int src;
	int dest;

	Edge(int src, int dest) {
		this.src = src;
		this.dest = dest;
	}
}

public class Graph {
	Map<Integer, List<Integer>> adjMap;
	List<Edge> edges;
	Set<Integer> vertices;

	Graph(List<Edge> edges) {
		adjMap = new HashMap<>();
		this.edges = edges;
		this.vertices = new HashSet<>();

		for (Edge e : edges) {
			List<Integer> connections = adjMap.getOrDefault(e.src, new ArrayList<>());
			connections.add(e.dest);
			adjMap.put(e.src, connections);
			vertices.addAll(Arrays.asList(e.src, e.dest));
		}

	}

}

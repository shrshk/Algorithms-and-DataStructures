package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphWeightedWithCollections {
	static class Edge {
		int src;
		int dest;
		int weight;

		Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
	}

	static class Node {
		int weight, value;

		Node(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}

	List<List<Node>> adjList = new ArrayList<>();

	GraphWeightedWithCollections(List<Edge> edges) {
		// allocate memory for adj. list
		for (int i = 0; i < edges.size(); i++) {
			adjList.add(i, new ArrayList<>());
		}

		for (Edge edge : edges) {
			adjList.get(edge.src).add(new Node(edge.weight, edge.dest));
		}

	}

	static void printGraph(GraphWeightedWithCollections graph) {
		int n = graph.adjList.size();
		int i = 0;
		while (i < n) {
			for (Node node : graph.adjList.get(i)) {
				System.out.println(i + " " + node.value + " " + node.weight);
			}
			i++;
		}
	}

	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList(new Edge(0, 1, 6), new Edge(1, 2, 7), new Edge(2, 0, 5), new Edge(2, 1, 4),
				new Edge(3, 2, 10), new Edge(4, 5, 1), new Edge(5, 4, 3));
		GraphWeightedWithCollections graph = new GraphWeightedWithCollections(edges);
		printGraph(graph);
	}

}

package googlePrep.onsite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class KosarajuAlgorithm {

	private void DFS(Stack<Integer> order, int v, Graph g, Set<Integer> visited) {

		visited.add(v);
		List<Integer> nodes = g.adjMap.get(v);
		if (nodes == null) {
			order.push(v);
			return;
		}

		for (int node : nodes) {
			if (!visited.contains(node))
				DFS(order, node, g, visited);
		}

		order.push(v);

	}

	private Stack<Integer> fillOrder(Graph g, Set<Integer> visited) {

		Stack<Integer> order = new Stack<>();

		for (int v : g.vertices) {
			if (!visited.contains(v))
				DFS(order, v, g, visited);
		}

		return order;
	}

	private Graph getTranspose(Graph g) {

		List<Edge> reverseEdges = new ArrayList<>();

		for (Edge e : g.edges) {
			reverseEdges.add(new Edge(e.dest, e.src));
		}

		return new Graph(reverseEdges);
	}

	public List<List<Integer>> stronglyConnComponents(Graph g) {

		Set<Integer> visited = new HashSet<>();

		Stack<Integer> order = fillOrder(g, visited);

		Graph revGraph = getTranspose(g);

		visited.clear();

		List<List<Integer>> sCComps = new ArrayList<>();

		int size = order.size();

		for (int i = 0; i < size; i++) {
			int node = order.pop();
			if (!visited.contains(node)) {
				Stack<Integer> comp = new Stack<>();
				DFS(comp, node, revGraph, visited);
				sCComps.add(new ArrayList<>(comp));
			}
		}

		return sCComps;
	}

	private Graph buildCompressedGraph(Graph g, List<List<Integer>> comps) {
		// pick a repres. from each of the comp.
		// remove every other vertex other than repres.
		// any outer connections to those vertices have to be added to the
		// repres.
		// build comp. graph with these new edges
		return g;
	}

	public int minConnections(List<List<Integer>> comps, Graph g) {

		// build a new graph
		// check in degree 0 vertices other than new vertex
		// thats the answer.

		Map<Integer, Integer> inDegCount = new HashMap<>();

		for (List<Integer> comp : comps) {

		}

		return 0;
	}

	public static void main(String[] args) {
		// g.addEdge(1, 0);
		// g.addEdge(0, 2);
		// g.addEdge(2, 1);
		// g.addEdge(0, 3);
		// g.addEdge(3, 4);

		List<Edge> edges = Arrays.asList(new Edge(1, 0), new Edge(0, 2), new Edge(2, 1), new Edge(0, 3),
				new Edge(3, 4));

		Graph g = new Graph(edges);

		System.out.println(new KosarajuAlgorithm().stronglyConnComponents(g).toString());

	}

}

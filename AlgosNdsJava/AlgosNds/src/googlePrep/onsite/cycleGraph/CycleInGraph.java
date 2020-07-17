package googlePrep.onsite.cycleGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum Visited {
	ACTIVE, DONE, NEW
}

class Node {
	List<Node> neighbors;
	int data;
	Visited visited;

	Node(int data) {
		this.data = data;
		this.neighbors = new ArrayList<>();
		this.visited = Visited.NEW;
	}

	void addDirectNeighbor(Node n) {
		neighbors.add(n);
	}

}

class Graph {
	Map<Integer, Node> adjMap;
	List<Node> vertices;

	Graph() {
		this.vertices = new ArrayList<>();
		this.adjMap = new HashMap<>();
	}

	void addEdge(int n1, int n2) {
		Node node1 = adjMap.get(n1);
		Node node2 = adjMap.get(n2);

		List<Node> ns = node1.neighbors;
		ns.add(node2);
	}

	void addNode(int n1) {
		Node node = new Node(n1);
		vertices.add(node);
		adjMap.put(n1, node);
	}

}

public class CycleInGraph {
	public boolean hasCycle(int[][] edges, int N) {
		Graph g = new Graph();

		for (int i = 1; i <= N; i++) {
			g.addNode(i);
		}

		for (int[] edge : edges) {
			g.addEdge(edge[0], edge[1]);
		}

		try {
			for (Node n : g.vertices) {
				DFS(n);
			}
		} catch (Exception e) {
			return true;
		}

		return false;
	}

	private void DFS(Node n) throws Exception {
		n.visited = Visited.ACTIVE;
		List<Node> neighbors = n.neighbors;
		for (Node neighbor : neighbors) {
			if (neighbor.visited == Visited.NEW) {
				DFS(neighbor);
			} else if (neighbor.visited == Visited.ACTIVE) {
				throw new Exception("cycle found");
			}
		}
		n.visited = Visited.DONE;
	}

	public static void main(String[] args) {
		int[][] edges = new int[][] { { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 }, { 4, 5 }, { 5, 6 }, { 6, 4 } };
		System.out.println(new CycleInGraph().hasCycle(edges, 6));
	}

}

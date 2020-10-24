package amazonPractice.criticalConnections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

enum Status {
	Visited, NotVisited
}

class Node {
	int val;
	List<Node> neighbors;
	Status status;

	Node(int val) {
		this.val = val;
		this.neighbors = new ArrayList<>();
		this.status = Status.NotVisited;
	}
}

class Graph {
	Map<Integer, Node> adjMap;

	Graph(int n, int exclude, List<List<Integer>> connections) {
		adjMap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			if (i == exclude)
				continue;
			adjMap.put(i, new Node(i));
		}

		buildGraph(filteredConns(connections, exclude));
	}

	List<List<Integer>> filteredConns(List<List<Integer>> connections, int exclude) {
		return connections.stream().filter(conn -> !conn.contains(exclude)).collect(Collectors.toList());
	}

	void addDirectNeighbor(int src, int target) {
		Node srcNode = adjMap.get(src);
		Node targetNode = adjMap.get(target);
		srcNode.neighbors.add(targetNode);
		targetNode.neighbors.add(srcNode);
	}

	void buildGraph(List<List<Integer>> connections) {
		for (List<Integer> conn : connections) {
			int src = conn.get(0);
			int target = conn.get(1);
			addDirectNeighbor(src, target);
		}
	}

}

public class CriticalConnections {
	// steps
	// build graph excluding one node at a time
	// for given graph check connected components
	// if conn. comp. are > 1 add node to the result
	// repeat the steps

	public List<Integer> criticalNodes(int n, List<List<Integer>> connections) {

		Set<Integer> criticalNodes = new HashSet<>();

		for (int i = 0; i < n; i++) {
			Graph g = new Graph(n, i, connections);
			if (getConnectedComps(g) > 1)
				criticalNodes.add(i);
		}

		return new ArrayList<>(criticalNodes);

	}

	private int getConnectedComps(Graph g) {
		int connComps = 0;
		for (int i : g.adjMap.keySet()) {
			Node src = g.adjMap.get(i);
			if (src.status == Status.NotVisited) {
				DFS(src);
				connComps++;
			}
		}

		return connComps;
	}

	private void DFS(Node src) {
		if (src.status == Status.Visited)
			return;
		src.status = Status.Visited;
		for (Node neighbor : src.neighbors) {
			DFS(neighbor);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> connections = new ArrayList<>(
				Arrays.asList(Arrays.asList(0, 1), Arrays.asList(0, 2), Arrays.asList(1, 3), Arrays.asList(2, 3),
						Arrays.asList(2, 5), Arrays.asList(5, 6), Arrays.asList(3, 4)));
		System.out.println(new CriticalConnections().criticalNodes(7, connections));
	}

}

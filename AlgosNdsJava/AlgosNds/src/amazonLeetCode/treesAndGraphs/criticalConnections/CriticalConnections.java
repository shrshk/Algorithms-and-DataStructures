package amazonLeetCode.treesAndGraphs.criticalConnections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	Graph(int n) {
		adjMap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			adjMap.put(i, new Node(i));
		}

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
	// build graph excluding one connection at a time
	// for given graph check connected components
	// if conn. comp. are > 1 add removed connection to result and repeat steps

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

		List<List<Integer>> res = new ArrayList<>();

		for (int i = 0; i < connections.size(); i++) {
			List<Integer> conn = connections.get(i);
			connections.remove(i);
			Graph g = new Graph(n);
			g.buildGraph(connections);
			if (getConnectedComps(g, n) > 1)
				res.add(conn);
			connections.add(conn);
		}

		return res;

	}

	private int getConnectedComps(Graph g, int n) {
		int connComps = 0;
		for (int i = 0; i < n; i++) {
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
		List<List<Integer>> connections = new ArrayList<>(Arrays.asList(Arrays.asList(0,1),Arrays.asList(0,2),Arrays.asList(1,3),Arrays.asList(2,3),Arrays.asList(2,5),Arrays.asList(5,6),Arrays.asList(3,4)));
		System.out.println(new CriticalConnections().criticalConnections(7, connections));
	}

}

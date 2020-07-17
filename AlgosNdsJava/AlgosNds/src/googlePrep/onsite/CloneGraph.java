package googlePrep.onsite;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}

public class CloneGraph {
	Map<Integer, Node> adjMap;

	CloneGraph() {
		adjMap = new HashMap<>();
	}

	public Node cloneGraph(Node node) {

		Set<Integer> visited = new HashSet<>();
		Map<Integer, List<Integer>> map = new HashMap<>();

		Queue<Node> q = new ArrayDeque<>();

		q.add(node);

		while (!q.isEmpty()) {
			Node current = q.poll();
			if (visited.contains(current.val)) {
				continue;
			}
			visited.add(current.val);
			List<Integer> vals = map.getOrDefault(current.val, new ArrayList<>());
			for (Node neighbor : current.neighbors) {
				if (!visited.contains(neighbor.val)) {
					q.add(neighbor);
				}

				vals.add(neighbor.val);

			}

			map.put(current.val, vals);

		}

		buildGraph(map);

		return adjMap.values().iterator().next();
	}

	private void buildGraph(Map<Integer, List<Integer>> map) {

		for (int vertex : map.keySet()) {
			adjMap.put(vertex, new Node(vertex));
		}

		for (int vertex : map.keySet()) {
			Node n = adjMap.get(vertex);
			List<Integer> neighborVals = map.get(vertex);
			for (int val : neighborVals) {
				n.neighbors.add(adjMap.get(val));
			}

		}
	}

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);

		n3.neighbors = Arrays.asList(n1, n2);
		n2.neighbors = Arrays.asList(n1, n3);
		n1.neighbors = Arrays.asList(n2, n3);
		Node x = new CloneGraph().cloneGraph(n1);
		System.out.println(x.val);
		System.out.println(x.neighbors.get(1).val);
		// Map<Integer,Node> test = new HashMap<>();
		// Node x = new Node(1);
		// test.put(1, x);
		// x.neighbors = Arrays.asList(new Node(2));
		// System.out.println(test.get(1).neighbors.size());

	}
}

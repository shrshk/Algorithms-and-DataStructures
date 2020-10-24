package twilioPrep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Node {
	Queue<Node> neighbors;
	String val;

	Node(String val) {
		this.val = val;
		this.neighbors = new PriorityQueue<Node>((n1, n2) -> n1.val.compareTo(n2.val));
	}

	void addNeighbor(Node neighbor) {
		neighbors.add(neighbor);
	}
}

public class ReconstructItinerary {
	Map<String, Node> nodeMap;
	private static final String start = "JFK";

	ReconstructItinerary() {
		this.nodeMap = new HashMap<>();

	}

	public List<String> findItinerary(List<List<String>> tickets) {
		LinkedList<String> res = new LinkedList<>();
		for (List<String> ticket : tickets) {
			String src = ticket.get(0);
			String target = ticket.get(1);
			if (!nodeMap.containsKey(src)) {
				nodeMap.put(src, new Node(src));
			}

			if (!nodeMap.containsKey(target)) {
				nodeMap.put(target, new Node(target));
			}

			nodeMap.get(src).addNeighbor(nodeMap.get(target));
		}

		DFS(res, nodeMap.get(start));

		return res;
	}

	private void DFS(LinkedList<String> res, Node n) {

		while (!n.neighbors.isEmpty()) {
			Node neighbor = n.neighbors.poll();
			DFS(res, neighbor);
		}

		res.addFirst(n.val);

	}

	public static void main(String[] args) {
		List<List<String>> tickets = Arrays.asList(Arrays.asList("JFK", "KUL"), Arrays.asList("JFK", "NRT"),
				Arrays.asList("NRT", "JFK"));
		System.out.println(new ReconstructItinerary().findItinerary(tickets));

	}
}

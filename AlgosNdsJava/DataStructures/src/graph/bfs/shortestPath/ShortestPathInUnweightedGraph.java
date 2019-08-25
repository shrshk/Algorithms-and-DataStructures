package graph.bfs.shortestPath;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Node {
	int data;
	List<Node> outNodes;

	Node(int data) {
		this.data = data;
	}

	int getData() {
		return data;
	}

	void setOutNodes(List<Node> outNodes) {
		this.outNodes = outNodes;
	}

	List<Node> getOutNodes() {
		return outNodes;
	}

}

public class ShortestPathInUnweightedGraph {

	static List<Node> buildGraph() {
		Node zero = new Node(0);
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);

		zero.setOutNodes(Arrays.asList(three, one));
		one.setOutNodes(Arrays.asList(zero, two));
		two.setOutNodes(Arrays.asList(one));
		three.setOutNodes(Arrays.asList(zero, seven, four));
		seven.setOutNodes(Arrays.asList(six, four, three));
		four.setOutNodes(Arrays.asList(seven, six, three, five));
		five.setOutNodes(Arrays.asList(six, four));
		six.setOutNodes(Arrays.asList(seven, four, five));

		return Arrays.asList(zero, seven);
	}

	static List<Integer> getDirections(Node start, Node finish) {
		Map<Node, Boolean> visited = new HashMap<>();
		Map<Node, Node> currPrev = new HashMap<>();

		List<Integer> directions = new ArrayList<>();

		Queue<Node> q = new ArrayDeque<Node>();
		Node current = start;
		q.add(current);
		visited.put(current, true);
		
		while (!q.isEmpty()) {
			current = q.poll();
			if (current.equals(finish))
				break;
			else {
				for (Node outNode : current.getOutNodes()) {
					if (!visited.containsKey(outNode)) {
						q.add(outNode);
						visited.put(outNode, true);
						currPrev.put(outNode, current);
					}
				}
			}

		}

		if (current != null && (!current.equals(finish))) {
			System.out.println("No route found");
		}

		for(Node node = finish; node != null; node = currPrev.get(node)) {
	        directions.add(node.data);
	    }

		Collections.reverse(directions);

		return directions;
	}

	public static void main(String[] args) {
		Node start = buildGraph().get(0);
		Node finish = buildGraph().get(1);

		System.out.println(getDirections(start, finish).toString());
	}
}

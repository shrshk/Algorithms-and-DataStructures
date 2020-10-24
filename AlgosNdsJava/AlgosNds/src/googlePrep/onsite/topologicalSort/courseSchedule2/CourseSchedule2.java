package googlePrep.onsite.topologicalSort.courseSchedule2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum Visited {
	ACTIVE, NEW, DONE
}

class Node {
	int data;
	List<Node> adjNodes;
	Visited status;

	Node(int data) {
		this.data = data;
		this.adjNodes = new ArrayList<>();
		this.status = Visited.NEW;
	}

	void addDirectedNeighbor(Node n) {
		adjNodes.add(n);
	}
}

class Graph {
	Map<Integer, Node> map;
	List<Node> nodes;

	Graph() {
		map = new HashMap<>();
		nodes = new ArrayList<>();
	}

	public void addNode(int i) {
		Node node = new Node(i);
		nodes.add(node);
		map.put(i, node);
	}

	public void addEdge(int src, int dest) {
		Node n1 = map.get(src);
		Node n2 = map.get(dest);
		n1.adjNodes.add(n2);
	}

}

public class CourseSchedule2 {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		// numCourses = 2, prerequisites = [[1,0],[0,1]]
		// if cycle return false
		// if topSort size>numCourses return false
		// return true;
		Graph g = new Graph();
		for (int i = 0; i < numCourses; i++) {
			g.addNode(i);
		}

		for (int[] prereq : prerequisites) {
			g.addEdge(prereq[1], prereq[0]);
		}

		return topoSort(g);

	}

	private int[] topoSort(Graph g) {
		Node source = new Node(-1);
		for (Node n : g.nodes) {
			source.addDirectedNeighbor(n);
		}

		ArrayDeque<Node> result = new ArrayDeque<>();

		try {
			DFS(source, result);
		} catch (Exception e) {
			return new int[0];
		}
		result.removeFirst();
		return convertToArray(result);
	}

	private void DFS(Node n, ArrayDeque<Node> result) throws Exception {
		n.status = Visited.ACTIVE;
		for (Node node : n.adjNodes) {
			if (node.status == Visited.NEW) {
				DFS(node, result);
			} else if (node.status == Visited.ACTIVE) {
				throw new Exception("Graph is not Directed Acyclic");
			}
		}
		n.status = Visited.DONE;
		result.addFirst(n);
	}

	private int[] convertToArray(ArrayDeque<Node> deque) {
		int[] array = new int[deque.size()];
		int i = 0;
		while (!deque.isEmpty()) {
			array[i] = deque.removeFirst().data;
			i++;
		}
		return array;
	}

}

// private void DFS(Deque<Integer> topSort, Graph g, int vertex, Set<Integer>
// visited, Set<Integer> recStack,
// Set<Integer> cycle) {
//
// List<Integer> neighbors = g.adjMap.get(vertex);
//
//// if (recStack.contains(vertex)) {
//// cycle.add(vertex);
//// return;
//// }
//
// if (neighbors == null) {
// topSort.offerFirst(vertex);
// visited.add(vertex);
// recStack.add(vertex);
// return;
// }
// recStack.add(vertex);
// visited.add(vertex);
//
// for (int neighbor : neighbors) {
// DFS(topSort, g, neighbor, visited, recStack, cycle);
// }
// topSort.offerFirst(vertex);
// }
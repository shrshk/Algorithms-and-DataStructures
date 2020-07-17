package googlePrep.onsite.topologicalSort;

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

public class CourseSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
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

	private boolean topoSort(Graph g) {
		Node source = new Node(-1);
		for (Node n : g.nodes) {
			source.addDirectedNeighbor(n);
		}

		try {
			DFS(source);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private void DFS(Node n) throws Exception {
		n.status = Visited.ACTIVE;
		for (Node node : n.adjNodes) {
			if (node.status == Visited.NEW) {
				DFS(node);
			} else if (node.status == Visited.ACTIVE) {
				throw new Exception("Graph is not Directed Acyclic");
			}
		}
		n.status = Visited.DONE;
	}

	public static void main(String[] args) {
		int[][] prerequisites = new int[][] { { 0, 1 }, { 0, 2 }, { 1, 2 } };
		System.out.println(new CourseSchedule().canFinish(3, prerequisites));
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
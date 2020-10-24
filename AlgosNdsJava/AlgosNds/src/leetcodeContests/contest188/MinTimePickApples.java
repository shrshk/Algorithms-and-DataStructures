package leetcodeContests.contest188;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum Status {
	NotVisited, Visited
}

class Node {
	int data;
	List<Node> children;
	Status status;
	boolean hasApple;

	Node(int data, boolean hasApple) {
		this.data = data;
		this.status = Status.NotVisited;
		this.children = new ArrayList<>();
		this.hasApple = hasApple;
	}
}

class Tree {
	Map<Integer, Node> nodeMap;
	
	Tree() {
		nodeMap = new HashMap<>();
	}

	void addNode(int key, boolean hasApple) {
		nodeMap.put(key, new Node(key, hasApple));
	}

	void addEdge(int source, int dest) {
		Node sourceNode = nodeMap.get(source);
		Node destNode = nodeMap.get(dest);
		sourceNode.children.add(destNode);
		destNode.children.add(sourceNode);
	}

}

public class MinTimePickApples {
	public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
		Tree tree = new Tree();
		for (int i = 0; i < n; i++) {
			tree.addNode(i, hasApple.get(i));
		}

		for (int[] edge : edges) {
			tree.addEdge(edge[0], edge[1]);
			tree.addEdge(edge[1], edge[0]);
		}

		return DFS(tree.nodeMap.get(0));
	}

	private int DFS(Node node) {
		node.status = Status.Visited;
		int res = 0;

		for (Node curr : node.children) {
			if (curr.status == Status.Visited)
				continue;
			res += DFS(curr);
		}

		if ((res > 0 || node.hasApple) && node.data != 0)
			res += 2;

		return res;
	}

	public static void main(String[] args) {
		int n = 4;
		int[][] edges = new int[][] { { 0, 2 }, { 0, 3 }, { 1, 2 } };
		List<Boolean> hasApple = Arrays.asList(false, true, false, false);
		System.out.println(new MinTimePickApples().minTime(n, edges, hasApple));
	}

}

package leetcode30DayChallenge.may;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

enum Color {
	Red, Green, Null
}

class Node {
	int val;
	Color color;
	List<Node> neighbors;

	Node(int val) {
		this.val = val;
		this.color = Color.Null;
		this.neighbors = new ArrayList<>();
	}

	void addNeighbor(Node neighbor) {
		this.neighbors.add(neighbor);
	}

}

public class PossibleBipartition {
	Map<Integer, Node> adjMap;

	PossibleBipartition() {
		adjMap = new HashMap<>();
	}

	public boolean possibleBipartition(int N, int[][] dislikes) {
		// N = 4, dislikes = [[1,2],[1,3],[2,4]]

		// steps
		// define colors
		// keep coloring the graph and check if child doesn't have same color as
		// parent

		for (int i = 1; i <= N; i++) {
			adjMap.put(i, new Node(i));
		}

		for (int i = 0; i < dislikes.length; i++) {
			int src = dislikes[i][0];
			int target = dislikes[i][1];
			adjMap.get(src).addNeighbor(adjMap.get(target));
			adjMap.get(target).addNeighbor(adjMap.get(src));
		}

		return bfs(N);
	}

	private boolean bfs(int N) {

		for (int idx = 1; idx <= N; idx++) {
			Node n = adjMap.get(idx);
			if (n.color != Color.Null)
				continue;
			n.color = Color.Red;
			Queue<Node> q = new ArrayDeque<>();
			q.add(n);

			while (!q.isEmpty()) {
				Node curr = q.poll();

				for (Node neighbor : curr.neighbors) {
					if (curr.color == neighbor.color)
						return false;
					if (neighbor.color == Color.Null) {
						neighbor.color = curr.color == Color.Red ? Color.Green : Color.Red;
						q.add(neighbor);
					}

				}

			}
		}

		return true;

	}

	public static void main(String[] args) {
		int[][] dislikes = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 1, 5 } }; // [[1,2],[1,3],[2,4]]
																								// [[1,2],[2,3],[3,4],[4,5],[1,5]]
		System.out.println(new PossibleBipartition().possibleBipartition(5, dislikes));
	}
}

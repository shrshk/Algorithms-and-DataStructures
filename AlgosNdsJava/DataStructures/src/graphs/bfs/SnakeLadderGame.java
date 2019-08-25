package graphs.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class EdgeS {
	int src;
	int dest;

	EdgeS(int src, int dest) {
		this.src = src;
		this.dest = dest;
	}
}

class GraphS {
	List<List<Integer>> adjList = new ArrayList<>();

	GraphS(List<EdgeS> edges) {
		for (int i = 0; i < edges.size(); i++) {
			adjList.add(i, new ArrayList<>());
		}
		// add edges to the graph
		for (int i = 0; i < edges.size(); i++) {
			int src = edges.get(i).src;
			int dest = edges.get(i).dest;

			// Please note that directed is directed
			adjList.get(src).add(dest);
		}
	}
}

class Node {
	int ver;
	int minDist; // store min dist from starting vertex bcoz the goal is to find
					// shortest path to destination.

	Node(int ver, int minDist) {
		this.ver = ver;
		this.minDist = minDist;
	}
}

public class SnakeLadderGame {

	public static void BFS(GraphS graph, int source, int N) {
		//
		Queue<Node> q = new ArrayDeque<>();

		boolean[] discovered = new boolean[N + 1];

		discovered[source] = true;
		Node node = new Node(source, 0);

		q.add(node);

		while (!q.isEmpty()) {
			node = q.poll();
			if (node.ver == N) {
				System.out.println("Done" + node.minDist);
				break;
			}
			for (int u : graph.adjList.get(node.ver)) {
				if (!discovered[u]) {
					discovered[u] = true;
					q.add(new Node(u, node.minDist + 1));
				}
			}

		}

	}

	public static void findSolution(Map<Integer, Integer> ladder, Map<Integer, Integer> snake) {
		int N = 10 * 10;
		List<EdgeS> edges = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= 6 && i + j <= N; j++) {
				int _ladder = (ladder.get(i + j) != null) ? ladder.get(i + j) : 0;
				int _snake = (snake.get(i + j) != null) ? snake.get(i + j) : 0;

				if (_ladder != 0 || _snake != 0)
					edges.add(new EdgeS(i, _ladder + _snake));
				else
					edges.add(new EdgeS(i, i + j));

			}
		}

		GraphS g = new GraphS(edges);

		// find shortest path btwn 1 and 100

		BFS(g, 0, N);

	}

	public static void main(String[] args) {
		Map<Integer, Integer> ladder = new HashMap<>();
		Map<Integer, Integer> snake = new HashMap<>();

		// insert ladders into the map
		ladder.put(1, 38);
		ladder.put(4, 14);
		ladder.put(9, 31);
		ladder.put(21, 42);
		ladder.put(28, 84);
		ladder.put(51, 67);
		ladder.put(72, 91);
		ladder.put(80, 99);

		// insert snakes into the map
		snake.put(17, 7);
		snake.put(54, 34);
		snake.put(62, 19);
		snake.put(64, 60);
		snake.put(87, 36);
		snake.put(93, 73);
		snake.put(95, 75);
		snake.put(98, 79);

		findSolution(ladder, snake);
	}
}

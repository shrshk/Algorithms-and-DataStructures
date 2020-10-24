package leetcode30DayChallenge.september.evaluateEquations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Neighbor {
	Node node;
	double cost;

	Neighbor(Node node, double cost) {
		this.node = node;
		this.cost = cost;
	}

}

class Node {
	String name;
	List<Neighbor> neighbors;

	Node(String name) {
		this.name = name;
		this.neighbors = new ArrayList<>();
	}

	void addEdge(Node target, double cost) {
		this.neighbors.add(new Neighbor(target, cost));
	}
}

class Graph {
	Map<String, Node> adjMap;

	Graph() {
		adjMap = new HashMap<>();
	}
}

public class EvaluateDivisionNW {
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

		int len = equations.size();
		Graph g = new Graph();

		for (int i = 0; i < len; i++) {
			List<String> eq = equations.get(i);
			String src = eq.get(0);
			String target = eq.get(1);
			double val = values[i];
			g.adjMap.putIfAbsent(src, new Node(src));
			g.adjMap.putIfAbsent(target, new Node(target));
			Node srcNode = g.adjMap.get(src);
			Node targetNode = g.adjMap.get(target);
			srcNode.addEdge(targetNode, val);
			targetNode.addEdge(srcNode, 1 / val);
		}

		double[] res = new double[queries.size()];

		for (int i = 0; i < queries.size(); i++) {
			List<String> query = queries.get(i);
			Node start = g.adjMap.get(query.get(0));
			Node end = g.adjMap.get(query.get(1));
            res[i] = DFS(g, queries.get(i), start, end, 1.0, new HashSet<>());
		}


		return res;
	}

	private Double DFS(Graph g, List<String> query, Node start, Node end, double res, Set<String> seen) {
		if (start == null || !seen.add(start.name))
			return -1.0;
		if (start.name.equals(end.name))
			return res;
		for (Neighbor neighbor: start.neighbors) {
			double result = DFS(g, query, neighbor.node, end, res*neighbor.cost, seen);
			if (result==-1.0)
				continue;
			return result;
		}
		
		return -1.0;
	}
}

// private Double BFS(Graph g, List<String> query) {
// Queue<Node> q = new ArrayDeque<>();
// Node start = g.adjMap.get(query.get(0));
// Node end = g.adjMap.get(query.get(1));
// double res = 1.0;
// q.add(start);
// while(!q.isEmpty()) {
// Node curr = q.poll();
// if (curr.name.equals(end.name))
// return res;
// if (curr.status == Status.VISITED)
// continue;
// curr.status = Status.VISITED;
// for (Neighbor neighbor: curr.neighbors) {
// Node node = neighbor.node;
//
// }
// }
//
// return null;
// }

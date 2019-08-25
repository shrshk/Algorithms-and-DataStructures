package graphs.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class Edge {
	int src;
	int dest;
	Edge(int src, int dest) {
		this.src = src;
		this.dest = dest;
	}
}

class Graph {
	Map<Integer,List<Integer>> adjMap = new HashMap<>();
	Graph(List<Edge> edges) {
		for (Edge e : edges) {
			if (!adjMap.containsKey(e.src)) {
				List<Integer> adjList = new ArrayList<>();
				adjList.add(e.dest);
				adjMap.put(e.src, adjList);
			} else {
				List<Integer> adjList = adjMap.get(e.src);
				adjList.add(e.dest);
				adjMap.put(e.src, adjList);
			}
			
		}
		
	}
}

public class DFS {
	
	static void dfsTraversal (int vertex, Graph g, Map<Integer, Boolean> discovered) {
		// when a new node is discovered push the current node into stack to explore later
		Stack<Integer> stack = new Stack<>();
		int start = vertex;
		stack.push(start);
		while(!stack.isEmpty()) {
			start = stack.pop();
			if (discovered.get(start))
				continue;
			discovered.put(start, true);
			System.out.println(start);
			List<Integer> adjList = g.adjMap.get(start);
			if (adjList!=null) {
				for (Integer i: adjList) {
					if (!discovered.get(i)) {
						stack.push(i);
					}					
				}
			}
		}
	}
	
	static void dfsRecursive (int vertex, Graph g, Map<Integer, Boolean> discovered) {
		discovered.put(vertex, true);
		System.out.println(vertex);
		List<Integer> adjList = g.adjMap.get(vertex);
		if (adjList!=null) {
			for (Integer u: adjList) {
				if (!discovered.get(u)) {
					dfsRecursive(u, g, discovered);
				}
			}
		}

	}
	
	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList(
				// Notice that node 0 is unconnected node
				new Edge(1, 2), new Edge(1, 7), new Edge(1, 8),
				new Edge(2, 3), new Edge(2, 6), new Edge(3, 4),
				new Edge(3, 5), new Edge(8, 9), new Edge(8, 12),
				new Edge(9, 10), new Edge(9, 11)
				// , new Edge(6, 9) // introduce cycle
		);
		
		List<Integer> vertices = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
		
		Graph graph = new Graph(edges);
		
		Map<Integer, Boolean> discovered = new HashMap<>();
		for (Integer v : vertices) {
			discovered.put(v, false);
		}
		
		for (Integer v : vertices) {
			if (!discovered.get(v)) {
				dfsRecursive(v, graph, discovered);
				//dfsTraversal(v, graph, discovered);
			}
				
		}		
		
	}

}

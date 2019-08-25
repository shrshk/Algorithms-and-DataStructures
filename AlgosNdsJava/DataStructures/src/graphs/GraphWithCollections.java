package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Edge {
	int src, dest;
	Edge(int src, int dest) {
		this.src = src;
		this.dest = dest;
	}
}
public class GraphWithCollections {
	List<List<Integer>> adjList = new ArrayList<>();
	GraphWithCollections(List<Edge> edges) {
		for (int i=0; i<edges.size(); i++) {
			adjList.add(i, new ArrayList<>());
		}
		for (Edge e: edges) {
			adjList.get(e.src).add(e.dest);
		}	
		
	}
	
	static void printGraph(GraphWithCollections graph) {
		// System.out.println(Arrays.deepToString(graph.adjList));
		int n = graph.adjList.size();
		int i = 0;
		while (i < n) {
			for (int x : graph.adjList.get(i)) {
				System.out.println(i + " " + x );				
			}
			i++;
		}
	}
	
	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList(new Edge(0,1), new Edge(1,2), new Edge(2,0), new Edge(2,1), new Edge(3,2),new Edge(4,5), 
				new Edge(5,4));
		GraphWithCollections graph = new GraphWithCollections(edges);
		printGraph(graph);
	}

}

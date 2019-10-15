package amazonPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Graph {
	Map<Integer, List<Integer>> adjMap = new HashMap<>();
	Graph(List<Edge> edges) {
		for (Edge edge: edges) {
			if (!adjMap.containsKey(edge.src)) {
				adjMap.put(edge.src, new ArrayList<>(Arrays.asList(edge.dest)));
			}else {				
				List<Integer> edgeList = adjMap.get(edge.src);
				edgeList.add(edge.dest);
				adjMap.put(edge.src, edgeList);
			}
		}
	}	
}

class Edge {
	int src;
	int dest;
	Edge(int src, int dest){
		this.src = src;
		this.dest = dest;
	}
}

public class BridgesInGraph {
	static int time = 0;
	static Graph g;
	
    static void bridge(Graph g) {
    	// initialize datastructures needed for the algo.
    	Map<Integer, Boolean> visited = new HashMap<>(); // keep track of vertices visited by DFS
    	Map<Integer, Integer> discoveryTime = new HashMap<>(); // keep track of discovery times
    	Map<Integer, Integer> lowestDiscoveryTime = new HashMap<>(); // keep track of lowest discovery times
    	Map<Integer, Integer> parentChild = new HashMap<>(); // keep track of parent child relationship of vertices
    	
    	// initialize parent and visited
    	
    	for (Integer vertex: g.adjMap.keySet()) {
    		visited.put(vertex, false);
    		parentChild.put(vertex, -1);
    	}
    	
    	for (Integer vertex: g.adjMap.keySet()) {
    		if (!visited.get(vertex)) {
    			bridgeUtil(vertex, visited, discoveryTime, lowestDiscoveryTime, parentChild);
    		}
    	}
    	
    }
    
    static void bridgeUtil(Integer u, Map<Integer, Boolean> visited, 
    		Map<Integer, Integer> discoveryTime, 
    		Map<Integer, Integer> lowestDiscoveryTime, 
    		Map<Integer, Integer> parentChild) {
    	visited.put(u, true);
    	discoveryTime.put(u, time +1);
    	lowestDiscoveryTime.put(u, time+1);
    	++time;
    	for (Integer v: g.adjMap.get(u)) {
    		if (!visited.get(v)) {
    			parentChild.put(v, u);
    			bridgeUtil(v, visited, discoveryTime, lowestDiscoveryTime, parentChild);
    			lowestDiscoveryTime.put(u, Math.min(lowestDiscoveryTime.get(u), lowestDiscoveryTime.get(v)));
    			if (lowestDiscoveryTime.get(v)>=discoveryTime.get(u))
    				System.out.println(u + " " + v);
    		}else if (v!=parentChild.get(u))   { 
    			// 3 is not the parent of 6 but can be reached with an edge hence update low of 6 with disc. time of 3(
    			//if it's then than 6's lowest discovery time
    			lowestDiscoveryTime.put(u, Math.min(lowestDiscoveryTime.get(u), discoveryTime.get(v)));
    		}
    			
    	}
    	
    }
	
	public static void main(String[] args) {
		// steps 
		// build Graph
		// call bridge method on it
		// bridge calls recursive bridgeUtil for each unvisited vertex.		
		
		// build graph
		List<Edge> edges = new ArrayList<>(Arrays.asList(new Edge(1,4),
				new Edge(1,2),
				new Edge(4,3),
				new Edge(2,3),
				new Edge(3,5),
				new Edge(3,6),
				new Edge(5,6),
				new Edge(4,1),
				new Edge(2,1),
				new Edge(3,4),
				new Edge(3,2),
				new Edge(5,3),
				new Edge(6,3),
				new Edge(6,5)));				
		
		g = new Graph(edges);
		System.out.println(g.adjMap.toString());
		// bridge method inputs
		bridge(g);
		
		
	}
}

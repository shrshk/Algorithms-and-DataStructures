package googlePrep.onsite.cloneGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

//class NodeG {
//	int val;
//	List<Node> neighbors;
//	NodeG(int val) {
//		this.val = val;
//		this.neighbors = new ArrayList<>();
//	}
//}

public class CloneGraph {
	// val, Node
	// List<Integer> vals;
	// use vals to build new graph
	
	Map<Integer, Node> map;
	List<Integer> list;
	
	CloneGraph() {
		map = new HashMap<>();
		list = new ArrayList<>();
	}
	
    public Node cloneGraph(Node node) {
    	// 1 [2,3]
        // [12]
    	Set<Integer> visited = new HashSet<>();
    	Queue<Node> q = new ArrayDeque<>();
    	
    	q.add(node);
    	
    	while(!q.isEmpty()) {
    		Node current = q.poll();
    		updateGraph(current);
    		visited.add(current.val);
    		for (Node neighbor: current.neighbors) {
    			if (visited.contains(neighbor.val))
    				continue;
    			q.add(neighbor);
    		}
    	}
    	
    	return buildClone();
    }
    
    private void updateGraph(Node node) {
    	list.add(node.val);
    	Node newNode = map.getOrDefault(node.val, new Node(node.val));
    	for (Node neighbor: node.neighbors) {
    		List<Node> neighbs = newNode.neighbors.stream().filter(x->x.val==neighbor.val).collect(Collectors.toList());
    		if (neighbs.isEmpty())
    			newNode.neighbors.add(new Node(neighbor.val));
    	}
    	map.put(node.val, newNode);
    }
    
    private Node buildClone() {
    	Collections.sort(list);
    	
    	for (int val: list) {
    		
    	}
    	
    	return new Node();
    }
	
}

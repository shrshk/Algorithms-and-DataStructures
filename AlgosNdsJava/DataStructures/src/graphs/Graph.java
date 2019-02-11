package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	private Integer numOfNodes=0;	
	private Map<Integer, List<Integer>> adjacencyList=new HashMap<Integer, List<Integer>>();
	
	public Integer getNumOfNodes() {
		return numOfNodes;
	}
	public void setNumOfNodes(Integer numOfNodes) {
		this.numOfNodes = numOfNodes;
	}
	public Map<Integer, List<Integer>> getAdjacencyList() {
		return adjacencyList;
	}
	public void setAdjacencyList(Map<Integer, List<Integer>> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}
	
	public void addVertex(Integer data) {
		this.adjacencyList.put(data, new ArrayList<Integer>());
		this.numOfNodes++;
	}
	
	public void addEdge(Integer data1, Integer data2) {
		this.adjacencyList.get(data1).add(data2);
		this.adjacencyList.get(data2).add(data1);
	}
	
	public void showConnections() {
		List<Integer> allNodes = new ArrayList<Integer>(this.adjacencyList.keySet());
		for (Integer node: allNodes) {
			List<Integer> nodeConnections = this.adjacencyList.get(node);
			String connections = "";
			for (Integer vertex: nodeConnections) {
				connections+=vertex+" ";
			}
			System.out.println(node + "-->" + connections);
		}
	}
	
	public static void main(String[] args) {
		Graph myGraph = new Graph();
		myGraph.addVertex(0);
		myGraph.addVertex(1);
		myGraph.addVertex(2);
		myGraph.addVertex(3);
		myGraph.addVertex(4);
		myGraph.addVertex(5);
		myGraph.addVertex(6);
		myGraph.addEdge(3, 1); 
		myGraph.addEdge(3, 4); 
		myGraph.addEdge(4, 2); 
		myGraph.addEdge(4, 5); 
		myGraph.addEdge(1, 2); 
		myGraph.addEdge(1, 0); 
		myGraph.addEdge(0, 2); 
		myGraph.addEdge(6, 5);

		myGraph.showConnections(); 
	}

}
/*
 * class Graph { 
  constructor() { 
    this.numberOfNodes = 0;
    this.adjacentList = {
    }; 
  } 
  addVertex(node)  { 
    this.adjacentList[node] = [];
    this.numberOfNodes++;    
  } 
  addEdge(node1, node2) { 
    //undirected Graph 
    this.adjacentList[node1].push(node2);
    this.adjacentList[node2].push(node1);
  } 
  showConnections() { 
    const allNodes = Object.keys(this.adjacentList); 
    for (let node of allNodes) { 
      let nodeConnections = this.adjacentList[node]; 
      let connections = ""; 
      let vertex;
      for (vertex of nodeConnections) {
        connections += vertex + " ";
      } 
      console.log(node + "-->" + connections); 
    } 
} 
} 

const myGraph = new Graph();
myGraph.addVertex('0');
myGraph.addVertex('1');
myGraph.addVertex('2');
myGraph.addVertex('3');
myGraph.addVertex('4');
myGraph.addVertex('5');
myGraph.addVertex('6');
myGraph.addEdge('3', '1'); 
myGraph.addEdge('3', '4'); 
myGraph.addEdge('4', '2'); 
myGraph.addEdge('4', '5'); 
myGraph.addEdge('1', '2'); 
myGraph.addEdge('1', '0'); 
myGraph.addEdge('0', '2'); 
myGraph.addEdge('6', '5');

myGraph.showConnections(); 
//Answer:
// 0-->1 2 
// 1-->3 2 0 
// 2-->4 1 0 
// 3-->1 4 
// 4-->3 2 5 
// 5-->4 6 
// 6-->5*/
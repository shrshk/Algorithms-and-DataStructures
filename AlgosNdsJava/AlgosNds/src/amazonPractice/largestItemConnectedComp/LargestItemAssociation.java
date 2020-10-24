package amazonPractice.largestItemConnectedComp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PairString {
	String first;
	String second;

	public PairString(String first, String second) {
		this.first = first;
		this.second = second;
	}
}

class Node {
	String name;
	List<Node> neighbors;

	Node(String name) {
		this.name = name;
		this.neighbors = new ArrayList<>();
	}
}

class Graph {
	Map<String, Node> adjMap;

	Graph() {
		adjMap = new HashMap<>();
	}

	void addLink(PairString pair) {
		String first = pair.first;
		String second = pair.second;
		if (!adjMap.containsKey(first)) {
			adjMap.put(first, new Node(first));
		}
		if (!adjMap.containsKey(second)) {
			adjMap.put(second, new Node(second));
		}
		Node start = adjMap.get(first);
		Node end = adjMap.get(second);
		start.neighbors.add(end);
	}

}

public class LargestItemAssociation {
	List<String> ans;

	public List<String> largestItemAssociation(List<PairString> itemAssociation) {
		// write your code here
		// build graph
		// loop and find largest conn. comp.
		ans = new ArrayList<>();
		Graph g = new Graph();

		for (PairString pairString : itemAssociation) {
			g.addLink(pairString);
		}

		for (String key : g.adjMap.keySet()) {
			List<String> tmpList = new ArrayList<>();
			tmpList.add(key);
			dfs(g.adjMap.get(key), tmpList);
			if (tmpList.size() > ans.size())
				ans = new ArrayList<>(tmpList);
			else if (tmpList.size() == ans.size()) {
				sortLex(tmpList);
			}

		}

		return ans;
	}

	private void dfs(Node n, List<String> tmpList) {
		for (Node neighbor : n.neighbors) {
			tmpList.add(neighbor.name);
			dfs(neighbor, tmpList);
		}
	}

	private void sortLex(List<String> tmpList) {
		Collections.sort(tmpList);
		Collections.sort(ans);

		int len = tmpList.size();

		for (int i = 0; i < len; i++) {
			String item1 = tmpList.get(i);
			String item2 = ans.get(i);
			int compare = item1.compareTo(item2);
			if (compare == 0)
				continue;
			if (compare < 0) {
				ans = new ArrayList<>(tmpList);
			}

			return;
		}

	}

	public static void main(String[] args) {
		PairString p1 = new PairString("item1", "item2");
		PairString p2 = new PairString("item3", "item4");
		PairString p3 = new PairString("item5", "item6");

		System.out.println(new LargestItemAssociation().largestItemAssociation(Arrays.asList(p1, p2, p3)));
	}
}

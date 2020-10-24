package amazonPractice.packageInstaller;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

enum Status {
	ACTIVE, VISITED, NEW
}

class Node {
	int val;
	Set<Node> neighbors;
	Status status;

	Node(int val) {
		this.val = val;
		this.neighbors = new HashSet<>();
		this.status = Status.NEW;
	}
}

public class PackageInstaller {

	public List<Integer> packageOrder(Map<Integer, List<Integer>> dependencies) {
		Map<Integer, Node> adjMap = new HashMap<>();
		for (Integer dependency : dependencies.keySet()) {
			Node n = adjMap.getOrDefault(dependency, new Node(dependency));
			List<Integer> list = dependencies.get(dependency);
			for (Integer val : list) {
				Node neighbor = adjMap.getOrDefault(val, adjMap.get(val));
				n.neighbors.add(neighbor);
			}
			adjMap.put(dependency, n);
		}

		return topSort(adjMap);
	}

	private List<Integer> topSort(Map<Integer, Node> adjMap) {
		List<Integer> res = new ArrayList<>();

		Node src = new Node(-1);
		for (Node n : adjMap.values()) {
			src.neighbors.add(n);
		}

		Deque<Integer> order = new ArrayDeque<>();

		try {
			DFS(src, order);
		} catch (Exception e) {
			return new ArrayList<>();
		}

		order.removeFirst();

		while (!order.isEmpty())
			res.add(order.pollLast());

		return res;
	}

	private void DFS(Node n, Deque<Integer> order) {
		n.status = Status.ACTIVE;
		for (Node node : n.neighbors) {
			if (node.status == Status.NEW) {
				DFS(node, order);
			} else if (node.status == Status.ACTIVE) {
				throw new RuntimeException("Cyclic dependency found");
			}
		}

		n.status = Status.VISITED;
		order.addFirst(n.val);
	}

	public static void main(String[] args) {
		Map<Integer, List<Integer>> dependencies = new HashMap<>();
		dependencies.put(0, new ArrayList<>());
		dependencies.put(1, Arrays.asList(0));
		dependencies.put(2, Arrays.asList(1));
		dependencies.put(3, Arrays.asList(1, 2));
		dependencies.put(4, Arrays.asList(3));
		System.out.println(new PackageInstaller().packageOrder(dependencies));
	}
}

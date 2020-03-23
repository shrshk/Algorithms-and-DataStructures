package leetcodeContests.contest179;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class Node {
	int id;
	Set<Node> nextNodes;
	int informTime;

	Node(int id, int informTime) {
		this.id = id;
		this.informTime = informTime;
	}
}

public class TimeNeededToInformEmployees {
	List<Node> treeNodes;
	int time;

	private void buildTreeNodes(int n, int headID, int[] manager, int[] informTime) {
		treeNodes = new ArrayList<>();
		Node root = new Node(headID, informTime[headID]);
		treeNodes.add(root);
		for (int i = 0; i < n; i++) {
			if (i != headID) {
				treeNodes.add(new Node(i, informTime[i]));
			}
		}

		for (Node node : treeNodes) {
			int id = node.id;
			Set<Node> nextNodes = new HashSet<>();
			for (int i = 0; i < manager.length; i++) {
				if (manager[i] == id) {
					nextNodes.add(treeNodes.get(i));
				}
			}
			if (!nextNodes.isEmpty())
				node.nextNodes = nextNodes;
		}

	}

	private void bfs() {
		// steps
		// loop thru add up time
		Queue<Node> q = new ArrayDeque<>();
		q.add(treeNodes.get(0));
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node curr = q.poll();
				time += curr.informTime;
				Set<Node> nextNodes = curr.nextNodes;
				if (nextNodes == null || curr.id == treeNodes.get(0).id)
					continue;
				for (Node node : nextNodes) {
					q.add(node);
				}
			}
		}

	}

	public int numOfMinutesNW(int n, int headID, int[] manager, int[] informTime) {
		buildTreeNodes(n, headID, manager, informTime);
		bfs();
		return time;
	}

	public int numOfMinutesCopied(int n, int headID, int[] manager, int[] informTime) {
		List<Integer>[] graph = new List[n];
		for (int i = 0; i < n; i++)
			graph[i] = new ArrayList<>();
		for (int i = 0; i < n; i++)
			if (manager[i] != -1)
				graph[manager[i]].add(i);
		Queue<int[]> q = new LinkedList<>(); // Since it's a tree, we don't need
												// `visited` array
		q.offer(new int[] { headID, 0 });
		int ans = 0;
		while (!q.isEmpty()) {
			int[] top = q.poll();
			int u = top[0], w = top[1];
			ans = Math.max(w, ans);
			for (int v : graph[u])
				q.offer(new int[] { v, w + informTime[u] });
		}
		return ans;
	}

	public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (manager[i] != -1) {
				List<Integer> nodes = map.getOrDefault(manager[i], new ArrayList<>());
				nodes.add(i);
				map.put(manager[i], nodes);
			}
		}

		Queue<int[]> q = new ArrayDeque<>();

		q.offer(new int[] { headID, 0 });

		// loop thru all nodes and update maxTime.
		int res = 0;
		while (!q.isEmpty()) {
			int[] node = q.poll();
			int id = node[0];
			int time = node[1];
			res = Math.max(res, time);
			if (map.get(id) == null)
				continue;
			for (int i : map.get(id)) {
				q.offer(new int[] { i, informTime[id] + time });
			}
		}

		return res;
	}

	public static void main(String[] args) {
		// n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime =
		// [0,0,1,0,0,0]
		int n = 6, headID = 2;
		int[] manager = new int[] { 2, 2, -1, 2, 2, 2 }, informTime = new int[] { 0, 0, 1, 0, 0, 0 };
		System.out.println(new TimeNeededToInformEmployees().numOfMinutes(n, headID, manager, informTime));
	}
}

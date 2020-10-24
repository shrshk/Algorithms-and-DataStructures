package leetcodeContests.contest208;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Node {
	String parent;
	String name;
	List<Node> children;

	Node(String parent, String name) {
		this.parent = parent;
		this.name = name;
		this.children = new ArrayList<>();
	}
}

public class CrawlLogFolder {
	public int minOperations(String[] logs) {
		Map<String, Node> graph = new HashMap<>();
		graph.put("main", new Node(null, "main"));
		Node curr = graph.get("main");
		// ["d1/","d2/","../","d21/","./"]
		for (String log : logs) {
			if (log.equals("../")) {
				if (!curr.name.equals("main")) {
					curr = graph.get(curr.parent);
				}
				continue;
			}

			if (log.equals("./"))
				continue;

			Node child = new Node(curr.name, log);

			graph.put(log, child);

			curr.children.add(child);

			curr = child;
		}

		return BFS(graph, graph.get("main"), curr);
	}

	private int BFS(Map<String, Node> graph, Node begin, Node end) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(begin);

		int dist = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node curr = q.poll();
				if (curr.name == end.name) {
					return dist;
				}
				for (Node child : curr.children) {
					q.add(child);
				}
			}
			dist++;
		}

		return 0;
	}
	
	public static void main(String[] args) {
		String[] logs = new String[]{"d1/","../","../","../"};
		System.out.println(new CrawlLogFolder().minOperations(logs));
	}
}

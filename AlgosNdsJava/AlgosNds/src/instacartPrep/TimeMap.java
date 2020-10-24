package instacartPrep;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Node {
	String value;
	int timestamp;

	Node(String value, int timestamp) {
		this.value = value;
		this.timestamp = timestamp;
	}

}

public class TimeMap {
	Map<String, PriorityQueue<Node>> map;

	TimeMap() {
		map = new HashMap<>();
	}

	public String get(String key) {
		if (!map.containsKey(key)) {
			return "";
		}
		PriorityQueue<Node> pq = map.get(key);
		Node n = pq.peek();
		return n.value;
	}

	public String get(String key, long timestamp) {
		if (!map.containsKey(key)) {
			return "";
		}
		Queue<Node> pq = map.get(key);

		for (Node n : pq) {
			if (n.timestamp == timestamp) { // 122
				return n.value;
			}
		}

		return "";
	}

	public int set(String key, String value) {
		int timestamp = (int) Instant.now().toEpochMilli();
		PriorityQueue<Node> pq;
		if (!map.containsKey(key)) {
			pq = new PriorityQueue<Node>((n1, n2) -> (n2.timestamp - n1.timestamp));
			Node newNode = new Node(value, timestamp);
			pq.add(newNode);
			map.put(key, pq);
		} else {
			pq = map.get(key);
			pq.add(new Node(value, timestamp));
			map.put(key, pq);
		}

		return timestamp;
	}

	public static void main(String args[]) throws Exception {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT
		 */

		// {'s': [{val, tim1}, {val, tim2}]}
		// timeStamp

		// Map<String, Priorityq

		// String : [t1,t2,t3]
		// Map<t: [1,2,]>
		TimeMap s = new TimeMap();
		int timestamp = s.set("foo", "bar");

		System.out.println(s.get("foo"));
		System.out.println(s.get("foo", timestamp));

	}
}
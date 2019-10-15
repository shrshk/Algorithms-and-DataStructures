package amazonPractice;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ConnectNRopes {
	static int connectNRopes(List<Integer> input) {
		int minCost = 0;
		Queue<Integer> q = new PriorityQueue<>(input);

		while (q.size() > 1) {
			int item1 = q.poll();
			int item2 = q.poll();
			minCost = minCost + item1 + item2;
			q.add(item1 + item2);
		}

		return minCost;
	}

	public static void main(String[] args) {
		System.out.println(connectNRopes(Arrays.asList(4, 3, 2, 6, 7)));
	}
}

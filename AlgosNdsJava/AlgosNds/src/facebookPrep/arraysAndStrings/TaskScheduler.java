package facebookPrep.arraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
		// steps
		// build a map of task and count
		// add map entries to max.heap pq to poll entries based on max.freq.
		// run a loop for every interval = n+1;
		// dec. interval ass tasks are being done and inc. cnt of intervals.
		// if a swipe of tasks is done i.e q is empty and interval>0 count
		// remaining interval as idle time.
		// return cnt

		if (tasks == null || tasks.length == 0)
			return -1;

		Map<Character, Integer> taskMap = new HashMap<>();

		for (char c : tasks) {
			taskMap.put(c, taskMap.getOrDefault(c, 0) + 1);
		}

		Queue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
		pq.addAll(taskMap.entrySet());
		int count = 0;

		while (!pq.isEmpty()) {
			int interval = n + 1;
			// keep track of entries as we poll from the pq to add them back to
			// the pq.
			List<Map.Entry<Character, Integer>> list = new ArrayList<>();

			while (interval > 0 && !pq.isEmpty()) {
				Map.Entry<Character, Integer> task = pq.poll();
				task.setValue(task.getValue() - 1);
				list.add(task);
				interval--;
				count++;
			}

			for (Map.Entry<Character, Integer> task : list) {
				if (task.getValue() > 0)
					pq.add(task);
			}

			if (pq.isEmpty())
				break;

			count += interval;

		}

		return count;
	}

	// ["A","A","A","B","B"]
	// pq 0 3 6 0 3 6
	// 3 6 9 3 6 9

	// 1 2 2 0

	public static void main(String[] args) {
		// tasks = ["A","A","A","B","B","B"], n = 2

		System.out.println(new TaskScheduler().leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2));

	}
}

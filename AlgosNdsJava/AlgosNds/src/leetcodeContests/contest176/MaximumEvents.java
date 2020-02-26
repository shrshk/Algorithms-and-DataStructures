package leetcodeContests.contest176;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumEvents {
	public int maxEventsNW(int[][] events) {
		Map<Integer, Boolean> map = new HashMap<>();
		int min = Integer.MAX_VALUE;
		int max = 0;
		int count = 0;
		
		Arrays.sort(events, (event1, event2) -> ((event1[1]-event1[0])-(event2[1]-event2[0])));

		for (int[] event : events) {
			min = Math.min(min, event[0]);
			max = Math.max(max, event[1]);
		}

		for (int i = min; i <= max; i++) {
			map.put(i, true);
		}
		
		System.out.println(map.toString());

		for (int[] event : events) {
			int start = event[0];
			int end = event[1];
			if (isAttentable(map, start, end))
				count++;
		}

		return count;
	}
	
	private boolean isAttentable(Map<Integer, Boolean> map, int start, int end) {
		for (int i=start; i<=end; i++) {
			if (map.get(i)) {
				map.put(i, false);
				return true;
			}
		}
		
		return false;
	}
	
	public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]); // sort events increasing by start time
        Queue<Integer> minHeap = new PriorityQueue<>();
        int ans = 0, i = 0, n = events.length;
        for (int d = 1; d <= 100000; d++) {        	
            while (i < n && events[i][0] == d) { // Add new events that can attend on day `d`
                minHeap.add(events[i++][1]);
                System.out.println("one"+ " " + minHeap.toString());
            }
            while (!minHeap.isEmpty() && minHeap.peek() < d) { // Remove events that are already closed
                minHeap.poll(); 
                System.out.println("two"+ " " + minHeap.toString());
            }
            if (!minHeap.isEmpty()) { // Use day `d` to attend to the event that closes earlier
                ans++;
                minHeap.poll();    
                System.out.println("three"+ " " + minHeap.toString());
            }
            
            if (minHeap.isEmpty() && i>=n)
                break;
        }
        return ans;
    }
	
	public static void main(String[] args) {
		//{1,4},{1,5},{1,6},{1,7}
		// {,,3,4}
		// [[1,2],[1,2],[3,3],[1,5],[1,5]]   [[1,4],[4,4],[2,2],[3,4],[1,1]]
		// 1,4 1,1 2,2 3,4 3,4 4,4     4,4   
		int[][] events = new int[][]{{1,2},{2,3},{3,4},{1,2}}; //3,3 1,2 1,2 1,5 1,5
		System.out.println(new MaximumEvents().maxEvents(events));
	}
	
	
}

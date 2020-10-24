package bloombergPractice;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxEvents {
	public int maxEvents(int[][] events) {
        // 1,2 1,2 2,3 3,4
        // 2,2,3,4
        // 
        // steps
        // maintain pq to close events which end earlier
        // remove events which passed their day 
        // on d day count one event.
        Arrays.sort(events, (e1,e2) -> (e1[0]-e2[0]));
        Queue<Integer> pq = new PriorityQueue<>();
        int i=0, n=events.length, res=0;
        for (int d=1; d<=100000; d++) {
            while(i<n && events[i][0] == d) {
                pq.add(events[i][1]);
                i++;
            }
            
            while(!pq.isEmpty() && pq.peek() < d) { // we are passed this day so close the events
                pq.poll();
            }
            
            if(!pq.isEmpty()) { // assign d day event
                res++;
                pq.poll();
            }
            
            if (pq.isEmpty() && i>=n)
                break;
            
        }
        
        return res;
	}
	
	public static void main(String[] args) {
		System.out.println('z'-'a');
	}
}

package atlassianPrep;

import java.util.HashMap;
import java.util.Map;

public class HitCounter {
	
	Map<Integer,Integer> hitMap;

    /** Initialize your data structure here. */
    public HitCounter() {
        // [] 1,2,3,4,5,....
    	// {1->2, 2->3, 3->4, 300->1}
    	// 301 - 300 = [1..301]
    	// [1,2,3,4]
    	// [1,2,3,4] 
    	hitMap = new HashMap<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
    	hitMap.put(timestamp, hitMap.getOrDefault(timestamp, 0)+1);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
    	int low = timestamp - 300 < 0 ? 0 : timestamp-300;
    	int count = 0;
    	while(timestamp>low) {
    		if (hitMap.containsKey(timestamp))
    			count+=hitMap.get(timestamp);
    		timestamp--;
    	}
        return count;
    }
    
    public static void main(String[] args) {
    	HitCounter counter = new HitCounter();
    	
    	// ["HitCounter","hit","hit","hit","hit","getHits"]
    	// [[],[1],[1],[1],[300],[300]]   // {1}

    	// hit at timestamp 1.
    	counter.hit(1);

    	// hit at timestamp 2.
    	counter.hit(1);

    	// hit at timestamp 3.
    	counter.hit(1);

    	// get hits at timestamp 4, should return 3.
    	// counter.getHits(4);

    	// hit at timestamp 300.
    	counter.hit(300);

    	// get hits at timestamp 300, should return 4.
    	System.out.println(counter.getHits(300));

    	// get hits at timestamp 301, should return 3.
    	// System.out.println(counter.getHits(301));
    	System.out.println(301%300);
	}
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

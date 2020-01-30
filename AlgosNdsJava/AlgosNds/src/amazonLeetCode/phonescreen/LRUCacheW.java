package amazonLeetCode.phonescreen;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LRUCacheW {

	Map<Integer,int[]>map;
	int capacity;

	public LRUCacheW(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
	}

	public int get(int key) {
		int[] val = map.get(key);
		if (val != null) {
			int count = val[1];
			val[1] = ++count;
			map.put(key, val);
			return val[0];
		}
		return -1;
	}

	public void put(int key, int value) {
		if (map.size() == capacity) {
			invalidateCache();
			int leastUsedKey = getLeastUsedKey();
			map.remove(leastUsedKey);
			// resetCache();
		}
		if (map.containsKey(key)) {
			int[] val = map.get(key);
			val[0] = value;
			val[1]+=val[1];
			return;
		}
		map.put(key, new int[] { value, 0 });
	}

	private int getLeastUsedKey() {
        int leastUsedVal = Integer.MAX_VALUE;
        int leastUsedKey = -1;
        for (Entry<Integer, int[]> entry: map.entrySet()) {
            int key = entry.getKey();
            int[] value = entry.getValue();
            if (value[1]<leastUsedVal) {
                leastUsedVal = value[1];
                leastUsedKey = key;
            }
        }
        return leastUsedKey;
    }
	
	private void invalidateCache() {
		for (int[] val : map.values()) {
			val[1] = 0;
		}
	}
	
	public static void main(String[] args) {
		LRUCacheW cache = new LRUCacheW(2);
		cache.put(2,1);
		cache.put(2, 2);
		System.out.println(cache.get(2));       
		cache.put(1,1);	         
		cache.put(4,1);
		System.out.println(cache.get(2));
//		cache.get(1);       // returns -1 (not found)
//		cache.get(3);       // returns 3
//		cache.get(4);       // returns 4
		// ["LRUCache","put","put","get","put","put","get"]
		// [[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
	}
}



/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */

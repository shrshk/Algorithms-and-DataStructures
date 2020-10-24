package amazonLeetCode.phonescreen;

import java.util.LinkedHashMap;

public class LRUCache {
	private LinkedHashMap<Integer, Integer> map;
	private int SIZE;
	public LRUCache(int capacity) {
	    map = new LinkedHashMap<>();
	    SIZE = capacity;
	}

	public int get(int key) {
	    if(map.containsKey(key)) {
	        int value = map.remove(key);
	        map.put(key, value);
	        return value;
	    }
	    return -1;
	}

	public void put(int key, int value) {
	    if(map.containsKey(key)) {
	        map.remove(key);
	    }else if(map.size() == SIZE) {
	        map.remove(map.keySet().iterator().next());
	    }
	    map.put(key, value);
	}
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.put(2,1);
		cache.put(2, 2);
		System.out.println(cache.get(2));       
		cache.put(1,1);	         
		cache.put(4,1);
		System.out.println(cache.get(2));
	}
}

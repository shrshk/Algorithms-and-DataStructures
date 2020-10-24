package twilioPrep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

	// 1,2,3,4 // 2,0 2

	Map<Integer, Integer> map;
	List<Integer> list;
	Random rand;

	/** Initialize your data structure here. */
	public RandomizedSet() {
		map = new HashMap<>();
		list = new ArrayList<>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		if (map.containsKey(val))
			return false;
		int idx = list.size();
		list.add(val);
		map.put(val, idx);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		Integer removeIdx = map.get(val);
		if (removeIdx == null)
			return false; // 3 2 3:0
		map.remove(val);

		int size = list.size();
		Integer lastVal = list.get(size - 1);

		Collections.swap(list, removeIdx, size - 1);

		map.put(lastVal, removeIdx);
		list.remove(size - 1);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		rand = new Random();
		int size = list.size();
		System.out.println(size);
		int idx = rand.nextInt(size);
		return list.get(idx);
	}
	public static void main(String[] args) {
//		RandomizedSet x = new RandomizedSet();
//		System.out.println(x.insert(1));
//		System.out.println(x.remove(0));
		List<Integer> a = new ArrayList<>();
		System.out.println(new Random().nextInt(a.size()));
		
	}
}



/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */

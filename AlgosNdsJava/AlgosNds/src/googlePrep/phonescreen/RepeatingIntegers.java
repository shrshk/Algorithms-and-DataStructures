package googlePrep.phonescreen;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RepeatingIntegers {
	boolean hasRepeats(List<Integer> numbers, List<Integer> repeats) {
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer num : numbers) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		Collections.sort(repeats, Comparator.reverseOrder());
		Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b-a));
		for (int val: map.values()) {
			if (val< repeats.get(repeats.size()-1))
				continue;
			pq.add(val);
		}
		
		// 1->4
		for (int i=0; i<repeats.size(); i++) {
			int repeatFreq = repeats.get(i);
			if (pq.isEmpty())
				return false;
			int currFreq = pq.poll();
			if (currFreq < repeatFreq)
				return false;
			int remainFreq = currFreq - repeatFreq;
			if (remainFreq>0)
				pq.add(remainFreq);
		}
		
		
		return true;
	}
	
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1,1,1,1);
		List<Integer> repeats = Arrays.asList(2,2);
		System.out.println(new RepeatingIntegers().hasRepeats(nums, repeats));
	}
}
/*		int i=0;
		int j=0;
		int intersection = 0;
		while(i<counts.size() && j<repeats.size()) {
			if (counts.get(i)<repeats.get(j)) {
				i++;
			} else if (counts.get(i)>repeats.get(j)) {
				j++;
			} else {
				i++;
				j++;
				intersection++;
			}			
		}	
		System.out.println(intersection);

		return repeats.size() == intersection;*/
package googlePrep.onsite;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RepeatingIntegers {
	public boolean hasRepeats(List<Integer> numbers, List<Integer> repeats) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int num : numbers) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		Queue<Integer> fPQ = new PriorityQueue<>((a, b) -> (b - a));
		Queue<Integer> nPQ = new PriorityQueue<>((a, b) -> (map.get(b) - map.get(a)));

		for (int freq : repeats) {
			fPQ.add(freq);
		}

		for (int num : numbers) {
			nPQ.add(num);
		}

		while (!fPQ.isEmpty() && !nPQ.isEmpty()) {
			int freq = fPQ.poll();
			int top = nPQ.peek();
			while (freq > 0 && !nPQ.isEmpty() && nPQ.peek() == top) {
				nPQ.poll();
				freq--;
			}
			if (freq != 0)
				return false;
		}

		return fPQ.isEmpty();
	}

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 1, 1, 1, 1);
		List<Integer> repeats = Arrays.asList(2, 2);
		System.out.println(new RepeatingIntegers().hasRepeats(numbers, repeats));
	}
}

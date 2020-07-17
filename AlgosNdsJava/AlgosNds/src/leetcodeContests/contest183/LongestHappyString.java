package leetcodeContests.contest183;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import javafx.util.Pair;

public class LongestHappyString {
	public String longestDiverseString(int a, int b, int c) {		
		StringBuilder sb = new StringBuilder();
		Queue<Pair<Character, Integer>> pq = new PriorityQueue<>((c1, c2) -> (c2.getValue() - c1.getValue()));
		
		if (a>0)
			pq.add(new Pair<Character, Integer>('a', a));
		if (b>0)
			pq.add(new Pair<Character, Integer>('b', b));
		if (c>0)
			pq.add(new Pair<Character, Integer>('c', c));
		
		while (!pq.isEmpty()) {
			Pair<Character, Integer> first = pq.poll();
			if (sb.length()!=0 && sb.charAt(sb.length()-1) == first.getKey()) {
				if (pq.isEmpty())
					return sb.toString();
				Pair<Character, Integer> second = pq.poll();
				sb.append(second.getKey());
				if (second.getValue()-1>0) {
					pq.add(new Pair<Character, Integer>(second.getKey(), second.getValue()-1));
				}
				pq.add(first);				
			} else {
				int limit = Math.min(2, first.getValue());
				int counter = 0;
				while (counter++<limit) {
					sb.append(first.getKey());
				}
				if (first.getValue()-limit>0)
					pq.add(new Pair<Character, Integer>(first.getKey(), first.getValue()-limit));				
			}
		}	
		return sb.toString();
	}
	public String longestDiverseStringBF(int a, int b, int c) {
		// "ccaccbcc"
		// { a:1, b:1, c:5}

		// c:7 b:1 a:1 // c:5 b cc

		// cc b cc a cc

		// b:1 c:1
		// aa bb c b
		// aa b bc

		// cc

		Map<Character, Integer> map = new HashMap<>();

		if (a>0)
			map.put('a', a);
		if (b>0)
			map.put('b', b);
		if (c>0)
			map.put('c', c);

		Queue<Character> q = new PriorityQueue<>((c1, c2) -> map.get(c2) - map.get(c1));

		StringBuilder sb = new StringBuilder();
		
		if (a>0)
			q.add('a');
		if (b>0)
			q.add('b');
		if (c>0)
			q.add('c');

		while (!q.isEmpty()) {
			char first = q.poll();

			if (sb.length() != 0 && sb.charAt(sb.length() - 1) == first) {
				if (q.isEmpty())
					return sb.toString();
				else {
					char second = q.poll();
					sb.append(second);
					map.put(second, map.get(second) - 1);
					if (map.get(second) > 0)
						q.add(second);
					q.add(first);
				}
			} else {
				int limit = Math.min(2, map.get(first));

				while (limit > 0) {
					sb.append(first);
					map.put(first, map.get(first) - 1);
					limit--;
				}

				if (map.get(first) > 0)
					q.add(first);

			}

		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new LongestHappyString().longestDiverseString(2, 2, 1));
		// char next = 'x';
		// if (q.size()>1)
		// next = q.poll();
		//
		// int firstCount = 1;
		//
		// while (firstCount<3 && map.get(first)>0) {
		// sb.append(first);
		// firstCount++;
		// map.put(first, map.get(first)-1);
		// }
		//
		// if (map.get(next)>0) {
		// sb.append(next);
		// map.put(next, map.get(next)-1);
		// }
		//
		// if (map.get(first)>0)
		// q.add(first);
		// if (map.get(next)>0)
		// q.add(next);
	}

}

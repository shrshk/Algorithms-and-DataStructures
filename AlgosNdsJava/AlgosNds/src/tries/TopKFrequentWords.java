package tries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

class Word {
	String word;
	int count;

	Word(String word, int count) {
		this.word = word;
		this.count = count;
	}
}

class WordComparator implements Comparator<Word> {
	public int compare(Word w1, Word w2) {
		if (w1.count == w2.count) {
			return w2.word.compareTo(w1.word);
		}
		return w1.count - w2.count;
	}
}

public class TopKFrequentWords {
	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> map = new HashMap<>();

		for (String word : words) {
			if (!map.containsKey(word))
				map.put(word, 1);
			else
				map.put(word, map.get(word) + 1);
		}

		Queue<Word> pq = new PriorityQueue<>(new WordComparator());

		for (Entry<String, Integer> e : map.entrySet()) {
			pq.add(new Word(e.getKey(), e.getValue()));
			if (pq.size()>k) pq.poll();
		}

		List<String> result = new ArrayList<>();

		for (int i = 0; i<k; i++) {
			result.add(pq.poll().word);
		}
		
		Collections.reverse(result);

		return result;
	}
	
	public static void main(String[] args) {
		// List<String> input = Arrays.asList();
		String[] input = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
		// ["i", "love", "leetcode", "i", "love", "coding"] // "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"
		System.out.println(new TopKFrequentWords().topKFrequent(input, 2));
	}
}
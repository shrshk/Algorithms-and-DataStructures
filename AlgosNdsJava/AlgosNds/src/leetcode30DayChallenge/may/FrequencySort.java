package leetcode30DayChallenge.may;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencySort {
	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		List<Character> list = new ArrayList<>();

		for (char c : map.keySet()) {
			list.add(c);
		}

		list.sort(new Comparator<Character>() {
			@Override
			public int compare(Character c1, Character c2) {
				return map.get(c2) - map.get(c1);
			}
		});

		StringBuilder sb = new StringBuilder();

		for (char c : list) {
			for (int i=0; i<map.get(c); i++)
				sb.append(c);
		}

		return sb.toString();

	}

	public static void main(String[] args) {
		System.out.println(new FrequencySort().frequencySort("loveleetcode"));
	}
}

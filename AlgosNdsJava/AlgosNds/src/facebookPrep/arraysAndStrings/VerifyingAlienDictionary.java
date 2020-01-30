package facebookPrep.arraysAndStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordComparator implements Comparator<String> {
	String order;
	Map<Character, Integer> map = new HashMap<>();

	WordComparator(String order) {
		this.order = order;
		for (int i = 0; i < order.length(); i++) {
			map.put(order.charAt(i), i);
		}
	}

	@Override
	public int compare(String s1, String s2) {
		int i = 0, j = 0;

		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) == s2.charAt(j)) {
				i++;
				j++;
			} else {
				if (map.get(s1.charAt(i)) < map.get(s2.charAt(j))) {
					return -1;
				} else
					return 1;
			}
		}

		if (s1.length() < s2.length())
			return -1;

		return 0;
	}

}

public class VerifyingAlienDictionary {

	Map<Character, Integer> map = new HashMap<>();

	public boolean isAlienSortedWithComparator(String[] words, String order) {
		List<String> wordList = new ArrayList<>(words.length);

		for (String word : words)
			wordList.add(word);

		Collections.sort(wordList, new WordComparator(order));

		System.out.println(wordList.toString());

		for (int i = 0; i < words.length; i++) {
			if (!words[i].equals(wordList.get(i)))
				return false;
		}

		return true;
	}

	private boolean compare(String s1, String s2) {
		int i = 0, j = 0;

		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) != s2.charAt(j)) {
				if (map.get(s1.charAt(i)) > map.get(s2.charAt(j))) {
					return false;
				} else {
					return true;
				}
			}
			i++;
			j++;
		}

		if (s1.length() > s2.length())
			return false;

		return true;
	}

	public boolean isAlienSorted(String[] words, String order) {
		for (int i = 0; i < order.length(); i++) {
			map.put(order.charAt(i), i);
		}

		for (int i = 0; i < words.length - 1; i++) {
			if (!compare(words[i], words[i + 1]))
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		String[] words = new String[] { "apple", "app" }; // "hello","leetcode"
		String order = "abcdefghijklmnopqrstuvwxyz";
		System.out.println(new VerifyingAlienDictionary().isAlienSorted(words, order));
		System.out.println(Character.isDigit('.'));
	}
}

package codeFights;

import java.util.*;

public class FoxProblem {

	public static List<String> count(String string, String[] excludeList) {
		List<String> finalList = new ArrayList<String>();
		String[] splitStr = string.split("\\s+");

		Map<String, Integer> occurrences = new HashMap<String, Integer>();
		Integer maxCount = 0;

		for (String word : splitStr) {
			Integer oldCount;
			if (Arrays.asList(excludeList).contains(word)) {
				oldCount = 0;
			} else {
				oldCount = occurrences.get(word);
				if (oldCount!=null && maxCount < oldCount) {
					maxCount = oldCount;
				} else {
					oldCount = 0;
				}
			}
			occurrences.put(word, oldCount + 1);
		}

		for (Map.Entry<String, Integer> entry : occurrences.entrySet()) {
			String word = entry.getKey();
			Integer count = entry.getValue();
			if (count >= maxCount) {
				finalList.add(word);
			}
		}

		return finalList;
	}

	public static void main(String args[]) {
		String[] list = new String[3];
		list[0] = "is";
		list[1] = "brown";
		list[2] = "fox";

		List<String> finalList = (ArrayList<String>) count("A quick brown fox jumps over the lazy dog jumps dog", list);
		System.out.println(finalList);
	}
}
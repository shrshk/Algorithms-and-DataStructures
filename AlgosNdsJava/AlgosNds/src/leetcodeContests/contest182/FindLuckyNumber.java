package leetcodeContests.contest182;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FindLuckyNumber {
	public int findLucky(int[] arr) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i : arr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		int maxValue = -1;

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			int num = entry.getKey();
			int freq = entry.getValue();
			if (freq == num) {
				maxValue = Math.max(num, maxValue);
			}

		}

		return maxValue;
	}

	public static void main(String[] args) {

	}
}

package facebookPrep.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class AnyNumberInAllRanges {
	public int anyNumberInAllRanges(int[][] ranges) {

		int[] curr = ranges[0];

		for (int i = 1; i < ranges.length; i++) {
			int[] newR = ranges[i];
			if (newR[0] > curr[1])
				return -1;
			curr[0] = Math.max(curr[0], newR[0]);
			curr[1] = Math.min(curr[1], newR[1]);
		}

		return curr[0];
	}

	public int maxOccuring(int[][] range) {
		// freq array to store the frequency
		int n = range.length;
		int[] freq = new int[(int) (1e6 + 2)];

		int first = 0, last = 0;

		// iterate and mark the hash array
		for (int i = 0; i < n; i++) {
			int l = range[i][0];
			int r = range[i][1];

			// increase the hash array by 1 at L
			freq[l] += 1;

			// Decrease the hash array by 1 at R
			freq[r + 1] -= 1;

			first = Math.min(first, l);
			last = Math.max(last, r);
		}

		// System.out.println(first);
		// System.out.println(last);

		// stores the maximum frequency
		int maximum = 0;
		int element = 0;

		// check for the most occuring element
		for (int i = first + 1; i <= last; i++) {

			// increase the frequency
			freq[i] = freq[i - 1] + freq[i];
			System.out.println(freq[i]);

			// check if is more than the previous one
			if (freq[i] > maximum) {
				maximum = freq[i];
				element = i;
			}
		}
		return element;
	}

	public int maxOccuringElement(int[][] ranges) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 0);
		int start = 0, end = 0;
		for (int i = 0; i < ranges.length; i++) {
			int[] curr = ranges[i];
			int left = curr[0];
			int right = curr[1];
			map.put(left, map.getOrDefault(left, 0) + 1);
			map.put(right + 1, map.getOrDefault(right + 1, 0) - 1);

			start = Math.min(start, left);
			end = Math.max(end, right);
		}

		int maxFreq = 0;
		int num = 0;

		for (int i = start + 1; i <= end; i++) {
			if (!map.containsKey(i)) {
				map.put(i, 0);
			}
			map.put(i, map.get(i - 1) + map.get(i));
			if (map.get(i) > maxFreq) {
				maxFreq = map.get(i);
				num = i;
			}
		}

		return num;
	}

	public static void main(String[] args) {
		int[][] ranges = new int[][] { { 1, 6 }, { 2, 3 }, { 2, 5 }, { 3, 8 } };// [[1,4],[3,5],[4,6]]
		System.out.println(new AnyNumberInAllRanges().maxOccuringElement(ranges));
	}

}

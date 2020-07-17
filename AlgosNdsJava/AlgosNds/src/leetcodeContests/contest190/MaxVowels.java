package leetcodeContests.contest190;

import java.util.Arrays;
import java.util.List;

public class MaxVowels {

	List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');

	public int maxVowels(String s, int k) {
		// s = "abciiidef", k = 3

		int i = 0;
		int MaxCount = 0;
		int count = 0;
		while (i < s.length()) {
			if (vowels.contains(s.charAt(i))) {
				count++;
			}
			if (i >= k && vowels.contains(s.charAt(i - k))) {
				count--;
			}
			MaxCount = Math.max(count, MaxCount);
			i++;
		}

		return MaxCount;
	}

	public static void main(String[] args) {
		String s = "abciiidef";
		System.out.println(new MaxVowels().maxVowels(s, 3));
	}
}

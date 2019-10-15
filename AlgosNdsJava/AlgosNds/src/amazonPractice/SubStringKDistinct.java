package amazonPractice;

import java.util.HashSet;
import java.util.Set;

public class SubStringKDistinct {

	static int subStringKDist(String str, int k) {
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			char start = str.charAt(i);
			int j = i + 1;
			String x = start + "";
			while (j < str.length()) {
				x = x + str.charAt(j);
				if (x.length() >= k && isDist(x, k)) {
					count++;
				}
				j++;
			}
		}
		return count;
	}

	static boolean isDist(String x, int k) {
		Set<Character> s = new HashSet<>();
		for (char ch : x.toCharArray()) {
			s.add(ch);
		}
		return s.size() == k;
	}

	public static void main(String[] args) {
		System.out.println(subStringKDist("aabab", 3));
	}
}

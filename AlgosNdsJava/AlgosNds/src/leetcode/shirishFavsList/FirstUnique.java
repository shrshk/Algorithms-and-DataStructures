package leetcode.shirishFavsList;

import java.util.ArrayList;
import java.util.List;

public class FirstUnique {
	static int firstUnique(String s) {
		List<Character> repeating = new ArrayList<>();
		List<Character> nonRepeating = new ArrayList<>();// a a c // c // a a c
		// for (char ch: s.toCharArray()) {
		// if (repeating.contains(ch)) {
		// nonRepeating.remove(ch);
		// }else{
		// repeating.add(ch);
		// nonRepeating.add(ch);
		// }
		// }
		for (int i = 0; i < s.length(); i++) {
			Character temp = s.charAt(i);
			if (repeating.contains(temp)) {
				nonRepeating.remove(temp);
			} else {
				repeating.add(temp);
				nonRepeating.add(temp);
			}
		}
		char ch = nonRepeating.size() > 0 ? nonRepeating.get(0) : ' ';
		int index = ch != ' ' && s.indexOf(ch) > 0 ? s.indexOf(ch) : -1;
		return index;
	}

	static boolean isGeometricProgression(int[] sequence) {
		int n = sequence.length;
		if (n == 1)
			return true;
		int ratio = sequence[1] / (sequence[0]);
		for (int i = 1; i < n; i++) {
			if ((sequence[i] / (sequence[i - 1])) != ratio) {
				return false;
			}
		}
		return true;
	}

	static String[] isDivisibleBy3(String inputString) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			String newString = inputString.replace("*", String.valueOf(i));
			int sum = 0;
			for (int k = 0; k < newString.length(); k++) {
				sum += newString.charAt(k) - '0';
			}
			if (sum % 3 == 0) {
				res.add(newString);
			}
		}
		String str[] = new String[res.size()];
		for (int j = 0; j < res.size(); j++) {
			// Assign each value to String array
			str[j] = res.get(j);
			System.out.println(str[j]);
		}
		return str;
	}

	public static void main(String[] args) {
		String str = "1*0";
		System.out.println(isDivisibleBy3("1233444444444444*0"));
		str = str.replace("*", "0");
		// System.out.println(str);
	}
}

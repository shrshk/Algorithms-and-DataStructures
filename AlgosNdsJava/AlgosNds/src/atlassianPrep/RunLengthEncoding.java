package atlassianPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RunLengthEncoding {
	public String runLengthEncode(String s) {
		int i = 0, j = 0;
		StringBuilder sb = new StringBuilder();
		while (i < s.length()) {
			int count = 0;
			while (j < s.length() && s.charAt(j) == s.charAt(i)) {
				count++;
				j++;
			}
			sb.append(s.charAt(i));
			sb.append(count);
			i = j;
		}
		return sb.toString();
	}

	boolean checkFactorial(int n) {
		//
		int i = 1;
		while (i++ < n) {
			if (n % i == 0) {
				n /= i;
			} else {
				break;
			}
		}

		if (n == 1) {
			return true;
		}
		return false;
	}

	String[] isDivisibleBy6(String inputString) {

		List<String> res = new ArrayList<>();

		for (int i = 0; i <= 9; i++) {
			String c = String.valueOf(i);
			String num = inputString.replace("*", c);

			int n = Integer.parseInt(num);

			if (n % 2 == 0 && n % 3 == 0)
				res.add(String.valueOf(n));
		}

		String[] output = new String[res.size()];

		int i = 0;

		for (String x : res) {
			output[i++] = x;
		}

		return output;
	}

	public static void main(String[] args) {
		// System.out.println(new RunLengthEncoding().runLengthEncode("wwwwaaadexxxxxx"));
		System.out.println("1*0".replace('*', (char)1));
		
		System.out.println(Arrays.toString(new RunLengthEncoding().isDivisibleBy6("1*0")));
	}
}

package leetcodeContests.contest179;

import java.util.Arrays;

public class StringWithOddCounts {
	public String generateTheString(int n) {
		int[] splits = n % 2 == 0 ? new int[] { n - 1, 1 } : new int[] { n };
		StringBuilder sb = new StringBuilder();
		char[] repeat = new char[splits[0]];
		Arrays.fill(repeat, 'a');
		sb.append(repeat);
		if (splits.length > 1) {
			sb.append('b');
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new StringWithOddCounts().generateTheString(499));
	}
}

package facebookPrep.phonescreen;

public class MaximumSwap {
	public int maximumSwap(int num) {
		String x = String.valueOf(num);
		String maxString = x;
		for (int i = 0; i < x.length(); i++) {
			for (int j = 0; j < x.length(); j++) {
				if (i != j) {
					String current = swap(x, i, j);
					if (current.compareTo(maxString) > 0) {
						maxString = current;
					}
				}
			}
		}

		int res = Integer.parseInt(maxString);

		return res;
	}

	private String swap(String x, int i, int j) {
		StringBuilder sb = new StringBuilder(x);

		sb.setCharAt(i, x.charAt(j));
		char temp = x.charAt(i);
		sb.setCharAt(j, temp);

		return sb.toString();
	}

	public int maximumSwapO(int num) {
		char[] digits = Integer.toString(num).toCharArray();

		int[] buckets = new int[10];
		for (int i = 0; i < digits.length; i++) {
			buckets[digits[i] - '0'] = i;
		}
		
		// 2736
		// [0,0,0,2,0,0,3,1,0,0]

		for (int i = 0; i < digits.length; i++) {
			for (int k = 9; k > digits[i] - '0'; k--) {
				if (buckets[k] > i) {
					char tmp = digits[i];
					digits[i] = digits[buckets[k]];
					digits[buckets[k]] = tmp;
					return Integer.valueOf(new String(digits));
				}
			}
		}

		return num;
	}
}

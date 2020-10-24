package googlePrep.onsite;

import java.util.Arrays;
import java.util.LinkedList;

public class SubtractIntegers {
	public int[] subtractIntegers(int[] num1, int[] num2) {
		if (num1.length < num2.length)
			return subtractIntegers(num2, num1);
		if (num1.length == num2.length) {
			for (int i = 0; i < num1.length; i++) {
				if (num1[i] > num2[i])
					break;
				else if (num2[i] > num1[i])
					return subtractIntegers(num2, num1);
			}
		}

		LinkedList<Integer> result = new LinkedList<>();
		int carry = 0;
		int num1Iter = num1.length - 1;
		int num2Iter = num2.length - 1;
		while (num1Iter >= 0) {
			int first = num1[num1Iter]; // 100 // 91 // 0 // 345 // 123
			num1Iter--;
			int second = carry; // 1
			if (num2Iter >= 0) { //
				second += num2[num2Iter]; // 10
				num2Iter--;
			}
			if (second > first) { // 1>0 //
				first += 10; // 0 + 10 = 10
				carry = 1; // 1
			} else
				carry = 0;
			result.addFirst(first - second); // 10-1 = 9 //0,9
		}
		return result.stream().mapToInt(i -> i).toArray();
	}

	public int[] subtractTwoIntegers(int[] num1, int[] num2) {
		// steps
		// always subtract from higher number to avoid negative
		// 100 91

		// start with 0 carry
		// add carry to second
		// if sec > first then make first+10
		// make carry = 1 else 0
		// add first - second to the result

		if (num1.length < num2.length)
			return subtractTwoIntegers(num2, num1);
		if (num1.length == num2.length) {
			for (int i = 0; i < num1.length; i++) {
				if (num1[i] > num2[i])
					break;
				else if (num1[i] < num2[i])
					return subtractTwoIntegers(num2, num1);
			}
		}

		LinkedList<Integer> res = new LinkedList<>();

		int num1Idx = num1.length - 1;
		int num2Idx = num2.length - 1;

		int carry = 0; // 100 // 91

		while (num1Idx >= 0) {
			int first = num1[num1Idx];
			num1Idx--;
			int second = carry;
			if (num2Idx >= 0) {
				second += num2[num2Idx];
				num2Idx--;
			}
			if (second > first) {
				first += 10;
				carry = 1;
			} else
				carry = 0;

			res.addFirst(first - second);

		}

		return res.stream().mapToInt(digit -> digit).toArray();

	}

	public static void main(String[] args) {
		int[] num1 = new int[] { 1, 0, 0 };
		int[] num2 = new int[] { 9 };
		System.out.println(Arrays.toString(new SubtractIntegers().subtractTwoIntegers(num1, num2)));
	}
}

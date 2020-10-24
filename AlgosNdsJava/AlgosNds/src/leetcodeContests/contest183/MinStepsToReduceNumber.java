package leetcodeContests.contest183;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class MinStepsToReduceNumber {	
	// https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/tutorial/
	// read above and then practice below.
	public int numSteps(String s) {
		int res = 0;
		char[] arr = s.toCharArray();
		int i = s.length() - 1;
		while (i > 0) {
			char c = arr[i];
			if (c == '0') {
				res++; // /2 operation simulates >>1
				i--; // move to left digit
			} else {
				res++; // current last digit is 1, 1*2^0 = 1, +1 operation for
						// odd number
				// now consider the consequence of adding this 1:
				// this digit and consecutive 1's to its left will need to
				// devide 2 because they are even after adding above 1:
				while (i > 0 && arr[i] == '1') {
					res++; // / 2 simulate >> 1 and carry another 1 to the left
							// digit
					i--;
				}
				// finally find a '0' or i == 0 : conditions to break while loop
				// above
				if (i == 0) {
					// Given that leading digit must be 1, the carry over 1 add
					// to 1
					res++; // / 2 operation for 2/2 = 1 - final result
					return res;
				} else {
					arr[i] = '1'; // this digit now changed from 0 to 1 and next
									// loop still continues from this digit 1
					// should NOT do i--
				}
			}
		}
		return res;

	}

	public int numStepsOverFlow(String s) {
		// bfs
		int steps = 0;
		Queue<Integer> q = new ArrayDeque<>();

		Set<Integer> visited = new HashSet<>();

		// steps
		// if num 1 return
		// maintain visited to not add dups to q
		// poll from q update each step

		int num = Integer.parseInt(s, 2);

		// int num = integerfrmbinary(s);

		q.add(num);

		while (!q.isEmpty()) {

			int size = q.size();
			for (int i = 0; i < size; i++) {
				int curr = q.poll();

				if (curr == 1)
					return steps;

				if (!visited.contains(curr / 2) && curr % 2 == 0) {
					q.add(curr / 2);
					visited.add(curr / 2);
				}

				if (!visited.contains(curr + 1) && curr % 2 != 0) {
					q.add(curr + 1);
					visited.add(curr + 1);
				}

			}

			steps++;

		}

		return steps;

	}

	private int binaryToDecimal(int n) {
		int num = n;
		int dec_value = 0;

		// Initializing base
		// value to 1, i.e 2^0
		int base = 1;

		int temp = num;
		while (temp > 0) {
			int last_digit = temp % 10;
			temp = temp / 10;

			dec_value += last_digit * base;

			base = base * 2;
		}

		return dec_value;
	}

	public static int bin2Dec(String binaryString) throws NumberFormatException {
		int decimal = 0;
		for (int i = 0, j = binaryString.length() - 1; i < binaryString.length(); i++, j--) {
			if (binaryString.charAt(i) < '0' || binaryString.charAt(i) > '1')
				throw new NumberFormatException("The string is not a binary string");
			decimal += (Integer.parseInt(String.valueOf(binaryString.charAt(i)))) * Math.pow(2, j);
		}
		return decimal;
	}

	public static int integerfrmbinary(String str) {
		double j = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				j = j + Math.pow(2, str.length() - 1 - i);
			}

		}
		return (int) j;
	}

	private BigDecimal bitStringToBigDecimal(String bitStr) {

		BigDecimal sum = new BigDecimal("0");
		BigDecimal base = new BigDecimal(2);
		BigDecimal temp;
		for (int i = 0; i < bitStr.length(); i++) {
			if (bitStr.charAt(i) == '1') {
				int exponent = bitStr.length() - 1 - i;
				temp = base.pow(exponent);
				sum = sum.add(temp);
			}

		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(
				new MinStepsToReduceNumber().numSteps("1111011110000011100000110001011011110010111001010111110001"));
	}
}

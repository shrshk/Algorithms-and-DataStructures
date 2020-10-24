package leetcode30DayChallenge.may;

import java.util.Stack;

public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
		// "1432219"
		// 1219 341
		// 1
		// 10200

		if (num.length() == k)
			return "0";

		Stack<Character> stack = new Stack<>();
		int n = num.length();
		int i = 0;

		while (i < n) {
			char c = num.charAt(i);
			while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
				stack.pop();
				k--;
			}
			stack.push(c);
			i++;
		}

		while (k > 0 && !stack.isEmpty()) {
			stack.pop();
			k--;
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			char digit = stack.pop();
			sb.append(digit);
		}

		sb.reverse();
		while (sb.length() > 1 && sb.charAt(0) == '0')
			sb.deleteCharAt(0);

		return sb.toString();

	}

	public static void main(String[] args) {
		System.out.println(new RemoveKDigits().removeKdigits("1234567890", 9));
	}
}

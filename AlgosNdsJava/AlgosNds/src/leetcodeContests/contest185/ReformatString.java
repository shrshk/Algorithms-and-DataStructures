package leetcodeContests.contest185;

import java.util.ArrayDeque;
import java.util.Queue;

class ReformatString {
	public String reformat(String s) {
		// "a0b1c2"
		// "covid2019"
		// abcd12
		Queue<Character> charQ = new ArrayDeque<>();
		Queue<Character> intQ = new ArrayDeque<>();

		for (char ch : s.toCharArray()) {
			if (Character.isDigit(ch))
				intQ.add(ch);
			else
				charQ.add(ch);
		}

		if (Math.abs(charQ.size() - intQ.size()) > 1)
			return "";

		StringBuilder sb = new StringBuilder();

		int cLen = charQ.size();
		int iLen = intQ.size();

		boolean flag = cLen > iLen;

		while (!charQ.isEmpty() && !intQ.isEmpty()) {
			if (flag) {
				sb.append(charQ.poll());
				flag = false;
			} else {
				sb.append(intQ.poll());
				flag = true;
			}
		}

		if (!charQ.isEmpty())
			sb.append(charQ.poll());

		if (!intQ.isEmpty())
			sb.append(intQ.poll());

		return sb.toString();

	}

	public static void main(String[] args) {
		System.out.println(new ReformatString().reformat("covid2019"));
	}
}

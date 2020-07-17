package facebookPrep.mockTests.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LetterCombinationOfPhoneNumber {
	public List<String> letterCombinationsBFS(String digits) {
		Map<Integer, char[]> map = new HashMap<>();
		map.put(2, new char[] { 'a', 'b', 'c' });
		map.put(3, new char[] { 'd', 'e', 'f' });
		map.put(4, new char[] { 'g', 'h', 'i' });
		map.put(5, new char[] { 'j', 'k', 'l' });
		map.put(6, new char[] { 'm', 'n', 'o' });
		map.put(7, new char[] { 'p', 'q', 'r', 's' });
		map.put(8, new char[] { 't', 'u', 'v' });
		map.put(9, new char[] { 'w', 'x', 'y', 'z' });

		if (digits == null || digits.length() == 0)
			return new ArrayList<>();

		List<String> res = new ArrayList<>();

		Queue<String> q = new LinkedList<>();
		q.add("");

		// steps
		// loop thru q add chars at current level
		// when level reaches the end return result
		int level = 0;

		while (!q.isEmpty()) {
			if (level == digits.length())
				break;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String curr = q.poll();
				char[] letters = map.get(digits.charAt(level) - '0');
				for (int j = 0; j < letters.length; j++) {
					q.add(curr + letters[j]);
				}
			}
			level++;
		}

		res.addAll(q);

		return res;
	}

	public List<String> letterCombinationsDFS(String digits) {
		Map<Integer, char[]> map = new HashMap<>();
		map.put(2, new char[] { 'a', 'b', 'c' });
		map.put(3, new char[] { 'd', 'e', 'f' });
		map.put(4, new char[] { 'g', 'h', 'i' });
		map.put(5, new char[] { 'j', 'k', 'l' });
		map.put(6, new char[] { 'm', 'n', 'o' });
		map.put(7, new char[] { 'p', 'q', 'r', 's' });
		map.put(8, new char[] { 't', 'u', 'v' });
		map.put(9, new char[] { 'w', 'x', 'y', 'z' });

		if (digits.equals(""))
			return new ArrayList<>();

		List<String> res = new ArrayList<>();
		StringBuilder temp = new StringBuilder();

		backtrack(temp, 0, map, digits, res);

		return res;
	}

	private void backtrack(StringBuilder temp, int start, Map<Integer, char[]> map, String digits, List<String> res) {
		if (temp.length() == digits.length()) {
			res.add(temp.toString());
		}

		if (start == digits.length())
			return;

		char[] letters = map.get(digits.charAt(start) - '0');
		for (int i = 0; i < letters.length; i++) {
			temp.append(letters[i]);
			backtrack(temp, start + 1, map, digits, res);
			temp.deleteCharAt(temp.length() - 1);
		}

	}

	public List<String> letterCombinations(String digits) {
		String[] mappings = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		// steps
		// loop thru digits
		// get the mapping of the digit
		// add it to FIFO queue
		// keep polling from the head until the head reaches the length of
		// digits
		// pop the head of the q add chars from map to it
		LinkedList<String> ans = new LinkedList<>();
		ans.add("");
		while (ans.peek().length() != digits.length()) {
			String head = ans.remove();
			String map = mappings[digits.charAt(head.length()) - '0'];
			System.out.println(head);
			for (char c : map.toCharArray()) {
				// System.out.println("head" + " " + head);
				// System.out.println("" + " " + c);
				ans.addLast(head + c);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new LetterCombinationOfPhoneNumber().letterCombinationsBFS("23"));
	}
}

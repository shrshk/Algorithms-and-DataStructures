package leetcode30DayChallenge;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class StringShift {

	public String stringShift(String s, int[][] shift) {
		// [[0,1],[1,2]]
		// "abc"
		LinkedList<Character> list = new LinkedList<>();
		for (char c : s.toCharArray()) {
			list.add(c);
		}

		for (int[] item : shift) {
			int dir = item[0];
			int amount = item[1];
			shift(list, dir, amount);
		}

//		StringBuilder sb = new StringBuilder();
//		for (char r : list)
//			sb.append(r);

		return list.stream().map(String::valueOf).collect(Collectors.joining());
	}

	private void shift(LinkedList<Character> list, int dir, int amount) {
		// abc //bac
		while (amount-- > 0) {
			if (dir == 0) {
				list.addLast(list.removeFirst());
			}
			if (dir == 1) {
				list.addFirst(list.removeLast());
			}
		}

	}

	public static void main(String[] args) {
		String s = "abc";
		int[][] shift = new int[][] { { 0, 1 }, { 1, 2 } };
		System.out.println(new StringShift().stringShift(s, shift));
	}

}

package leetcode30DayChallenge.june;

import java.util.ArrayList;
import java.util.List;

//enum Status {
//	START,
//	DONE
//}

public class PermutationSequence {
	int count = 0;
	StringBuilder sb = new StringBuilder();
	String status = "start";

	public String getPermutation(int n, int k) {
		List<Integer> tmpList = new ArrayList<>();
		backtrack(n, k, tmpList, new boolean[n + 1]);

		return sb.toString();
	}

	private void backtrack(int n, int k, List<Integer> tmpList, boolean[] used) {
		if (status == "done")
			return;
		if (tmpList.size() == n) {
			count++;
			if (count == k) {
				buildString(tmpList);
				status = "done";
			}

			return;
		}

		for (int i = 1; i <= n; i++) {
			if (used[i])
				continue;
			used[i] = true;
			tmpList.add(i);
			backtrack(n, k, tmpList, used);
			used[i] = false;
			tmpList.remove(tmpList.size() - 1);
		}
	}

	private void buildString(List<Integer> tmpList) {
		for (int digit : tmpList)
			sb.append(digit);
	}

	public static void main(String[] args) {
		System.out.println(new PermutationSequence().getPermutation(3, 3));
	}
}

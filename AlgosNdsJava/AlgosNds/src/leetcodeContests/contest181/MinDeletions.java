package leetcodeContests.contest181;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinDeletions {
	public int solutionBF(String S, int[] C) {
		if (S == null || S.length() < 2)
			return 0;
		int i = 0, j = 1;
		int n = S.length();
		Map<Character, PriorityQueue<Integer>> map = new HashMap<>();
		while (i < n && j < n) {
			if (S.charAt(i) == S.charAt(j)) {
				PriorityQueue<Integer> indices = new PriorityQueue<>();
				indices.add(C[i]);
				map.put(S.charAt(i), indices);
				while (j < n && S.charAt(i) == S.charAt(j)) {
					PriorityQueue<Integer> indi = map.get(S.charAt(j));
					indi.add(C[j]);
					map.put(S.charAt(j), indi);
					j++;
				}
				i = j - 1;
			}
			i++;
			j++;
		}

		int res = 0;

		for (PriorityQueue<Integer> costs : map.values()) {
			while (costs.size() > 1) {
				res += costs.poll();
			}
		}

		return res;

	}

	public int solution(String S, int[] C) {
		if (S == null || S.length() < 2)
			return 0;
		int res = 0;
		int i = 0, j = 1;
		int n = S.length();
		while (i < n && j < n) {
			if (S.charAt(i) == S.charAt(j)) {
				PriorityQueue<Integer> pq = new PriorityQueue<>();
				pq.add(C[i]);
				while (j < n && S.charAt(i) == S.charAt(j)) {
					pq.add(C[j]);
					j++;
				}
				i = j - 1;
				while (pq.size() > 1) {
					res += pq.poll();
				}
			}
			i++;
			j++;

		}

		return res;

	}

	public static void main(String[] args) {
		System.out.println(new MinDeletions().solution("aabbccdd", new int[] { 1, 2, 1, 2, 1, 2, 1, 2 }));
	}
}

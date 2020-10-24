package leetcodeContests.contest178;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RankTeams {
	public String rankTeams(String[] votes) {
		String res = "";

		Map<Character, int[]> map = new HashMap<>();

		for (String vote : votes) {
			char[] chars = vote.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				int[] voteCount = map.getOrDefault(chars[i], new int[chars.length]);
				voteCount[i] += 1;
				map.put(chars[i], voteCount);
			}
		}

		Queue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
			public int compare(Character c1, Character c2) {
				int[] vote1 = map.get(c1);
				int[] vote2 = map.get(c2);
				int idx = 0;

				while (idx < vote1.length && idx < vote2.length) {
					if (vote1[idx] != vote2[idx]) {
						return vote2[idx] - vote1[idx];
					} else {
						idx++;
					}
				}

				return c1 - c2;
			};
		});

		for (Character c : map.keySet())
			pq.add(c);

		while (!pq.isEmpty()) {
			res += pq.poll();
		}

		return res;
	}

	public static void main(String[] args) {
		String[] votes = new String[] { "BCA", "CAB", "CBA", "ABC", "ACB", "BAC" };
		System.out.println(new RankTeams().rankTeams(votes));
	}
}

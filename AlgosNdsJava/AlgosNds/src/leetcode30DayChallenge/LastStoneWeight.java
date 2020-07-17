package leetcode30DayChallenge;

import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {
	public int lastStoneWeight(int[] stones) {

		Queue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
		for (int stone : stones)
			pq.add(stone);

		while (pq.size() > 1) {
			int first = pq.poll();
			int second = pq.poll();
			int comb = first - second;
			if (comb > 0)
				pq.add(comb);
		}

		return pq.isEmpty() ? 0 : pq.poll();
	}

	public static void main(String[] args) {
		int[] stones = new int[]{2,7,4,1,8,1};
		System.out.println(new LastStoneWeight().lastStoneWeight(stones));
	}
}

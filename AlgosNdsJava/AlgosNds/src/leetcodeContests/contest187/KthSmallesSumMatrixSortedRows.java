package leetcodeContests.contest187;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallesSumMatrixSortedRows {
	public int kthSmallest(int[][] mat, int k) {
		// steps
		// 2 pqs
		// 10,10,1
		// 10+5 10+4 10+1 .....
		//

		Queue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b - a));
		for (int item : mat[0]) {
			pq.add(item);
			if (pq.size() > k)
				pq.poll();
		}

		for (int i = 1; i < mat.length; i++) {
			int[] row = mat[i];
			Queue<Integer> nextPq = new PriorityQueue<Integer>((a, b) -> (b - a));
			for (int prev : pq) {
				for (int curr : row) {
					nextPq.add(prev + curr);
					if (nextPq.size() > k)
						nextPq.poll();
				}
			}

			pq = nextPq;

		}

		return pq.poll();

	}
}

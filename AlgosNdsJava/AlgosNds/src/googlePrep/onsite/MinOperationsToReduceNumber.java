package googlePrep.onsite;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class MinOperationsToReduceNumber {

	// overlapping subproblems solve it via bfs or dp.
	public int minOperations(int n) {
		int count = 0;
		while (n != 1) {
			n = n - 1;
			if (n % 2 == 0) {
				n = n / 2;
			} else if (n % 3 == 0) {
				n = n / 3;
			}
			count++;
		}

		return count;
	}

	public int steps(int n) {
		// steps
		// keep track of the number visited to not visit again
		// explore and add steps until you reach 1

		int steps = 0;
		Queue<Integer> q = new ArrayDeque<>();

		Set<Integer> set = new HashSet<>();

		q.add(n);
		set.add(n);

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int curr = q.poll();
				if (curr == 1)
					return steps;

				if (!set.contains(curr-1)) {
					q.add(curr - 1);
					set.add(curr-1);
				}

				if (curr % 2 == 0 && !set.contains(curr / 2)) {
					q.add(curr / 2);
					set.add(curr / 2);
				}

				if (curr % 3 == 0 && !set.contains(curr / 3)) {
					q.add(curr / 3);
					set.add(curr / 3);
				}

			}
			steps++;

		}

		return steps;

	}

	public static void main(String[] args) {
		System.out.println(new MinOperationsToReduceNumber().steps(9));
	}
}

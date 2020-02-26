package leetcodeContests.contest177;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class ClosestDivisors {
	public int[] closestDivisors(int num) {
		// 999 1000
		// 1000 1
		int num1 = num + 1;
		int num2 = num + 2;
		Queue<int[]> pq1 = new PriorityQueue<>(
				(int[] a, int[] b) -> (Math.abs((a[0] - a[1])) - Math.abs((b[0] - b[1]))));
		for (int i = 1; i <= num1; i++) {
			if (num1 % i == 0) {
				pq1.add(new int[] { i, num1 / i });
			}
		}

		Queue<int[]> pq2 = new PriorityQueue<>(
				(int[] a, int[] b) -> (Math.abs((a[0] - a[1])) - Math.abs((b[0] - b[1]))));
		for (int i = 1; i <= num2; i++) {
			if (num2 % i == 0) {
				pq2.add(new int[] { i, num2 / i });
			}
		}

		int[] first = pq1.poll();
		int[] second = pq2.poll();

		return Math.abs(first[0] - first[1]) < Math.abs(second[0] - second[1]) ? first : second;

	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new ClosestDivisors().closestDivisors(999)));
	}
}

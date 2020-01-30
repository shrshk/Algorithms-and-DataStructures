package facebookPrep.arraysAndStrings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class LocComparator implements Comparator<int[]> {

	@Override
	public int compare(int[] o1, int[] o2) {
		int x1 = o1[0];
		int x2 = o2[0];
		int y1 = o1[1];
		int y2 = o2[1];
		double distance1 = Math.sqrt((y1 - 0) * (y1 - 0) + (x1 - 0) * (x1 - 0));
		double distance2 = Math.sqrt((y2 - 0) * (y2 - 0) + (x2 - 0) * (x2 - 0));

		if (distance1 > distance2)
			return 1;
		else if (distance1 < distance2)
			return -1;
		return 0;
	}

}

public class KclosestPointsToOrigin {
	public int[][] kClosest(int[][] points, int K) {

		int[][] res = new int[K][];
		Queue<int[]> pq = new PriorityQueue<>(new LocComparator());

		for (int[] loc : points) {
			pq.add(loc);
			if (pq.size() > K)
				pq.poll();
		}

		for (int i = 0; i < K; i++) {
			res[i] = pq.poll();
			System.out.println(Arrays.toString(res[i]));
		}

		return res;
	}

	public int[][] kClosestOpt(int[][] points, int K) {
		Queue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] p1, int[] p2) {
				return distance(p2) - distance(p1);
			}
		});
		for (int[] p : points) {
			pq.add(p);
			if (pq.size() > K)
				pq.poll();
		}
		// int[][] res = new int[K][2];
		// while (K > 0) {
		// res[--K] = pq.poll();
		// System.out.println(Arrays.toString(res[K]));
		// }
		return pq.toArray(new int[K][2]);
	}

	private int distance(int[] point) {
		return point[0] * point[0] + point[1] * point[1];
	}

	public static void main(String[] args) {
		// points = [[1,3],[-2,2]], K = 1
		// [[2,10],[-9,-9],[0,8],[-2,-2],[8,9],[-10,-7],[-5,2],[-4,-9]]
		int[][] points = new int[][] { { 2, 10 }, { -9, -9 }, { 0, 8 }, { -2, -2 }, { 8, 9 }, { -10, -7 }, { -5, 2 },
				{ -4, -9 } };

		int[][] res = new KclosestPointsToOrigin().kClosestOpt(points, 7);

		for (int[] pt: res)
			System.out.println(Arrays.toString(pt));
	}
}

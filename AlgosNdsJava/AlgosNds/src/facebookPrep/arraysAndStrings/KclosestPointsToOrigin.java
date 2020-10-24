package facebookPrep.arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class PairInt {
	int first, second;

	PairInt() {

	}

	PairInt(int first, int second) {
		this.first = first;
		this.second = second;
	}
}

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
	public List<PairInt> closestLocations(int totalCrates, List<PairInt> allLocations, int truckCapacity) {

		if (allLocations == null || allLocations.isEmpty()) {
			List<PairInt> emptyList = new ArrayList<>();
			for (int i = 0; i < truckCapacity; i++) {
				emptyList.add(new PairInt());
			}
			return emptyList;
		}

		int len = allLocations.size(), l = 0, r = len - 1;
		while (l <= r) {
			int mid = helper(allLocations, l, r);
			if (mid == truckCapacity)
				break;
			if (mid < truckCapacity) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return allLocations.subList(0, truckCapacity);
	}

	private int helper(List<PairInt> A, int l, int r) {
		PairInt pivot = A.get(l);
		while (l < r) {
			while (l < r && compare(A.get(r), pivot) >= 0)
				r--;
			A.set(l, A.get(r));
			while (l < r && compare(A.get(l), pivot) <= 0)
				l++;
			A.set(r, A.get(l));
		}
		A.set(l, pivot);
		return l;
	}

	private int compare(PairInt p1, PairInt p2) {
		return p1.first * p1.first + p1.second * p1.second - p2.first * p2.first - p2.second * p2.second;
	}

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

	public List<PairInt> closestLocationsOld(int totalCrates, List<PairInt> allLocations, int truckCapacity) {

		if (allLocations == null || allLocations.isEmpty()) {
			List<PairInt> emptyList = new ArrayList<>();
			for (int i = 0; i < truckCapacity; i++) {
				emptyList.add(new PairInt());
			}
			return emptyList;
		}

		Queue<PairInt> pq = new PriorityQueue<PairInt>(
				(PairInt p1, PairInt p2) -> distanceTruck(p2) - distanceTruck(p1));
		for (PairInt p : allLocations) {
			pq.add(p);
			if (pq.size() > truckCapacity)
				pq.poll();
		}

		return new ArrayList<>(pq);

	}

	private int distanceTruck(PairInt point) {
		return point.first * point.first + point.second * point.second;
	}

	public int[][] kClosestOpt(int[][] points, int K) {
		// Queue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
		// @Override
		// public int compare(int[] p1, int[] p2) {
		// return distance(p2) - distance(p1);
		// }
		// });
		Queue<int[]> pq = new PriorityQueue<int[]>((int[] p1, int[] p2) -> distance(p2) - distance(p1));
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
		// int[][] points = new int[][] { { 2, 10 }, { -9, -9 }, { 0, 8 }, { -2,
		// -2 }, { 8, 9 }, { -10, -7 }, { -5, 2 },
		// { -4, -9 } };
		//
		// int[][] res = new KclosestPointsToOrigin().kClosestOpt(points, 7);
		// List<Integer> list = new ArrayList<>();
		// System.out.println(list.isEmpty());
		//
		// for (int[] pt : res)
		// System.out.println(Arrays.toString(pt));
		//
		int truckCapacity = 2;
		int totalCrates = 3;
		//
		List<PairInt> allLocations = Arrays.asList(new PairInt(1, 2), new PairInt(3, 4), new PairInt(1, -1));
		List<PairInt> ans = new KclosestPointsToOrigin().closestLocations(totalCrates, allLocations, truckCapacity);
		for (PairInt pI : ans)
			System.out.println(pI.first + " " + pI.second);

	}
}

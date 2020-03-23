package microsoftOnlineAssessmentPrep;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxNetworkRank {

	public int maxNetworkRank(int[] A, int[] B, int N) {
		int res = 0;
		Map<Integer, Set<Integer>> map = new HashMap<>();
		int i = 0, j = 0;
		while (i < N && j < N) {
			Set<Integer> vals1 = map.getOrDefault(A[i], new HashSet<>());
			Set<Integer> vals2 = map.getOrDefault(B[j], new HashSet<>());
			vals1.add(B[j]);
			vals2.add(A[i]);
			map.put(A[i], vals1);
			map.put(B[j], vals2);
			i++;
			j++;
		}
		
		for (int idx=0; idx<N; idx++) {
			Set<Integer> temp = new HashSet<>();
			temp.addAll(map.get(A[idx]));
			temp.addAll(map.get(B[idx]));
			res = Math.max(res, temp.size());
		}

		return res;
	}

	public static void main(String[] args) {
		// 1,2,3,3 // 2 3 1 4
		// (1,2) (2,3) (3,1) (3,4)
		// 1: {2,3}
		// 2: {1,3}
		// 3: {1,2,4}
		// 4: {3}
		int[] A = new int[] { 1, 2, 3, 3 };
		int[] B = new int[] { 2, 3, 1, 4 };
		int N = 4;

		System.out.println(new MaxNetworkRank().maxNetworkRank(A, B, N));
	}
}

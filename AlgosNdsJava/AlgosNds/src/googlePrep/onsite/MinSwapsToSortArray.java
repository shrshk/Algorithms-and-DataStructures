package googlePrep.onsite;

import java.util.HashMap;
import java.util.Map;

public class MinSwapsToSortArray {

	public int minSwaps(int[] arr) {

		boolean isVisited[] = new boolean[arr.length + 1];

		Map<Integer, Integer> nodeMap = new HashMap<Integer, Integer>();

		for (int i = 1; i < isVisited.length; i++) {
			nodeMap.put(i, arr[i - 1]);
		}
		
		// 4 3 2 1
		
		// { 1:4, 2:3, 3:2 1:4 }
		
		// k  
		
		int countSwap = 0;

		for (int k = 1; k <= nodeMap.size(); k++) {

			//int nextNode;

			if (isVisited[k] == false) {
				isVisited[k] = true;

				if (k == nodeMap.get(k)) {
					continue;
				} else {
					int c = nodeMap.get(k);
					while (!isVisited[c]) {

						isVisited[c] = true;

						//nextNode = nodeMap.get(c);
						//c = nextNode;
						++countSwap;
					}
				}

			}
		}

		return countSwap;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1,2,3,5,4 };
		System.out.println(new MinSwapsToSortArray().minSwaps(arr));
	}
}
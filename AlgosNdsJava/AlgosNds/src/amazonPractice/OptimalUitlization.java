package amazonPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

Input:
a = [[1, 3], [2, 5], [3, 7], [4, 10]]
b = [[1, 2], [2, 3], [3, 4], [4, 5]]

*/

public class OptimalUitlization {
	public List<List<Integer>> optimalUtilization(int maxCapacity, List<List<Integer>> fList,
			List<List<Integer>> rList) {
		Map<Integer, List<List<Integer>>> resultMap = new HashMap<>();
		Collections.sort(fList, (f1, f2) -> (f1.get(1) - f2.get(1)));
		Collections.sort(rList, (r1, r2) -> (r1.get(1) - r2.get(1)));

		int f = fList.size();
		int r = rList.size();
		int fIdx = 0;
		int rIdx = r - 1;

		int maxPossibleCapacity = Integer.MIN_VALUE;

		while (fIdx < f && rIdx >= 0) {
			int sumCapacity = fList.get(fIdx).get(1) + rList.get(rIdx).get(1);
			if (sumCapacity > maxCapacity) {
				--rIdx;
				continue;
			}
			if (maxPossibleCapacity <= sumCapacity) {
				List<List<Integer>> pairs = resultMap.get(sumCapacity) == null ? new ArrayList<>()
						: resultMap.get(sumCapacity);
				pairs.add(Arrays.asList(fList.get(fIdx).get(0), rList.get(rIdx).get(0)));
				maxPossibleCapacity = sumCapacity;
				// add similar pairs
				for (int index = rIdx - 1; index >= 0
						&& rList.get(index).get(1) == rList.get(index + 1).get(1); index--) {
					pairs.add(new ArrayList<>(Arrays.asList(fList.get(fIdx).get(0), rList.get(index).get(0))));
				}
				resultMap.put(sumCapacity, pairs);
			}
			++fIdx;
		}

		return resultMap.get(maxPossibleCapacity);
	}

	public static void main(String[] args) {
		// [1, 3], [2, 5], [3, 7], [4, 10] b = [[1, 2], [2, 3], [3, 4], [4, 5]]
		// [[1, 2], [2, 4], [3, 6]] [[1, 2]]
		 List<List<Integer>> fList =
		 Arrays.asList(Arrays.asList(1,3),Arrays.asList(2,3),
		 Arrays.asList(3,3),Arrays.asList(4,3));
		 List<List<Integer>> rList =
		 Arrays.asList(Arrays.asList(1,3),Arrays.asList(2,3),
				 Arrays.asList(3,3),Arrays.asList(4,3));
//		List<List<Integer>> fList = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 4), Arrays.asList(3, 6),
//				Arrays.asList(1, 2));
//		List<List<Integer>> rList = Arrays.asList(Arrays.asList(1, 2));
		System.out.println(new OptimalUitlization().optimalUtilization(6, fList, rList));

	}
}

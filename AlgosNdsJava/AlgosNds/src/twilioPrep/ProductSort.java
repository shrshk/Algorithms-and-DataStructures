package twilioPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductSort {

	public int[] itemSort(int[] input) {
		// 4 4 5 5
		// 4 5 6 5 4 3

		int[] res = new int[input.length];

		Map<Integer, Integer> map = new HashMap<>();

		List<Integer> nums = new ArrayList<>();

		for (int num : input) {
			nums.add(num);
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		nums.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer n1, Integer n2) {
				if (map.get(n1) > map.get(n2)) {
					return 1;
				} else if (map.get(n1) < map.get(n2)) {
					return -1;
				}
				return n1-n2;
			}
		});
		int idx = 0;
		for (int item : nums) {
			res[idx++] = item;
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new ProductSort().itemSort(new int[]{8,5,5,5,5,1,1,1,4,4})));
	}
}

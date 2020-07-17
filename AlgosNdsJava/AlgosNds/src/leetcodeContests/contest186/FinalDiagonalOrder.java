package leetcodeContests.contest186;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinalDiagonalOrder {
	public int[] findDiagonalOrder(List<List<Integer>> nums) {
		// steps
		// diagonal has same r+c count
		Map<Integer, List<Integer>> map = new HashMap<>();
		int maxCol = 0;
		int n = 0;
		int rows = nums.size() - 1;
		for (int r = rows; r >= 0; r--) {
			int col = nums.get(r).size();
			maxCol = Math.max(maxCol, col);
			n += col;
			for (int c = 0; c < col; c++) {
				map.putIfAbsent(r + c, new ArrayList<>());
				map.get(r + c).add(nums.get(r).get(c));
			}
		}

		int[] output = new int[n];
		int idx = 0;

		for (int key = 0; key <= rows + maxCol; key++) {
			List<Integer> items = map.get(key);
			if (items != null) {
				for (int item : items) {
					output[idx++] = item;
				}
			}
		}

		return output;
	}

	public int[] findDiagonalOrderTLE(List<List<Integer>> nums) {
		int height = nums.size();
		int width = 0;
		for (List<Integer> list : nums)
			width = Math.max(width, list.size());
		List<Integer> res = new ArrayList<>();

		for (int i = 0; i < height; i++) {
			int x = i;
			int y = 0;
			while (x >= 0 && y < width) {
				if (x >= 0 && y < width) {
					List<Integer> curr = nums.get(x);
					if (y < curr.size()) {
						res.add(curr.get(y));
					}

				}
				x = x - 1;
				y = y + 1;
			}
		}

		for (int j = 1; j < width; j++) {
			int x = height - 1;
			int y = j;
			while (x >= 0 && y < width) {
				if (x >= 0 && y < width) {
					List<Integer> curr = nums.get(x);
					if (y < curr.size()) {
						res.add(curr.get(y));
					}

				}
				x = x - 1;
				y = y + 1;
			}
		}

		int[] output = new int[res.size()];
		for (int i = 0; i < output.length; i++) {
			output[i] = res.get(i);
		}

		return output;
	}

	public static void main(String[] args) {
		List<List<Integer>> nums = Arrays.asList(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(6, 7), Arrays.asList(8),
				Arrays.asList(9, 10, 11), Arrays.asList(12, 13, 14, 15, 16));
		System.out.println(Arrays.toString(new FinalDiagonalOrder().findDiagonalOrder(nums)));
	}
}

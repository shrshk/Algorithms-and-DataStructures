package amazonLeetCode.phonescreen;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int maxCount = 1;
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}

		for (int num : nums) {
			if (set.remove(num)) {
				int temp = num;
				int count = 1;
				while (set.remove(temp - 1)) {
					temp--;
				}
				count += num - temp;
				temp = num;
				while (set.remove(temp + 1)) {
					temp++;
				}
				count += temp - num;
				maxCount = Math.max(count, maxCount);
			}

		}

		return maxCount;
	}

}

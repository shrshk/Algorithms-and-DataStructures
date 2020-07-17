package leetcodeContests.contest182;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountTeams {

	public int numTeams(int[] rating) {

		List<int[]> ratingList = new ArrayList<>();

		for (int i = 0; i < rating.length; i++) {
			ratingList.add(new int[] { i, rating[i] });
		}

		Collections.sort(ratingList, (r1, r2) -> (r1[1] - r2[1]));

		int i = 0, j = 1;
		int n = ratingList.size();
		int count = 0;
		while (i < n) {
			int[] curr = ratingList.get(i);
			int tempCount = 1;
			while (j < n && tempCount < 3) {
				int[] next = ratingList.get(j);
				if (next[0] > curr[0] && next[1] > curr[1])
					tempCount++;
				j++;
			}
			if (tempCount == 3)
				count++;
			i++;
			j = i + 1;
		}
		
		i=n-1;
		j=n-2;
		
		while (i > 0) {
			int[] curr = ratingList.get(i);
			int tempCount = 1;
			while (j >=0 && tempCount < 3) {
				int[] next = ratingList.get(j);
				if (next[0] < curr[0] && next[1] < curr[1])
					tempCount++;
				j--;
			}
			if (tempCount == 3)
				count++;
			i--;
			j = i - 1;
		}

		// [2,5,3,4,1]
		// 2: [1]
		// 2: [3,4]

		return count;
	}

	public static void main(String[] args) {
		// rating = [2,5,3,4,1]
		// 2 5 3 [4,1][]
		// [1,2,3,4,5]
		// 4 0 2 3 1 2
		// 1 2 3 4 1 * 1 *
		int[] rating = new int[]{2,5,3,4,1};
		System.out.println(new CountTeams().numTeams(rating));

	}
}

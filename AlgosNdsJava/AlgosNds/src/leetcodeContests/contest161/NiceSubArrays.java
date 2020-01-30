package leetcodeContests.contest161;

public class NiceSubArrays {
	public int niceSubArr(int[] nums, int k) {
		// [1,1,2,1,1]
		// [1,1,2,1] // [1,2,1,1]
		// 0 1 3 4
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int odd = 0;
			for (int j = i; j < nums.length; j++) {
				if (nums[j] % 2 != 0)
					odd++;
				if (odd == k)
					count++;
			}
		}

		return count;
	}

	public int niceSubOpt(int[] nums, int k) {
		// steps
		
		// build a prefix arr 
		// for index with odd num  inc. oddCount
		// odd-k will give a subArr containing k odd elements
		int count = 0;
		int n = nums.length;
		int prefix[] = new int[n];
		int odd = 0;

		for (int i = 0; i < n; i++) {
			prefix[odd]++;

			if ((nums[i] & 1) == 1)
				odd++;

			if (odd >= k)
				count += prefix[odd - k];
		}

		return count;
	}

	public static void main(String[] args) {
		 System.out.println(new NiceSubArrays().niceSubOpt(new int[] { 1, 1, 2, 1, 1, 4 }, 3));
		//System.out.println(9 & 1);
	}
}

// 

// "xx", s2 = "yy"

// s1 = "xxyyxyxyxx", s2 = "xyyxyxxxyx"

// [1,1,2,1,1], k = 3

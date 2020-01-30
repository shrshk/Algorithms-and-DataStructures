package leetcode.patterns.slidingWindow;

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
	
	public int numberOfSubarrays(int[] A, int k) {
        return atMost(A, k) - atMost(A, k - 1);
    }

    public int atMost(int[] A, int k) {
        int res = 0, i = 0, n = A.length;
        for (int j = 0; j < n; j++) {
            k -= A[j] % 2;
            while (k < 0)
                k += A[i++] % 2;
            res += j - i + 1;
        }
        return res;
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


package leetcode.shirishFavsList;

public class ClimbingStairs {
	static int fibNumber(int n) {
		return fibNumber(n, new int[n+1]);
	}
	
	static int fibNumber(int n, int[] memo) {
		if (n<0)
			return 0;
		if (n<=1)
			return 1;
		if(memo[n]==0)
			memo[n] = fibNumber(n-1, memo) + fibNumber(n-2, memo);
		return memo[n];
	}
	
	public static void main(String[] args) {
		System.out.println(fibNumber(4));
	}
}

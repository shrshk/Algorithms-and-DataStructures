package leetcode.shirishFavsList;

public class FactorialTrailingZeros {
	static int trailingZeroes(int n) {
		int count=0;
		while (n!=0) {
			count+=n/5;
			n=n/5;
		}
		return count;
	}
	
	static int findFactorial(int n) {
		int result;
		if (n==1 || n==0)
			return 1;
		result = findFactorial(n-1) * n;
		return result;
	}
	
	int fact(int n)
    {
        int result;
       if(n==0 || n==1)
         return 1;

       result = fact(n-1) * n;
       return result;
    }
	
	int factorial(int n) {
		int result=1;
		for (int i=2; i<=n; i++) {
			result = i * result;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(new FactorialTrailingZeros().factorial(10)); // 13 * 12 * 11 * 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1
	}
}

package leetcodeContests.contest184;

public class NumWays {
    public int numOfWays(int n) {
        int MOD = (int) (1e9 + 7);
        long a121 = 6, a123 = 6, b121, b123;
        // 3 : 2 2
        // 2 2 3
        for (int i=1; i<n; i++) {
        	b123 = a121 * 2 + a123 * 2;
        	b121 = a121 * 3 + a123 * 2;
        	a121 = b121 % MOD;
        	a123 = b123 % MOD;
        }
        return (int) (a121+a123)%MOD;
    }
    
    public static void main(String[] args) {
		System.out.println(new NumWays().numOfWays(2));
	}
}

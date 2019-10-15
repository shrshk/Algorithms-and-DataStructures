package leetcodeContests;

public class BalancedStringSplit {

	static int balancedStringSplit(String s) {
		char[] chars = s.toCharArray();
		int n = chars.length;
		int count = 0;
		// RL RRLL RLRL
		// RL {R:2, L:2} // R == L
		int rCount = 0;
		int lCount = 0;

		for (int i = 0; i < n; i++) {
			if (chars[i] == 'R')
				rCount++;
			if (chars[i] == 'L')
				lCount++;
			if (lCount == rCount) {
				count++;
				lCount = 0;
				rCount = 0;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(balancedStringSplit("LLLLRRRR"));
	}

}

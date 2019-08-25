package leetcode.shirishFavsList;

public class EqualPairOfBits {
	static int equalPairOfBits(int n, int m) {
		return n+m+1 & -m-1-n;
	}
	
	public static void main(String[] args) {
		System.out.println(equalPairOfBits(10, 11));
	}
}

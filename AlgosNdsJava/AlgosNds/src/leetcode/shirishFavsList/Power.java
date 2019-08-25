package leetcode.shirishFavsList;

public class Power {
	static boolean isPowerOf(int x, int y) {
		if (x==1)
			return y==1;
		int pow = 1;
		while(pow < y) {
			pow = pow * x;
		}
		return pow == y;
	}
	
	public static void main(String[] args) {
		System.out.println(isPowerOf(2,128));
	}
}

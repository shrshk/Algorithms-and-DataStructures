package leetcode.shirishFavsList;

public class Sum2Integers {
	static int sumTwoIntegers(int a, int b) {
		while (b!=0){
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		return a;
	}
	public static void main(String[] args) {
		System.out.println(sumTwoIntegers(15, 5));
	}
}

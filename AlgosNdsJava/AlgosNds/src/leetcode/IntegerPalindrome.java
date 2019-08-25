package leetcode;

public class IntegerPalindrome {
	static boolean isIntPalindrome(int x) {
		if (x<0 || (x!=0 && x%10==0)) return false;
		int rev = 0;
		// 123 
		while(x>rev){
			rev = rev*10 + x%10;
			x = x/10;
		}
		System.out.println(x);
		System.out.println(rev);
		return x==rev || x==rev/10;
	}
	public static void main(String[] args) {
		System.out.println(isIntPalindrome(1001));
	}
}

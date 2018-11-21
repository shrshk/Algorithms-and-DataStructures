package leetcode;

public class ReverseInteger {
	public static int reverse(int x) {
        String ans = x < 0 ? new StringBuilder(String.valueOf(-x)).append("-").reverse().toString()
                : new StringBuilder(String.valueOf(x)).reverse().toString();
        try {
            return Integer.parseInt(ans);
        } catch (Exception e) {
            return 0;
        }
    }
	
	public static boolean isPalindrome(int x) {
		if (x == reverse(x)) {
			return true;
		}
		return false;
	}

  
  public static void main(String[] args) {
	System.out.println(isPalindrome(121));
}
}


//public static int reverseInterger(int x) {
//	 int reverseNum = 0;
//	 while(x!=0) {
//		 reverseNum = reverseNum * 10 + x%10;
//		 x = x/10;
//	 }
//	 return reverseNum;
//}
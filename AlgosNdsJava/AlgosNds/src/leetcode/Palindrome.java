package leetcode;

public class Palindrome {
	public boolean isPalindrome(String s) {
		s = s.replaceAll("[^A-Za-z0-9]", "").trim().toLowerCase();
		System.out.println(s);
		char[] rev = new char[s.length()];
		for(int i=s.length()-1, j=0; i>=0 & j<s.length();i--) {
			rev[j] = s.charAt(i);
			j++;
		}
		String revStr = new String(rev);
		System.out.println(revStr);
		if(s.equals(revStr)) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(new Palindrome().isPalindrome("race a car"));
	}
}

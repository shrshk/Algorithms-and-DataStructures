package facebookPrep.arraysAndStrings;

public class ValidPalindromee {
	public boolean isPalindrome(String s) {
		s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        if (s.equals(""))
            return true;
		int n = s.length();
		int left=0, right = n-1;
		
		while (left<n && right>=0) {
			if(s.charAt(left++)!=s.charAt(right--))
				return false;
		}	
		
		return true;
	}
	
	public boolean validPalindrome(String s) {
		int n = s.length();
		int left=0, right=n-1;
		
		while(left<n && right>=0) {
			if (s.charAt(left)==s.charAt(right)) {
				left++;
				right--;
			} else {
				return checkPalindrome(s, left+1, right) || checkPalindrome(s, left, right-1);
			}
		} 
		
		return true;

	}
	
	private boolean checkPalindrome(String s, int left, int right) {
		while(left<=right) {
			if (s.charAt(left)==s.charAt(right)) {
				left++;
				right--;
			} else {
				return false;
			}
		}
		return true;
	}
	
	

	public static void main(String[] args) {
		System.out.println(new ValidPalindromee().validPalindrome("abca")); // a b c a   a 
	}

}

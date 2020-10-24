package amazonPractice;

public class BackspaceStringCompare {
	// S = "ab#c", T = "ad#c"
	// c1 = 1    c2=1
	public boolean backspaceCompare(String S, String T) {
		int m=S.length(); int n=T.length();
		
		int i=m-1, j=n-1;
		int cnt1=0, cnt2=0;
		
		while(i>=0 || j>=0) {
			while(i>=0 && (S.charAt(i) == '#' || cnt1>0)) {
				if (S.charAt(i) == '#') {
					cnt1++;
				} else {
					cnt1--;
				}
				i--;
			}
			
			while(j>=0 && (T.charAt(j) == '#' || cnt2>0)) {
				if (T.charAt(j) == '#') {
					cnt2++;
				} else {
					cnt2--;
				}
				j--;
			}
			
			if (i>=0 && j>=0 && S.charAt(i) == T.charAt(j)) {
				i--;
				j--;
			} else {
				return i==-1&&j==-1;
			}
			
		}
		
		
		return true;
	}
}

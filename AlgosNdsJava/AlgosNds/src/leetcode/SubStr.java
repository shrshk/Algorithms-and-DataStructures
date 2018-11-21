package leetcode;

public class SubStr {
	
	public static int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if(len2 == 0) {
            return 0;
        }
        for(int i=0, j=0; i<len1 && j<len2; i++) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                if(j==len2-1) {
                    return i-len2+1;
                }
                j++;
            } else {
                i=i-j;
                j=0;
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		System.out.println(strStr("mississippi", "issip")); // "mississippi" 		"issip"
	}
}

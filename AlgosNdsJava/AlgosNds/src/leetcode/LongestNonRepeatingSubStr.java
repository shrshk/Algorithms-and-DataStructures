package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatingSubStr {
	static int nonRepeatingSubStr(String s) {
		int i=0,j=0; //geeksForGeeks
		int maxLen = 0;
		String res = "";
		while(i<s.length()) {
			if(res.indexOf(s.charAt(i))!=-1) {
				res+=s.charAt(i);
				i++;
				j++;
			} else {
				j=i-j+1;
				i++;
				if (maxLen < i-j+1) {
					maxLen = i-j+1;
				}
				
			}
				
		}
		return maxLen;
//		int n = s.length(), ans = 0;
//        Map<Character, Integer> map = new HashMap<>(); // current index of character
//        // try to extend the range [i, j]
//        for (int j = 0, i = 0; i < n; i++) {
//            if (map.containsKey(s.charAt(i))) {
//                j = Math.max(map.get(s.charAt(i)), j); // baab
//            }
//            ans = Math.max(ans, i - j + 1);
//            map.put(s.charAt(i), i + 1);
//        }
//        return ans;
	}
	public static void main(String[] args) {
		System.out.println(nonRepeatingSubStr("geeksforgeeks"));
	}
}

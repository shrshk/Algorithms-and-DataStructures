package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStringWithoutRepeat {
	static int subStrNoRepeat(String s) {
		int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, j = 0, i = 0;
        while (j < n && i < n) {
        	System.out.println(Arrays.toString(set.toArray()));
            // try to extend the range [i, j]
            if(!set.contains(s.charAt(i))) {
            	set.add(s.charAt(i++));
            	if(ans<i-j)
            		ans = i-j;
            } else {
            	set.remove(s.charAt(j++));
            }
        }
        return ans;
	}
	
    public int lengthOfLongestSubstring(String s) {
        int ans=0, left=0;
        int n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        for (int right=0; right<n; right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)));
            }
            
            ans = Math.max(right-left+1, ans);
            map.put(s.charAt(right), right+1);    
        }
       
       return ans;
   }
    
	public static void main(String[] args) {
		//abcabcbb
		System.out.println(subStrNoRepeat("dvddf"));
	}
}
//
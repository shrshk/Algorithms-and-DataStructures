package facebookPrep.mockTests.two;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringAtMostK {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Set<Character> set = new HashSet<>();
        int i=0;
        int j=i;
        int max=0;
        while (i<s.length() && j<s.length()) {
            char current = s.charAt(j);
            if (!set.contains(current)) {
                set.add(current);      
            }
            
            if (set.size()>k) {
                set = new HashSet<>();
                i++;
                j=i;
            }else {
            	max = Math.max(max, j-i+1);
                j++;           
            }            
        }
        
        return max;
        
    }
    
    public static void main(String[] args) {
		System.out.println(new LongestSubStringAtMostK().lengthOfLongestSubstringKDistinct("a", 0));
	}
}

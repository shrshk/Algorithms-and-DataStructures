package googlePrep.phonescreen;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
	public String minWindow(String s, String t) {
        // S = "ADOBEC ODEBANC", T = "ABC"
     // steps
		// make a map of t chars
		// swipe thru S to find the window with all t chars
		// while loop thru s and adjust map and counter accordingly
		// when counter is 0 i.e. all chars in t are found
		// update minLen
		// reset map and move to start till the counter is 0
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c: s.toCharArray()) {
            map.put(c,0);
        }
        
        for (char c: t.toCharArray()) {
            if (map.containsKey(c))
                map.put(c,map.get(c)+1);
            else
                return "";
        }
        
        int i=0, j=0, counter=0, minStart = 0, minLen = Integer.MAX_VALUE;
        
        while(j<s.length()) {
            char c1 = s.charAt(j);
            if (map.get(c1)>0) {
                counter++;                               
            }
            map.put(c1, map.get(c1)-1);  // ADOBEC ODEBANC // 1 -1 -1 0 -1 0 2
            
            while (counter == t.length()) {
                char c2 = s.charAt(i);
                if (minLen>j-i+1) {
                    minLen = j-i+1;
                    minStart = i;
                }
                map.put(c2, map.get(c2)+1);
                    
                if (map.get(c2)>0)
                    counter--;
                i++;
            }
            j++;            
        } 
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart+minLen);
	}
	
	public static void main(String[] args) {
		// S = "ADOBEC ODEBANC", T = "ABC"
		String s = "ADOBEC ODEBANC";
		String t = "ABC";
		System.out.println(new MinWindowSubstring().minWindow(s, t));
	}
}

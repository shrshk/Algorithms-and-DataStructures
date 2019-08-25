package leetcode;

import java.util.HashMap;

public class MinWindow {
	public String minWindow(String s, String t) {
	    HashMap<Character,Integer> map = new HashMap<>();
	    for(char c : s.toCharArray())
	        map.put(c,0);
	    for(char c : t.toCharArray())
	    {
	        if(map.containsKey(c))
	            map.put(c,map.get(c)+1);
	        else
	            return "";
	    }
	    
	    int start =0, end=0, minStart=0,minLen = Integer.MAX_VALUE, counter = t.length();
	    while(end < s.length())
	    {
	        char c1 = s.charAt(end);
	        if(map.get(c1) > 0)
	            counter--;
	        map.put(c1,map.get(c1)-1);
	        
	        end++;
	        
	        while(counter == 0)
	        {
	            if(minLen > end-start)
	            {
	                minLen = end-start;
	                minStart = start;
	            }
	            
	            char c2 = s.charAt(start);
	            map.put(c2, map.get(c2)+1);
	            
	            if(map.get(c2) > 0)
	                counter++;
	            
	            start++;
	        }
	    }
	    return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart,minStart+minLen);
	}
	
	public static void main(String[] args) {
		System.out.println(new MinWindow().minWindow("xyyzzyx", "xyz"));
	}
}

package leetcode.shirishFavsList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {
	static List<Integer> findnagrams(String s, String p) {
		List<Integer> indexes = new ArrayList<>();
		if(s.isEmpty() || p.length()>s.length()) return indexes;
		Map<Character,Integer> pHash = new HashMap<>();
		for(char c: p.toCharArray()) {
			if(pHash.containsKey(c)) {
				pHash.put(c, pHash.get(c)+1);
			} else {
				pHash.put(c, 1);
			}
		}
		
		int numberOfCharsToBeZero = pHash.keySet().size();
		
		for(int i=0;i<p.length();i++) {
			char c = s.charAt(i);
			if(pHash.containsKey(c)) {
				int value = pHash.get(c)-1;
				pHash.put(c, value);
				if(value==0) numberOfCharsToBeZero--;
			}
		}
		if(numberOfCharsToBeZero==0) indexes.add(0);
		int start=0;
		int end=p.length()-1;
		while(end<s.length()-1) {
			char startChar = s.charAt(start++);
			char endChar = s.charAt(++end);
			if(pHash.containsKey(startChar)) {
				if(pHash.get(startChar)==0) numberOfCharsToBeZero++;
				pHash.put(startChar, pHash.get(startChar)+1);
			}
			if(pHash.containsKey(endChar)) {
				pHash.put(endChar, pHash.get(endChar)-1);
				if(pHash.get(endChar)==0) numberOfCharsToBeZero--;
			}
			if(numberOfCharsToBeZero==0) indexes.add(start);
		}
		return indexes;
	}
	
	public List<Integer> findAnagrams(String s, String p) {
	    List<Integer> list = new ArrayList<>();
	    if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
	    int[] hash = new int[256]; //character hash
	    //record each character in p to hash
	    for (char c : p.toCharArray()) {
	        hash[c]++;
	    }
	    //two points, initialize count to p's length
	    int left = 0, right = 0, count = p.length();
	    while (right < s.length()) {
	        //move right everytime, if the character exists in p's hash, decrease the count
	        //current hash value >= 1 means the character is existing in p
	        if (hash[s.charAt(right++)]-- >= 1) count--; 
	        
	        //when the count is down to 0, means we found the right anagram
	        //then add window's left to result list
	        if (count == 0) list.add(left);
	    
	        //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
	        //++ to reset the hash because we kicked out the left
	        //only increase the count if the character is in p
	        //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
	        if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
	    }
	    return list;
	}
}

package leetcode.TopInterviewQuestions.Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {
	static boolean anagram(String s1, String s2) {
		if (s1.length()!=s2.length())
			return false;
		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();
		for(int i=0; i<s1.length(); i++) {
			if (!map1.containsKey(s1.charAt(i)))
				map1.put(s1.charAt(i), 1);
			else 
				map1.put(s1.charAt(i), map1.get(s1.charAt(i))+1);
		}
		for(int j=0;j<s2.length();j++) {
			if (!map2.containsKey(s2.charAt(j)))
				map2.put(s2.charAt(j), 1);
			else 
				map2.put(s2.charAt(j), map2.get(s2.charAt(j))+1);
		}
		return map1.equals(map2);
	}
	static int NO_OF_CHARS = 256; 
	static boolean isAnagram(String str1, String str2) {
		int count[] = new int[NO_OF_CHARS]; 
		Arrays.fill(count, 0); 
	    int i; 
	  
	    // For each character in input strings, increment count in 
	    // the corresponding count array 
	    for (i = 0; i< str1.toCharArray().length && i< str2.toCharArray().length; i++) { 
	        count[str1.toCharArray()[i]]++; 
	        count[str2.toCharArray()[i]]--; 
	    } 
	    System.out.println(Arrays.toString(count));
	    // If both strings are of different length. Removing this condition 
	    // will make the program fail for strings like "aaca" and "aca" 
	    if (str1.length() != str2.length()) 
	        return false; 
	  
	    // See if there is any non-zero value in count array 
	    for (i = 0; i < NO_OF_CHARS; i++) 
	        if (count[i]>0) 
	            return false; 
	    return true; 
	}
	
	public static void main(String[] args) {
		System.out.println(isAnagram("aabbbb", "aaaabb"));
	}
}

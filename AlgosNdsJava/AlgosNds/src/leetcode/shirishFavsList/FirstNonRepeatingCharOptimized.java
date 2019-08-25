package leetcode.shirishFavsList;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstNonRepeatingCharOptimized {
	static int firstNonRepeatingChar(String s) {
		int[] alpha = new int[26];
		char[] arr = s.toCharArray();
		for (char c: arr) {
			alpha[c-'a']++;
		}
		for (int i=0; i<arr.length; i++) {
			if(alpha[arr[i]-'a']==1) return i;
		}
		return -1;
	}
	
	static int firstNonRepHashMap(String s) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		char[] arr = s.toCharArray();
		for (Character c : arr) {
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c)+1);
			}
		}
		
		Character res = null;
		
		for (Entry<Character, Integer> e : map.entrySet()) {
			if (e.getValue()==1) {
				res = e.getKey();
				break;
			}			
		}
		
		if (res!=null) {
			for (int i=0; i<arr.length; i++) {
				if (arr[i]==res)
					return i;
			}
		}
		
		
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(firstNonRepHashMap("leetcode"));
	}
}

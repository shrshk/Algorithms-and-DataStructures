package facebookPrep.recursionAndBacktracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DecodeWays {
	public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        return dfs(s, map, 0);
    }
    
    private int dfs(String str, HashMap<Integer, Integer> map, int index){
    	System.out.println(str.substring(index, str.length()));
        if(index == str.length()){
            return 1;
        }
        if(map.containsKey(index)) {
            return map.get(index);
        }
        if(str.charAt(index) == '0') {
            map.put(index, 0);
            return 0;
        }
        int res = dfs(str, map, index + 1); // 22        
        if(index + 1 < str.length() && (str.charAt(index) == '1' || (str.charAt(index) == '2' && str.charAt(index + 1) < '7'))){
            res += dfs(str, map ,index + 2);
        }
        map.put(index, res);
        return res;
    }
    
	public int numDecodingsTLE(String str) {
		if (str == null || str.length() == 0)
			return 0;
		Set<Integer> digits = new HashSet<>();

		for (int i = 1; i <= 26; i++) {
			digits.add(i);
		}

		return dfs(str, "" + str.charAt(0), 1, new HashMap<>(), digits);
	}

	private int dfs(String s, String tmp, int start, Map<String, Integer> cache, Set<Integer> digits) {

		String key = tmp;
		
		if (cache.containsKey(key)) {
			System.out.println(key);
			return cache.get(key);
		}
			

		String[] tmpTokens = tmp.split(",");
		for (String tmpToken : tmpTokens) {
			if (!digits.contains(Integer.parseInt(tmpToken)))
				return 0;
		}

		if (tmp.replace(",", "").length() == s.length())
			return 1;

		int count = 0;

		char c = s.charAt(start);
		String left = tmp + "," + c;
		count += dfs(s, left, start + 1, cache, digits);
		String right = tmp + c;
		count += dfs(s, right, start + 1, cache, digits);

		cache.put(key, count);

		return cache.get(key);

	}

	public static void main(String[] args) {
		System.out.println(new DecodeWays().numDecodings("226"));
	}
}

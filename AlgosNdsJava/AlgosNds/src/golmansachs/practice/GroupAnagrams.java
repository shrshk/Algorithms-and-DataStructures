package golmansachs.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
    	if (strs == null || strs.length == 0)
    		return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();        
        for (String s: strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String keyStr = new String(temp);
            if (!map.containsKey(keyStr))
            	map.put(keyStr, new ArrayList<>()); 
            map.get(keyStr).add(s);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
}

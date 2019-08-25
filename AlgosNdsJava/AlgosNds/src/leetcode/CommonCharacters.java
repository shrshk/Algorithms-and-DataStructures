package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonCharacters {
	static List<String> commonCharacters(String[] A) {
		Map<Character, Integer> map = new HashMap<>();
		String result = "";
		for(String s: A) {
			result=result+s;
		}
		for(int i=0;i<result.length();i++) {
			map.put(result.charAt(i), -1);
		}
		
		List<String> retrn = new ArrayList<>();
		
		for (Character c: map.keySet()) {
			for(String s : A) {
				int tempCount=0;
				if (s.indexOf(c)!=-1 && map.get(c)!=0) {
					for(int i=0;i<s.length();i++) {
						if(s.charAt(i)==c){
							tempCount++;
						}
					}
				}
				if ((map.get(c)>0) && (map.get(c)<tempCount)) {
					continue;
				} else {
					map.put(c, tempCount);
				}
					
			}

		}
		
		for (Map.Entry<Character, Integer> entry:map.entrySet()) {
			if(entry.getValue()>0) {
				for(int i=0;i<entry.getValue();i++) {
					retrn.add(entry.getKey().toString());
				}
			}
		}
		
		
		return retrn;
	}
	public static void main(String[] args) {
		String[] A = new String[]{"cool","lock","cook"};
		System.out.println(commonCharacters(A));
	}
    public boolean isValid(String S) {
        if(S.charAt(0)=='a' && S.charAt(S.length()-1)=='c')
            return true;
        return false;
    }
}

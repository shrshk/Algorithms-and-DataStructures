package leetcode.shirishFavsList;

import java.util.HashMap;
import java.util.Map;

public class StringCompression {
	static int compress(char[] chars) {
//		char[] result = new char[chars.length];
//		while(i<chars.length && j<chars.length){ // a b b 
//			if (chars[i]==chars[j]){
//				j++;
//			}else{
//				result[i] = chars[i];
//				result[i+1] = (char) (j);
//				i++;
//				j++;
//			}
//		}
//		return result.length;
		
		Map<Character, Integer> map = new HashMap<>();
		for (int i=0; i<chars.length; i++) {
			int count = 0;
			for (int j=0; j<chars.length; j++) {
				if (chars[i]==chars[j]) {
					count++;
				}
			}
			map.put(chars[i], count);			
		}
		int size = 0;
		for (Map.Entry<Character, Integer> entry: map.entrySet()) {
			size = size + entry.getValue();
		}
		
		char[] res = new char[size];
		int k=0;
		for (Map.Entry<Character, Integer> entry: map.entrySet()) {
			if(entry.getValue()>1) {
				res[k++]=entry.getKey();
				System.out.println("val is "+ (char)((int)entry.getValue()));
				res[k++] = (char)((int)entry.getValue());
			}else{
				res[k++] = entry.getKey();
			}
		}	
		
		return res.length;
		
	}
	
	static int myCompress(char[] chars){		
		if (chars == null || chars.length == 0)
            return 0;
        
        int index = 0, n = chars.length, i = 0, j=0;
        while (i < n) {// a a b b
            char ch = chars[i];
            //int j = i;
            while (j < n && chars[i] == chars[j]) { // chars[i..j - 1] are ch.
                j++;
            }
            int freq = j - i; // The frequency of ch.
            chars[index++] = ch;
            if (freq == 1) {
                
            }                
            else if (freq < 10) {
                chars[index++] = (char)(freq + '0');
            }
            else {
                String strFreq = String.valueOf(freq); 
                for (char chFreq : strFreq.toCharArray())
                    chars[index++] = chFreq;
            }
            i = j;
        }
        
        return index;
	}
	
	
	
	
	
	public static void main(String[] args) {
		System.out.println(myCompress(new char[]{'a', 'a', 'b', 'b'}));
	}
}

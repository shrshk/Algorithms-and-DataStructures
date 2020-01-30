package leetcodeContests.contest170;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DecryptString {
	public String freqAlphabets(String s) {
		Map<Integer, Character> map = new HashMap<>();
		int count = 1;
		for (char ch = 'a'; ch <='z'; ch++) {
			map.put(count++, ch);
		}
		
		System.out.println(map.toString());

		String res = "";
		List<Integer> nums = new ArrayList<>();
		int i = s.length() - 1;
		while (i >= 0) {
			if (s.charAt(i) == '#') {
				String num = "" + s.charAt(i - 2) + s.charAt(i - 1);
				nums.add(Integer.parseInt(num));
				i = i - 3;
			} else {
				nums.add(Character.getNumericValue(s.charAt(i)));
				i--;
			}

		}

		for (int j = nums.size() - 1; j >= 0; j--) {
			res += map.get(nums.get(j));
		}

		return res;
	}
	
	public String freqAlphabetsOpt(String s) {
		StringBuilder sb = new StringBuilder();
		int len = s.length();
		for (int i=0; i<len; i++) {
			if (i+2<len && s.charAt(i+2)=='#') {
				sb.append((char) ((Integer.parseInt(s.substring(i, i+2)) - 1)+ 'a') );
				i=i+2;
			} else {
				sb.append( (char) ( (Integer.parseInt(String.valueOf(s.charAt(i))) - 1) + 'a') ); 
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new DecryptString().freqAlphabetsOpt("1326#"));
	}
}

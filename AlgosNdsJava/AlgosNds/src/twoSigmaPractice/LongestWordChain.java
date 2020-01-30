package twoSigmaPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestWordChain {
	
	public int longestStrChain(String[] words) {
		int res=0;
		Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			int best = 0;
			for (int i=0; i<word.length(); i++) {
				String prev = word.substring(0,i) + word.substring(i+1); // dca bca
				best = Math.max(best, map.getOrDefault(prev, 0)+1);
			}
			map.put(word, best);	
			res = Math.max(res, best);
		}
		System.out.println(map.toString());
		return res;
	}
	
	public static void main(String[] args) {
		String[] words = new String[]{"a","b","ba","bca","bda","bdca"};
//		String word = "bdca";
//		for (int i=0; i<word.length(); i++) {
//			String prev = word.substring(0,i) + word.substring(i+1);
//			System.out.println(prev);
//		}
		System.out.println(new LongestWordChain().longestStrChain(words));
		
		// loop thru each word 
	}
}

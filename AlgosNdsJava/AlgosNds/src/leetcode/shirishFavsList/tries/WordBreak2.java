package leetcode.shirishFavsList.tries;

import java.util.ArrayList;
import java.util.List;

public class WordBreak2 {
	public List<String> wordBreak(String s, List<String> wordDict) {
		// s = "catsanddog"
		// wordDict = ["cat", "cats", "and", "sand", "dog"]
		List<String> res = new ArrayList<>();
		
		// steps
		// build a trie of wordDict
		// start with empty string add chars and call helper on it when word is leaf add to result

		return res;
	}
	
	public static void main(String[] args) {
		ActionCode actionCode = new ActionCode(ActionCodeType.valueOf("Add".toUpperCase()), "CustomerRequest");
		System.out.println(actionCode.getMessage());
		System.out.println(actionCode.getAction());
	}
	
	
	
	
}

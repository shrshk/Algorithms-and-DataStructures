package graphs.dfs;

import java.util.LinkedList;
import java.util.List;

public class LetterCasePermutation {
	public List<String> letterCasePermutation(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        
        List<String> res = new LinkedList<>();
        helper(S.toCharArray(), res, 0);
        return res;
    }
    
    public void helper(char[] chs, List<String> res, int pos) {
        if (pos == chs.length) {
            res.add(new String(chs));
            System.out.println(res);
            return;
        }
        
        if (chs[pos] >= '0' && chs[pos] <= '9') {
            helper(chs, res, pos + 1);
            return;
        }
        
        chs[pos] = Character.toLowerCase(chs[pos]);
        helper(chs, res, pos + 1);
        
        chs[pos] = Character.toUpperCase(chs[pos]);
        helper(chs, res, pos + 1);
    }
    
    public static void main(String[] args) {
		System.out.println(new LetterCasePermutation().letterCasePermutation("a1b2"));
		// a 1 b 2        a 1 B 2 A 1 b2 
	}
}

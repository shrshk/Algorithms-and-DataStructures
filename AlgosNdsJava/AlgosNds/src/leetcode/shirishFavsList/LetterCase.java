package leetcode.shirishFavsList;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class LetterCase {
	public static List<String> bfsLetterCasePermutation(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);
        
        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) continue;            
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();
                
                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));
                
                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));
            }
        }
        
        return new LinkedList<>(queue);
    }
	
	public static List<String> dfsLetterCasePermutation(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        
        List<String> res = new LinkedList<>();
        helper(S.toCharArray(), res, 0);
        return res;
    }
    
    public static void helper(char[] chs, List<String> res, int pos) {
        if (pos == chs.length) {
            res.add(new String(chs));
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
		System.out.println(bfsLetterCasePermutation("a1b2")); // a 1 b 2 // A
		System.out.println(dfsLetterCasePermutation("a1b2"));
	}
}


/*

// a 1 b 2           A 
 int totalComb = 0;
 for (int i=0; i<a.length; a++) {
    if (type(a[i]) == Character)
        totalComb+=2;
    else
        totalComb++;
 int[] res = new int[totalComb]
 List<String>
 // loop thru the array to create res.
 int count=0;
 for (int k=0;k<a.length; k++) {
     int comb = 0;
     if (type[a[k]==char)
        StringB sb1 = new StringBuiler();
        sb.setChar
        comb=2;
     else
        comb=1
     for (int x=0; x<comb;++)
         
         new sb(
         res.add(
      // a 1 b 2 // A 1 b2
     for (int i=0; i<S.length(); i++) {
			if (Character.isLetter(S.charAt(i))) {
				StringBuilder sb1 = new StringBuilder();
				StringBuilder sb2 = new StringBuilder();
				sb1.append(S);
				sb2.append(S);
				sb2.setCharAt(i, Character.toUpperCase(S.charAt(i)));
				result.add(sb1.toString());
				result.add(sb2.toString());				
			}	
			
			// a 1 b 2                       
			// a 1 B 2
			// A 1 b 2
			// A 1 B 2
		}    
          
    
 }
 }
 




*/
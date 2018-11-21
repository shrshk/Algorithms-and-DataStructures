package leetcode;

public class LastWord {
	public int lastWord(String s) {
		int len = 0; 
		  
        /* String a is 'final'-- can not be modified 
           So, create a copy and trim the spaces from 
           both sides */
        String x = s.trim(); 
        System.out.println(x);
        for (int i=0; i<x.length(); i++) 
        { 
            if (x.charAt(i)==' ') 
                len = 0; 
            else
                len++; 
        } 
  
        return len; 
	}
	public static void main(String[] args) {
		System.out.println(new LastWord().lastWord("hello world"));
	}
}

package facebookPrep.mockTests.one;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        String[] mappings = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        // steps 
        // loop thru digits 
        // get the mapping of the digit 
        // add it to FIFO queue
        // keep polling from the head until the head reaches the length of digits
        // pop the head of the q add chars from map to it
        LinkedList<String> ans = new LinkedList<>();
        ans.add("");
        while(ans.peek().length()!=digits.length()) {
            String head = ans.remove();
            String map = mappings[digits.charAt(head.length())-'0'];
            System.out.println(head);
            for (char c: map.toCharArray()) {
            	//System.out.println("head" + " " + head);
            	// System.out.println("" + " " + c);
                ans.addLast(head+c);
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
		System.out.println(new LetterCombinationOfPhoneNumber().letterCombinations("23"));
	}
}

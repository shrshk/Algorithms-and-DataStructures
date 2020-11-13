package bloombergPractice;

import java.util.Stack;

public class MinRemoveValidParenthesis {
	public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    sb.setCharAt(i, '#');
                }
            }
        }
        
        while(!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '#');
        }
        
        return sb.toString().replaceAll("\\#", "");
        
    }
}

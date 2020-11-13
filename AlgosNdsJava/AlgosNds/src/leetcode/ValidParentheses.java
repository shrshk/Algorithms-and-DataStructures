package leetcode;

import java.util.Stack;

public class ValidParentheses {
	
//	public boolean isValid(String s) {
//		Map<Character, Character> map = new HashMap<Character, Character>();
//		map.put('(', ')');
//		map.put('{', '}');
//		map.put('[', ']');
//		
//		if(s.length()%2!=0) {
//			return false;
//		}
//		
//		for (int i=0, j=i+1; i<s.length()-1 & j<s.length(); i=i+2) {
//			if (!map.containsKey(s.charAt(i))) {
//				return false;
//			}
//			if(map.get(s.charAt(i))!=s.charAt(j)) {
//				return false;
//			}
//			j=j+2;
//		}
//		
//		return true;
//	}
	
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		System.out.println(stack.isEmpty());
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ValidParentheses().isValid("{[]}"));
	}

}

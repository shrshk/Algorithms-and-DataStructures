//package bloombergPractice;
//
//import java.util.Stack;
//
//public class RemoveAllAdjacentDuplicates2 {
//	public String removeDuplicates(String s, int k) {
//		Stack<CharNode> stack = new Stack<>();
//		for (int i = 0; i < s.length(); i++) {
//			char curr = s.charAt(i);
//			if (!stack.isEmpty() && curr == stack.peek().c) {
//				if (stack.peek().count == k - 1) {
//					while (!stack.isEmpty() && stack.peek().c == curr) {
//						stack.pop();
//					}
//				} else {
//					stack.push(new CharNode(stack.peek().count + 1, curr));
//				}
//			} else {
//				stack.push(new CharNode(1, curr));
//			}
//		}
//
//		StringBuilder sb = new StringBuilder();
//		while (!stack.isEmpty())
//			sb.append(stack.pop().c);
//		return sb.reverse().toString();
//	}
//}
//
//class CharNode {
//	int count;
//	char c;
//
//	CharNode(int count, char c) {
//		this.count = count;
//		this.c = c;
//	}
//}

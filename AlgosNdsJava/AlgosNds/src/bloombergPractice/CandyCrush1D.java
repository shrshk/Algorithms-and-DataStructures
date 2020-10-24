package bloombergPractice;

import java.util.Stack;

class CharNode {
	int count;
	char c;

	CharNode(int count, char c) {
		this.count = count;
		this.c = c;
	}
}

class Entity {
	char character;
	int frequency;

	Entity(char p, int q) {
		character = p;
		frequency = q;
	}
}

public class CandyCrush1D {
	public String candyCrush1D(String s) {
		// aabbbacd
		Stack<CharNode> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if (!stack.isEmpty() && curr == stack.peek().c) {
				if (stack.peek().count == 2) {
					while (!stack.isEmpty() && stack.peek().c == curr) {
						stack.pop();
					}
				} else {
					stack.push(new CharNode(stack.peek().count + 1, curr));
				}
			} else {
				stack.push(new CharNode(1, curr));
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.append(stack.pop().c);
		return sb.reverse().toString();
	}

	public String candyCrush1DfollowUp(String st1, int k) {
		// Stack to store the character
		Stack<Entity> st = new Stack<Entity>();
		int n = st1.length();

		int i = 0;
		for (i = 0; i < n; i++) {

			// the current character
			char x = st1.charAt(i);

			// if the stack is not empty
			// and the frequency of the element
			// at the top of the stack is = k
			// then pop k elements
			if (st.size() > 0 && st.peek().frequency == k) {

				// stores the character at
				// the top of the stack
				char curr = st.peek().character;

				// while the character
				// at the top of the stack is curr
				// pop the character from the stack
				while (st.size() > 0 && st.peek().character == curr)
					st.pop();
			}

			// if the stack is not empty
			// and the top element of the
			// stack is = x,
			if (st.size() > 0 && st.peek().character == x) {

				// increase it's frequency and
				// push it to the stack
				Entity new_top = new Entity(x, st.peek().frequency + 1);
				st.push(new_top);
			}

			// if the current element is
			// not equal to the character
			// at the top of the stack
			else {
				Entity new_top = new Entity(x, 1);
				st.push(new_top);
			}
		}

		// if the last pushed character
		// has k frequency, then pop the
		// top k characters.
		if (st.size() > 0 && st.peek().frequency == k) {

			// get the character
			// at the top of the stack
			char curr = st.peek().character;

			// while the character
			// at the top of the stack is
			// curr, pop it from the stack
			while (st.size() > 0 && st.peek().character == curr)
				st.pop();
		}

		// Stores the string in
		// reversed fashion from stack
		String stack_string = "";
		while (st.size() > 0)
			stack_string += st.pop().character;

		String reduced_string = "";

		// reverse the stack string
		for (i = stack_string.length() - 1; i >= 0; i--)
			reduced_string += stack_string.charAt(i);

		return reduced_string;
	}

	public String removeDuplicates(String s, int k) {
		Stack<CharNode> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			// compare prev with cur
			if (!stack.isEmpty() && stack.peek().c == c) {
				stack.peek().count++;
			} else {
				// not repeat
				stack.push(new CharNode(1, c));
			}
			// remove when num of dup == k
			if (stack.peek().count == k)
				stack.pop();
		}
		// build result
		StringBuilder sb = new StringBuilder();
		for (CharNode node : stack) {
			for (int i = 0; i < node.count; i++) {
				sb.append(node.c);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new CandyCrush1D().candyCrush1D("aaabbbacd"));
		System.out.println(new CandyCrush1D().candyCrush1DfollowUp("aaabbbacd", 3));
	}
}

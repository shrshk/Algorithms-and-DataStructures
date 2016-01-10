package assignment5;
import java.util.Arrays;


import linkedList.DoublyLinkedNode;

public class Assignment5 {
	/**
	 * PROBLEM 1
	 * 
	 * @param args
	 */
	class Stack {
		private DoublyLinkedNode top;

		public boolean isEmpty() {
			return top == null;
		}

		public void push(Integer item) {
			DoublyLinkedNode node = new DoublyLinkedNode(item);
			node.setPreviousNode(this.top);
			if (top != null) {
				top.setNextNode(node);
			}
			top = node;
		}

		public Integer peek() {
			return this.top.getData();
		}

		public Integer pop() {
			Integer result = this.top.getData();
			if (this.top.getPreviousNode() != null)
				this.top.getPreviousNode().setNextNode(null);
			this.top = this.top.getPreviousNode();
			return result;
		}

	}

	/**
	 * PROBLEM 2
	 * 
	 * @param args
	 */
	class TwoStack {
		Object[] array = new Object[100];
		int top1 = -2, top2 = -1;

		public void pushFirst(Object data) {
			array[top1 += 2] = data;
		}

		public void pushSecond(Object data) {
			array[top2 += 2] = data;
		}

		public Object peekFirst() {
			if (top1 >= 0)
				return array[top1];
			throw new RuntimeException("First stack is empty");
		}

		public Object peekSecond() {
			if (top2 >= 0)
				return array[top2];
			throw new RuntimeException("Second stack is empty");
		}

		public Object popFirst() {
			if (top1 < 0)
				throw new RuntimeException("First stack is empty");
			top1 -= 2;
			return array[top1 + 2];
		}

		public Object popSecond() {
			if (top2 < 0)
				throw new RuntimeException("Second stack is empty");
			top2 -= 2;
			return array[top2 + 2];
		}

		public boolean isFirstEmpty() {
			return top1 < 0;
		}

		public boolean isSecondEmpty() {
			return top2 < 0;
		}
	}
	
	/**
	 * PROBLEM 3
	 * Similar to PROBLEM 1. Leaving it as an exercise
	 * @param args
	 */

	/**
	 * PROBLEM 4
	 * Evaluates expressions passed as a string in the prefix form.
	 * We need to keep one stack for storing operators and another for operands, 
	 * so we can just use the TwoStack class.
	 * @param args
	 */
	public double evaluate(String expression) {
		String[] tokens = expression.split(" ");
		
		System.out.println(Arrays.deepToString(tokens));
		
		TwoStack twoStack = new TwoStack();	
		
		for (String token : tokens) {
			token = stripBrackets(token);
			if (isOperator(token)) {
				twoStack.pushFirst(token);
				twoStack.pushSecond("#"); // marker in the operand stack
			} else if (isNumber(token)) {
				if (twoStack.isSecondEmpty() || (!twoStack.isSecondEmpty() && twoStack.peekSecond().equals("#"))) {
					twoStack.pushSecond(token);
				} else {
					while (!twoStack.isSecondEmpty() && isNumber((String)twoStack.peekSecond())) {
						Double inStack = Double.parseDouble((String)twoStack.popSecond());
						twoStack.popSecond(); //pop the marker
						String operator = (String)twoStack.popFirst();
						Double result = applyOp(operator, inStack, Double.parseDouble(token));
						if (twoStack.isSecondEmpty() || twoStack.peekSecond().equals("#")) {
							twoStack.pushSecond(result.toString());
							break;
						}
						token = result.toString();
					}
				}
			}
		}
		return Double.parseDouble((String)twoStack.popSecond()); //pop from the operand stack
	}

	private Double applyOp(String operation, Double op1, Double op2) {
		if (operation.equals("+"))
			return op1 + op2;
		if (operation.equals("-"))
			return op1 - op2;
		if (operation.equals("/"))
			return op1 / op2;
		if (operation.equals("*"))
			return op1 * op2;
		if (operation.equals("%"))
			return op1 % op2;
		throw new RuntimeException("Invalid operation");
	}
	
	private String stripBrackets(String s) {
		String res = s.replace('(', ' ');
		res = res.replace(')', ' ');
		return res.trim();
	}
	
	private boolean isNumber(String s) {
		char[] chars = s.toCharArray();
		for (int c : chars) {
			if ((c >= 48 && c <= 57) || c == 46) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
		
	private boolean isOperator(String c) {
		if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") || c.equals("%"))
			return true;
		return false;
	}

	public static void main(String[] args) {
		Assignment5 prob = new Assignment5();
		// Stack stack = prob.new Stack();
		// stack.push(1);
		// stack.push(2);
		// stack.push(3);
		// System.out.println(stack.peek());
		// System.out.println(stack.pop());
		// System.out.println(stack.pop());
		// System.out.println(stack.isEmpty());
		// System.out.println(stack.pop());
		// System.out.println(stack.isEmpty());

		TwoStack twoStack = prob.new TwoStack();

		twoStack.pushFirst(1);
		twoStack.pushFirst(3);
		twoStack.pushFirst(5);
		twoStack.pushSecond(2);
		twoStack.pushSecond(4);
		twoStack.pushSecond(6);

		System.out.println(twoStack.popFirst());
		System.out.println(twoStack.peekFirst());
		System.out.println(twoStack.popSecond());
		System.out.println(twoStack.peekSecond());

		System.out.println(twoStack.isFirstEmpty());
		System.out.println(twoStack.isSecondEmpty());
		
		System.out.println(prob.evaluate("+ 3 (* 5 3)"));

	}

}

package stack.copy;

public class Stack {
	int[] items = new int[4];
	int top = -1;

	public boolean isEmpty() {
		return top < 0;
	}

	public int push(int item) {
		if (top == items.length - 1)
			throw new RuntimeException("Stack is full");

		return items[++top] = item;
	}

	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		return items[top--];
	}

	public int peek() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		return items[top];
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack();
		System.out.println(stack.isEmpty());
		System.out.println(stack.push(1));
		System.out.println(stack.push(123));
		System.out.println(stack.push(110));
		System.out.println(stack.push(140));
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		
	}
}
package stack.copy;

public class Stack {
	int[] items = new int[100];
	int top = -1;
	
	public  boolean isEmpty() {
		return top<0;
	}
	
	public void push(int item) {
		if(top == items.length-1)
			throw new RuntimeException("Stack is full");
		items[++top] = item;
	}
	
	public int pop() {
		if(isEmpty())
			throw new RuntimeException("Stack is empty");
		return items[top--];
	}
	
	public int peek() {
		if(isEmpty())
			throw new RuntimeException("Stack is empty");
		return items[top];
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack();
		System.out.println(stack.isEmpty());
		stack.push(1);
		stack.push(123);
		stack.push(110);
		stack.push(140);
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		
	}
}
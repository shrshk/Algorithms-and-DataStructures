package twilioPrep;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithQueue {
	Queue<Integer> queue;

	public StackWithQueue() {
		this.queue = new LinkedList<Integer>();
	}

	// Push element x onto stack.
	public void push(int x) {
		queue.add(x);
		// 12 
		for (int i = 0; i < queue.size() - 1; i++) {
			queue.add(queue.poll());
		}
	}

	// Removes the element on top of the stack.
	public void pop() {
		queue.poll();
	}

	// Get the top element.
	public int top() {
		return queue.peek();
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return queue.isEmpty();
	}
}
package stack.queue;

public class Queue {

	int[] items;
	int head = -1;
	int tail = -1;

	int numOfItems = 0;

	public Queue(int size) {
		this.items = new int[size];
	}

	public boolean isFull() {
		return numOfItems == items.length;
	}

	public boolean isEmpty() {
		return numOfItems == 0;
	}

	public void Enqueue(int item) {
		if (isFull()) {
			throw new RuntimeException("Queue is Full");
		}
		if (tail == items.length - 1)
			tail = -1;

		items[++tail] = item;
		numOfItems++;

	}

	public int Dequeue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is Empty");
		}
		if (head == items.length - 1)
			head = -1;
		numOfItems--;
		return items[++head];
	}

	public int peek() {
		return items[head + 1];
	}

	public static void main(String[] args) {
		Queue q = new Queue(5);
		System.out.println(q.isEmpty());
		System.out.println(q.peek());
		q.Enqueue(23);
		q.Enqueue(7);
		q.Enqueue(10);
		q.Enqueue(11);
		q.Enqueue(45);
		System.out.println(q.peek());
		System.out.println(q.Dequeue());
		System.out.println(q.isFull());
		System.out.println(q.peek());

	}

}
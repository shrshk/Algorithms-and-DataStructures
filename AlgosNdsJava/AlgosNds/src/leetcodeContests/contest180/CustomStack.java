package leetcodeContests.contest180;

import java.util.Arrays;

public class CustomStack {
	int[] arr;
	int top = -1;
	int[] increment;

	CustomStack(int n) {
		arr = new int[n];
		increment = new int[n];
	}

	void push(int val) {
		if (top == arr.length - 1)
			return;
		arr[++top] = val;
	}

	int pop() {
		if (top == -1)
			return -1;
		if (top > 0)
			increment[top-1]+=increment[top];		
		int val = increment[top] + arr[top];
		increment[top] = 0;
		top--;
		return val;
	}

	void increment(int k, int val) {
		int idx = Math.min(k-1, top);
		if (idx>= 0) {
			increment[idx] += val;
		}
		
		System.out.println(Arrays.toString(increment));

		// int idx=0;
		// while(k-->0 && idx<arr.length && idx<=top) {
		// arr[idx] = arr[idx] + val;
		// idx++;
		// }
	}

	public static void main(String[] args) {
		// ["CustomStack","push","pop","increment","pop","increment","push","pop","push","increment","increment","increment"]
		              // [[2],[34],[],[8,100],[],[9,91],[63],[],[84],[10,93],[6,45],[10,4]]
		// ["CustomStack","pop","increment","push","increment","increment","increment","pop","increment"]
		// [[30],[],[3,40],[30],[4,63],[2,79],[5,57],[],[5,32]]
		CustomStack customStack = new CustomStack(30);
		System.out.println(customStack.pop()); // return 2 --> Return top of the stack 2, stack	
		customStack.increment(3, 40); // stack becomes [101, 102, 103]
		customStack.push(30);
		customStack.increment(4, 63);
		customStack.increment(2, 79);
		customStack.increment(5, 57); 
		System.out.println(customStack.pop()); // return 103 --> Return top of the stack 103, stack		
		customStack.increment(5, 32); 
	}

}

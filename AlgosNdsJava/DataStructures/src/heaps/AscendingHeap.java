package heaps;

import java.util.Arrays;

public class AscendingHeap {
	private Integer[] HeapData;
	private int currentPosition = -1;

	public AscendingHeap(int size) {
		this.HeapData = new Integer[size];

	}

	private boolean isFull() {
		return currentPosition == HeapData.length - 1;
	}

	public void insert(int item) {
		if (isFull()) {
			throw new RuntimeException("the heap is full");
		}
		this.HeapData[++currentPosition] = item;
		fixUp(currentPosition);
	}

	private void fixUp(int index) {
		int i = (index - 1) / 2;
		while (i >= 0 && HeapData[i] > HeapData[index]) {
			int temp = HeapData[i];
			HeapData[i] = HeapData[index];
			HeapData[index] = temp;
			index = i;
			i = (index - 1) / 2;
		}
	}

	public static void main(String[] args) {
		AscendingHeap aheap = new AscendingHeap(9);
		aheap.insert(3);
		aheap.insert(6);
		aheap.insert(8);
		aheap.insert(15);
		aheap.insert(11);
		aheap.insert(12);
		aheap.insert(13);
		aheap.insert(20);
		aheap.insert(10);

		System.out.println(Arrays.deepToString(aheap.HeapData));

	}

}

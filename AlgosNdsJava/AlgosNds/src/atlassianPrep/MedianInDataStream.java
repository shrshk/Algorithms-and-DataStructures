package atlassianPrep;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianInDataStream {

	Queue<Integer> left;
	Queue<Integer> right;

	/** initialize your data structure here. */
    public MedianInDataStream() {
        left = new PriorityQueue<>((num1,num2)->(num2-num1));
        right = new PriorityQueue<>();       
        
    }

	public void addNum(int num) {
		// 1 2 3
		right.add(num);
		left.add(right.poll());
		if (right.size() < left.size())
			right.add(left.poll());
	}

	// Returns the median of current data stream
	public double findMedian() {
		return right.size() > left.size() ? right.peek() : ((left.peek() + right.peek()) / 2.0);
	}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
 * obj.findMedian();
 */
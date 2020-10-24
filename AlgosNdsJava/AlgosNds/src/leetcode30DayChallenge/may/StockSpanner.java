package leetcode30DayChallenge.may;

import java.util.Stack;

public class StockSpanner {
	Stack<int[]> stockStack;

	public StockSpanner() {
		stockStack = new Stack<>();
	}

	public int next(int price) {
		// [100,1] [80,1]...
		int res = 1;
		while (!stockStack.isEmpty() && stockStack.peek()[0] <= price) {
			res += stockStack.pop()[1];
		}
		stockStack.push(new int[] { price, res });
		return res;
	}
	// List<Integer> stocks;
	// int currMax;
	//
	// public StockSpanner() {
	// stocks = new ArrayList<>();
	// currMax = Integer.MIN_VALUE;
	// }
	//
	// public int next(int price) {
	// stocks.add(price);
	// if (price >= currMax) {
	// currMax = price;
	// return stocks.size();
	// }
	// int count = 0;
	// for (int i = stocks.size() - 1; i >= 0; i--) {
	// if (stocks.get(i) <= price)
	// count++;
	// else
	// break;
	// }
	// return count;
	// }
}

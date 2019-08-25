package leetcode.shirishFavsList;

import java.util.LinkedList;

public class SlidingWindow {

	LinkedList<Integer> nums;
	int numOfZeros;
	int k;
	int prod = 1;

	public SlidingWindow(int k) {
		this.nums = new LinkedList<>();
		this.k = k;
	}

	public void add(int val) {
		if (nums.size() == k) {
			int num = nums.pollFirst();
			if (num == 0) {
				numOfZeros--;
			}
			prod = prod / num;
		}
		nums.add(val);
		if (val == 0) {
			numOfZeros++;
		} else {
			prod = prod * val;
		}

	}

	public int getProduct() {
		return numOfZeros > 0 ? 0 : prod;
	}

	public static void main(String[] args) {
		SlidingWindow window = new SlidingWindow(3);
		window.add(1); // [1]
		window.add(2); // [1, 2]
		System.out.println(window.getProduct()); // 2
		window.add(3); // [1, 2, 3]
		System.out.println(window.getProduct()); // 6
		window.add(4); // [2, 3, 4]
		System.out.println(window.getProduct()); // 24
		window.add(0); // [3,4,0]
		System.out.println(window.getProduct()); // 0
	}
}

/**
 * List<Integer> nums; int prod = 1; int j = 0; int numSize; Map<Integer,
 * Integer> zeroMap = new HashMap<>();
 * 
 * public SlidingWindow(int k) { this.nums = new ArrayList<>(); this.numSize=k;
 * this.zeroMap.put(0, 0); }
 * 
 * public void add(int val) { if (j == numSize - 1) { int temp = nums.get(0);
 * nums.remove(temp); if (temp == 0) zeroMap.put(0, zeroMap.get(0) - 1); j--; if
 * (this.prod != 0) this.prod = this.prod / temp;
 * 
 * } nums.add(val); j++; if (val == 0) zeroMap.put(0, zeroMap.get(0) + 1); if
 * (val != 0) prod = prod * val; }
 * 
 * public int getProduct() { return zeroMap.get(0) != 0 ? 0 : this.prod; }
 */

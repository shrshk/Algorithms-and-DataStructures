package dynamicProgramming;

public class MaximumSumNoNeighbor {
	public int maxSum(int[] arr) {
		int incl = arr[0];
		int excl = arr[1];
		
		for (int i=1; i<arr.length; i++) {
			int temp = incl;
			incl = Math.max(excl+arr[i], incl);
			excl = temp;
		}
		
		
		return incl;
	}
	public static void main(String[] args) {
		int[] arr = new int[]{2, 10, 13, 4, 2, 15, 10};
		System.out.println(new MaximumSumNoNeighbor().maxSum(arr));
	}
}

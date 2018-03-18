package codeFights;

public class MaxProduct {
	
	public static int maxProduct(int[] arr) {
		int maxProduct = -1000;
		for (int i=0;i<arr.length-1;i++) {
			if (arr[i] * arr[i+1] > maxProduct) {
				maxProduct = arr[i] * arr[i+1];
			}
		}
		return maxProduct;
	}
	
	public static void main(String[] args) {
		int[] arr = {-23, 4, -3, 8, -12};
		System.out.println(maxProduct(arr));
	}
}

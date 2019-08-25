package codeFights;

import java.util.Arrays;

public class ConsecutiveArray {
	
	public static int consecutiveArray(int[] arr) {
		Arrays.sort(arr);
		int count = 0;
		for (int i=0;i<arr.length-1;i++) {
			if (arr[i+1]-arr[i]>1) {
				count = count + (arr[i+1]-arr[i])-1;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = {6, 2, 3, 8};
		System.out.println(consecutiveArray(arr));
	}

}

package arrayQuestions;

import java.util.Arrays;

public class ReverseArray {
	static int[] reverseArray(int[] arr) {

		for (int i = 0; i < arr.length / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}

		return arr;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(reverseArray(arr)));
	}

}

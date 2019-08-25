package arrayQuestions;

import java.util.Arrays;

public class MoveZeros {
	static int[] moveZeros(int[] arr) {
		int count = 0;
		for (int i=0; i<arr.length;i++) {
			if (arr[i]!=0) {
				arr[count++] = arr[i];
			}
		}
		
		while(count<arr.length) {
			arr[count++] = 0;
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(moveZeros(new int[]{0,1,0,3,12})));
	}
}

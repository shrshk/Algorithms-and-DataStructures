package leetcode;

import java.util.Arrays;

public class RotateArray {
	static int[] rotateArr(int[] arr, int k) {
		// move all the elements one by one to the left
		// do it with juggling algorithm. // 7,1,2
		for (int i=0;i<k;i++) {
			int temp = arr[arr.length-1];
			for (int j=arr.length-2;j>=0;j--) {
				arr[j+1]=arr[j];
			}
			arr[0] = temp;
		}
		
		return arr;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(rotateArr(new int[]{1,2,3,4,5,6,7}, 3)));
	}
}
// 
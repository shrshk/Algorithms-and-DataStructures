package leetcode;

import sun.security.util.Length;

// unsolved
public class PlusOne {
	public int[] plusOne(int[] arr) {
		arr[arr.length-1] = arr[arr.length-1]+1;
		return arr;
	}
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3};
		System.out.println(new PlusOne().plusOne(arr));
	}
}

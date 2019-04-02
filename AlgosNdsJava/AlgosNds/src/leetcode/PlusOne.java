package leetcode;

import java.util.Arrays;

// unsolved
public class PlusOne {
	public int[] plusOne(int[] digits) {
		int carry = 1;
	    for (int i = digits.length-1; i>= 0; i--) {
	        digits[i] += carry;
	        if (digits[i] <= 9) // early return 
	            return digits;
	        digits[i] = 0;
	    }
	    int[] ret = new int[digits.length+1];
	    ret[0] = 1;
	    System.out.println(Arrays.toString(ret));
	    return ret;  
	}
	public static void main(String[] args) {
		int[] arr = new int[]{9};
		System.out.println(Arrays.toString(new PlusOne().plusOne(arr)));
	}
}
//String temp = Integer.toString(num);
//int[] newGuess = new int[temp.length()];
//for (int i = 0; i < temp.length(); i++)
//{
//    newGuess[i] = temp.charAt(i) - '0'; 100
//}
//return newGuess;
/*int num=0;
		for (int i=0;i<arr.length;i++) {
			if (i==0) {
				num = arr[i];
			} else {
				num = num * 10 + arr[i];
			}
		}
		num = num +1;
		int length = (int)(Math.log10(num)+1);
		int[] result = new int[length];
		int j=length-1;
		while(num>0) {
			result[j] = num%10;
			j--;
			num = num/10;
		}
		
		return result;*/
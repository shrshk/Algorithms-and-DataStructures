package arrayQuestions;

import java.util.Arrays;

public class TopTwoMax {
	static int[] maxTwo(int[] arr) {
				
		if (arr.length<=2) {
			return arr;
		}
		int maxOne = 0;
		int maxTwo = 0;
		for (int n: arr) {
			if (maxOne < n) {
				maxTwo = maxOne;
				maxOne = n;
			}else if(maxTwo < n)	 {
				maxTwo = n;
			}
		}
		int[] maxTwoArr = {maxOne, maxTwo};
		return maxTwoArr;
	}
	public static void main(String[] args) {
		/*
		 * 1,2,3,4,5
		 * max=Integer.min
		 * 2ndMax=Integer.min
		 * loop once get firstMax
		 * if num>max and !=firstMax
		 * 
		 * 
		 * */
		System.out.println(Arrays.toString(maxTwo(new int[]{5,34,78,2,45,1,99,80})));
	}
}

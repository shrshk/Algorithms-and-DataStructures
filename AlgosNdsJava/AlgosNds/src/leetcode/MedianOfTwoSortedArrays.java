package leetcode;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
	static double medianArrays(int[] arr1, int[] arr2) {
		int i=0,j=0;
		int count=0;
		int[] arr3 = new int[arr1.length+arr2.length];
		while(i<arr1.length&&j<arr2.length) {
			if (arr1[i]<arr2[j]) {
				arr3[count++]=arr1[i];
				i++;
			} else if(arr1[i]>arr2[j]) {
				arr3[count++]=arr2[j];
				j++;
			} else {
				arr3[count++] = arr1[i];
				arr3[count++] = arr2[j];
				i++;
				j++;
			}
		}
		while (i<arr1.length) {
			arr3[count++] = arr1[i++];
		}
		while (j<arr2.length) {
			arr3[count++] = arr2[j++];
		}
		
		System.out.println(Arrays.toString(arr3));
			
		return median(arr3);
	}
	
	static double median(int[] arr) {
		double median = 0.0;
		int n = arr.length;
		if (n % 2 == 0) {
			median = (arr[n/2] + arr[(n/2)-1])/2.0;
			System.out.println(arr[n/2]);
			System.out.println(arr[(n/2)-1]);
		} else {
			median = arr[(n-1)/2];
		}
		return median;
	}
	
	public static void main(String[] args) {
		System.out.println(medianArrays(new int[] {1},new int[] {1}));
	}
	
	
}

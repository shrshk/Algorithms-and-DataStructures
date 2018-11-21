package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestCommonSubList {
	
	
	static int longestCommon(List<Integer> arr1, List<Integer> arr2) {
		int max_length = 0;
		int i=0, j=0;
		while (i<arr2.size() || j>=0) {
			List<Integer> arr3 = new ArrayList<>();
			//int[] arr3 = new int[j+1];
			for( int k=0; k<j+1; k++) {
				// arr3.=arr2[j];
				arr3.add(arr2.get(i+j)); // 2, 4, 1 
			}
			// check if arr3 is sublist of arr1. 
			// reset i = i-j+1
			// reset j=0
			// Collections.indexOfSubList(Arrays.asList(array), Arrays.asList(subArray));
			if (Collections.indexOfSubList(Arrays.asList(arr1), Arrays.asList(arr3))!=-1) {
			  i++;
			  j=0;	
				if(arr3.size()>max_length) { //1 
					max_length = arr3.size(); // 1				
				}	
			} else {
				j++;
			}		
		}
		return max_length;
	}
	
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1,3,2,4,5));
		List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(2,4,1,3,2));
	
		
		System.out.println(longestCommon(list1, list2));
	}

}

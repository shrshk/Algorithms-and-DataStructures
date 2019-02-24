package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public static int[] retNumbrs(int[] arr, int number) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<arr.length;i++) {
			int complement = number - arr[i];
			if(map.containsKey(complement)) {
				return new int[]{map.get(complement), i};
			}
			map.put(arr[i], i);
		}
		throw new IllegalArgumentException("did not find");
	}
	
	
	public static void main(String[] args) {
		int[] arr = new int[]{2,7,11,15};
		int[] arr2 = retNumbrs(arr, 26);
		for (int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		// System.out.println(retNumbrs(arr, 9));
	}

}

// brute force
//public static int[] retNumbers(int[] arr, int number) {
//int[] newArr = new int[arr.length];
//int indx1=0;
//int indx2=0;
//for (int i=0;i<arr.length;i++) {
//	for(int j=i+1;j<arr.length;j++) {  
//		if(arr[i]+arr[j] == number) {
//			indx1 = i;
//			indx2 = j;
//		}
//	}
//}
//System.out.println(indx1);
//System.out.println(indx2);
//newArr[0] = indx1;
//newArr[1] = indx2;
//
//return newArr;
//}
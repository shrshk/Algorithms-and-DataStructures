package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {
	static List<List<Integer>> threeSum(int[] arr) {
		List<List<Integer>> threeSumLists = new ArrayList<List<Integer>>();
		for (int i=0;i<arr.length;i++) {
			List<Integer> tempList = new ArrayList<Integer>();
			for (int j=0;j<arr.length;j++) {
				if (j!=i) {
					tempList.add(arr[i],arr[j]);
					for(int k=0;k<arr.length;k++) {
						if(k!=i&&k!=j) {
							int sum=0;
							for (int a:tempList) {
								sum = sum + a;								
							}
							if (sum + arr[k]==0) {
								threeSumLists.add(tempList);
							}
						}
					}
				}
			}
		}
		return threeSumLists;
	}
	
	public static void main(String[] args) {
		System.out.println(threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
	}

}

package com.AlgosAndDs;

import java.util.ArrayList;
import java.util.List;

public class CommonInteger {
	
	public ArrayList commonNumbers(int[] x, int[] y) {
		int count;
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i=0;i<y.length;i++) {
			count = 0;
			for(int j=0;j<x.length;j++){
				if (y[i]>=x[j]) {
					count++;					
				}
			}
			numbers.add(count);
			System.out.println(count);
		}
		
		return (ArrayList) numbers;
		
	}

	public static void main(String[] args) {
		CommonInteger ci = new CommonInteger();
		//ci.commonNumbers(x, y)
	}
}

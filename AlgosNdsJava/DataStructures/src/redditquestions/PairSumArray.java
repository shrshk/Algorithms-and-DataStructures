package redditquestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PairSumArray {

	public static void pairSumTen(int[] arr){
		
		//int temp=arr[0];
		for(int i=0;i<arr.length-1;i++){
			int temp=arr[i];
			for(int j=i+1;j<arr.length;j++){
				if(temp+arr[j]==10){
					Set<Integer> x = new HashSet<Integer>();					
					x.add(temp);
					x.add(arr[j]);
					System.out.println(x.toString());
				}
				
			}
			
		}
		
	}
	public static void main(String[] args) {
		PairSumArray psa = new PairSumArray();
		int[] f = {1,5,6,9,8,3};
		psa.pairSumTen(f);
	}
	
}

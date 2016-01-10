package com.AlgosAndDs;

public class BubbleSort {

	public static int[] bubbleSortAlgo(int[] arr){
		boolean flag=true;
		int temp;
		while(flag){
			flag = false;
			for(int i=0;i<arr.length-1;i++){
				if(arr[i]<arr[i+1]){
					temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
					flag=true;
				}
			}
			
			
		}
		return arr;
	}
	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		int[] x ={1,5,3,2,4};
		System.out.println(bs.bubbleSortAlgo(x));
	}
}

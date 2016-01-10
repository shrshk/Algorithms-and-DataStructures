package com.programmingInterviewsProblems;

public class CountArray {
public static int countRepetition(int a,int[] x){
	int count =0;
	for(int i=0;i<x.length;i++){
		if(x[i]==a){
			count++;
		}
	}
	return count;
}
public static void main(String[] args) {
	CountArray ca = new CountArray();
	int[] xray ={1,1,3,4,5};
	System.out.println(ca.countRepetition(1,xray));
}

}

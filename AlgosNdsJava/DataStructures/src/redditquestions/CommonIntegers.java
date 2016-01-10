package redditquestions;

import java.util.ArrayList;

public class CommonIntegers {
	
	public static ArrayList<Integer> retCommonInts(int[] x, int[] y){
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for(int i=0;i<x.length;i++){
			for(int j=0;j<y.length;j++){
				if(x[i]==y[j]){
					
					al.add(x[i]);
					
					
				}
			}
		}
		return al;
	}
	public static void main(String[] args) {
		int[] x ={1,4,5,6,7};
		int[] y ={8,5,9,2,3};
		System.out.println(retCommonInts(x, y));
		
	}

}

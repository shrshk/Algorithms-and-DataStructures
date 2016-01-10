package linkedList;

import java.util.ArrayList;
import java.util.List;

public class SplitByDifference {
	
//	public int splitByDef(int input[], int number){
//		int i=0;
//		int j=input.length-1;
//		int variance =0;
//		while(i!=j){
//			if(variance==0){
//				if(input[i]==number){
//					variance = 1;
//				}
//				i++;
//			}
//			else if(variance!=0){
//				if(input[j]==number){
//					variance = 0;
//				}
//				j--;
//			}
//			//System.out.println(variance +" "+ i + " " + j );
//		}
//		return i+1;	
//	}
	public static int solution(int X, int[] A){
		int length = A.length;
		int lastIndex = length - 1;
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();

		int K = -1;
		for(int i = 0; i < length; i++){
		if(A[i] == X){
		left.add(i);
		}
		if(A[lastIndex - i] != X){
		right.add(lastIndex - i);
		}	
		}

		for(int j = 0; j < right.size(); j++){
		if(( j < left.size() & j < right.size()) && (left.get(j) < right.get(j)) ){
		K = right.get(j);
		}
		}

		return K;
		}
	public static void main(String[] args) {
		SplitByDifference sbd = new SplitByDifference();
		int[] input = {5,5,1,7,2,1,3,5};
		System.out.println(sbd.solution(5,input));
		
	}

}

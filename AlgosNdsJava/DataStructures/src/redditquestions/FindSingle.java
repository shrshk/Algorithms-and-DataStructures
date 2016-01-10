package redditquestions;

import java.util.HashSet;
import java.util.Set;

public class FindSingle {
public static int retSingle(int[] x){
	Set<Integer> singleSet = new HashSet<Integer>();
	for(int i=0;i<x.length;i++){
		if(singleSet.contains(x[i])){
			return x[i];
		}
		else{
			singleSet.add(x[i]);
		}
	}
	return 0;
}
public static void main(String[] args) {
	int[] a ={1,2,2,3};
	System.out.println(retSingle(a));
}
}

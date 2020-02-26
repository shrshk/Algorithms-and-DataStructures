package leetcodeContests.contest175;

import java.util.HashSet;
import java.util.Set;

public class CheckDoubleNumber {
	public boolean checkIfExist(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for (int i=0; i<arr.length; i++) {
			if (arr[i]%2==0 && set.contains(arr[i]/2) || set.contains(arr[i]*2)) {
				return true;
			}
			set.add(arr[i]);
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(new CheckDoubleNumber().checkIfExist(new int[]{10,2,5}));
	}
}

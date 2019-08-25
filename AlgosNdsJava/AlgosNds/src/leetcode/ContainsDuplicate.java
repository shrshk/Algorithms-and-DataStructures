package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	static boolean containsDupl(int[] arr) {
//		int[] temp = new int[arr.length];
//		int j=0;
//		for (int i=0;i<arr.length;i++) {
//			int num = arr[i];
//			System.out.println(Arrays.toString(temp));
//			if (Arrays.stream(temp).anyMatch(x -> x == num)) {
//				return true;
//			}
//			temp[j++]=arr[i];
//		}
		Set<Integer> set = new HashSet<>();
		for (int i=0;i<arr.length;i++) {
			if (set.contains(arr[i])) {
				return true;
			}
			set.add(arr[i]);
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(containsDupl(new int[]{1,5,-2,-4,0}));
	}
}

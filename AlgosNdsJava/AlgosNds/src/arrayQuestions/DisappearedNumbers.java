package arrayQuestions;

import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {
	static List<Integer> disappereadNumbers(int[] nums) {
		int[] ret = new int[nums.length+1];
		List<Integer> missing = new ArrayList<>();
		for (int i : nums) {
			ret[i] = 1;
		}
		for (int i=1; i<ret.length; i++) {
			//int misIdx=0;
			if (ret[i]==0)
				missing.add(i);
		}
		return missing;
	}
	
	public static void main(String[] args) {
		System.out.println((disappereadNumbers(new int[]{4,3,2,7,8,2,3,1})));
	}
}

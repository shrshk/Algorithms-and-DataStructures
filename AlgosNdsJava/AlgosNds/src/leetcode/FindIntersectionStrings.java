package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindIntersectionStrings {
	
	public String findIntersection(String[] nums) {
		String[] first = nums[0].split(",");		
		String[] second = nums[1].split(",");
		String res = "";
		
		int i=0,j=0;
		
		while(i<first.length && j<second.length) {
			int firstVal = Integer.valueOf(first[i]);
			int secondVal= Integer.valueOf(second[j]);
			if (firstVal<secondVal)
				i++;
			else if (firstVal>secondVal)
				j++;
			else {
				res+=first[i] + ",";
				i++;
				j++;
			}
		}
		
		return res.equals("") ? "false" : res;
	}
	
	public List<Integer> findIntersectionNums(int[][] nums) {
		int[] first = nums[0];
		int[] second = nums[1];
		List<Integer> res = new ArrayList<>();
		
		int i=0,j=0;
		
		while(i<first.length && j<second.length) {
			int firstVal = first[i];
			int secondVal= second[j];
			if (firstVal<secondVal) {
				i++;
			}
			if (firstVal>secondVal) {
				j++;
			}
			if (firstVal==secondVal) {				
				res.add(firstVal);
				i++;
				j++;
			}
		}
		
		return res;
	}
	
	
	public static void main(String[] args) {
		// 1 3 4 7 13 
		// 1 2 4 13 15
		System.out.println(new FindIntersectionStrings().findIntersectionNums(new int[][]{{1,3,4,7,13},{1,2,4,13,15}}));
		System.out.println(new FindIntersectionStrings().findIntersection(new String[]{"1,3,4,7,13","1,2,4,13,15"}));
	}
}

package leetcode.shirishFavsList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class FirstDigitComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return compareTwoNumbers(o1, o2);		
	}

	private int compareTwoNumbers(Integer num1, Integer num2) {
		List<Integer> digitsArray1 = new ArrayList<>();
		List<Integer> digitsArray2 = new ArrayList<>();
		int x = num1;
		int y = num2;
		while (x != 0) {
			digitsArray1.add(x % 10);
			x = x / 10;
		}
		while (y != 0) {
			digitsArray2.add(y % 10);
			y = y / 10;
		}

		int i = digitsArray1.size()-1;
		int j = digitsArray2.size()-1;

		while (i >= 0 && j >= 0) {
			if (digitsArray1.get(i) > digitsArray2.get(j)) {
				return 1;
			} else if (digitsArray1.get(i) < digitsArray2.get(j)) {
				return -1;
			} else {
				i--;
				j--;
			}
		}		

		if (i>=0) {
			if (digitsArray1.get(i)>digitsArray2.get(j+1))
				return 1;
		}else if (j>=0) {
			if (digitsArray1.get(i+1)<digitsArray2.get(j))
				return -1;
		}

		return 0;
	}

}

public class LargestNumber {
	static String largestNumber(int[] num) {
//		Queue<Integer> pq = new PriorityQueue<>(new FirstDigitComparator());
//
//		String result = "";
//		for (int i = 0; i < nums.length; i++) {
//			pq.add(nums[i]);
//		}
//		
//		List<Integer> temp = new ArrayList<>();
//		for (Integer element: pq) {
//			temp.add(element);
//		}
//		
//		Collections.reverse(temp);
//		
//		for (Integer i: temp) {
//			result+=i;
//		}
//		
//		return result;
		if(num == null || num.length == 0)
		    return "";
		
		// Convert int array to String array, so we can sort later on
		String[] s_num = new String[num.length];
		for(int i = 0; i < num.length; i++)
		    s_num[i] = String.valueOf(num[i]);
			
		// Comparator to decide which string should come first in concatenation
		Comparator<String> comp = new Comparator<String>(){
		    @Override
		    public int compare(String str1, String str2){
		        String s1 = str1 + str2;
			String s2 = str2 + str1;
			return s2.compareTo(s1); // reverse order here, so we can do append() later
		    }
	        };
		
		Arrays.sort(s_num, comp);
                // An extreme edge case by lc, say you have only a bunch of 0 in your int array
                if(s_num[0].charAt(0) == '0')
                    return "0";
            
		StringBuilder sb = new StringBuilder();
		for(String s: s_num)
	            sb.append(s);
		
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(largestNumber(new int[] { 128,12 }));
	}
}

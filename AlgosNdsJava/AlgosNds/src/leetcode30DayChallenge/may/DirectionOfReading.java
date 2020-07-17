package leetcode30DayChallenge.may;

import java.util.ArrayList;
import java.util.List;

public class DirectionOfReading {
	public List<Integer> directionOfReading(int[] nums) {
		List<Integer> res = new ArrayList<>();
		int len = nums.length;
		List<String> squareList = new ArrayList<>(len);
		for (int num : nums) {
			String numStr = String.valueOf(num);
			String myString = appendZeros(numStr, len);
			squareList.add(myString);
		}

		List<char[]> list = new ArrayList<>();

		for (String val : squareList) {
			list.add(val.toCharArray());
		}

		for (int i = 0; i < len; i++) {
			String val = "";
			for (int j = 0; j < len; j++) {
				val += list.get(j)[i];
			}
			res.add(Integer.valueOf(val));
		}

		return res;

	}

	private String appendZeros(String num, int len) {
		String res = "" + num;
		while (res.length() < len) {
			res = "0" + res;
		}
		return res;
	}

	// def directionOfReading(numbers):
	//
	// length = len(numbers)
	// mySquare = [];
	//
	// for num in numbers:
	// myString = str(num).zfill(length)
	// mySquare.append(myString)
	//
	// return [int(''.join(x)) for x in zip(*mySquare)]
	public static void main(String[] args) {
		int[] nums = new int[] { 12, 345, 67, 5 };
		System.out.println(new DirectionOfReading().directionOfReading(nums));
	}
}

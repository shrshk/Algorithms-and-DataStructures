package leetcode30DayChallenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber {
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();

		while (n != 1) {
			List<Integer> digits = getDigits(n);
			int digitSqr = 0;
			for (int digit : digits) {
				digitSqr += digit * digit;
			}

			if (set.contains(digitSqr))
				return false;
			
			set.add(digitSqr);
			
			n = digitSqr;
		}

		return true;
	}

	private List<Integer> getDigits(int n) {
		List<Integer> digits = new ArrayList<>();
		while (n != 0) {
			int digit = n % 10;
			digits.add(digit);
			n = n / 10;
		}

		return digits;
	}

	public static void main(String[] args) {
		System.out.println(new HappyNumber().isHappy(20));
	}
}

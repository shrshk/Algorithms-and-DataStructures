package leetcode30DayChallenge.may;

public class Deposit {
	public int depositProfit(int deposit, int rate, int threshold) {
		int counter = 0;
		double newDeposit = deposit;

		while (newDeposit < threshold) {
			newDeposit += (newDeposit * rate) / 100;
			counter++;
		}

		return counter;
	}

	public static void main(String[] args) {
		System.out.println(new Deposit().depositProfit(100, 20, 200));
	}
}

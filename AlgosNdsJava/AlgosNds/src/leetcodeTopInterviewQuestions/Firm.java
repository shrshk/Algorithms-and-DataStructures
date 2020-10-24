package leetcodeTopInterviewQuestions;

public class Firm {
	void assignSalaries(int[] income, int[] salaries) {
		int sLen = salaries.length;
		int incLen = income.length;

		int i = 0, j = 0;

		while (i < incLen && j < sLen) {
			income[i] = salaries[j];
			System.out.println(income[i]);
			i++;
			j++;
		}
	}

	double averageSalary(int[] income) {
		int sum = 0;
		int n = income.length;
		for (int inc : income)
			sum += inc;
		return sum / n;
	}
	
	int maxSalary(int[] income) {
		int max = Integer.MIN_VALUE;
		for (int inc : income)
			max = Math.max(max, inc);
		return max;
	}
	
	int minSalary(int[] income) {
		int min = Integer.MAX_VALUE;
		for (int inc : income)
			min = Math.min(min, inc);
		return min;
	}

}

package leetcodeTopInterviewQuestions;

public class EngineerFirm extends Firm implements Company {
	int[] income;

	EngineerFirm(int n) {

		income = new int[n];
	}

	@Override
	public void assignSalaries(int[] salaries) {
		super.assignSalaries(income, salaries);
	}

	@Override
	public void averageSalary() {
		System.out.println("Average salary of engineers is " + super.averageSalary(income));
	}

	@Override
	public void maxSalary() {
		int max = super.maxSalary(income);
		System.out.println("Maximum salary amongst engineers is " + max);
	}

	@Override
	public void minSalary() {
		int min = super.minSalary(income);
		System.out.println("Minimum salary amongst engineers is " + min);
	}
}

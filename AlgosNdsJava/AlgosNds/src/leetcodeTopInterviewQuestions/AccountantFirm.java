package leetcodeTopInterviewQuestions;

public class AccountantFirm extends Firm implements Company {
	int[] income;

	AccountantFirm(int n) {

		income = new int[n];
	}

	@Override
	public void assignSalaries(int[] salaries) {
		super.assignSalaries(income, salaries);
	}

	@Override
	public void averageSalary() {
		System.out.println("Average salary of accountants is " + super.averageSalary(income));
	}

	@Override
	public void maxSalary() {
		int max = super.maxSalary(income);
		System.out.println("Maximum salary amongst accountants is " + max);
	}

	@Override
	public void minSalary() {
		int min = super.minSalary(income);
		System.out.println("Minimum salary amongst accountants is " + min);
	}
}


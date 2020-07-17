package coinbasePrep;

public class FibonaaciNthNumber {
	public int fibNumber(int n) {
		if (n<2)
			return n;
		return fibNumber(n-1) + fibNumber(n-2);
	}
	public static void main(String[] args) {
		System.out.println(new FibonaaciNthNumber().fibNumber(6));
	}
}

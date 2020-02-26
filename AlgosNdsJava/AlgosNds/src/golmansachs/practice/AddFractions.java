package golmansachs.practice;

public class AddFractions {
	public String fractionAddition(String expression) {
		// steps
		// split exp into tokens     1/2+3/2
		// [1/2, 3/2]
		// build num arr and den arr
		// get num and den of result fraction
		// get gcd of den and num 
		// divide it to num and den for res
		String[] tokens = expression.split("(?=[+-])");
		int len = tokens.length;
		int[] numerators = new int[len];
		int[] denominators = new int[len];
		for (int i=0; i<len; i++) {
			numerators[i] = Integer.parseInt(tokens[i].split("/")[0]);
			denominators[i] = Integer.parseInt(tokens[i].split("/")[1]);		
		}
		
		long numerator = 0, denominator = 1;
		
		for (int i=0; i<len; i++) {
			// 1/2 + 1/3
			denominator *= denominators[i];
		}
		
		for (int i=0; i<len; i++) {
			numerator += denominator * numerators[i]/denominators[i];
		}
		
		long A = Math.abs(gcd(denominator, numerator));
		
		String res = numerator/A + "/" + denominator/A;
		
		return res;
	}
	
	private long gcd(long x, long y) {
		if (y==0)
			return x;
		return gcd(y, x%y);
	}
	
	public static void main(String[] args) {
		System.out.println(new AddFractions().fractionAddition("1/2+1/3"));
	}
}

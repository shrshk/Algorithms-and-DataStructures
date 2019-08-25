package leetcode.TopInterviewQuestions.Strings;

public class ReverseInteger {
	static int reverseInteger(int x) {
		long result = 0;
		while (x!=0) {
			int tail = x % 10;
			x = x / 10;
			result =result*10+ tail;
		}
		if(result > Integer.MAX_VALUE || result <Integer.MIN_VALUE) {
			result = 0;
		}
		return (int) result;
	}
	public static void main(String[] args) {
		System.out.println(reverseInteger(120));
	}
}

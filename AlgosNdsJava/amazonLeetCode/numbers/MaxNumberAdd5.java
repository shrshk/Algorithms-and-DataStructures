package amazonLeetCode.numbers;

public class MaxNumberAdd5 {
	public int maxNumber(int number) {
		boolean isNeg = number<0;
		String s = String.valueOf(number);
		s = isNeg ? s.substring(1,s.length()): s;	
		int max = Integer.MIN_VALUE;
		for (int i=0; i<=s.length(); i++) {
			String temp = s.substring(0,i) + '5' + s.substring(i);
			temp = isNeg ? '-' + temp : temp;
			if (Integer.parseInt(temp) > max) {
				max = Integer.parseInt(temp);
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(new MaxNumberAdd5().maxNumber(670));
	}
	
}

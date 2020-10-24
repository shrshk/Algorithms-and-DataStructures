package facebookPrep.arraysAndStrings;

public class AddStrings {
	public String addStrings(String num1, String num2) {

		int len = Math.max(num1.length(), num2.length());

		for (int i = num1.length(); i < len; i++)
			num1 = num1 + "0";

		for (int i = num2.length(); i < len; i++)
			num2 = num2 + "0";

		int idx = len - 1;
		int carry = 0;

		StringBuilder sb = new StringBuilder();

		while (idx >= 0) {
			int curr1 = num1.charAt(idx) - '0';
			int curr2 = num2.charAt(idx) - '0';
			int sum = curr1 + curr2 + carry;
			if (sum > 9) {
				sb.append(sum % 10);
				carry = sum / 10;
			} else {
				sb.append(sum);
				carry = 0;
			}
			idx--;
		}

		if (carry > 0) {
			sb.append(carry);
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(new AddStrings().addStrings("9", "99"));
	}
}

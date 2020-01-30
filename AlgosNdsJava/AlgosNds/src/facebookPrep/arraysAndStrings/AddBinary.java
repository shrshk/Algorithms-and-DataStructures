package facebookPrep.arraysAndStrings;

public class AddBinary {

	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		// a = "1010", b = "1011"
		int i = a.length() - 1, j = b.length() - 1, carry = 0;

		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (i >= 0)
				sum += a.charAt(i--) - '0';
			if (j >= 0)
				sum += b.charAt(j--) - '0';
			carry = sum / 2;
			sb.append(sum % 2);
		}

		if (carry != 0)
			sb.append(carry);

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(new AddBinary().addBinary("1010", "1011"));
	}
}

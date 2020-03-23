package googlePrep.phonescreen;

public class SubStringWithAphabetsInSeq {
	public boolean inSeq(String s) {
		char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		int idx = 0;
		int i = 0;
		while (i < s.length() && idx < alpha.length) {
			if (alpha[idx] == s.charAt(i)) {
				idx++;
				i++;
			} else {
				i++;
			}
		}

		return idx == 26;
	}

	public static void main(String[] args) {
		System.out.println(new SubStringWithAphabetsInSeq()
				.inSeq("sabuycudkge fagkhfgi jakilameng,okpaq reswytgukjvfwgxaeyw z,kg"));
	}
}

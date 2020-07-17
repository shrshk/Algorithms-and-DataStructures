package twilioPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaginatedString {

	public static List<String> segments(String message) {
		return getSplits(message);
	}

	private static List<String> getSplits(String message) {
		List<String> result = new ArrayList<>();
		if (message.length() < 160) {
			result.add(message);
			return result;
		}

		int maxlen = 154;
		int s = 0, e = s + maxlen;
		while (e < message.length()) {
			if (message.charAt(e) != ' ') {
				while (e >= s && message.charAt(e) != ' ' && message.charAt(e + 1) != ' ') {
					e--;
				}
			}
			result.add(message.substring(s, e + 1));
			s = e + 1;
			e = s + maxlen;
		}
		result.add(message.substring(s, message.length()));

		for (int i = 0; i < result.size(); i++) {
			result.set(i, result.get(i) + "(" + (i + 1) + "/" + (result.size()) + ")");
		}
		return result;
	}

	public String[] formatString(String s) {

		List<String> tokens = new ArrayList<>();
		int maxLen = 154;
		int start = 0;
		int limit = start + maxLen;
		
		if (s.length()<160)
			return new String[]{s};

		while (limit < s.length()-1) {
			while (limit >= start && s.charAt(limit) != ' ' && s.charAt(limit + 1) != ' ') {
				limit--;
				System.out.println(limit);
			}
			tokens.add(s.substring(start, limit + 1));
			start = limit + 1;
			limit = start + maxLen;
		}
		
		tokens.add(s.substring(start, s.length()));

		String[] output = new String[tokens.size()];

		for (int i = 0; i < tokens.size(); i++) {
			output[i] = tokens.get(i) + "(" + String.valueOf(i + 1) + "/" + String.valueOf(tokens.size()) + ")";
		}

		return output;
	}

	public static void main(String[] args) {
		// System.out.println("njdksjfn jdfnds kjfdklsjf jsdofjsd f
		// jdslkjfgdslkngdslkjg fljksdjflsfdsjfdslkfjdslkfmdsklmfgn ljsdglkdsfg
		// d lkjgdslkgjdsljgdslkjgdsfjngds lkjsdlkgjdsgklds (1/3)".length());
		String input = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis partu sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore ver rup. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa.";
		// System.out.println(input.length());
		// System.out.println((int) Math.ceil(334 / (160 + 1.0)));
		
		System.out.println(input.charAt(154));
		System.out.println(input.charAt(155));
		
		System.out.println("njdksjfn jdfnds kjfdklsjf jsdofjsd f jdslkjfgdslkngdslkjg fljksdjflsfdsjfdslkfjdslkfmdsklmfgn ljsdglkdsfg d lkjgdslkgjdsljgdslkjgdsfjngds".length());

		// System.out.println("njdksjfn jdfnds kjfdklsjf jsdofjsd f
		// jdslkjfgdslkngdslkjg fljksdjflsfdsjfdslkfjdslkfmdsklmfgn ljsdglkdsfg
		// d lkjgdslkgjdsljgdslkjgdsfjngds lkjsdlkgjdsgkldsjgsdlkg
		// lkjdslkgjdslkgjdslgmnds glkjgdslkjgdslkjfgodsjfds
		// g,mdsgkjdsngdlsknfgldsjfglkdsjfglkdsjglkdsjglkdsgjdsklgjdslk
		// lkgjdslkgfjdslkgjdslkgjdsljfgdslkgjmdslkg
		// kljghjdslkjgdslkjfg".length());
		System.out.println(Arrays.toString(new PaginatedString().formatString(input)));
		System.out.println(segments(input).toString());
		// System.out.println("njdksjfn jdfnds kjfdklsjf jsdofjsd f
		// jdslkjfgdslkngdslkjg fljksdjflsfdsjfdslkfjdslkfmdsklmfgn ljsdglkdsfg
		// d lkjgdslkgjdsljgdslkjgdsfjngds (1/3)".length());
		// System.out.println("njdksjfn jdfnds kjfdklsjf jsdofjsd f
		// jdslkjfgdslkngdslkjg fljksdjflsfdsjfdslkfjdslkfmdsklmfgn ljsdglkdsfg
		// d lkjgdslkgjdsljgdslkjgdsfjngds (1/3)".length());
	}
}

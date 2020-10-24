package amazonPractice;

import java.util.Arrays;

public class ReorderLogFiles {
	public String[] reorderLogFiles(String[] logs) {
		Arrays.sort(logs, (log1, log2) -> {
			String[] split1 = log1.split(" ", 2);
			String[] split2 = log2.split(" ", 2);
			boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
			boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
			if (!isDigit1 && !isDigit2) {
				int comp = split1[1].compareTo(split2[1]);
				if (comp == 0)
					comp = split1[0].compareTo(split2[0]);
				return comp;
			} else if (isDigit1 && isDigit2) {
				return 0;
			} else if (isDigit1 && !isDigit2) {
				return 1;
			} else {
				return -1;
			}
		});
		return logs;
	}

	public static void main(String[] args) {
		String[] xa = new String[] { "1", "2", "a" };
		Arrays.sort(xa, (x1, x2) -> {
			Character.isDigit(x1.charAt(0));
			return x1.compareTo(x2);
		});
		System.out.println(xa);
	}
}

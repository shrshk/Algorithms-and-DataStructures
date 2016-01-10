package assignment03;

public class DuplicateChecker {
	/**
	 * This version assumes that the string is any general string (may contain
	 * non-ascii chars) Time complexity is order of n squared. This method does
	 * not take additional space.
	 * 
	 * @param s
	 * @return
	 */
//	public boolean hasDuplicateChars(String s) {
//		for (int i = 0; i < s.length() - 1; i++) {
//			for (int j = i + 1; j < s.length(); j++) {
//				if (s.charAt(i) == s.charAt(j))
//					return true;
//			}
//		}
//		return false;
//	}

	/**
	 * This method assumes that only ASCII characters are present Given the
	 * above condition, we can check in order of n time - O(n) But we need to
	 * use additional memory space to keep track of the counter for each
	 * character
	 * 
	 * @param s
	 * @return
	 */
	public boolean hasDuplicateChars(String s) {
		// Standard ASCII (if you want to include extended ASCII, you may use a 256 length array
		boolean[] charSet = new boolean[128]; // additional memory
		for (int i=0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (charSet[c]) return true;
			charSet[c] = true;
		}
		return false;
	}
	
	/**
	 * If it is OK to change the contents of the string, we can first sort it
	 * using nlogn algorithm like MergeSort (will study later). And then go over
	 * each character checking if the neighbours are identical.
	 * So time complexity becomes O(nlogn + n) = O(nlogn)
	 * @param s
	 * @return
	 */
//	public boolean hasDuplicateChars(String s) {
//		// first sort the string in nlogn time
//		// now assuming that string is already sorted
//		for (int i=0; i < s.length()-1; i++) { // 
//			if (s.charAt(i) == s.charAt(i+1))
//				return true;
//		}
//		return false;
//	}

	public static void main(String[] args) {
		DuplicateChecker dc = new DuplicateChecker();
		System.out.println(dc.hasDuplicateChars("abracadabra"));
	}
}

package dynamicProgramming;

class LongestPalindromicSubstring {
	// expand in both directions of low and high to find
	// maximum length palindrome
	public static String expand(String str, int low, int high) {
		int len = str.length();

		// expand in both directions
		while (low >= 0 && high < len && (str.charAt(low) == str.charAt(high))) {
			low--;
			high++;
		}

		// return palindromic substring
		return str.substring(low + 1, high);
	}

	// Function to find Longest Palindromic SubString in O(n^2) time
	// and O(1) space
	public static String LongestPalindromicSubString(String str, int len) {
		// max_str stores the maximum length palindromic substring
		// found so far
		String max_str = "", curr_str;

		// max_length stores the length of maximum length palindromic
		// substring found so far
		int max_length = 0, curr_length;

		// consider every adjacent pair of characters as mid points and
		// expand in both directions to find maximum length palindrome

		for (int i = 0; i < len; i++) {
			// find a longest odd length palindrome with str[i] as mid point
			curr_str = expand(str, i, i);
			curr_length = curr_str.length();

			// update maximum length palindromic substring if odd length
			// palindrome has greater length

			if (curr_length > max_length) {
				max_length = curr_length;
				max_str = curr_str;
			}

			// find a longest even length palindrome with str[i] and
			// str[i+1] as mid points.
			// Note that an even length palindrome has two mid points

			curr_str = expand(str, i, i + 1);
			curr_length = curr_str.length();

			// update maximum length palindromic substring if even length
			// palindrome has greater length

			if (curr_length > max_length) {
				max_length = curr_length;
				max_str = curr_str;
			}
		}

		return max_str;
	}

	public static void main(String[] args) {
		String str = "racecar";

		System.out.println("Longest Palindromic SubString of " + str + " is "
				+ LongestPalindromicSubString(str, str.length() - 1));
	}
}

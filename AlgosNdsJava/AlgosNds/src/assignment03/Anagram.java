package assignment03;

public class Anagram {

	/**
	 * If we can change the contents of the string, we can sort them in nlogn
	 * time and check if both the strings are equal (easy) 
	 * BUT IN THIS METHOD we will consider that characters of the 
	 * string are all ASCII.
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean isAnagram(String str1, String str2) {
		// if the lengths are not equal, they definitely cannot be anagrams
		if (str1.length() != str2.length())
			return false;

		int[] charSet = new int[128];
		int numOfUniqueChars = 0;
		int numCompletedInStr2 = 0;
		char[] chars = str1.toCharArray();
		for (char c : chars) { // count number of each char in s.
			if (charSet[c] == 0)
				++numOfUniqueChars;
			++charSet[c];
		}
		// The basic idea here is to go through all the characters of
		// str2 now, and if this char is not present (count in charSet is zero), it is not an anagram
		// otherwise we reduce the count for that character in the charSet array.
		// If you don't understand the code below, I suggest that you step through it using a debugger.
		// It's not very difficult to understand if you do that.
		for (int i = 0; i < str2.length(); ++i) {
			int c = (int) str2.charAt(i);
			if (charSet[c] == 0) { // More of character 'c' in str2 than in str1
				return false;
			}
			--charSet[c]; // reduce the count
			if (charSet[c] == 0) {
				++numCompletedInStr2;
				if (numCompletedInStr2 == numOfUniqueChars) {
					// it’s a match if str2 has been processed completely
					return i == str2.length() - 1;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
//		System.out.println(isAnagram("ABABABC", "BABABAD"));
		System.out.println(isAnagram("daniel clowes", "enid coleslaw"));
	}

}

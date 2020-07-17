package atlassianPrep;

import java.util.Arrays;
import java.util.List;

public class ReverseVowels {
	public String reverseVowels(String s) {
        int i=0,j=s.length()-1;
        char[] chars = s.toCharArray();
        List<Character> vowels = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
        while(i<=j) {
            if (vowels.contains(chars[i]) && vowels.contains(chars[j])) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
                continue;
            }
            if (!vowels.contains(chars[i])) {
                i++;
            }
            if (!vowels.contains(chars[j])) {
                j--;
            }
        }
        
        return new String(chars);
    }
	
	public static void main(String[] args) {
		System.out.println(new ReverseVowels().reverseVowels("leetcode"));
	}
}

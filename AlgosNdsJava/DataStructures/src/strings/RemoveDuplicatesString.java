package strings;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesString {
	public static String removeDuplicates(String s) {
		char[] c = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < c.length; i++) {
			if (!set.contains(c[i])) {
				set.add(c[i]);

			}

		}
		String letters = set.toString();
		System.out.println(letters);
		char[] d = letters.toCharArray();
		for(int i=0;i<2;i++){
			System.out.println(d[i]); 
		}
		sb.append(set);
		return sb.toString();

	}

	public static void main(String[] args) {
		System.out.println(removeDuplicates("shirish"));
	}
	public String getName(String name,String yourName){
		return String.format("hi %s,my name is %s", name,yourName);
	}
}

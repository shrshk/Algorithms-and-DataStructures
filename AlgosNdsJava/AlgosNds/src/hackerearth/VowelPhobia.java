package hackerearth;
import java.util.*;

public class VowelPhobia {
	public static void main(String[] args) throws Exception {
		List<Character> vowels = new ArrayList<Character>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		Set<Character> inputSet = new HashSet<Character>();
		int size = 5;
		String input = "aeioe";
		
		for(int i=0; i<size; i++) {
			if(vowels.contains(input.charAt(i))) {
				inputSet.add(input.charAt(i));
			}
		}
		if(inputSet.size()==5) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}		
	}
}

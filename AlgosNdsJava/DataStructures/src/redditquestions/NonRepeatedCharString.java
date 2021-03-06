package redditquestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
class NonRepeatedCharString {

public static char retChar(String input){
	
	Set<Character> repeating = new HashSet<Character>();
	List<Character> nonrepeating = new ArrayList<Character>();
	
	for(int i=0;i<input.length();i++){
		char temp = input.charAt(i);
		if(repeating.contains(temp)){
			continue;
		}
		if(nonrepeating.contains(temp)){
			nonrepeating.remove((Character) temp);
			repeating.add(temp);
		}
		else{
			nonrepeating.add(temp);
		}
	}
	return nonrepeating.get(0);
	
}
public static void main(String[] args) {
	System.out.println(retChar("ngrhhqbhnsipkcoqjyviikvxbxyphsnjpdxkhtadltsuxbfbrkof"));
}
}
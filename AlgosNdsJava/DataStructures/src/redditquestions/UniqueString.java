package redditquestions;

import java.util.HashSet;
import java.util.Set;

public class UniqueString {
	
	public static boolean isUnique(String s){
		Set<Character> sc = new HashSet<Character>();
		for(int i=0;i<s.length();i++){
			if(!sc.contains(s.charAt(i))){
			sc.add(s.charAt(i));
			}
			else{
				return false;
			}
			
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isUnique("shirish"));
	}

}

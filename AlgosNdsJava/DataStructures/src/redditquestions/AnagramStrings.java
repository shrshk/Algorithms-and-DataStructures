package redditquestions;

import java.util.ArrayList;
import java.util.List;

public class AnagramStrings {
public static boolean isAnagram(String s1, String s2){
	List<Character> l1 = new ArrayList<Character>();
	List<Character> l2 = new ArrayList<Character>();
	for(int i=0;i<s1.length();i++){
		l1.add(s1.charAt(i));
		
	}
	for(int j=0;j<s2.length();j++){
		if(l1.contains(s2.charAt(j))){
			l2.add(s2.charAt(j));
		}
		else{
			return false;
		}
		
	}
	if(l1.size()!=l2.size()){
		return false;
	}
	
	return true;
}
public static void main(String[] args) {
	System.out.println(isAnagram("aacc", "ccac"));
}
}

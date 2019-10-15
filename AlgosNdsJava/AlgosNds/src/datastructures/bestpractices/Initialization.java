package datastructures.bestpractices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Initialization {
	public static void main(String[] args) {
		// default array size is 10 if we add more than 10 list expands 
		// and copies all the previous items which is inefficient
		List<Integer> list = new ArrayList<>(50);
		list.addAll(Collections.nCopies(50, 0));
		
		ArrayList<String> list2 = new ArrayList<>(100); // BAD
		
		// Code to interface to change the implementation.
		List<String> list3 = new ArrayList<>(100);   // GOOD
		List<String> list4 = new LinkedList<String>();  // GOOD
		
		
		// return emptyList instead of null
		
		List<String> emptyList = Collections.emptyList( );
		Set<Integer> emptySet = Collections.emptySet( );
		
		List<String> unmod = Collections.unmodifiableList(Arrays.asList("string"));
		unmod.add("b");
 		
	}
}

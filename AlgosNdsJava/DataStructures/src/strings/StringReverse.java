package strings;

import java.util.Scanner;

public class StringReverse {

	public static void main(String[] args) {
		String original, reverse="";
		System.out.println("enter the string you want to reverse");
		Scanner in = new Scanner(System.in);
		original = in.nextLine();
		for(int i=original.length()-1;i>=0;i--){
			reverse = reverse + original.charAt(i);
			
		}
		System.out.println("the reverse is"+" "+reverse);
	}
}

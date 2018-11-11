package hackerearth;

import java.util.Scanner;

public class FizzBuzz {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int remainingTest = s.nextInt();
		while(remainingTest>0) {
			for(int i=1; i<=s.nextInt(); i++) {
				if(i%3==0 && i%5==0){
					System.out.println("FizzBuzz");
				}else if(i%3==0) {
					System.out.println("Fizz");
				}else if(i%5==0) {
					System.out.println("Buzz");
				}else {
					System.out.println(i);
				}
			}
			remainingTest--;
		}
		s.close();
	}
}

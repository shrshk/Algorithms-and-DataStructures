package math.fun;

public class CollatzConjecture {
	static void printFinalNumber(int n) {
		while(n!=1) {
			if (n%2==0)
				n=n/2;
			else
				n=3*n+1;
		}
		System.out.println(n);
	}
	
	public static void main(String[] args) {
		printFinalNumber(56789777);
	} 
}

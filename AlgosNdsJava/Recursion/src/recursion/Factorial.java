package recursion;

public class Factorial {
	public static int factorial(int n){
		//int factorial =1;
		if(n==0){
			return 1;
		}
		return n * factorial(n-1);
	}
	public static void main(String[] args){
		System.out.println(factorial(20));
	}

}

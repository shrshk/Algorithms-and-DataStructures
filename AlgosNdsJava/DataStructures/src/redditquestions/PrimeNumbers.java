package redditquestions;

public class PrimeNumbers {

	public static void printPrimeNumbers(int n){
		for(int i=2;i<n;i++){
			if(i==2){
				System.out.println(i);
			}
			for(int j=2;j<10;j++){
				if(i%j!=0){
					System.out.println(i);
				}
			}
			
			
		}
		
	}
	public static void main(String[] args) {
		printPrimeNumbers(10);
	}
	
}

package linkedList;

public class Fibanocci {
	//int n;
	public void printFibonacci(int n){
		int next;
		int first=0;
		int second =1;
		for(int i=0;i<n;i++){
		    if(i<=1){
		    	next=i;
		    }
		    else{
		    	next = first + second;
		    	first=second;
		    	second=next;
		    }
		
			
			//System.out.println(i);
			System.out.println(next);
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Fibanocci fb = new Fibanocci();
		fb.printFibonacci(8);

	}

}

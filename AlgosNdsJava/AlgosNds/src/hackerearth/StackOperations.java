package hackerearth;

public class StackOperations {
	public static void main(String[] args) {
		
		int n = 6;
		int k = 4;
		
		int[] a = new int[]{1,2,4,3,3,5};
		Stack s = new Stack(n);
		
		for(int i=n-1; i>0; i--) {
			s.push(a[i]);
		}
		
		int max = s.peek();
		
		for(int i=0; i<4; i++) {
			if(a[i]>=max) {
				s.pop();
				max = a[i];
			}else {
				s.push(max);
			}
		}
		
		System.out.println(s.peek());
		
		// Stack s = new Stack(6);
	}
}

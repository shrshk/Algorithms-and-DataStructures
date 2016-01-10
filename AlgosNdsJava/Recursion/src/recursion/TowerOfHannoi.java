package recursion;

public class TowerOfHannoi{
	public void move(int numOfDiscs, char from, char to, char interm){
		if(numOfDiscs==1){
			System.out.println("moving disc 1 "+numOfDiscs+from+"to"+to);
		}
		else{
		move(numOfDiscs-1, from, interm, to);
		System.out.println("moving discs"+numOfDiscs+from+"to"+to);
		move(numOfDiscs-1,interm,to,from);
		}
		
	}
	public static void main(String[] args) {
		TowerOfHannoi toh = new TowerOfHannoi();
		toh.move(3, 'A', 'C', 'B');
	}

}

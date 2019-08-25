package leetcode;

public class BarterMarket {
	
	static int maxFiction(int n, int m, int x, int y) {
		while(n!=0) {
			if (n>0 && m>=x) {
				n=n-1;
				m=m-x;
			} else {
				n=n-1;
				m=m+y;
			}
			
		}
		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxFiction(393, 896, 787, 920));
	}

}

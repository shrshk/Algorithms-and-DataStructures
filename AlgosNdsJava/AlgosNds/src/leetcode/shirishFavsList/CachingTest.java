package leetcode.shirishFavsList;

class A {
	String x;

	A(String x) {
		this.x = x;
	}
	
	@Override
	public boolean equals(Object obj) {
		A anotherA = (A) obj;
		// TODO Auto-generated method stub
		return x == anotherA.x;
	}
}

public class CachingTest {

	public static void main(String[] args) {
		String a = "abcdeeeeeeeeeeeeeeeefnvenevn";
		String b = "abcdeeeeeeeeeeeeeeeefnvenevn";
		
		A one = new A(a);
		A two = new A(b);
		
		System.out.println(one.equals(two));
		System.out.println(one.toString().equals(two.toString()));

	}

}

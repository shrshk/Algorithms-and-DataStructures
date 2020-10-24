package golmansachs.practice;

public class PascalTriangle {
	public static void print(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(pascal(i, j) + " ");
			}
			System.out.println();
		}
	}

	public static int pascal(int i, int j) {
		if (j == 0 || j == i) {
			return 1;
		}

		return pascal(i - 1, j - 1) + pascal(i - 1, j);

	}

	public static void main(String[] args) {
		print(5);
		//System.out.println(pascal(3, 2));
	}
}

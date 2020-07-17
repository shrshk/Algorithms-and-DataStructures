package microsoftOnlineAssessmentPrep;

public class FairIndexes {

	public int fairIndexes(int[] A, int[] B) {
		int res=0;
		
		int totalA = 0;
		int totalB = 0;

		for (int a : A)
			totalA += a;
		for (int b : B)
			totalB += b;

		if (totalA != totalB)
			return res;

		int i = 0;
		int sumA = 0;
		int sumB = 0;
		int total = totalA;

		int N = A.length;
		
		while (i < N) {
			sumA += A[i];
			sumB += B[i];
			if (sumA == total - sumA && sumB == total - sumB && sumA == sumB) {
				return i+1;
			}
			i++;
		}

		return res;
	}

	public static void main(String[] args) {
		// 4 -1 0 3
		// -2 5 0 3

		// 6 // 6

		// 3 3

		// steps
		// get total of A and B
		// loop thru arr if total-sum = sum for A and B return k else return 0

		int[] A = new int[] { 3,2,6 };
		int[] B = new int[] { 4,1,6 };
		System.out.println(new FairIndexes().fairIndexes(A, B));

	}
}

package amazonLeetCode.numbers;

public class Test {
    public boolean solution(int[] A, int K) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] + 1 < A[i + 1])
                return false;
        }
        if (A[0] != 1 || A[n - 1] != K)
            return false;
        else
            return true;
    }
    public static void main(String[] args) {
		System.out.println(new Test().solution(new int[]{1,2,3,6,5,5,6,6}, 6));
	}
}

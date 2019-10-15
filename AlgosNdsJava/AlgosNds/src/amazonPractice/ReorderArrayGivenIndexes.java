package amazonPractice;

import java.util.Arrays;

public class ReorderArrayGivenIndexes {
	public int[] replace(int[] A, int[] B)    {
		int nextValue = -1;
        int nextIndex = -1;
        for(int i=0;i<A.length;i++){
            if(B[i]==1){
                nextValue = A[i];
                nextIndex = B[i];
            }
        }
        int start = nextIndex;
        while(true){
            int i = nextIndex-1;
            int tempv = A[i];
            int tempi = B[i];
            A[i] = nextValue;
            nextValue = tempv;
            nextIndex = tempi;
            if (nextIndex==start)
                break;
        }
        return A;
    }
	
	int[] sortAWithB(int[] A, int[] B) {

	    for (int i = 0; i < B.length; i++) {
	        while (B[i]-1 != i) {
	            swap(A, i, B[i]-1);
	            swap(B, i, B[i]-1);
	        }
	    }

	    return A;
	}

	void swap(int[] A, int i, int j) {
	    int tmp = A[i];
	    A[i] = A[j];
	    A[j] = tmp;
	}
	
	public static void main(String[] args) {
		int[] A = new int[]{24, 56, 74, -23, 87, 91};
		int[] B = new int[]{1, 2, 3, 0, 4, 5};
		System.out.println(Arrays.toString(new ReorderArrayGivenIndexes().replace(A, B)));
		//System.out.println(Arrays.toString(new ReorderArrayGivenIndexes().replace(A, B)));
	}
}

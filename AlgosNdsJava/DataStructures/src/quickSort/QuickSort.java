package quickSort;

import java.util.Arrays;

public class QuickSort {
	int pivot;
	int start;
	int end;

	public void quickSort(int[] A, int start, int end) {
		if (start < end) {
			int pivot = partition(A, start, end);
			quickSort(A, start, pivot - 1);
			quickSort(A, pivot + 1, end);
			for(int i=start,j=start;j<=end-1;j++){
				if(A[j]<=pivot){
					A[i]=A[j];
					i++;
				}
				A[i]=A[end];
			}
			

		}
		

	}
	public int partition(int[] A, int start, int end){
		pivot = A[end];
		return pivot;
		
	}
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int[] A = {12,9,7,15,10};
		qs.quickSort(A, 0, A.length-1);
		System.out.println(Arrays.toString(A));
	}

}

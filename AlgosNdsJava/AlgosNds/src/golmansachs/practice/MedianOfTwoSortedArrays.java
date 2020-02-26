package golmansachs.practice;

public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] arr1, int[] arr2) {
		int i=0,j=0;
		int count=0;
		int[] arr3 = new int[arr1.length+arr2.length];
		while(i<arr1.length&&j<arr2.length) {
			if (arr1[i]<arr2[j]) {
				arr3[count++]=arr1[i++];
			} else if(arr1[i]>arr2[j]) {
				arr3[count++]=arr2[j++];
			} else {
				arr3[count++] = arr1[i];
                arr3[count++] = arr2[j];
				i++;
				j++;
			}
		}
		while (i<arr1.length) {
			arr3[count++] = arr1[i++];
		}
		while (j<arr2.length) {
			arr3[count++] = arr2[j++];
		}
			
		return median(arr3);
	}
	
	static double median(int[] arr) {
		double median = 0.0;
		int n = arr.length;
		if (n % 2 == 0) {
			median = (arr[n/2] + arr[(n/2)-1])/2.0;
		} else {
			median = arr[(n-1)/2];
		}
		return median;
	}
}

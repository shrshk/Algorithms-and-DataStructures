package redditquestions;

public class BinarySearchAlgo {
	
	public static int retKeyBinarySearch(int[] x, int k){
		int low = 0;
		int high = x.length;
		while(low<high){
			int mid = low + (high-low)/2;
			if(k<x[mid]){
				 high = mid-1;
			}
			else if(k>x[mid]){
				 low = mid+1;
						
			}
			else{
				return mid;
			}
		}
	
	return -1;
	}
	public static void main(String[] args) {
		BinarySearchAlgo bsa = new BinarySearchAlgo();
		int k=5;
		int[] x ={1,2,3,4,5};
		System.out.println(bsa.retKeyBinarySearch(x, k));
	}
	

}

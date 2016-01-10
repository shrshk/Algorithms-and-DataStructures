package recursion;

import java.util.Arrays;

public class MergeSortPractice {

	public void sort(int[] data){
		mergeSort(data,0,data.length-1);
	}
	public void mergeSort(int[] data, int start, int end){
		if(start<end){
			int mid = (int) Math.floor((start+end)/2);
			mergeSort(data,start,mid);
			mergeSort(data,mid+1,end);
			merge(data,start,mid,end);
		}
	}
	public void merge(int[] data, int start, int mid, int end){
		int sizeOfLeft = mid-start+1;
		int sizeOfRight = end-mid;
		int[] left = new int[sizeOfLeft];
		int[] right = new int[sizeOfRight];
		for(int i=0;i<sizeOfLeft;i++){
			left[i]=data[start+i];
			
		}
		for(int j=0;j<sizeOfRight;j++){
			right[j]=data[mid+1+j];
		}
		int i=0,j=0;
		for(int k=start;k<=end;k++){
			if((j>=sizeOfRight)||(i<sizeOfLeft&&left[i]<=right[j])){
				data[k]=left[i];
				i++;
			}
			else{
				data[k]=right[j];
				j++;
			}
			
		}
		
		
	}
	public static void main(String[] args) {
		MergeSortPractice msp = new MergeSortPractice();
		int[] data ={9,4,5,8,3};
		msp.sort(data);
		System.out.println(Arrays.toString(data));
	}
}

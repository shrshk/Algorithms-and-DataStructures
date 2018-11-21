package leetcode;

public class MergeSortedArrays {
	
	public void merge(int[] arr1, int m, int[] arr2, int n) {
		int i=0;
		int j=0;
		int k=0;
		int [] arr3 = new int[m+n];
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i]<arr2[j]) {
				arr3[k++] = arr2[i++];
			} else {
				arr3[k++]=arr1[j++];
			}
		}	
		while (i<m) {
			arr3[k++] = arr1[i++];
 		}
		while (j<n) {
			arr3[k++] = arr2[j++];
		}
		
		for (int x=0; x<arr3.length;x++) {
			System.out.println(arr3[x]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = new int[]{2,3,4};
		int[] y = new int[]{2,3,4};
	    new MergeSortedArrays().merge(x, x.length, y, y.length);

	}

}
/* public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] >= nums2[n]) {
                nums1[index--] = nums1[m--];
            } else {
                nums1[index--] = nums2[n--];
            }
        } 
        
        while (n >= 0) {
            nums1[index--] = nums2[n--];
        }
    } */
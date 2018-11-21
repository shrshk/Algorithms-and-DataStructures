package leetcode;

public class RemoveElement {
//	public static int removeElement(int[] arr, int val) {
//		int count = 0;
//		for(int i=0; i<arr.length;i++) {
//			if(arr[i]==val) {
//				count++;
//			}
//		}
//		return count;
//	}
	
//	public int removeElement(int[] arr, int val) {
//        arr = ArrayUtils.removeElement(arr, val);
//        return arr.length;
//	}
	
	public static int removeElement(int[] arr, int val) {
		int i=0;
	    for(int j=0; j<arr.length;j++) {
	    	if(arr[j]!=val) {
	    		arr[i] = arr[j];
	    		i++;
	    	}
	    }
	    return i;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{3,2,2,3};
		System.out.println(removeElement(arr, 3));
		
	}
}

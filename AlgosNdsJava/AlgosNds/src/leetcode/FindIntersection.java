package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindIntersection 
{ 
    /* Function prints Intersection of arr1[] and arr2[] 
       m is the number of elements in arr1[] 
       n is the number of elements in arr2[] */
    static void printIntersection(int arr1[], int arr2[], int m, int n) 
    { 
      int i = 0, j = 0; 
      while (i < m && j < n) 
      { 
        if (arr1[i] < arr2[j]) 
          i++; 
        else if (arr2[j] < arr1[i]) 
          j++; 
        else 
        { 
          System.out.print(arr2[j++]+" "); 
          i++; 
        } 
      } 
    } 
      
    public static void main(String args[]) 
    { 
        int arr1[] = {1, 2, 4, 5, 6}; 
        int arr2[] = {2, 3, 5, 7}; 
        int m = arr1.length; 
        int n = arr2.length; 
        System.out.println(Arrays.toString(findIntersection(arr1, arr2)));
    } 
    
    
   static int[] findIntersection(int[] arr1, int[] arr2) {
	   Arrays.sort(arr1);
	   Arrays.sort(arr2);	   
	   List<Integer> list = new ArrayList<>();
	   int i=0,j=0;
	   while (i<arr1.length && j<arr2.length) {
		   if (arr1[i]<arr2[j]) {
			   i++;
		   } else if(arr1[i]>arr2[j]) {
			   j++;
		   } else {		   
			   list.add(arr1[i]);
			   i++;
			   j++;
		   }
	   }
	   
	   int[] result = new int[list.size()];
	   int x=0;
	   for (Integer num: list) {
		   result[x++]=num;
	   }
	   
	   return result;
   }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
} 

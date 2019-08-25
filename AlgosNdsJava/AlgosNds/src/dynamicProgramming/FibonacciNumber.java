package dynamicProgramming;

import java.util.HashMap;

public class FibonacciNumber {
	 static int getFibonacciNumberRecursively(int n) {
	    if(n == 0) return 0;
	    if(n == 1) return 1;
	    return getFibonacciNumberRecursively(n - 1) + getFibonacciNumberRecursively(n - 2);
	  }
	  static HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	  static int getFibonacciNumberTopDown(int n) {
	    if(hm.containsKey(n)) return hm.get(n);
	    if(n == 0) return 0;
	    if(n == 1) return 1;
	    int nthValue = getFibonacciNumberTopDown(n - 1) + getFibonacciNumberTopDown(n - 2);
	    hm.put(n, nthValue);
	    return nthValue;
	  }
	  static int getFibonacciNumberBottomUpWithCache(int n) {
	    hm.put(0, 0);
	    hm.put(1, 1);
	    for(int i = 2; i <= n; i++) {
	      hm.put(i, hm.get(i - 1) + hm.get(i - 2));
	    }
	    return hm.get(n);
	  }
	  static int getFibonacciNumberBottomUpWithoutCache(int n) {
	    int fnMin2 = 0;
	    int fnMin1 = 1;
	    int sum = 0;
	    for(int i = 2; i <= n; i++) {
	      sum = fnMin1 + fnMin2;
	      fnMin2 = fnMin1;
	      fnMin1 = sum;
	    }
	    return sum;
	  }
	  public static void main(String [] args) {
	    System.out.println(getFibonacciNumberRecursively(8)); // 21
	    System.out.println(getFibonacciNumberTopDown(8)); // 21
	    System.out.println(getFibonacciNumberBottomUpWithCache(8)); // 21
	    System.out.println(getFibonacciNumberBottomUpWithoutCache(8)); // 21
	  } 
	}
